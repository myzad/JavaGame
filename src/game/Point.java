package game;

public class Point {
	
	protected int x; 
	protected int y; 
		
	//constructors
	public Point() {
		x = 0;
		y = 0;
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
		
	public String toString() {
		return "("+this.x+";"+this.y+")";
	}
		
	//getters and setters
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
		
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
		
	//Move point
	public void moveTop() throws IllegalArgumentException {
		if(this.y > 0 && this.y <= 20) {
			this.y -= 1;
		}else {
			throw new IllegalArgumentException("Déplacement non autorisé car tu es au bord ! ");
		}
	}
	public void moveBottom() throws IllegalArgumentException{
		if(this.y >= 0 && this.y < 20) {
			this.y += 1;
		}else {
			throw new IllegalArgumentException("Déplacement non autorisé car tu es au bord ! ");
		}
	}
	public void moveRight() throws IllegalArgumentException{
		if(this.x >= 0 && this.x < 20) {
			this.x += 1;
		}else {
			throw new IllegalArgumentException("Déplacement non autorisé car tu es au bord ! ");
		}
	}
	public void moveLeft() throws IllegalArgumentException{
		if(this.x > 0 && this.x <= 20) {
			this.x -= 1;
		}else {
			throw new IllegalArgumentException("Déplacement non autorisé car tu es au bord ! ");
		}
	}
	public void moveNo(int x, int y){
		this.x = x;
		this.y = y;
	}
}
