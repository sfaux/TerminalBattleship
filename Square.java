public class Square {
	private int x, y;
	private boolean hasShip, hasBeenHit;

	public Square(int x, int y){
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

	public boolean hasShip(){
		return hasShip;
	}

	public void sethasShip(boolean bool){
		hasShip = bool;
	}

	public boolean hasBeenHit(){
		return hasBeenHit;
	}

	public void setHasBeenHit(boolean bool){
		hasBeenHit = bool;
	}


}