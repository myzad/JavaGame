package game;

import java.util.Scanner;

public class Joueur {
	
	private String name;
	private char perso; //character representing the player
	public Element positionPlayer; //position's player
	public Compteur pointVie;
	public Compteur objet; //object storing the keys
	public CompteurElement pieceOr;
	private int Ax, Ay; //old position values
	private char rep; //answer (continue or stop)
	
	//initialize a player
	public Joueur(String name){
		this.name = name;
		this.perso = 'X';
		positionPlayer = new Element(0,0,this.perso,0);
		pointVie = new Compteur(10);
		objet = new Compteur(0);
		pieceOr = new CompteurElement(0,10);
	}
	
	//informations about the player
	public String toString() {
		return "Joueur : "+name+" \nPosition : ("+this.positionPlayer.getX()+";"+this.positionPlayer.getY()
		+")\nPoint de vie : "+pointVie.getCounter()+" \nPiece d'or : "+pieceOr.getCounter()
		+"\nClef : "+objet.getCounter();
	}
	
	//getters
	public String getName() {
		return name;
	}
	
	public char getPerso() {
		return perso;
	}
	
	public int getAx() {
		return Ax;
	}
	public int getAy() {
		return Ay;
	}
	
	public char getRep() {
		return rep;
	}
	
	//move player
	public int deplacerPersonnage(int touche) throws IllegalArgumentException{
		
		//position before moving
		Ax = this.positionPlayer.x;
		Ay = this.positionPlayer.y;
		
		if(pointVie.getCounter() == 0) {
			System.out.println("Tu as perdu !");
			return -1;
		}
		if(pieceOr.getCounter() == pieceOr.getMax()) {
			System.out.println("Tu as gagné !");
			return -1;
		}
		
		switch(touche) {
			case 8 : 
				positionPlayer.moveTop();
				break;
			case 2 : 
				positionPlayer.moveBottom();
				break;
			case 6 : 
				positionPlayer.moveRight();
				break;
			case 4 : 
				positionPlayer.moveLeft();
				break;
			case 0 : 
				Scanner sc = new Scanner(System.in);
				System.out.println("Voulez-vous continuer ? (O/N)");
				rep = sc.next().charAt(0);
				if(rep == 'O' || rep == 'N') {
					if(rep == 'O') {
						System.out.println("Le joueur est sur la case : "+this.positionPlayer.getNumero());
					}else {
						return -1;
					}
				}else {
					throw new IllegalArgumentException("Tu devais choisir entre O (oui) ou N (non) ! \nRéappuie sur 0.");
				}
				break;
			default :
				throw new IllegalArgumentException("Le numero de déplacement n'est pas bon. \nChoisis entre 8 = haut, 2 = bas, 6 = droite, 4 = gauche, 0 pour arrêter ou connaître ta position.");
		}
		return touche;
	}
}
