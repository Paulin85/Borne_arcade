package premier;

import java.util.ArrayList;

import javax.swing.DefaultListModel;


import premier.Joueur;
import premier.bdd;

import org.newdawn.slick.Color;
import org.newdawn.slick.ControllerListener;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class ScoreBoard extends MapGameState implements ControllerListener{
	
	//déclaration des différentes variables pour les ennemis
    ArrayList<Joueur> liste = bdd.selectAll();
    
	private Image background;
	private StateBasedGame game;

    
    public int getID() {
        return 5;
    }
    
  //affiche les images du Scoreboard
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
    	
    	background.draw(0, 0, container.getWidth(), container.getHeight());
        g.setColor(Color.white);
        g.drawString("HighScores"+ "\n\n" + liste , 600, 200);
        g.drawString("Bouton 1 pour retourner au menu", 50, 50);
    }
    
	//initialisation des différents objets du Scoreboard
	  @Override
	  public void init(GameContainer container, StateBasedGame game) throws SlickException {
		  	this.game = game;
		    this.background = new Image("resources/background/space.jpg");
		  
			 DefaultListModel modeldeliste;

			modeldeliste= new DefaultListModel();
			
        for(Joueur p: liste) {
            modeldeliste.addElement(p);
        }
	    
	  }



    public void update(GameContainer container, StateBasedGame game, int i) throws SlickException {
    	
        if (container.getInput().isKeyPressed(Input.KEY_1)) {
			 game.enterState(0, new FadeOutTransition(), new FadeInTransition());
        }
    	

    }
    
	//Action à l'appui du bouton
	@Override
	public void controllerButtonPressed(int controller, int button)  {
		System.out.println(button);
		 if (button == 9) {
			 game.enterState(0, new FadeOutTransition(), new FadeInTransition());
		 }
		 
		 
	}

    
    
}
