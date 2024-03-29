package com.mycompany.a3;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.Label;
import com.codename1.ui.Container;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;
import java.util.Observable;

public class Game extends Form implements Runnable {
	private GameWorld gw;
	private MapView mv;//creating mapview observer
	private ScoreView sv;//creating scoreview observer
	private UITimer timer; 
	private int TICK=20; 
	
	
	//Doing this in order to use all of the commands interchangably
	private CheckBox chkBoxCmd; 
	private AccelerateCommand accmd; 
	private ExitCommand ecmd; 
	private HelpCommand hcmd; 
	private SoundCommand sound; 
	private BrakeCommand bkcmd; 
	private TurnRightCommand rtcmd; 
	private TurnLeftCommand ltcmd;
	private AboutCommand acmd;
	private Button btnBrake;
	private Button btnRight;
	private Button btnAccelerate;
	private PositionCommand position;
	private Button btnPosition;
	private Button btnPause;
	private PauseCommand pause;
	private Button btnLeft; 
	
	//new game method with observers and desired layout manager
	public Game() {
		this.setLayout(new BorderLayout());
		gw =new GameWorld(); 
		mv = new MapView(); 
		sv = new ScoreView(); 
		
		gw.addObserver(mv); 
		gw.addObserver(sv); 
		
		this.add(BorderLayout.NORTH,sv); 
		this.add(BorderLayout.CENTER,mv); 
		
		//Command Keys
		setUpMenu(); 
		setUpCommandLeft(); 
		setUpCommandRight();
		setUpCommandBottom(); 
		
		
		gw.init();
		this.show(); 
		//gw.createSound(); 
		revalidate(); 
		
		timer=new UITimer(this);
		timer.schedule(TICK,true,this); 
		
		GameWorld.setGameWidth(mv.getWidth());
		GameWorld.setGameHeight(mv.getHeight());
		
		mv.setMapViewOrigin(new Point(mv.getX(),mv.getY()));
		MapView.setMapViewHeight(mv.getHeight());
		MapView.setMapViewWidth(mv.getWidth());
		
		
		 
	}


	private void setUpMenu() {
		Toolbar tools= new Toolbar(); 
		this.setToolbar(tools); 
		tools.setTitle("Start to Finish Game");
		
		
		//Help Command
		hcmd=new HelpCommand(); 
		tools.addCommandToRightBar(hcmd); 
		
		//Exit Command
		 ecmd=new ExitCommand(); 
		tools.addCommandToSideMenu(ecmd); 
		
		//About
		 acmd=new AboutCommand();
		tools.addCommandToSideMenu(acmd);
		
		//Acceleration Command
		 accmd= new AccelerateCommand(gw); 
		tools.addCommandToSideMenu(accmd); 
		
		//Sound 
		chkBoxCmd= new CheckBox(); 
		chkBoxCmd.getAllStyles().setBgTransparency(255);
		chkBoxCmd.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		chkBoxCmd.setFocusable(false);
	    sound=new SoundCommand(gw); 
		chkBoxCmd.setCommand(sound);
		//adding all to the sidemenu 
		tools.addComponentToSideMenu(chkBoxCmd);
		
	}

	private void setUpCommandRight() {

		Container rightContainer = new Container((new BoxLayout(BoxLayout.Y_AXIS)));
		rightContainer.getAllStyles().setBorder(Border.createLineBorder(1,ColorUtil.rgb(0, 0, 0)));
		
		// Brake button
		 bkcmd=new BrakeCommand(gw); 
		 btnBrake= new Button(bkcmd); 
		btnBrake=topSide(btnBrake); 
		rightContainer.add(btnBrake); 
		addKeyListener('b', bkcmd); 
		
		//Right Turn Button
		 rtcmd=new TurnRightCommand(gw); 
		 btnRight=new Button(rtcmd); 
		btnRight= applyMakeup(btnRight); 
		rightContainer.add(btnRight); 
		addKeyListener('r',rtcmd); 
		this.add(BorderLayout.EAST,rightContainer); 
		
		
	}
	
	private void setUpCommandLeft() {
		Container leftContainer=new Container((new BoxLayout(BoxLayout.Y_AXIS)));
		leftContainer.getAllStyles().setBorder(Border.createLineBorder(1,ColorUtil.rgb(0, 0, 0)));
		
		//Accelerate Button
		 accmd=new AccelerateCommand(gw); 
		 btnAccelerate = new Button(accmd); 
		btnAccelerate=topSide(btnAccelerate); 
		leftContainer.add(btnAccelerate);
		addKeyListener('a',accmd); 
		
		//Turn Left Button 
		 ltcmd = new TurnLeftCommand(gw); 
		 btnLeft= new Button(ltcmd); 
		btnLeft= applyMakeup(btnLeft); 
		leftContainer.add(btnLeft); 
		addKeyListener('l',ltcmd); 
		// adding all command buttons to the west container
		this.add(BorderLayout.WEST,leftContainer); 
		
		
		
	}
	
	private void setUpCommandBottom() { 
		Container bottomContainer= new Container((new BoxLayout(BoxLayout.X_AXIS)));
		bottomContainer.getAllStyles().setBorder(Border.createLineBorder(1,ColorUtil.rgb(0, 0, 0)));
		
		//PositionCommand
		position = new PositionCommand(gw); 
		btnPosition=new Button(position); 
		btnPosition=bothSide(btnPosition); 
		bottomContainer.add(btnPosition); 
		
		//PauseCommand
		 btnPause=new Button("Pause"); 
		btnPause=bothSide(btnPause);
		btnPause.getAllStyles().setMarginRight(450);
		 pause=new PauseCommand(gw,this,btnPause); 
		btnPause.setCommand(pause);
		bottomContainer.add(btnPause); 
		this.add(BorderLayout.SOUTH,bottomContainer); 
		
	}

	//Formatting all of the side buttons 
	private Button bothSide(Button obj) {
		obj.getAllStyles().setBgTransparency(255); 
		obj.getUnselectedStyle().setBgColor(ColorUtil.BLUE); 
		obj.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255)); 
		obj.getAllStyles().setBorder(Border.createLineBorder(2,ColorUtil.rgb(0,0,0)));
		obj.getAllStyles().setPadding(TOP, 5);
		obj.getAllStyles().setPadding(BOTTOM, 5);
		return obj; 
	}

	//Applying makeup to specific buttons 
	private Button applyMakeup(Button obj) {
		obj.getAllStyles().setBgTransparency(255); 
		obj.getUnselectedStyle().setBgColor(ColorUtil.BLUE); 
		obj.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255)); 
		obj.getAllStyles().setBorder(Border.createLineBorder(2,ColorUtil.rgb(0,0,0)));
		obj.getAllStyles().setPadding(TOP, 5);
		obj.getAllStyles().setPadding(BOTTOM, 5);
		return obj; 
		
	}


	//Formatting the top buttons 
	private Button topSide(Button obj) {
		obj.getAllStyles().setBgTransparency(255); 
		obj.getUnselectedStyle().setBgColor(ColorUtil.BLUE); 
		obj.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255)); 
		obj.getAllStyles().setBorder(Border.createLineBorder(2,ColorUtil.rgb(0,0,0)));
		obj.getAllStyles().setMarginTop( 100);
		obj.getAllStyles().setPadding(TOP, 5);
		obj.getAllStyles().setPadding(BOTTOM, 5);
		return obj; 
	}


	@Override
	public void run() {
		gw.tick(TICK); 
		
	}


	public void pressedPause() {
		if(!gw.getPause()) { 
			timer.cancel(); 
			removeKeyListener('b',bkcmd); 
			removeKeyListener('a',accmd); 
			removeKeyListener('l',ltcmd); 
			removeKeyListener('r',rtcmd);
			
			
			accmd.setEnabled(false); 
			bkcmd.setEnabled(false); 
			ltcmd.setEnabled(false);
			rtcmd.setEnabled(false); 
			btnAccelerate.setEnabled(false);
			btnBrake.setEnabled(false);
			btnLeft.setEnabled(false); 
			position.setEnabled(true);
			btnPosition.setEnabled(true);
			//gw.soundOff();
			gw.setPause(!gw.getPause());
			
			}else {
				timer.schedule(TICK, true, this);
				addKeyListener('b',bkcmd); 
				addKeyListener('a',accmd); 
				addKeyListener('l',ltcmd); 
				addKeyListener('r',rtcmd);
				accmd.setEnabled(true); 
				bkcmd.setEnabled(true); 
				ltcmd.setEnabled(true);
				rtcmd.setEnabled(true); 
				btnAccelerate.setEnabled(true);
				btnBrake.setEnabled(true);
				btnLeft.setEnabled(true); 
				position.setEnabled(false);
				btnPosition.setEnabled(false);
				//gw.soundOn();
				gw.setPause(!gw.getPause());
				
			}
		}
}
