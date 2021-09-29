public class Square {
	private int x, y;
	private boolean hasShip, hasBeenHit;

	public Square(x, y){
		this.x = x;
		this.y = y;
		hasShip = false;
		hasBeenHit = false;
	}

	public int getx(){
		return x;
	}

	public void setx(int x){
		this.x = x;
	}

	public int gety(){
		return y;
	}

	public void sety(){
		this.y = y;
	}

	public boolean getHasShip(){
		return hasShip();
	}

	public void sethasShip(boolean bool){
		hasShip = bool;
	}

	public boolean getHasBeenHit(){
		return hasBeenHit;
	}

	public void setHasBeenHit(boolean bool){
		hasBeenHit = bool;
	}

	
}