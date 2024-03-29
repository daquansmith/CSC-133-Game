package com.mycompany.a3;
import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label; 
import com.codename1.ui.layouts.BoxLayout; 

//This class is an observer of the game class
public class ScoreView extends Container implements Observer{
	private GameWorld gw; 
	private Label livesLabel; 
	private Label clockLabel; 
	private Label lastFlagReachedLabel; 
	private Label foodLevelLabel; 
	private Label healthLevelLabel; 
	private Label soundValueLabel; 
	
	//These are all labels for the information that is observerd
	public ScoreView() {
		setLayout(); 
		setClockLabel(); 
		setLivesLabel(); 
		setLastFlagReachedLabel(); 
		setFoodLevelLabel(); 
		setHealthLevelLabel(); 
		setSoundValueLabel(); 
	}
	//Setting layout for this observer 
	public void setLayout() {
		this.setLayout(new BoxLayout(BoxLayout.X_AXIS));
	}
	//This is adding an label for lives
	public void setLivesLabel() {
		Label lifeLabel=new Label("Lives left: ");
		lifeLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		lifeLabel.getAllStyles().setPadding(1,1,1,1);
		livesLabel=new Label("0"); 
		livesLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		livesLabel.getAllStyles().setPadding(RIGHT, 3);
		this.add(lifeLabel);
		this.add(livesLabel); 
		
	}
	
	//adding a label for clock
	public void setClockLabel() {
		Label timeLabel=new Label("Time: ");
		timeLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		timeLabel.getAllStyles().setPadding(1,1,1,1);
		clockLabel=new Label("0"); 
		clockLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		clockLabel.getAllStyles().setPadding(RIGHT, 3);
		this.add(timeLabel);
		this.add(clockLabel); 
	}
	//adding a label for food level
	public void setFoodLevelLabel() {
		Label foodLabel=new Label("Ant Food Level: ");
		foodLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		foodLabel.getAllStyles().setPadding(1,1,1,1);
		foodLevelLabel=new Label("0"); 
		foodLevelLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		foodLevelLabel.getAllStyles().setPadding(RIGHT, 3);
		this.add(foodLabel);
		this.add(foodLevelLabel); 
	}
	//adding a label for health level
	public void setHealthLevelLabel() {
		Label healthLabel=new Label("Ant Health Level: ");
		healthLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		healthLabel.getAllStyles().setPadding(1,1,1,1);
		healthLevelLabel=new Label("0"); 
		healthLevelLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		healthLevelLabel.getAllStyles().setPadding(RIGHT, 5);
		this.add(healthLabel);
		this.add(healthLevelLabel); 
	}
	
	//adding a label for last flag reached
	public void setLastFlagReachedLabel() {
		Label lastFlagLabel=new Label("Last Flag Reached: ");
		lastFlagLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		lastFlagLabel.getAllStyles().setPadding(1,1,1,1);
		lastFlagReachedLabel=new Label("0"); 
		lastFlagReachedLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		lastFlagReachedLabel.getAllStyles().setPadding(RIGHT, 3);
		this.add(lastFlagLabel);
		this.add(lastFlagReachedLabel); 
	}
	//adding sound label 
	public void setSoundValueLabel() {
		Label soundLabel=new Label("Sound: ");
		soundLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		soundLabel.getAllStyles().setPadding(1,1,1,1);
		soundValueLabel=new Label("OFF"); 
		soundValueLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		soundValueLabel.getAllStyles().setPadding(RIGHT, 5);
		this.add(soundLabel);
		this.add(soundValueLabel); 
	}
	
	
	//Overriden update in order to get the correct data to be displayed
	@Override
	public void update(Observable observable, Object data) {
		gw=(GameWorld) data; 
		this.livesLabel.setText(" "+gw.getLife());
		this.clockLabel.setText(" "+gw.getTime());
		this.lastFlagReachedLabel.setText(" "+gw.getLastFlagReached());
		this.foodLevelLabel.setText(" "+gw.getFoodLevel());
		this.healthLevelLabel.setText(" "+gw.getHealthLevel());
		
		if(gw.getSound()) {
			this.soundValueLabel.setText("ON");
			System.out.println("Sound ON");
		}else {
			this.soundValueLabel.setText("OFF"); 
		}
		this.repaint(); 
		
		
	}

}
