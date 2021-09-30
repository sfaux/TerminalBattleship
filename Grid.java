import java.util.*;

public class Grid {

	private int gridSize;
	private ArrayList<Ship> ships;
	private ArrayList<Square> squaresChosen;
	private int shipsRemaining;

	public Grid(int gs) {
		gridSize = gs;
		ships = new ArrayList<Ship>();
		squaresChosen = new ArrayList<Square>();
		shipsRemaining = 3;

		for(int i = 0; i<gs; i++)
		{
			for(int j = 0; j<gs; j++)
			{
				Square s = new Square(i, j, false, false); 
				squaresChosen.add(s)
			}
		}
	}

	public int getShipsRemaining() {
		return shipsRemaining;
	}

	public void setShipsRemaining(int n) {
		shipsRemaining = n;
	}

	public ArrayList<Square> getSquaresChosen() {
		return squaresChosen;
	}


	public boolean bomb(int x, int y) {
		boolean allShipsSunk = true;
		boolean isHit = false;
		//if (squaresChosen.get(x).get(y).getHasBeenHit() == false) {
		for(square : squaresChosen)
		{
			if (square.getx() == x && square.gety() == y)
			{
				square.setHasBeenHit(true);
			}
		}


			for (ship : ships) {
				for (square : ship.getSquares()) {
					if (square.gety() == y && square.getx() == x) {
						square.setHasBeenHit(true);
						isHit = true;
					}
					if (square.hasBeenHit() == false) {
						allShipsSunk = false;
					}
				}

				if (allShipsSunk == true) {
					ship.setHasBeenSunk(true);
					shipsRemaining = shipsRemaining -1;
				}
			}


		//} 

		return isHit;

	}

	public boolean makeShip(Ships s) {
		ships.add(s);
		for (square : s.getSquares()) {
			square.sethasShip(true);
		}
	}

	/*public boolean isSquareEmpty(int x, int y) {
		if (squaresChosen.get(x).get(y).getHasShipOn() == false) {
			return true;
		} else {
			return false;
		}
	}*/

}