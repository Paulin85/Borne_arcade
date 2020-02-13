package premier;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class GameOver extends MapGameState {
	
	  private static  StateBasedGame game;
	  
	//ID de la page GameOver
	 public int getID() {
	        return 4;
	    }
	 
	  @Override
	  public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    this.game = game;
	  }

	    
	    public void update(GameContainer gc, StateBasedGame game, int i) throws SlickException {
	    	MapGameState.updatePlay();
	    	
	    	//Gestion des pages à l'aide du clavier
	        if (gc.getInput().isKeyPressed(Input.KEY_Y)) {
	            game.enterState(1, new FadeOutTransition(), new FadeInTransition());            
	        }
	        
	        if (gc.getInput().isKeyPressed(Input.KEY_N)) {
	            game.enterState(0, new FadeOutTransition(), new FadeInTransition());
	        }
	        if (gc.getInput().isKeyPressed(Input.KEY_L)) {
	            game.enterState(5, new FadeOutTransition(), new FadeInTransition());
	        }
	    }
	    
	    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
	    	
	    	//Mise en page de la page 
	        g.setColor(Color.white);
	        g.drawString("GAME OVER! " + Joueur2.pseudo_joueur + " WIN !", 600,100);
	        
	        g.drawString("PLAYER 1", 300, 300);
	        g.drawString("Your final score was " + finalScore, 300, 340);

	        
	        g.drawString("PLAYER 2", 960, 300);
	        g.drawString("Your final score was " + finalScore2, 960, 340);
	        
	        g.drawString("Try again? (Y/N)", 600, 460);
	        g.drawString("LeaderBoard (L)", 600, 480);
	        

	    }
	    
		//Action à l'appui du bouton
		@Override
		public void controllerButtonPressed(int controller, int button)  {
			System.out.println(button);
			//Bouton Resistance pour Play
			 if (button == 9) {
				 game.enterState(1, new FadeOutTransition(), new FadeInTransition());			 }
			 //Bouton Option
			 if (button == 7) {
		         game.enterState(0, new FadeOutTransition(), new FadeInTransition());
			 }	
			 if (button == 5) {
		         game.enterState(5, new FadeOutTransition(), new FadeInTransition());
				 }

			 	 
		}

}
