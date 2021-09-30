public class Driver {
	public static void main(String[] args){
		int gridSize = 5;

		Grid user1 = new Grid(gridSize);
		Grid user2 = new Grid(gridSize);

		boolean isUser1Turn = true;
		int user1Score = 0;
		int user2Score = 0;

		String missMarker = ".";
		String hitMarker = "x";

	}

	protected Square toSquare(String str){
		str.toLowerCase();
		char xCoordinate = str.charAt(0);
		int xCoordinateValue = (int) xCoordinate - 97;

		int yCoordinateValue =  Integer.parseInt(str.substring(1)) - 1;

		Square toReturn = new Square(xCoordinateValue, yCoordinateValue);

		return toReturn;
	}

	public void resetGame(){
		user1 = new Grid(gridSize);
		user2 = new Grid(gridSize);
		if(isUser1Turn){
			user1Score++;
		} else{
			user2Score++;
		}
		isUser1Turn = true;
	}

	public void drawGrid(Grid grid){
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
					if(square.hasBeenHit() == false){
						toAdd = " ";

					} else if(square.hasBeenHit() == true){
						if(square.hasShip() == true){
							toAdd += missMarker;

						} else{ //square does not have a ship on
							toAdd += hitMarker;
						}
					}

					
				}

				System.out.print("| ");
			}
			


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