package controller;

import java.awt.Color;
import java.util.Scanner;



import model.ILevel;
import model.ITile;
import view.IView;

public class Controller implements IController{
	
	public ILevel level;
	public IView view;
	
	int countgrey;
	
	
	

	public  Controller(ILevel level, IView view) {
		this.view= view;
		this.level=level;
	}
	
	
	
	
	
	
	
	
	
	public void play() {
		level.getTimer().start();
		System.out.println("Play");
		while(level.getPlayer().isAlive() && countgrey!=1){
		
		countgrey=0;	
		for (ITile tile : level.getMap()) {
			tile.reduce();
			countgrey +=(tile.getColor()==Color.GRAY)?1:0;
			if(tile.getX()==level.getPlayer().getX()&& tile.getY()==level.getPlayer().getY() && tile.getColor()==Color.BLACK) {level.getPlayer().setAlive(false);}
			
	
		}
		
		
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		level.getTimer().stop();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Well played, please enter your name:");
		String scr = sc.nextLine();
		
		
		
		level.save(scr);
		System.out.println("you've been registered");
		
		
		if(countgrey==1)this.view.displayMessage("You won " + level.getTimer().getTime());
			
		else{this.view.displayMessage("Game Over in " + level.getTimer().getTime());}
		
		
	}










	
	
	
	
	

}
