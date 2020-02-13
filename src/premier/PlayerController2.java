package premier;

import org.newdawn.slick.ControllerListener;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;

public class PlayerController2 implements KeyListener, ControllerListener {
	
	//déclaration des différentes variables pour les controllers du player 2

	private Player player2;
	private int numJoystick;

    public PlayerController2(Player player, int numJoystick) {
        this.player2 = player;
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
		case Input.KEY_UP:
			this.player2.setDirection(0);
			this.player2.setMoving(true);
			break;
		case Input.KEY_LEFT:
			this.player2.setDirection(1);
			this.player2.setMoving(true);
			break;
		case Input.KEY_DOWN:
			this.player2.setDirection(2);
			this.player2.setMoving(true);
			break;
		case Input.KEY_RIGHT:
			this.player2.setDirection(3);
			this.player2.setMoving(true);
			break;
		}
	}
	
	//Actions au relâchement des touches

	@Override
	public void keyReleased(int key, char c) {
		switch(key){
        case Input.KEY_UP: 
          if(this.player2.getDirection() == 0) this.player2.setMoving(false); 
            break;
        case Input.KEY_LEFT: 
          if(this.player2.getDirection() == 1) this.player2.setMoving(false);
            break;
        case Input.KEY_DOWN: 
          if(this.player2.getDirection() == 2) this.player2.setMoving(false);
            break;
        case Input.KEY_RIGHT: 
          if(this.player2.getDirection() == 3) this.player2.setMoving(false);
            break;
      }
	}

	//Action en fonction de la direction du joystick

	@Override
	public void controllerLeftPressed(int controller2) {
		if (controller2 == 2) {
		this.player2.setDirection(1);
		this.player2.setMoving(true);}
	}

	@Override
	public void controllerLeftReleased(int controller2) {
        if(this.player2.getDirection() == 1) this.player2.setMoving(false);
	}

	@Override
	public void controllerRightPressed(int controller2) {
		if (controller2 == 2) {
		this.player2.setDirection(3);
		this.player2.setMoving(true);}
	}

	@Override
	public void controllerRightReleased(int controller2) {
		if(this.player2.getDirection() == 3) this.player2.setMoving(false);
	}

	@Override
	public void controllerUpPressed(int controller2) {
		if (controller2 == 2) {
		this.player2.setDirection(0);
		this.player2.setMoving(true);}
	}

	@Override
	public void controllerUpReleased(int controller2) {
		if(this.player2.getDirection() == 0) this.player2.setMoving(false); 
	}

	@Override
	public void controllerDownPressed(int controller2) {
		if (controller2 == 2) {
		this.player2.setDirection(2);
		this.player2.setMoving(true);}
	}

	@Override
	public void controllerDownReleased(int controller2) {
        if(this.player2.getDirection() == 2) this.player2.setMoving(false);
	}
	
	//Action à l'appui du bouton

	@Override
	public void controllerButtonPressed(int controller2, int button) {
		System.out.println(controller2);
		System.out.println(button);
		
		 if (button == 1) {
             if (MapGameState.shotDelay > MapGameState.timedShotDelay) {
            	 MapGameState.shotDelay = 0;

    			 try {
    					MapGameState.shootEnemy2();
    				} catch (SlickException e) {
    					e.printStackTrace();
    				}
             }
		 }
	}

	@Override
	public void controllerButtonReleased(int controller2, int button) {
	}

}
