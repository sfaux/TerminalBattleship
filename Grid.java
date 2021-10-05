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
		for(Square square : squaresChosen)
		{
			if (square.getx() == x && square.gety() == y)
			{
				square.setHasBeenHit(true);
			}
		}


			for (Ship ship : ships) {
				for (Square square : ship.getSquares()) {
					if (square.gety() == y && square.getx() == x) {
						square.setHasBeenHit(true);
						isHit = true;
					}
					if (square.hasBeenHit() == false) {
						allShipsSunk = false;
					}
				}

				if (allShipsSunk == true) {
					shipsRemaining = shipsRemaining -1;
				}
			}


		//} 

		return isHit;

	}

	public boolean placeShip(Ship s) {
		for (Square square : s.getSquares()) {
			if ((square.getx() >= gridSize || square.getx() < 0)&&(square.gety() >= gridSize || square.gety() < 0)) {
				return false;
			}
		}
	

		for (Ship ship : ships) {
			for (Square square : ship.getSquares()) {
				for (Square sq : s.getSquares()) {
					if (square.getx() == sq.getx() && square.gety() == sq.gety()) {
						return false;
					}
				}
			}
		}

		
		for (Square square : s.getSquares()) {
			square.sethasShip(true);
		}

		ships.add(s);

		return true;
	}

	/*public boolean isSquareEmpty(int x, int y) {
		if (squaresChosen.get(x).get(y).getHasShipOn() == false) {
			return true;
		} else {
			return false;
		}
	}*/

}