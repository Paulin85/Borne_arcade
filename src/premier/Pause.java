package premier;

import org.newdawn.slick.Color;
import org.newdawn.slick.ControllerListener;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Pause extends BasicGameState implements ControllerListener {
	
	private int numJoystick;
	private StateBasedGame game;
	
	
	//ID de la page Pause
    public int getID() {
        return 3;
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    this.game = game;
        
    }
    
    
    //Action réalisé à l'appui des touches
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if (container.getInput().isKeyPressed(Input.KEY_R)) {
            game.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }
        
        if (container.getInput().isKeyPressed(Input.KEY_C)) {
        	MapGameState.updatePlay();
            game.enterState(0);
        }
        
    }
    
    //Mise en page 
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(Color.white);
        g.drawString("PAUSED", 600, 300);
        g.drawString("R OU BOUTON P POUR REPRENDRE", 600, 350);
        g.drawString("C OU BOUTON 1 POUR REVENIR AU MENU", 600, 400);
    }
    
	//Action à l'appui du bouton
	@Override
	public void controllerButtonPressed(int controller, int button)  {
		System.out.println(button);
		 if (button == 11) {
			 
			 game.enterState(1, new FadeOutTransition(), new FadeInTransition());
		 }
		 if (button == 9) {
	        	MapGameState.updatePlay();
	            game.enterState(0);
		 }
		 if (button == 4) {
			 
			 game.enterState(1, new FadeOutTransition(), new FadeInTransition());
		 }
		 
		 
	}
	
	
}
