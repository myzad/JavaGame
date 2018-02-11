package game;

public class Compteur {
	
	protected int counter;
	
	//initialize a counter
	public Compteur(int counter) {
		this.counter = counter;
	}
	
	public String toString() {
		return ""+this.counter;
	}
	
	//getter and setter
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	//add one to counter
	public void increment() {
		this.counter++;
	}
	
	//remove one to counter
	public void decrement() {
		if(counter > 0) {
			this.counter--;
		}
	}

}
