package game;

public class CompteurElement extends Compteur{

	private int max; //limit
	
	//initialize a counter
	public CompteurElement(int counter, int max) {
		super(counter);
		this.max = max;
	}
	
	//getter
	public int getMax() {
		return max;
	}
	
	//add one to counter
	public void increment() {
		if(this.counter < this.max) {
			super.increment();
		}
	}

}
