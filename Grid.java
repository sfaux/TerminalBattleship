import java.util.*;

public class Grid {

	private int gridSize;
	private ArrayList<Ship> ships;
	private ArrayList<ArrayList<Square>> squaresChosen;
	private int shipsRemaining;

	public Grid(int gs) {
		gridSize = gs;
		ships = new ArrayList<Ship>();
		squaresChosen = new ArrayList<ArrayList<Square>>();
		shipsRemaining = 3;
	}

	public int getShipsRemaining() {
		return shipsRemaining;
	}

	public void setShipsRemaining(int n) {
		shipsRemaining = n;
	}

	public ArrayList<ArrayList<Square>> getSquaresChosen() {
		return squaresChosen;
	}


	public boolean bomb(int x, int y) {
		boolean allShipsSunk = true;
		boolean isHit = false;
		//if (squaresChosen.get(x).get(y).getHasBeenHit() == false) {
			squaresChosen.get(x).get(y).setHasBeenHit(true);


			for (ship : ships) {
				for (square : ship.getSquares()) {
					if (square.getY() == y && square.getX() == x) {
						square.setHasBeenHit(true);
						isHit = true;
					}
					if (square.getHasBeenHit() == false) {
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
			square.setHasShipOn(true);
		}
	}

	public boolean isSquareEmpty(int x, int y) {
		if (squaresChosen.get(x).get(y).getHasShipOn() == false) {
			return true;
		} else {
			return false;
		}
	}

}