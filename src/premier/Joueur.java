package premier;

public class Joueur {

	//déclaration des différentes variables pour le joueur physique

    static String pseudo_joueur;
    private int id;
    private String score;

    public Joueur() {

    }
    public Joueur(String pseudo_joueur, int id, String score) {
        this.pseudo_joueur = pseudo_joueur;
        this.id = id;
        this.score = score;

    }

    public Joueur(String pseudo_joueur, String score) {
        this.pseudo_joueur = pseudo_joueur;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String string) {
        this.score = string;
    }

    public String getPseudo_joueur() {
        return pseudo_joueur;
    }
    public void setPseudo_joueur(String pseudo_joueur) {
        this.pseudo_joueur = pseudo_joueur;
    }

    //String à afficher provenant de la bdd
    @Override
    public String toString() {
        return  pseudo_joueur+ " " + score + "\n\n";
    }
}
