package premier;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class StateGame extends StateBasedGame {
	
	//Lancement de la fen�tre du jeu
	 public static void main(String[] args) throws SlickException {
		    new AppGameContainer(new StateGame(), 1366, 768, false).start();
		  }

		  public StateGame() {
		    super("StreetShooter");
		  }
		 
		  //Initialisation des diff�rentes boucles du jeu
		  @Override
		  public void initStatesList(GameContainer container) throws SlickException {
		    addState(new MainScreenGameState());
		    addState(new MapGameState());
	        addState(new Pause());
	        addState(new Options());
	        addState(new ScoreBoard());
	        addState(new GameOver());
	        addState(new GameOver2());
		  }

}
