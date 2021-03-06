import java.util.*;

public class Ship {
	ArrayList<Square> squares;
	int x, y, orientation, size;

//for orientation: 0 is horizontal, 1 is vertical
	public Ship(int x, int y, int orientation, int size){
		this.size = size;
		this.x = x;
		this.y = y;
		this.orientation = orientation;
		findCoord();

	}

	public void findCoord(){
		squares = new ArrayList<Square>(size);
		for (int i = 0; i < size; i++){
			if (orientation == 0){
				squares.add(new Square(x + i, y));
			} else {
				squares.add(new Square(x, y + i));
			}
		}
		for (Square s : squares){
			s.sethasShip(true);
		}
	}

	public boolean hasBeenSunk(){
		for (Square s : squares){
			if (s.hasBeenHit() == false){
				return false;
			}
		}
		return true;
	}

	public void setSquares(ArrayList<Square> newarr){
		squares = newarr;
	}

	public ArrayList<Square> getSquares(){
		return squares;
	}

	public int getOrientation(){
		return orientation;
	}

	public int getSize(){
		return size;
	}

	public int getx(){
		return x;
	}

	public int gety(){
		return y;
	}

	public String toString(){
		String toReturn = "";
		toReturn += (orientation == 0) ? "Orientation: Horizontal" : "Orientation: Vertical" ;
		toReturn += "\nSize: " + size;
		for (Square s : squares){
			toReturn += "\nX: " + s.getx() + "  Y: " + s.gety();
		}
		return toReturn;
	}

}