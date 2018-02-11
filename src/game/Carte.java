package game;

import java.util.Random;

public class Carte {
	
	public Random rand = new Random(); // random number
	private int randomX, randomY, randomF, randomA, randomR, randomC, randomPO, randomCA, randomP, randomM;
	private int size; //map' size
	private int min = 0; //minimum value
	public Element herbe,fleur,arbre,rocher,clef,pieceOr,cadenas,piege,monstre; //elements
	public char Carte[][]; //map
	private char initNum = '0';
	
	public Carte(int size){
		this.size = size;
		Carte = new char[size+1][size+1];
		
		//initialize a map
		for(int i = 0; i < Carte.length; i++) {
			for(int j = 0; j < Carte[i].length; j++) {
				Carte[j][i] = initNum;
			}
		}
		
		//initialize elements of map
		fleur = new Element(0,0,'1',5); //flower
		arbre = new Element(0,0,'2',5); //tree
		rocher = new Element(0,0,'3',10); //rock
		clef = new Element(0,0,'4',3); //key
		pieceOr = new Element(0,0,'5',20); //gold coin
		cadenas = new Element(0,0,'6',3); //lock
		piege = new Element(0,0,'7',10); //trap
		monstre = new Element(0,0,'8',15); //monster
	}

	public void initialiserCarte() {
		
		//appearance of flowers
		randomF = rand.nextInt(size - fleur.getApparition() + 1) + fleur.getApparition(); //random number of appearance
		for(int a = 0; a <= randomF; a++) {
			randomX = rand.nextInt(size - min + 1) + min; //random number of x
			randomY = rand.nextInt(size - min + 1) + min; //random number of y
			
			fleur.x = randomX;
			fleur.y = randomY;
			
			fleur.setApparition(randomF); //number of appearance
			
			Carte[fleur.y][fleur.x] = fleur.getNumero(); //give x and y to map's elements with a number
		}
		
		//appearance of trees
		randomA = rand.nextInt(size - arbre.getApparition() + 1) + arbre.getApparition();
		for(int a = 0; a <= randomA; a++) {
			randomX = rand.nextInt(size - min + 1) + min;
			randomY = rand.nextInt(size - min + 1) + min;
			
			arbre.x = randomX;
			arbre.y = randomY;
			
			arbre.setApparition(randomA);
			
			Carte[arbre.y][arbre.x] = arbre.getNumero();
		}
		
		//appearance of rocks
		randomR = rand.nextInt(size - rocher.getApparition() + 1) + rocher.getApparition();
		for(int a = 0; a <= randomR; a++) {
			randomX = rand.nextInt(size - min + 1) + min;
			randomY = rand.nextInt(size - min + 1) + min;
			
			rocher.x = randomX;
			rocher.y = randomY;
			
			rocher.setApparition(randomR);
			
			Carte[rocher.y][rocher.x] = rocher.getNumero();
		}
		
		//appearance of gold coins
		randomPO = rand.nextInt(size - pieceOr.getApparition() + 1) + pieceOr.getApparition();
		for(int a = 0; a <= randomPO; a++) {
			randomX = rand.nextInt(size - min + 1) + min;
			randomY = rand.nextInt(size - min + 1) + min;
			
			pieceOr.x = randomX;
			pieceOr.y = randomY;
			
			pieceOr.setApparition(randomPO);
			
			Carte[pieceOr.y][pieceOr.x] = pieceOr.getNumero();
		}
		
		//appearance of traps
		randomP = rand.nextInt(size - piege.getApparition() + 1) + piege.getApparition();
		for(int a = 0; a <= randomP; a++) {
			randomX = rand.nextInt(size - min + 1) + min;
			randomY = rand.nextInt(size - min + 1) + min;
			
			piege.x = randomX;
			piege.y = randomY;
			
			piege.setApparition(randomP);
			
			Carte[piege.y][piege.x] = piege.getNumero();
			
		}
		
		//appearance of monster
		randomM = rand.nextInt(size - monstre.getApparition() + 1) + monstre.getApparition();
		for(int a = 0; a <= randomM; a++) {
			randomX = rand.nextInt(size - min + 1) + min;
			randomY = rand.nextInt(size - min + 1) + min;
			
			monstre.x = randomX;
			monstre.y = randomY;
			
			monstre.setApparition(randomM);
			
			Carte[monstre.y][monstre.x] = monstre.getNumero();
		}
		
		//appearance of keys
		randomC = rand.nextInt(size - clef.getApparition() + 1) + clef.getApparition();
		for(int a = 0; a <= randomC; a++) {
			randomX = rand.nextInt(size - min + 1) + min;
			randomY = rand.nextInt(size - min + 1) + min;
			
			clef.x = randomX;
			clef.y = randomY;
			
			clef.setApparition(randomC);
			
			Carte[clef.y][clef.x] = clef.getNumero();
		}
		
		//appearance of locks
		randomCA = randomC;
		for(int a = 0; a <= randomCA; a++) {
			randomX = rand.nextInt(size - min + 1) + min;
			randomY = rand.nextInt(size - min + 1) + min;
			
			cadenas.x = randomX;
			cadenas.y = randomY;
			
			cadenas.setApparition(randomCA);
			
			Carte[cadenas.y][cadenas.x] = cadenas.getNumero();
		}
		
		Carte[0][0] = initNum; 
	}
	
	public void afficherCarte(Joueur perso) {
		
		//unlocking player
		if((Carte[0][1] == arbre.getNumero() || Carte[0][1] == rocher.getNumero() || Carte[0][1] == cadenas.getNumero()) && (Carte[1][0] == arbre.getNumero() || Carte[1][0] == rocher.getNumero() || Carte[1][0] == cadenas.getNumero())){
			initialiserCarte();
		}
		
		//position's player
		perso.positionPlayer.setNumero(Carte[perso.positionPlayer.getY()][perso.positionPlayer.getX()]);
		
		//player's position with his character
		switch(Carte[perso.positionPlayer.getY()][perso.positionPlayer.getX()]) {
		case '0' :
			Carte[perso.positionPlayer.getY()][perso.positionPlayer.getX()] = perso.getPerso();
			break;
		case '2' :
		case '3' :
			Carte[perso.getAy()][perso.getAx()] = perso.getPerso();
			break;
		case '6' :
			if(perso.objet.getCounter() <= 0) {
				Carte[perso.getAy()][perso.getAx()] = perso.getPerso();
			}
			break;
		default:
			break;
		}
		
		//display map
		for(int i = 0; i < Carte.length; i++) {
			for(int j = 0; j < Carte[i].length; j++) {
				System.out.print(Carte[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		//action to player
		switch(Carte[perso.positionPlayer.getY()][perso.positionPlayer.getX()]) {
		case '1' : 
			System.out.println("Tu marches sur une fleur.");
			break;
		case '2' :
		case '3' :
			perso.positionPlayer.x = perso.getAx(); //take old position of x
			perso.positionPlayer.y = perso.getAy(); //take old position of y
			System.out.println("Tu es bloqué par un arbre ou un rocher.");
			Carte[perso.positionPlayer.getY()][perso.positionPlayer.getX()] = initNum; //case's number transform to grass
			break;
		case '6' :
			if(perso.objet.getCounter() <= 0) {
				perso.positionPlayer.x = perso.getAx();
				perso.positionPlayer.y = perso.getAy();
				Carte[perso.getAy()][perso.getAx()] = perso.getPerso();
				System.out.println("Tu es bloqué. Tu dois posseder une clef pour ouvrir ce cadenas.");
				Carte[perso.positionPlayer.getY()][perso.positionPlayer.getX()] = initNum;
			}else {
				perso.objet.decrement(); //remove one key
				System.out.println("Tu as ouvert le cadenas grâce à ta clef.");
			}
			break;
		case '4' : 
			perso.objet.increment(); //add one key
			perso.pieceOr.increment(); //add two gold coins
			perso.pieceOr.increment();
			System.out.println("Tu as trouvé une clef, tu reçois 2 pieces d'or.");
			Carte[perso.positionPlayer.getY()][perso.positionPlayer.getX()] = initNum;
			break;
		case '5' : 
			perso.pieceOr.increment(); //add one gold coin
			System.out.println("Tu as trouvé une piece d'Or, tu reçois 1 piece d'or.");
			Carte[perso.positionPlayer.getY()][perso.positionPlayer.getX()] = initNum;
			break;
		case '7' : 
			perso.pointVie.decrement(); //remove one life point
			System.out.println("Tu es tombé dans un piège, tu perds 1 point de vie.");
			Carte[perso.positionPlayer.getY()][perso.positionPlayer.getX()] = initNum;
			break;
		case '8' : 
			perso.pointVie.decrement(); //remove two life points
			perso.pointVie.decrement();
			System.out.println("Tu es face à un monstre, tu perds 2 points de vie.");
			break;
		default :
			Carte[perso.positionPlayer.getY()][perso.positionPlayer.getX()] = initNum;
			break;
		}
	}

}
