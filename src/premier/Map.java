package premier;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;


public class Map {
	
	//attribution des variables
	private TiledMap map;

	public void init() throws SlickException {
		// chargement de la carte
		this.map = new TiledMap("resources/map/REAL.tmx");
	}

	public void render() {
		this.map.render(0, 0, 0);
	}

	//Méthode pour déterminer si il y'a collision
		public boolean isCollision(float x, float y) {
		    int tileW = this.map.getTileWidth();
		    int tileH = this.map.getTileHeight();
		    int logicLayer = this.map.getLayerIndex("Collision");
		    Image tile = this.map.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
		    boolean collision = tile != null;
		    if (collision) {
		        Color color = tile.getColor((int) x % tileW, (int) y % tileH);
		        collision = color.getAlpha() > 0;
		    }
		    return collision;
		}

		public void changeMap(String file) throws SlickException {
			this.map = new TiledMap(file);
		}

		public int getObjectCount() {
			return this.map.getObjectCount(0);
		}

		public String getObjectType(int objectID) {
			return this.map.getObjectType(0, objectID);
		}

		public float getObjectX(int objectID) {
			return this.map.getObjectX(0, objectID);
		}

		public float getObjectY(int objectID) {
			return this.map.getObjectY(0, objectID);
		}

		public float getObjectWidth(int objectID) {
			return this.map.getObjectWidth(0, objectID);
		}

		public float getObjectHeight(int objectID) {
			return this.map.getObjectHeight(0, objectID);
		}

		public String getObjectProperty(int objectID, String propertyName, String def) {
			return this.map.getObjectProperty(0, objectID, propertyName, def);
		}


}


