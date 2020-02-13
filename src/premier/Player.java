package premier;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
//import org.newdawn.slick.geom.Ellipse;
//import org.newdawn.slick.geom.Shape;

public class Player {

	//déclaration des différentes variables pour les players
	
	private float x, y;
	private int direction=0;
	private boolean moving = false;
	private Animation[] animations = new Animation[8];
	private SpriteSheet spriteSheet;
	private int health;
    private int damage;
    
	private Map map;

	public Player(Map map, int x, int y, int health, int damage) {
		this.health = health;
	    this.damage = damage;
		this.map = map;
		this.x = x;
		this.y = y;
		
	}

	public void init() throws SlickException {
		// chargement du personnage
				SpriteSheet spriteSheet = new SpriteSheet("sprites/spaceship.png", 50, 45);
			    this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
			    this.animations[1] = loadAnimation(spriteSheet, 0, 1, 0);
			    this.animations[2] = loadAnimation(spriteSheet, 0, 1, 0);
			    this.animations[3] = loadAnimation(spriteSheet, 0, 1, 0);
			    this.animations[4] = loadAnimation(spriteSheet, 0, 1, 0);
			    this.animations[5] = loadAnimation(spriteSheet, 0, 1, 0);
			    this.animations[6] = loadAnimation(spriteSheet, 0, 1, 0);
			    this.animations[7] = loadAnimation(spriteSheet, 0, 1, 0);
			    
	}

	//Méthode pour l'animation
	private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
	    Animation animation = new Animation();
	    for (int x = startX; x < endX; x++) {
	        animation.addFrame(spriteSheet.getSprite(x, y), 100);
	    }
	    return animation;
	}
	

	public void render(Graphics g) {
		//parametres du personnage
		g.setColor(new Color(0, 0, 0, .5f));
		g.fillOval((int) x - 16, (int) y - 8, 32, 16);
		g.drawAnimation(animations[direction + (moving ? 4 : 0)], (int) x - 32, (int) y - 60);
	}

	public void update(GameContainer container, int delta) throws SlickException {
		//Gestion de la Collision
		   if (this.moving) {
		        float futurX = getFuturX(delta);
		        float futurY = getFuturY(delta);
		        boolean collision = this.map.isCollision(futurX, futurY);
		        if (collision) {
		            this.moving = false;
		        } else {
		            this.x = futurX;
		            this.y = futurY;
		        }
		    }
		    
	}

	//Méthode pour trouver le déplacement X futur pour les collisions
		private float getFuturX(int delta) {
		    float futurX = this.x;
		    switch (this.direction) {
		    case 1: futurX = this.x - .5f * delta; break;
		    case 3: futurX = this.x +.5f * delta; break;
		    }
		    return futurX;
		}

		//Méthode pour trouver le déplacement Y futur pour les collisions
		private float getFuturY(int delta) {
		    float futurY = this.y;
		    switch (this.direction) {
		    case 0: futurY = this.y - .5f * delta; break;
		    case 2: futurY = this.y +.5f * delta; break;
		    }
		    return futurY;
		}
		
		
		
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    

}