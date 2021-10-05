import java.util.Scanner;

public class Driver {
	public static void main(String[] args){
		int gridSize = 5;

		Grid user1 = new Grid(gridSize);
		Grid user2 = new Grid(gridSize);
		boolean gameReset = false;

		boolean isUser1Turn = true;
		int user1Score = 0;
		int user2Score = 0;

		String missMarker = ".";
		String hitMarker = "x";

		//START RUNNING THE GAME

		drawGrid(user1);
		placeShips(user1, 3);

		drawGrid(user2);
		placeShips(user2, 3);

		while(gameReset == false){
			takeTurn();
		}



	}

	protected Square toSquare(String str){
		str.toLowerCase();
		char xCoordinate = str.charAt(0);
		int xCoordinateValue = (int) xCoordinate - 97;

		int yCoordinateValue =  Integer.parseInt(str.substring(1)) - 1;

		if(xCoordinateValue < 0 || yCoordinateValue < 0 || xCoordinateValue > gridSize - 1 || yCoordinateValue > gridSize - 1){
			return null;

		}

		Square toReturn = new Square(xCoordinateValue, yCoordinateValue);

		return toReturn;
	}

	private void resetGame(){
		user1 = new Grid(gridSize);
		user2 = new Grid(gridSize);
		if(isUser1Turn){
			user1Score++;
		} else{
			user2Score++;
		}
		isUser1Turn = true;
		gameReset = true;
	}

	private void drawGrid(Grid grid){
		for(int i = 1; i <= gridSize; i++){ //top row (list of A    B    C    D    E    F...)
			char toWrite = (char) (i + 64);
			System.out.print("   " + toWrite);
		}
		System.out.println();
		for(int row = 1; row <= gridSize; row++){
			System.out.print("    ");
			for(int numDashes = 0; numDashes < ((4 * gridSize) + 1); numDashes++){
				System.out.print("-");
			}
			System.out.println();//new line


			System.out.print(row + "  ");
			for(int numVertLine = 0; numVertLine <= gridSize; numVetLine++){
				String toAdd = "";
				
				if(isUser1Turn && numVertLine != gridSize){ //drawing user2 grid then
					ArrayList<Square> user2Squares = user2.getSquares();
					Square square = getSquare(numVertLine, row-1, user2Squares); //wrong possibly
					if(square == null || square.hasBeenHit() == false){
						toAdd = " ";

					} else if(square.hasBeenHit() == true){
						if(square.hasShip() == true){
							toAdd += missMarker;

						} else{ //square does not have a ship on
							toAdd += hitMarker;
						}
					}

					
				}

				System.out.print("| " + toAdd + " ");
			}
		}

	}

	public void takeTurn(){
		Scanner scan = new Scanner(System.in);
		if(isUser1Turn){
			System.out.println("It's user 1's turn!");
			drawGrid(user2);

		} else{
			System.out.println("It's user 2's turn!");
			drawGrid(user1);
		}

		System.out.println("Type in the coordinates of the square you seek to bomb (letter;number)");
		String coordinate = scan.nextLine();

		Square tempSquare = toSquare(coordinate);
		if(tempSquare == null){
			takeTurn();
			return;
		}
		if(isUser1Turn){
			if(user2.bomb(tempSquare.getx(), tempSquare.gety()) == false){
				isUser1Turn = false;
			}
		} else{
			if(user2.bomb(tempSquare.getx(), tempSquare.gety()) == false){
				isUser1Turn = true;
			}
		}

		if(isUser1Turn){
			drawGrid(user2);
			if(user2.getShipsRemaining() < 1){
				user1Score++;
				resetGame();
			}
		} else{
			drawGrid(user1);
			if(user1.getShipsRemaining() < 1){
				user2Score++;
				resetGame();
			}

		}
		
	}

	public void placeShip(Grid grid, int shipWidth){
		Scanner scan = new Scanner(System.in);

		System.out.println("Type a point for you 1 by " + shipWidth + " ship");
		String coordinates = scan.nextLine();
		Square tempSquare = toSquare(coordinates);
		boolean works = false;
		String direction = "";
		while(works == false){
			System.out.println("Type r to go to the right and d to go down");
			direction = scan.nextLine().toLowerCase();
			if(direction.equals("r") == true || direction.equals("d")) == true){
				works = true;
			}

		}

		int dir = 1;

		if(direction.equals("r")){
			dir = 0;
		}

		Ship tempShip = new Ship(tempSquare.getx(), tempSquare.gety(), dir, shipWidth);
		grid.makeShip(tempShip);





	}

	public void placeShips(Grid grid, int numShips){
		for(int i = 1; i <= numShips; i++){
			placeShip(grid, i);
		}
		
	}

	private Square getSquare(int x, int y, ArrayList<Square> squares){
		for(Square square : squares){
			if(square.getx() == x && square.gety() == y){
				return square;
			}
		}

		return null;
	}
	

}