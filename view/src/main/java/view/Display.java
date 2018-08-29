package view;
/**
 * <h1>The Display class</h1>
 * 
 * @author Roxane-Vonarb
 * @version 1.0
 */
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.ILevel;
import model.ITile;



public class Display extends JPanel implements Observer {
	/** The serial version. */
	private static final long serialVersionUID = 1L;
	
	/** The model. */
	private ILevel level;
	
	
	public Display(ILevel level) {
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		System.out.println("Affichage");
		this.level = level;
		
		for (ITile tile : level.getMap()) {
			((Observable) tile).addObserver(this);
		}
		((Observable) level.getPlayer()).addObserver(this);
		
		
		
		
	}
	
	public void drawGrid(Graphics g)throws IOException, InterruptedException {
		
		
		for (ITile tile : level.getMap()) {
			g.setColor(tile.getColor());
			g.fillRect(
					tile.getX()*level.getPixels(),
					tile.getY()*level.getPixels(),
					level.getPixels(),
					level.getPixels()
					);
		}
		
		// player 
		g.setColor(level.getPlayer().getColor());
		g.fillRect(
				level.getPlayer().getX()*level.getPixels(),
				level.getPlayer().getY()*level.getPixels(),
				level.getPixels(),
				level.getPixels());
				
		
		
		
		
	}
	
	
	
	
	
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
			 try {
				drawGrid(g);
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		this.repaint();
		//System.out.println("Update");
		
	}

}
