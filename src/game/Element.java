package game;

public class Element extends Point{
	
	private char numero; //case's number
	private int apparition; //appearance on the map

	//initialize an element
	public Element(int x, int y, char numero, int apparition) {
		super(x, y);
		this.numero = numero;
		this.apparition = apparition;
	}
	
	public String toString() {
		return "x :"+super.x+" y :"+super.y+" apparition :"+this.apparition;
	}
	
	//getters and setters
	public char getNumero() {
		return numero;
	}
	public void setNumero(char num) {
		this.numero = num;
	}
	
	public int getApparition() {
		return apparition;
	}
	public void setApparition(int ap) {
		this.apparition = ap;
	}

}
