package test;

import java.util.Scanner;

import game.Carte;
import game.Joueur;

public class TheGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		int newC;
		int value1 = 0; //initialize values
		int value2 = 1;
		
		//New map
		Carte map = new Carte(20);
		map.initialiserCarte();
		
		//Rules
		System.out.println("Mini projet : Jeu java \n\nR�gle : Le but du jeu est de poss�der 10 pi�ces d'or tout �vitant les pi�ges et les monstres.\n");
		//New player
		System.out.println("\nDonne un nom a ton joueur :");
		name = sc.next();
		Joueur perso = new Joueur(name);
		System.out.println("Bonjour "+name+". Es-tu pr�t ? Ton joueur est repr�sent� par "+perso.getPerso()+".\n");
		
		do {
			map.afficherCarte(perso);
			System.out.println(perso);
			System.out.println("\nD�place ton joueur : \n(8 = haut, 2 = bas, 6 = droite, 4 = gauche, 0 pour arr�ter ou conna�tre ta position)");
			newC = sc.nextInt();
			try {
				perso.deplacerPersonnage(newC);
			}catch(IllegalArgumentException e) {
				System.err.println(e.getMessage());
			}
			
			//when game is over
			if(perso.pointVie.getCounter() == 0) {
				value1 = perso.pointVie.getCounter();
				value2 = 0;
			}
			if(perso.pieceOr.getCounter() == perso.pieceOr.getMax()) {
				value1 = perso.pieceOr.getCounter();
				value2 = perso.pieceOr.getMax();
			}
			if(perso.getRep() == 'N') {
				value1 = Integer.toString(perso.getRep()).charAt(0);
				value2 = Integer.toString('N').charAt(0);;
			}
			
		}while(value1 != value2);
		
		System.out.println("Le jeu est termin� ! \nMerci pour ta participation.");

	}

}
