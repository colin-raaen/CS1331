import java.util.Scanner; // Import Scanner Method

public class Battleship {
    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);  // Define scanner variable
		int array_length = 5; // constant for array length
		char[][] player_1_shipLocations = new char[array_length][array_length]; // Declare 2-d array to store player 1 ship coordinates
		char[][] player_2_shipLocations = new char[array_length][array_length]; // Declare 2-d array to store player 2 ship coordinates
		char[] player_ship_selection = new char[2]; // array to store selection from method
        char[][] player_1_targetHistory = new char[array_length][array_length]; // Declare 2-d array to store player 1 hit board
		char[][] player_2_targetHistory = new char[array_length][array_length]; // Declare 2-d array to store player 2 hit board
        char[] player_hit_selection = new char[2]; // array to store selection from method
		boolean battleshipWinner = false; // declare variable to track if winner has been determined

		// set initial values of players ship arrays and hit board arrays to '-'
		for (int a = 0; a < 5; a++){
			for (int b = 0; b < 5; b++){
				player_1_shipLocations[a][b] = '-';
				player_2_shipLocations[a][b] = '-';
                player_1_targetHistory[a][b] = '-';
                player_2_targetHistory[a][b] = '-';
			}
		}

        System.out.println("Welcome to Battleship!\n"); // Prompt user for two integers

		System.out.println("PLAYER 1, ENTER YOUR SHIPS’ COORDINATES."); // Prompt player 1 for Ship coordinates
		// for loop to gather 5 ship inputs from player 1
		for (int x = 1; x < 6; x++) {
			do {
				// Call method to get next ships coordinates input, repeat if invalid entry completed
				player_ship_selection = shipInputCheck(x, player_1_shipLocations, input);
			} while (player_ship_selection == null);
			// store
			player_1_shipLocations[player_ship_selection[0]][player_ship_selection[1]] = '@';

		}
		// Print Players 1 ship board
		printBattleShip(player_1_shipLocations);

		// for loop to print 100 new lines between player 1 and player 2
		for (int i = 0; i < 100; i++) {
			System.out.println(); // prints a newline character
		}

		// Get Player 2 ship coordinates
		System.out.println("PLAYER 2, ENTER YOUR SHIPS’ COORDINATES."); // Prompt user for two integers of ship location
		for (int y = 1; y < 6; y++) {
			do {
				// Call method to get next ships coordinates input, repeat if invalid entry completed
				player_ship_selection = shipInputCheck(y, player_2_shipLocations, input);
			} while (player_ship_selection == null);
			// store location of ship if valid input
			player_2_shipLocations[player_ship_selection[0]][player_ship_selection[1]] = '@';

		}
		// Print Players 2 ship board
		printBattleShip(player_2_shipLocations);
		System.out.println();

		// for loop to print 100 new lines between player 2 and Hit Entries
		for (int i = 0; i < 100; i++) {
			System.out.println(); // prints a newline character
		}

        // Prompt users for hit locations, continue until winner is determined
        do {
            // Prompt Player 1 for hit location, continue to prompt until valid location is entered
            do {
                // Call method to get next ships coordinates input, repeat if invalid entry completed
				player_hit_selection = hitInputCheck(player_2_shipLocations, player_1_targetHistory, 1, input);

            } while (player_hit_selection == null); // continue to prompt until valid coordinates are returned

            // If Player 2 board has a ship at location, update 2 d arrays with hit
			if (player_2_shipLocations[player_hit_selection[0]][player_hit_selection[1]] == '@'){
                player_1_targetHistory[player_hit_selection[0]][player_hit_selection[1]] = 'X';
				player_2_shipLocations[player_hit_selection[0]][player_hit_selection[1]] = 'X';
                System.out.println("PLAYER 1 HIT PLAYER 2’s SHIP!");
            }
			// Else update 2 d array to have a miss
			else {
                player_1_targetHistory[player_hit_selection[0]][player_hit_selection[1]] = 'O';
				player_2_shipLocations[player_hit_selection[0]][player_hit_selection[1]] = 'O';
                System.out.println("PLAYER 1 MISSED!");

            }
            printBattleShip(player_1_targetHistory); // Print Player 1 Hit board
			System.out.println();

			// Call Method to check Player 1 is a winner
			battleshipWinner = winnerCheck(player_1_targetHistory, 1);
			if (battleshipWinner == true){
				break;
			}

            // Prompt Player 2 for hit location, continue to prompt until valid location is entered
            do {
                // Call method to get next ships coordinates input, repeat if invalid entry completed
				player_hit_selection = hitInputCheck(player_1_shipLocations, player_2_targetHistory, 2, input);

            } while (player_hit_selection == null);

            // If Location contains a battleship, update 2d hit array and ship location array
			if (player_1_shipLocations[player_hit_selection[0]][player_hit_selection[1]] == '@'){
                player_2_targetHistory[player_hit_selection[0]][player_hit_selection[1]] = 'X';
				player_1_shipLocations[player_hit_selection[0]][player_hit_selection[1]] = 'X';
                System.out.println("PLAYER 2 HIT PLAYER 1’s SHIP!");

            }
            // else update 2 d array with misses
			else {
                player_2_targetHistory[player_hit_selection[0]][player_hit_selection[1]] = 'O';
				player_1_shipLocations[player_hit_selection[0]][player_hit_selection[1]] = 'O';
                System.out.println("PLAYER 2 MISSED!");

            }
            printBattleShip(player_2_targetHistory);
			System.out.println();

            // Call Method to check Player 2 is a winner
			battleshipWinner = winnerCheck(player_2_targetHistory, 2);

        } while (battleshipWinner == false);

		System.out.println("Final boards: \n");
		printBattleShip(player_1_shipLocations); // Print Player 1 final hit board
		System.out.println();
		printBattleShip(player_2_shipLocations); // Print Player 2 final hit board

		return;
    }

	// Method to check if a player won
	private static boolean winnerCheck(char[][] players_hit_board, int player){
		int player_hit_counter = 0; // declaire hit counter variable
		String winner = "PLAYER " + player;

		// traverse hit board rows
		for (int a = 0; a < 5; a++){
			// traverse hit board columns
			for (int b = 0; b < 5; b++){
				// check if hit was found
				if (players_hit_board[a][b] == 'X'){
					player_hit_counter++; // increment hit counter if hit found
				}
				else {
					continue;
				}
			}
		}
		// if 5 hits found than Player 1 is the winner
		if (player_hit_counter == 5){
			System.out.printf("%s WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!\n", winner);
			System.out.println();
			return true;
		}
		else {
			return false;
		}
	}

    // Method to prompt user for Hit Locations
    private static char[] hitInputCheck(char[][] opponent_ship_coord, char[][] players_hit_board, int player, Scanner input){
		String errorMessage1 = "Invalid coordinates. Choose different coordinates.";
		String errorMessage2 = "You already fired on this spot. Choose different coordinates.";
		char[] player_hit_selection = new char[2];

		System.out.println("Player " + player + ", enter hit row/column:"); // Prompt user for two integers

        // check if first input is integer
		if (input.hasNextInt()){
			int coordinate_1 = input.nextInt();
			// check if first input is within acceptable range
			if (-1 < coordinate_1 && coordinate_1 < 5){
				char coordinate_1_char = (char) coordinate_1; // type casting int to char
				// Check if second input is an integer
				if (input.hasNextInt()){
					int coordinate_2 = input.nextInt();
					// buffer for user hitting enter, consume enter
					input.nextLine();
					// Check if second input is within valid range
					if (-1 < coordinate_2 && coordinate_2 < 5){
						char coordinate_2_char = (char) coordinate_2; // type casting int to char

						// Check if user has already input coordinates
						// For loop to traverse rows in players ship coordinates
						for (int x = 0; x < 5; x++){
							// For loop to traverse columns in players ship coordinates
							for (int y = 0; y < 5; y++){
								if (players_hit_board[coordinate_1_char][coordinate_2_char] == 'X' || players_hit_board[coordinate_1_char][coordinate_2_char] == 'O'){
									System.out.println(errorMessage2); // Prompt user for two integers
									return null;
								}
							}
						}

						// if passes all checks, store ship coordinates into array and return
						player_hit_selection[0] = coordinate_1_char;
						player_hit_selection[1] = coordinate_2_char;
						return player_hit_selection;
					}
					// if second int isn't within range of board
					else {
						System.out.println(errorMessage1); // Print error message 1
						return null;
					}
				}
				// if second int isn't an integer
				else {
					System.out.println(errorMessage1); // Print error message 1
					return null;
				}
			}
			// if first integer isn't within range of board
			else {
				System.out.println(errorMessage1); // Print error message 1
				input.nextLine(); // buffer to consumer second input to prevent additional error messages
				return null;
			}
		}
		// if first int isn't an integer
		else {
			System.out.println(errorMessage1); // Print error message 1
			input.nextLine(); // buffer to consumer second input to prevent additional error messages
			return null;
		}
    }

	// Method to prompt user for Ship Locations
    private static char[] shipInputCheck(int ship_count, char[][] players_ship_coord, Scanner input) {
		String errorMessage1 = "Invalid coordinates. Choose different coordinates.";
		String errorMessage2 = "You already have a ship there. Choose different coordinates.";
		char[] player_ship_selection = new char[2];

		System.out.println("Enter ship " + ship_count + " location: "); // Prompt user for two integers
		// check if first input is integer
		if (input.hasNextInt()){
			int coordinate_1 = input.nextInt();
			// check if first input is within acceptable range
			if (-1 < coordinate_1 && coordinate_1 < 5){
				char coordinate_1_char = (char) coordinate_1; // type casting int to char
				// Check if second input is an integer
				if (input.hasNextInt()){
					int coordinate_2 = input.nextInt();
					// buffer for user hitting enter, consume enter
					input.nextLine();
					// Check if second input is within valid range
					if (-1 < coordinate_2 && coordinate_2 < 5){
						char coordinate_2_char = (char) coordinate_2; // type casting int to char

						// Check if user has already input coordinates
						// For loop to traverse rows in players ship coordinates
						for (int x = 0; x < 5; x++){
							// For loop to traverse columns in players ship coordinates
							for (int y = 0; y < 5; y++){
								if (players_ship_coord[coordinate_1_char][coordinate_2_char] == '@'){
									System.out.println(errorMessage2); // Prompt user for two integers
									return null;
								}
							}
						}

						// if passes all checks, store ship coordinates into array and return
						player_ship_selection[0] = coordinate_1_char;
						player_ship_selection[1] = coordinate_2_char;
						return player_ship_selection;
					}
					// if second int isn't within range of board
					else {
						System.out.println(errorMessage1); // Print error message 1
						return null;
					}
				}
				// if second int isn't an integer
				else {
					System.out.println(errorMessage1); // Print error message 1
					return null;
				}
			}
			// if first integer isn't within range of board
			else {
				System.out.println(errorMessage1); // Print error message 1
				input.nextLine(); // buffer to consumer second input to prevent additional error messages
				return null;
			}
		}
		// if first int isn't an integer
		else {
			System.out.println(errorMessage1); // Print error message 1
			input.nextLine(); // buffer to consumer second input to prevent additional error messages
			return null;
		}
	}

    // Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}
}