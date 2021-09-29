public class Ship {
	int size;
	ArrayList<Square> squares;
	int x1, y1, x2, y2

	public Ship(int x1, int y1, int x2, int y2, int size){
		this.size = size;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		findCoord();
	}

	public void findCoord(){
		squares = new ArrayList<Square>(size);
		
	}

	public boolean hasBeenSunk(){
		for (s : squares){
			if (s.getHasBeenHit() == false){
				return false;
			}
		}
		return true;
	}

}