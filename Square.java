public class Square {
	private int x, y;
	private boolean hasShip, hasBeenHit;

	public Square(int x, int y) {
		this.x = x;
		this.y = y;
		hasShip = false;
		hasBeenHit = false;
	}

	public int getx() {
		return x;
	}

	public void setx(int x) {
		this.x = x;
	}

	public int gety() {
		return y;
	}

	public void sety(int y) {
		this.y = y;
	}

	public boolean hasShip() {
		return hasShip;
	}

	public void sethasShip(boolean bool) {
		hasShip = bool;
	}

	public boolean hasBeenHit() {
		return hasBeenHit;
	}

	public void setHasBeenHit(boolean bool) {
		hasBeenHit = bool;
	}

	public String toString() {
		String result = "";
		result += "Ship at (x,y): (" + this.x + "," + this.y + ")\n";
		result += "hasShip: " + this.hasShip + "  hasBeenHit: " +
					hasBeenHit; 
		return result;
	}

	/*
	public static void main(String[] args) {
		Square s1 = new Square(1, 1);
		System.out.println(s1);

		Square s2 = new Square(0, 0);
		s2.setx(3);
		s2.sety(2);
		s2.setHasBeenHit(true);
		System.out.println(s2);
	}
	*/

}