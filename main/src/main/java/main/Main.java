package main;

import controller.Controller;

import model.ILevel;
import model.Level;
import view.Frame;
import view.IView;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
    	
    	
    	ILevel level = new Level();
    	IView view = new Frame(level);
    	
    	Controller controller = new Controller(level , view);
    	controller.play();
    	

}
    

}
