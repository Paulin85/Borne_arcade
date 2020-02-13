package premier;

import org.newdawn.slick.Color;
import org.newdawn.slick.ControllerListener;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Options extends MapGameState implements ControllerListener {
	
	//déclaration des différentes variables pour la page Options
	
	private Image background;
	private StateBasedGame game;

	
    static Boolean easy = false;
    static Boolean normal = true;
    static Boolean hard = false;
    
    //ID de la page Options
    public int getID() {
        return 2;
    }
    
    
    //Mise en page 
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
    	background.draw(0, 0, container.getWidth(), container.getHeight());
        g.setColor(Color.white);
        g.drawString("Comment jouer:", 600, 200);
        g.drawString("Déplacements: Flèches directionelles.",600, 260);
        g.drawString("Tir: Espace", 600, 290);
        g.drawString("Le but: détruire un max de vaisseau ennemi.", 600, 320);
        g.drawString("Le premier à être touché 3 fois perds.", 600, 350);
        g.drawString("Choix de la difficultée:", 600, 400); 
        g.drawString("APPUYER SUR F OU BOUTON 2 POUR FACILE", 600, 430);
        g.drawString("APPUYER SUR N OU BOUTON 1 POUR NORMAL", 600, 460);
        g.drawString("APPUYER SUR G OU BOUTON 4 POUR DIFFICLE", 600, 490);
    }
    
	  @Override
	  public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    this.background = new Image("resources/background/space.jpg");
	    this.game = game;
	  }


	  //Choix de la difficultée en fonction de la touche entrée
    public void update(GameContainer container, StateBasedGame game, int i) throws SlickException {
        if (container.getInput().isKeyPressed(Input.KEY_F)) {
            System.out.println("Difficulté Facile Choisis");
            MapGameState.setEasy();
            game.enterState(0);
        }
        
        else if (container.getInput().isKeyPressed(Input.KEY_N)) {
            System.out.println("Difficulté Normal Choisis");
            MapGameState.setNormal();
            game.enterState(0);
        }
        
        else if (container.getInput().isKeyPressed(Input.KEY_G)) {
            System.out.println("Difficulté Difficile Choisis");
            MapGameState.setHard();
            game.enterState(0);
        }
    }
    
	
	//Action à l'appui du bouton
	@Override
	public void controllerButtonPressed(int controller, int button)  {
		System.out.println(controller);
		System.out.println(button);
		//Bouton Resistance pour Play
		 //Bouton Option
		 if (button == 7) {
	            MapGameState.setEasy();
	            game.enterState(0);		 }	
		 if (button == 9) {
	            MapGameState.setNormal();
	            game.enterState(0);			 }
		 if (button == 2) {
	            MapGameState.setHard();
	            game.enterState(0);			 }
		 	 
	}

}
