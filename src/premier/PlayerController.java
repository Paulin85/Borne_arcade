package premier;

import org.newdawn.slick.ControllerListener;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;


public class PlayerController implements KeyListener, ControllerListener {

	//déclaration des différentes variables pour les controllers du player 1

	private Player player;
	private int numJoystick;
    
    public PlayerController(Player player, int numJoystick) {
        this.player = player;
        this.numJoystick = numJoystick;
    }
	

	@Override
	public void setInput(Input input) {

	}

	@Override
	public boolean isAcceptingInput() {
		return true;
	}

	@Override
	public void inputEnded() {

	}

	@Override
	public void inputStarted() {

	}

	//Actions à l'appui des touches
	@Override
	public void keyPressed(int key, char c) {
		switch (key) {
		case Input.KEY_Z:
			this.player.setDirection(0);
			this.player.setMoving(true);
			break;
		case Input.KEY_Q:
			this.player.setDirection(1);
			this.player.setMoving(true);
			break;
		case Input.KEY_S:
			this.player.setDirection(2);
			this.player.setMoving(true);
			break;
		case Input.KEY_D:
			this.player.setDirection(3);
			this.player.setMoving(true);
			break;

		}
	}
	
	//Actions au relâchement des touches
	@Override
	public void keyReleased(int key, char c) {
		switch(key){
        case Input.KEY_Z: 
          if(this.player.getDirection() == 0) this.player.setMoving(false); 
            break;
        case Input.KEY_Q: 
          if(this.player.getDirection() == 1) this.player.setMoving(false);
            break;
        case Input.KEY_S: 
          if(this.player.getDirection() == 2) this.player.setMoving(false);
            break;
        case Input.KEY_D: 
          if(this.player.getDirection() == 3) this.player.setMoving(false);
            break;
      }
	}
	
	public void getControllerCount() {
	}
	
	//Action en fonction de la direction du joystick

	@Override
	public void controllerLeftPressed(int controller) {
		numJoystick = 0;
		 if (controller == this.numJoystick) {
		this.player.setDirection(1);
		this.player.setMoving(true);
		 }
	}

	@Override
	public void controllerLeftReleased(int controller) {
        if(this.player.getDirection() == 1) this.player.setMoving(false);
	}

	@Override
	public void controllerRightPressed(int controller) {
		numJoystick = 0;
		 if (controller == this.numJoystick) {
	    this.player.setDirection(3);
		this.player.setMoving(true);
		 }
	}

	@Override
	public void controllerRightReleased(int controller) {
		if(this.player.getDirection() == 3) this.player.setMoving(false);
	}

	@Override
	public void controllerUpPressed(int controller) {
		numJoystick = 0;
		 if (controller == this.numJoystick) {
			 this.player.setDirection(0);
		     this.player.setMoving(true);
		}
	}

	@Override
	public void controllerUpReleased(int controller) {
        if(this.player.getDirection() == 0) this.player.setMoving(false); 
	}

	@Override
	public void controllerDownPressed(int controller) {
		numJoystick = 0;
		 if (controller == this.numJoystick) {
		this.player.setDirection(2);
		this.player.setMoving(true);
		 }
	}

	@Override
	public void controllerDownReleased(int controller) {
        if(this.player.getDirection() == 2) this.player.setMoving(false);
	}

	
	//Action à l'appui du bouton
	@Override
	public void controllerButtonPressed(int controller, int button)  {
		System.out.println(controller);
		System.out.println(button);
		 if (button == 12) {
             if (MapGameState.shotDelay > MapGameState.timedShotDelay) {
            	 MapGameState.shotDelay = 0;

    			 try {
    					MapGameState.shootEnemy();
    				} catch (SlickException e) {
    					e.printStackTrace();
    				}
             }
		 }
		 
		 
	}

	@Override
	public void controllerButtonReleased(int controller, int button) {	
	}

}
