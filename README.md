---


---

<h1 id="projet-borne-darcade">Projet Borne d’Arcade</h1>
<p>Le projet de développement logiciel est un projet à réaliser en binôme. Il consiste à créer une mini borne d’arcade contenant un jeu simple de 1 VS 1.</p>
<p>L’idée est de commander les personnages à l’aide de boutons et de joystick.</p>
<p>Le jeu doit également pouvoir communiquer avec une base de données. Elle doit notamment enregistrer les pseudos et scores des joueurs.</p>
<h2 id="la-base-de-données">La Base de Données</h2>
<p>Correspond au fichier “BDD” et est réalisé sur MySQL.<br>
Le fichier "Borne_arcade.sql est à importer sur votre ordinateur sur MysSQL à l’aide Xampp ou Wampp. Elle y contient deux tables, la table “score” qui permet de stocker les pseudos des joueurs et leurs score pour ensuite y faire un classement. Et la table “joueur”, non utilisée pour l’instant mais celle-ci devra permettre aux deux joueurs de modifier les caractéristiques de leur personnages.</p>
<p>Pour importer la table, il suffit de lancer Xampp, ensuite d’aller sur la page admin de MySQL, de créer une nouvelle base de donnée nommée “Borne_arcade” puis d’aller dans l’onglet “importer” et d’y importer ici le fichier .sql .</p>
<h2 id="les-ressources">Les ressources:</h2>
<p>Les ressources du jeu sont stockées dans deux dossier :</p>
<h3 id="resources-">"resources "</h3>
<p>Ce fichier contient tout l’arrière plan du jeu comme l’image de fond, les musiques ou encore les tuiles pour la map.</p>
<h3 id="sprites">“sprites”</h3>
<p>Ce fichier contient les sprites des personnages, des ennemies et des missiles.</p>
<h2 id="librairie">Librairie</h2>
<p>Pour le jeu nous utilisons la librairie Slick2d, très utile pour créer un jeu en Java. Pour l’importer il faut tout d’abord créer un dossier lib avec les mêmes fichiers que les miens et un dossier natives avec les mêmes fichiers que ceux dans mon dossier natives.<br>
Il suffit enfin d’ajouter ces librairies à celle du projet Java.</p>
<h2 id="le-jeu">Le jeu</h2>
<p>Tout les classes du jeu sont situées dans les dossiers “/src/premier”. On y retrouve 18 classes, toute nécessaire au jeu. Nous allons vous présenter les plus importantes:</p>
<h3 id="stategame">StateGame</h3>
<p>Classe qui permet le lancement de la fenêtre du jeu.</p>
<h3 id="bdd">bdd</h3>
<p>Cette classe permet de réaliser les fonctions nécessaire à la base de données comme la fonction getConnection() qui permet de se connecter à la bdd ou encore la fonction selectAll(), qui permet de tout sélectionner dans la table score.</p>
<h3 id="fenetre">Fenetre</h3>
<p>La classe qui permet d’ouvrir une fenêtre et d’y entrer les pseudos.</p>
<h3 id="mainscreengamestate">MainScreenGameState</h3>
<p>Ecran d’acceuil du jeu, cette classe permet de se déplacer entre les différents écrans du jeu. Plusieurs classes sont des écrans du jeu : GameOver, GameOver2 (les écrans de fin de partie); MapGameState (écran lorsque l’on joue); Options (écran d’instructions avec 3 options de difficultées); Pause (écran de pause); ScoreBoard (écran du classement).</p>
<h3 id="mapgamestate">MapGameState</h3>
<p>Le jeu lui même, tout le squelette du jeu est dans cette classe.</p>
<h3 id="playercontroller-2">PlayerController /2</h3>
<p>Les contrôles des joueurs sont stockées dans ces deux classes.</p>
<h3 id="les-classes-ressources">Les classes ressources</h3>
<p>On en retrouves plusieurs:<br>
Ennemy (classe de l’ennemi)<br>
Joueur /2 (classes des deux joueurs)<br>
Map (classe de la map du jeu)<br>
Missile (classe du missile)<br>
Player (classe du personnage jouable)</p>
<h2 id="lancer-le-jeu">Lancer le Jeu</h2>
<p>Pour lancer le jeu dans sur votre ordinateur, après importation de la base de données, il vous suffit de lancer, en ligne de commande à la racine du jeu, cette ligne:</p>
<pre><code> java -jar -Djava.library.path=lib\natives StreetShooter.jar
</code></pre>
<p>Cette ligne de commande permet au jeu d’aller chercher les librairies au bon endroit (ici dans le dossier lib\natives).</p>

