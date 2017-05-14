package bits.navalassault.model;

import bits.navalassault.model.Ship;
import bits.navalassault.view.BoardOverviewController;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class PlayerController extends BoardOverviewController {

	private static final Ship[][] gameBoard = new Ship[10][10];
	public static final Ship fleet[] = new Ship[8];
	private static final Ship[][] hitMissBoard = new Ship[10][10];
	private static boolean allShipsSunk = false;
    private static int shipsRemaining = 5;
    

    public static int getShipsRemaining() {
        return shipsRemaining;
    }

    public static void decreaseShipsRemaining() {
        shipsRemaining--;
    }
    
//    public static void resetShipsRemaining() {
//        OpponentController.shipsRemaining = 5;
//    }

    public static boolean isAllShipsSunk() {
        return allShipsSunk;
    }

    public static void setAllShipsSunk(boolean allShipsSunk) {
        PlayerController.allShipsSunk = allShipsSunk;
    }
	
	// gets current state for hitMissBoard coordinate
    public static Ship getHitMiss(int xAxis, int yAxis) {
        return hitMissBoard[xAxis][yAxis];
    }
    
    public static int getArrayLength() {
        return hitMissBoard.length;
    }
    
    // sets gameBoard coordinate to hit state
    public static void setHit(int xAxis, int yAxis) {
        hitMissBoard[xAxis][yAxis] = fleet[5];
    }

    // sets gameBoard coordinate to miss state
    public static void setMiss(int xAxis, int yAxis) {
        hitMissBoard[xAxis][yAxis] = fleet[6];
    }

    // resets all fields in array with empty ship object
    public static void setHitGridEmpty() {
        for (int i = 0; i < hitMissBoard.length; i++) {
            for (int j = 0; j < hitMissBoard[i].length; j++) {
                hitMissBoard[i][j] = fleet[7];
            }
        }
    }
	// gets current state for gameBoard coordinate
	public static Ship getState(int xAxis, int yAxis) {
		return gameBoard[xAxis][yAxis];
	}
	
	public static boolean checkOverlap(int x, int y) {
		if (getState(x, y) == fleet[0]) {
			return true;
		} else if (getState(x, y) == fleet[1]) {
			return true;
		} else if (getState(x, y) == fleet[2]) {
			return true;
		} else if (getState(x, y) == fleet[3]) {
			return true;
		} else if (getState(x, y) == fleet[4]) {
			return true;
		} else {
			return false;
		}
	}

	// creates the images for that make up the ships
	static Image battleship1Img = new Image("bits/navalassault/resources/ships/battleship1.png");
	static Image battleship2Img = new Image("bits/navalassault/resources/ships/battleship2.png");
	static Image battleship3Img = new Image("bits/navalassault/resources/ships/battleship3.png");
	static Image battleship4Img = new Image("bits/navalassault/resources/ships/battleship4.png");

	static Image battleship5Img = new Image("bits/navalassault/resources/ships/battleship5.png");
	static Image battleship6Img = new Image("bits/navalassault/resources/ships/battleship6.png");
	static Image battleship7Img = new Image("bits/navalassault/resources/ships/battleship7.png");
	static Image battleship8Img = new Image("bits/navalassault/resources/ships/battleship8.png");

	static Image carrier1Img = new Image("bits/navalassault/resources/ships/carrier1.png");
	static Image carrier2Img = new Image("bits/navalassault/resources/ships/carrier2.png");
	static Image carrier3Img = new Image("bits/navalassault/resources/ships/carrier3.png");
	static Image carrier4Img = new Image("bits/navalassault/resources/ships/carrier4.png");
	static Image carrier5Img = new Image("bits/navalassault/resources/ships/carrier5.png");

	static Image carrier6Img = new Image("bits/navalassault/resources/ships/carrier6.png");
	static Image carrier7Img = new Image("bits/navalassault/resources/ships/carrier7.png");
	static Image carrier8Img = new Image("bits/navalassault/resources/ships/carrier8.png");
	static Image carrier9Img = new Image("bits/navalassault/resources/ships/carrier9.png");
	static Image carrier10Img = new Image("bits/navalassault/resources/ships/carrier10.png");

	static Image sub1Img = new Image("bits/navalassault/resources/ships/sub1.png");
	static Image sub2Img = new Image("bits/navalassault/resources/ships/sub2.png");
	static Image sub3Img = new Image("bits/navalassault/resources/ships/sub3.png");

	static Image sub4Img = new Image("bits/navalassault/resources/ships/sub4.png");
	static Image sub5Img = new Image("bits/navalassault/resources/ships/sub5.png");
	static Image sub6Img = new Image("bits/navalassault/resources/ships/sub6.png");

	static Image cruiser1Img = new Image("bits/navalassault/resources/ships/cruiser1.png");
	static Image cruiser2Img = new Image("bits/navalassault/resources/ships/cruiser2.png");
	static Image cruiser3Img = new Image("bits/navalassault/resources/ships/cruiser3.png");

	static Image cruiser4Img = new Image("bits/navalassault/resources/ships/cruiser4.png");
	static Image cruiser5Img = new Image("bits/navalassault/resources/ships/cruiser5.png");
	static Image cruiser6Img = new Image("bits/navalassault/resources/ships/cruiser6.png");

	static Image destroyer1Img = new Image("bits/navalassault/resources/ships/destroyer1.png");
	static Image destroyer2Img = new Image("bits/navalassault/resources/ships/destroyer2.png");

	static Image destroyer3Img = new Image("bits/navalassault/resources/ships/destroyer3.png");
	static Image destroyer4Img = new Image("bits/navalassault/resources/ships/destroyer4.png");

    public static void setShips() {
        fleet[0] = new Ship("destroyer", 2, false, 0, true);
        fleet[1] = new Ship("submarine", 3, false, 0, true);
        fleet[2] = new Ship("cruiser", 3, false, 0, true);
        fleet[3] = new Ship("battleship", 4, false, 0, true);
        fleet[4] = new Ship("carrier", 5, false, 0, true);
        fleet[5] = new Ship("hit");
        fleet[6] = new Ship("miss");
        fleet[7] = new Ship("empty");
    }


	public static void setCarrier() {
		for (int yAxis = 0; yAxis < BoardOverviewController.player.length; yAxis++) {
			for (int xAxis = 0; xAxis < BoardOverviewController.player.length; xAxis++) {
				Button button = BoardOverviewController.player[xAxis][yAxis];
				button.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if (event.getButton() == MouseButton.PRIMARY) {
							int x = (int) button.getLayoutX() / 50;
							int y = (int) button.getLayoutY() / 50;
							placeCarrier(x, y);
						}
						if (event.getButton() == MouseButton.SECONDARY) {
							int x = (int) button.getLayoutX() / 50;
							int y = (int) button.getLayoutY() / 50;
							placeCarrierVertical(x, y);
						}
					}
				});
			}
		}
	}

	public static void setBattleship() {
		//BoardOverviewController.setStatus("Place your Battleship: LMB Horizontal RMB Vertical");	
		for (int yAxis = 0; yAxis < BoardOverviewController.player.length; yAxis++) {
			for (int xAxis = 0; xAxis < BoardOverviewController.player.length; xAxis++) {
				Button button = BoardOverviewController.player[xAxis][yAxis];
				button.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if (event.getButton() == MouseButton.PRIMARY) {
							int x = (int) button.getLayoutX() / 50;
							int y = (int) button.getLayoutY() / 50;
							placeBattleship(x, y);
						}
						if (event.getButton() == MouseButton.SECONDARY) {
							int x = (int) button.getLayoutX() / 50;
							int y = (int) button.getLayoutY() / 50;
							placeBattleshipVertical(x, y);
						}
					}
				});
			}
		}
	}

	public static void setSub() {
		for (int yAxis = 0; yAxis < BoardOverviewController.player.length; yAxis++) {
			for (int xAxis = 0; xAxis < BoardOverviewController.player.length; xAxis++) {
				Button button = BoardOverviewController.player[xAxis][yAxis];
				button.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if (event.getButton() == MouseButton.PRIMARY) {
							int x = (int) button.getLayoutX() / 50;
							int y = (int) button.getLayoutY() / 50;
							placeSub(x, y);
						}
						if (event.getButton() == MouseButton.SECONDARY) {
							int x = (int) button.getLayoutX() / 50;
							int y = (int) button.getLayoutY() / 50;
							placeSubVertical(x, y);
						}
					}
				});
			}
		}
	}

	public static void setCruiser() {
		for (int yAxis = 0; yAxis < BoardOverviewController.player.length; yAxis++) {
			for (int xAxis = 0; xAxis < BoardOverviewController.player.length; xAxis++) {
				Button button = BoardOverviewController.player[xAxis][yAxis];
				button.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if (event.getButton() == MouseButton.PRIMARY) {
							int x = (int) button.getLayoutX() / 50;
							int y = (int) button.getLayoutY() / 50;
							placeCruiser(x, y);
						}
						if (event.getButton() == MouseButton.SECONDARY) {
							int x = (int) button.getLayoutX() / 50;
							int y = (int) button.getLayoutY() / 50;
							placeCruiserVertical(x, y);
						}
					}
				});
			}
		}
	}

	public static void setDestroyer() {
		for (int yAxis = 0; yAxis < BoardOverviewController.player.length; yAxis++) {
			for (int xAxis = 0; xAxis < BoardOverviewController.player.length; xAxis++) {
				Button button = BoardOverviewController.player[xAxis][yAxis];
				button.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if (event.getButton() == MouseButton.PRIMARY) {
							int x = (int) button.getLayoutX() / 50;
							int y = (int) button.getLayoutY() / 50;
							placeDestroyer(x, y);
						}
						if (event.getButton() == MouseButton.SECONDARY) {
							int x = (int) button.getLayoutX() / 50;
							int y = (int) button.getLayoutY() / 50;
							placeDestroyerVertical(x, y);
						}
					}
				});
			}
		}
	}

	public static void allPlaced() {
		for (int yAxis = 0; yAxis < BoardOverviewController.player.length; yAxis++) {
			for (int xAxis = 0; xAxis < BoardOverviewController.player.length; xAxis++) {
				Button button = BoardOverviewController.player[xAxis][yAxis];
				button.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("All Ships Placed");
						alert.setHeaderText("All your ships have been successfully placed on the board.");
						alert.setContentText("Please choose your next shot on the opponents board.");
						alert.showAndWait();
					}
				});
			}
		}
	}

	public static void placeCarrier(int x, int y) {
		if (x + 4 > 9) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Try Again");
			alert.setContentText("The ship is too long to place here, choose another location");
			alert.showAndWait();
			setCarrier();
		} else {
			gameBoard[x][y] = fleet[4];
			BoardOverviewController.player[x][y].setGraphic(new ImageView(carrier1Img));
			gameBoard[x + 1][y] = fleet[4];
			BoardOverviewController.player[x + 1][y].setGraphic(new ImageView(carrier2Img));
			gameBoard[x + 2][y] = fleet[4];
			BoardOverviewController.player[x + 2][y].setGraphic(new ImageView(carrier3Img));
			gameBoard[x + 3][y] = fleet[4];
			BoardOverviewController.player[x + 3][y].setGraphic(new ImageView(carrier4Img));
			gameBoard[x + 4][y] = fleet[4];
			BoardOverviewController.player[x + 4][y].setGraphic(new ImageView(carrier5Img));
			setBattleship();
		}
	}

	public static void placeCarrierVertical(int x, int y) {
		if (y + 4 > 9) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Try Again");
			alert.setContentText("The ship is too long to place here, choose another location");
			alert.showAndWait();
			setCarrier();
		} else {
			gameBoard[x][y] = fleet[4];
			BoardOverviewController.player[x][y].setGraphic(new ImageView(carrier6Img));
			gameBoard[x][y + 1] = fleet[4];
			BoardOverviewController.player[x][y + 1].setGraphic(new ImageView(carrier7Img));
			gameBoard[x][y + 2] = fleet[4];
			BoardOverviewController.player[x][y + 2].setGraphic(new ImageView(carrier8Img));
			gameBoard[x][y + 3] = fleet[4];
			BoardOverviewController.player[x][y + 3].setGraphic(new ImageView(carrier9Img));
			gameBoard[x][y + 4] = fleet[4];
			BoardOverviewController.player[x][y + 4].setGraphic(new ImageView(carrier10Img));
			setBattleship();
		}
	}

	public static void placeBattleship(int x, int y) {
		if (x + 3 > 9) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Try Again");
			alert.setContentText("The ship is too long to place here, choose another location");
			alert.showAndWait();
			setBattleship();
		} else if (checkOverlap(x, y) == true || checkOverlap(x + 1, y) == true || checkOverlap(x + 2, y) == true
				|| checkOverlap(x + 3, y) == true) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Try Again");
			alert.setContentText("Ship Can't overlap another ship!");
			alert.showAndWait();
			setBattleship();
		} else {
			gameBoard[x][y] = fleet[3];
			BoardOverviewController.player[x][y].setGraphic(new ImageView(battleship1Img));
			gameBoard[x + 1][y] = fleet[3];
			BoardOverviewController.player[x + 1][y].setGraphic(new ImageView(battleship2Img));
			gameBoard[x + 2][y] = fleet[3];
			BoardOverviewController.player[x + 2][y].setGraphic(new ImageView(battleship3Img));
			gameBoard[x + 3][y] = fleet[3];
			BoardOverviewController.player[x + 3][y].setGraphic(new ImageView(battleship4Img));
			setSub();
		}
	}

	public static void placeBattleshipVertical(int x, int y) {
		if (y + 3 > 9) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Try Again");
			alert.setContentText("The ship is too long to place here, choose another location");
			alert.showAndWait();
			setBattleship();
		} else if (checkOverlap(x, y) == true || checkOverlap(x, y + 1) == true || checkOverlap(x, y + 2) == true
				|| checkOverlap(x, y + 3) == true) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Try Again");
			alert.setContentText("Ship Can't overlap another ship!");
			alert.showAndWait();
			setBattleship();
		} else {
			gameBoard[x][y] = fleet[3];
			BoardOverviewController.player[x][y].setGraphic(new ImageView(battleship5Img));
			gameBoard[x][y + 1] = fleet[3];
			BoardOverviewController.player[x][y + 1].setGraphic(new ImageView(battleship6Img));
			gameBoard[x][y + 2] = fleet[3];
			BoardOverviewController.player[x][y + 2].setGraphic(new ImageView(battleship7Img));
			gameBoard[x][y + 3] = fleet[3];
			BoardOverviewController.player[x][y + 3].setGraphic(new ImageView(battleship8Img));
			setSub();
		}
	}

	public static void placeSub(int x, int y) {
		if (x + 2 > 9) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Try Again");
			alert.setContentText("The ship is too long to place here, choose another location");
			alert.showAndWait();
			setSub();
		} else if (checkOverlap(x, y) == true || checkOverlap(x + 1, y) == true || checkOverlap(x + 2, y) == true) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Try Again");
			alert.setContentText("Ship Can't overlap another ship!");
			alert.showAndWait();
			setSub();
		} else {
			gameBoard[x][y] = fleet[1];
			BoardOverviewController.player[x][y].setGraphic(new ImageView(sub1Img));
			gameBoard[x + 1][y] = fleet[1];
			BoardOverviewController.player[x + 1][y].setGraphic(new ImageView(sub2Img));
			gameBoard[x + 2][y] = fleet[1];
			BoardOverviewController.player[x + 2][y].setGraphic(new ImageView(sub3Img));
			setCruiser();
		}
	}

	public static void placeSubVertical(int x, int y) {
		if (y + 2 > 9) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Try Again");
			alert.setContentText("The ship is too long to place here, choose another location");
			alert.showAndWait();
			setSub();
		} else if (checkOverlap(x, y) == true || checkOverlap(x, y + 1) == true || checkOverlap(x, y + 2) == true) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Try Again");
			alert.setContentText("Ship Can't overlap another ship!");
			alert.showAndWait();
			setSub();
		} else {
			gameBoard[x][y] = fleet[1];
			BoardOverviewController.player[x][y].setGraphic(new ImageView(sub4Img));
			gameBoard[x][y + 1] = fleet[1];
			BoardOverviewController.player[x][y + 1].setGraphic(new ImageView(sub5Img));
			gameBoard[x][y + 2] = fleet[1];
			BoardOverviewController.player[x][y + 2].setGraphic(new ImageView(sub6Img));
			setCruiser();
		}
	}

	public static void placeCruiser(int x, int y) {
		if (x + 2 > 9) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Try Again");
			alert.setContentText("The ship is too long to place here, choose another location");
			alert.showAndWait();
			setCruiser();
		} else if (checkOverlap(x, y) == true || checkOverlap(x + 1, y) == true || checkOverlap(x + 2, y) == true) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Try Again");
			alert.setContentText("Ship Can't overlap another ship!");
			alert.showAndWait();
			setCruiser();
		} else {
			gameBoard[x][y] = fleet[2];
			BoardOverviewController.player[x][y].setGraphic(new ImageView(cruiser1Img));
			gameBoard[x + 1][y] = fleet[2];
			BoardOverviewController.player[x + 1][y].setGraphic(new ImageView(cruiser2Img));
			gameBoard[x + 2][y] = fleet[2];
			BoardOverviewController.player[x + 2][y].setGraphic(new ImageView(cruiser3Img));
			setDestroyer();
		}
	}

	public static void placeCruiserVertical(int x, int y) {
		if (y + 2 > 9) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Try Again");
			alert.setContentText("The ship is too long to place here, choose another location");
			alert.showAndWait();
			setCruiser();
		} else if (checkOverlap(x, y) == true || checkOverlap(x, y + 1) == true || checkOverlap(x, y + 2) == true) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Try Again");
			alert.setContentText("Ship Can't overlap another ship!");
			alert.showAndWait();
			setCruiser();
		} else {
			gameBoard[x][y] = fleet[2];
			BoardOverviewController.player[x][y].setGraphic(new ImageView(cruiser4Img));
			gameBoard[x][y + 1] = fleet[2];
			BoardOverviewController.player[x][y + 1].setGraphic(new ImageView(cruiser5Img));
			gameBoard[x][y + 2] = fleet[2];
			BoardOverviewController.player[x][y + 2].setGraphic(new ImageView(cruiser6Img));
			setDestroyer();
		}
	}

	public static void placeDestroyer(int x, int y) {
		if (x + 1 > 9) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Try Again");
			alert.setContentText("The ship is too long to place here, choose another location");
			alert.showAndWait();
			setDestroyer();
		} else if (checkOverlap(x, y) == true || checkOverlap(x + 1, y) == true) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Try Again");
			alert.setContentText("Ship Can't overlap another ship!");
			alert.showAndWait();
			setDestroyer();
		} else {
			gameBoard[x][y] = fleet[0];
			BoardOverviewController.player[x][y].setGraphic(new ImageView(destroyer1Img));
			gameBoard[x + 1][y] = fleet[0];
			BoardOverviewController.player[x + 1][y].setGraphic(new ImageView(destroyer2Img));
			allPlaced();
		}
	}

	public static void placeDestroyerVertical(int x, int y) {
		if (y + 1 > 9) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Try Again");
			alert.setContentText("The ship is too long to place here, choose another location");
			alert.showAndWait();
			setDestroyer();
		} else if (checkOverlap(x, y) == true || checkOverlap(x, y + 1) == true) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Try Again");
			alert.setContentText("Ship Can't overlap another ship!");
			alert.showAndWait();
			setDestroyer();
		} else {
			gameBoard[x][y] = fleet[0];
			BoardOverviewController.player[x][y].setGraphic(new ImageView(destroyer3Img));
			gameBoard[x][y + 1] = fleet[0];
			BoardOverviewController.player[x][y + 1].setGraphic(new ImageView(destroyer4Img));
			allPlaced();
		}
	}
}
