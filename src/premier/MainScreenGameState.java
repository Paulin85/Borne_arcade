package premier;

import java.awt.Font;

import org.newdawn.slick.ControllerListener;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import premier.Fenetre;

public class MainScreenGameState extends BasicGameState implements ControllerListener {

	//déclaration des différentes variables pour l'écran d'acceuil

	public static final int ID = 0;
	  private Image background;
	  private static  StateBasedGame game;
	  private static Fenetre f1;

	  @Override
	  public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    MainScreenGameState.game = game;
	    this.background = new Image("resources/background/space.jpg");
	  }

	  //Mise en page
	  @Override
	  public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
	    background.draw(0, 0, container.getWidth(), container.getHeight());
        g.drawString("StreetShooter", 600, 150);
        g.drawString("Veuillez d'abord choisir votre pseudo en appuyant sur 4 !!!", 400, 300);
        g.drawString("1. Jouer", 600, 370);
        g.drawString("2. Options", 600, 400);
        g.drawString("3. Classement", 600, 430);
	  }

	  //Gestion des touches du clavier pour changer d'écran
	  
	  @Override
	  public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		  
	        if (container.getInput().isKeyPressed(Input.KEY_1)) {
	            game.enterState(1, new FadeOutTransition(), new FadeInTransition());
	        }

	        if (container.getInput().isKeyPressed(Input.KEY_2)) {
	            game.enterState(2, new FadeOutTransition(), new FadeInTransition());
	        }
	        
	        if (container.getInput().isKeyPressed(Input.KEY_3)) {
	            game.enterState(5, new FadeOutTransition(), new FadeInTransition());
	        }
	        if (container.getInput().isKeyPressed(Input.KEY_4)) {
	        	f1 = new Fenetre();
	        }
	        
	  }

	   //ID de la page d'acceuil
	  @Override
	  public int getID() {
	    return 0;
	  }
	  
	 

		
		//Action à l'appui du bouton
		@Override
		public void controllerButtonPressed(int controller, int button)  {
			System.out.println(controller);
			System.out.println(button);
			//Bouton Resistance pour Play
			 if (button == 9) {
				 game.enterState(1, new FadeOutTransition(), new FadeInTransition());
			 }
			 //Bouton Option
			 if (button == 7) {
				 game.enterState(2, new FadeOutTransition(), new FadeInTransition());			 
			 }	
			 //Bouton ScoreBoard
			 if (button == 5) {
				 game.enterState(5, new FadeOutTransition(), new FadeInTransition());			 
				 }
			//Bouton pseudo
			 if (button == 2) {
				 f1 = new Fenetre();
				 }
			 	 
		}


}
