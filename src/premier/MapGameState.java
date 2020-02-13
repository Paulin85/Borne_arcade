package premier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.ControllerListener;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MapGameState extends BasicGameState implements ControllerListener {
	
	//déclaration des différentes variables nécessaire au jeu

	public static final int ID = 2;

	private GameContainer container;
	private static Map map = new Map();
	private static Player player = new Player(map, 340, 700, 3, 1);
	private static Player player2 = new Player(map, 1020, 700, 3, 1 );
	private PlayerController controller = new PlayerController(MapGameState.player, 1);
	private PlayerController2 controller2 = new PlayerController2(MapGameState.player2, 2);
	protected static ArrayList<Ennemy> enemies;
	protected static ArrayList<Missile> missile;
	protected static ArrayList<Missile> missile2;
	private static double missleSpeed = 1;
	static double enemySpeed = 0.1;
	protected double timePassed = 0.0;
	public static int spawnTime = 500;
	static int shotDelay = 0;
	static int timedShotDelay = 100;
	protected Random rng = new Random();
	private StateBasedGame game;

	
	
	
	public static int score = 0;
	public static int score2 = 0;
	static int finalScore;
	static int finalScore2;
	
	
	protected Shape enemyHB;
	protected static Shape missileHB;
	protected static Shape missileHB2;
	protected Shape playerHB;
	protected Shape playerHB2;
	
	
	//initialisation des différents objets du jeu
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
	    this.game = game;
		this.container = container;
		Music background = new Music("resources/musique/Venus.wav");
		background.loop();
		MapGameState.map.init();
		MapGameState.player.init();
		MapGameState.player2.init();
		missile = new  ArrayList<Missile>();
		missile2 = new  ArrayList<Missile>();
		enemies = new ArrayList<Ennemy>();
		
		playerHB = new Ellipse((int)player.getX(), (int)player.getY(), -15, -25);
		playerHB2 = new Ellipse((int)player2.getX(), (int)player2.getY(), -15, -25);
			
		 container.getInput().addKeyListener(controller);
		 container.getInput().addControllerListener(controller);
		 
		 container.getInput().addKeyListener(controller2);
		 container.getInput().addControllerListener(controller2);
	}
	
	
	
	//affiche les images du jeu
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		MapGameState.map.render();
		MapGameState.player.render(g);
		MapGameState.player2.render(g);
		
		for (Missile m : missile) {
            m.getImage().draw((int)m.getX(), (int)m.getY());
			}
		
		for (Missile m : missile2) {
            m.getImage().draw((int)m.getX(), (int)m.getY());
			}
		

		for (Ennemy e: enemies) {
                    e.getImage().draw((int)e.getX(), (int)e.getY());
		}
		
		
		g.setColor(Color.white);
		g.drawString("Health: " + (int)player.getHealth(), 50, 50);		
		g.drawString("Health: " + (int)player2.getHealth(), 800, 50);
		
		g.drawString("Score: " + score, 500, 50);		
		g.drawString("Score: " + score2, 1200, 50);
		
		
}
	
	//mise à jour du jeux en fonction d'un temps delta

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {

		MapGameState.player.update(container, delta);
		MapGameState.player2.update(container, delta);
		
		// Pause    

		if (container.getInput().isKeyPressed(Input.KEY_P)) {
			game.enterState(3, new FadeOutTransition(), new FadeInTransition());
		}
		
		shotDelay += delta;
		
		//Action de touche du missile joueur 1
		if (container.getInput().isKeyPressed(Input.KEY_G)) {            
                    if (shotDelay > timedShotDelay) {
                        shotDelay = 0;

                        shootEnemy();
                    }
		}
		
		//Action de touche du missile joueur 2		
		if (container.getInput().isKeyPressed(Input.KEY_ENTER)) {            
            if (shotDelay > timedShotDelay) {
                shotDelay = 0;

                shootEnemy2();
            }
		}	

                    
		
		// Définition de la hitbox des joueurs.
		playerHB.setLocation((float)player.getX(), (float)player.getY());
		playerHB2.setLocation((float)player2.getX(), (float)player2.getY());
		
		// Incrémentation du temps qui définit le spawn des ennemis
		timePassed += delta;
		
	 if (timePassed > spawnTime) {
			timePassed = 0;
			addEnemy();
		}	
		
		// ArrayList des missile pour les joueurs
				for (Missile m : missile) {
					m.setY(m.getY() - missleSpeed);
				}
				
				for (Missile m : missile2) {
					m.setY(m.getY() - missleSpeed);
				}
				
                // ArrayList des ennemis
				for (Ennemy e : enemies) {
					e.setY(e.getY() + enemySpeed);
				}
				
				
                //Tant qu'il y'a des ennemis dans l'ArrayList, les affichent en haut de l'écran
                
                // Actualise la localisation des ennemis et les collisions des hitboxes
                
		for (Iterator<Ennemy> enemyIterator = enemies.iterator(); enemyIterator.hasNext();) {
                    Ennemy curEnemy = enemyIterator.next();
                    enemyHB.setLocation((float)curEnemy.getX(), (float)curEnemy.getY());
                    
                    if (enemyHB.intersects(playerHB)) 
                    {

                        player.setHealth(player.getHealth() - 1);
                        if (player.getHealth() <= 0) 
                        {
                                game.enterState(4);//4
                                finalScore = score;
                                finalScore2 = score2;
                                
                                Joueur p = new Joueur();
                                bdd.score(p);  
                                
                                Joueur2 p2 = new Joueur2();
                                bdd.score2(p2);
                        }

                        enemyIterator.remove();
                    }
                    
                    if (enemyHB.intersects(playerHB2)) 
                    {

                        player2.setHealth(player2.getHealth() - 1);
                        if (player2.getHealth() <= 0) 
                        {
                                game.enterState(7);//4
                                finalScore2 = score2;
                                finalScore = score;
                                
                                Joueur p = new Joueur();
                                bdd.score(p);
                                
                                Joueur2 p2 = new Joueur2();
                                bdd.score2(p2);
                        }

                        enemyIterator.remove();
                    }

                     for (Iterator<Missile> missileIterator = missile.iterator(); missileIterator.hasNext();) {
                    	
                        Missile curMissile = missileIterator.next();

                        // Définition de la hitbox des missiles
                       missileHB.setLocation((float)curMissile.getX(), (float)curMissile.getY());
                       

                        //Détruit le missile si il arrive en bas de l'écran
                        if (curMissile.getY() < 0) {
                                missileIterator.remove();
                        }          

                        // Si le missile touche un ennemi, il est détruit avec l'ennemi
                        if (missileHB.intersects(enemyHB)) {
                                enemyIterator.remove();
                                missileIterator.remove();
                                score += 100;
                        } 
                        
                    }
                     
                     for (Iterator<Missile> missileIterator = missile2.iterator(); missileIterator.hasNext();) {
                     	
                         Missile curMissile = missileIterator.next();
                        
                        // Hitbox missile
                       missileHB2.setLocation((float)curMissile.getX(), (float)curMissile.getY());

                         // Destruction du missile
                         if (curMissile.getY() < 0) {
                                 missileIterator.remove();
                         }          

                         // Destruction du missile et de l'ennemi
                         if (missileHB2.intersects(enemyHB)) {
                                 enemyIterator.remove();
                                 missileIterator.remove();
                                 score2 += 100;
                         } 
                         
                     }
                    
                    
                    }
		
 		// Supprime les ennemis si ils arrivent en bas de l'écran
 		for (int count = enemies.size() - 1; count >= 0; count--) {
                     Ennemy e = enemies.get(count);
                     if (e.getY() > 750 || e.getHealth() < 0 || e.getX() < 50 || e.getX() > 1300) {
                    	 
                             enemies.remove(count);
                                                      
                     }
                     
                     
                     if (e.getX() > 700 && e.getY() > 750) { 
                      	player2.setHealth(player2.getHealth() - 1);
                      	
                      	 if (player2.getHealth() <= 0) 
                           {
                                   game.enterState(7);//4
                                   finalScore = score;
                                   finalScore2 = score2;
                                   
                                   
                                   Joueur p = new Joueur();
                                   bdd.score(p);
                                   
                                   Joueur2 p2 = new Joueur2();
                                   bdd.score2(p2);
                           }
                      }
                     
                     
                      if (e.getX() < 666 && e.getY() > 750) {
                     	 
                      	player.setHealth(player.getHealth() - 1);
                      	
                          if (player.getHealth() <= 0) 
                          {
                                  game.enterState(4);//4
                                  finalScore2 = score2;
                                  finalScore = score;
                                  
                                  
                                  Joueur p = new Joueur();
                                  bdd.score(p);
                                  
                                  Joueur2 p2 = new Joueur2();
                                  bdd.score2(p2);
                          }
                      }
                     
 		}	
		
	}
	
	
	//Action à l'appui du bouton
	@Override
	public void controllerButtonPressed(int controller, int button)  {
		System.out.println(controller);
		System.out.println(button);
		//Bouton Resistance pour Play
		 if (button == 11) {
			 game.enterState(3, new FadeOutTransition(), new FadeInTransition());
		 }
		 if (button == 4) {
			 game.enterState(3, new FadeOutTransition(), new FadeInTransition());
		 }
		 	 
	}
		
				 				
	//Fonction qui réinitialise les données du jeu
	public static void updatePlay(){
        player.setX(340);
        player.setY(700);
        player2.setX(1020);
        player2.setY(700);
        missile = new  ArrayList<Missile>();
        player.setHealth(3);
        missile2 = new  ArrayList<Missile>();
        player2.setHealth(3);
        enemies = new ArrayList<Ennemy>();
        score = 0;
        score2 = 0;
	
}
	
	//Fonction d'ajout d'un ennemi
	public void addEnemy() throws SlickException {
        Ennemy e = new Ennemy("sprites/ennemy.png");
        e.setX(rng.nextInt(1550));
        enemyHB = new Ellipse((int)e.getX() + 10, (int)e.getY(), 20, 20);
        enemies.add(e);
}

	
	//Fonction d'ajout d'un missile pour le joueur 1
	public static void shootEnemy() throws SlickException  {
        Missile m = new Missile("sprites/missile.png");
        m.setX(player.getX()- 12);
        m.setY(player.getY() - 70);
        missileHB = new Ellipse((int)m.getX(), (int)m.getY(), 5, 5);
        missile.add(m);
}

	//Fonction d'ajout d'un missile pour le joueur 2
	public static void shootEnemy2() throws SlickException {
    Missile m = new Missile("sprites/missile.png");
    m.setX(player2.getX()- 12);
    m.setY(player2.getY() - 70);
    missileHB2 = new Ellipse((int)m.getX(), (int)m.getY(), 5, 5);
    missile2.add(m);
	}

    // Changement de difficulté
    //Niveau facile
	public static void setEasy(){
			missleSpeed = 0.5;
			shotDelay = 0;
			timedShotDelay = 400;
			enemySpeed = 0.1;
			player.setHealth(1);
		    player2.setHealth(1);
	
	}
	
	//Niveau normal
	public static void setNormal(){
			missleSpeed = 1;
			shotDelay = 0;
			timedShotDelay = 200;
			enemySpeed = 0.2;
	}
    
	//Niveau difficile
	public static void setHard(){
			missleSpeed = 2;
			shotDelay = 0;
			timedShotDelay = 100;
			enemySpeed = 0.5;
			player.setHealth(5);
		    player2.setHealth(5);
	}
	
	
	//Ferme la fenêtre si appuie sur echape
	@Override
	public void keyReleased(int key, char c) {
		if (Input.KEY_ESCAPE == key) {
			this.container.exit();
		}
	}

	//ID de la page MapGameState
	@Override
	public int getID() {
		return 1;
	}
	
}
