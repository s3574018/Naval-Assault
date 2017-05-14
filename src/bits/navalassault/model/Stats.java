package bits.navalassault.model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Stats {
    private static int hitCount;
    private static int missCount;
    private static int shotCount;
    // private static int[] values;
    private static int[] shotRecord = new int[100];
    private static int valuesCounter;

    public Stats() {
        hitCount = 0;
        missCount = 0;
        shotCount = 0;
        valuesCounter = 0;
        // int values = new int[100];
    }

    // get current hit count
    public static int getHitCount() {
        return hitCount;
    }

    // get current miss count
    public static int getMissCount() {
        return missCount;
    }

    // get current shot count
    public static int getShotCount() {
        return shotCount;
    }

    // increase hit count by 1
    public static void increaseHitCount() {
        hitCount += 1;
    }

    // increase miss count by 1
    public static void increaseMissCount() {
        missCount += 1;
    }

    // increase shot count by 1
    public static void increaseShotCount() {
        shotCount += 1;
    }

    // records hit to shotRecord array
    public static void addHitValue() {
        shotRecord[valuesCounter] = 2;
        valuesCounter++;
    }

    // records miss to shotRecord array
    public static void addMissValue() {
        shotRecord[valuesCounter] = 1;
        valuesCounter++;
    }

    // calculates consecutive misses and returns value
    public static int countConsecutiveMisses() {
        int maxLength = 0;
        int tempLength = 0;

        for (int i = 0; i < shotRecord.length; i++) {

            if (shotRecord[i] == 1) {
                tempLength++;
            } else {
                tempLength = 0;
            }

            if (tempLength > maxLength) {
                maxLength = tempLength;
            }
        }
        return maxLength;
    }

    // calculates consecutive hits and returns value
    public static int countConsecutiveHits() {
        int maxLength = 0;
        int tempLength = 0;
        for (int i = 0; i < shotRecord.length; i++) {
            if (shotRecord[i] == 2) {
                tempLength++;
            } else {
                tempLength = 0;
            }
            if (tempLength > maxLength) {
                maxLength = tempLength;
            }
        }
        return maxLength;
    }

    // for testing only
    public static void printArray() {
        for (int i = 0; i < shotRecord.length; i++) {
            System.out.print(shotRecord[i]);
            if (i == 49) {
                System.out.println();
            }
            if (i == 99) {
                System.out.println();
                System.out.println();
            }
        }
    }
    
    public static void showWin() {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Game Over");
		alert.setHeaderText("You have defeated the enemy! Congratulations!");
		alert.setContentText("Game Stats: \n"
				+ "\nShots Fired: " + getShotCount()
				+ "\nShots Hit: " + getHitCount()
				+ "\nShots Missed: " + getMissCount()
				+ "\n"
				+ "\nLargest Hit Streak: " + countConsecutiveHits()
				+ "\nLargest Miss Streak: " + countConsecutiveMisses()
				+ "\n"
				+ "\nUse the game menu to restart or quit the game"
				+ "\nThanks for playing!");
		alert.showAndWait();
    }
    
    public static void showLose() {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Game Over");
		alert.setHeaderText("You have been defeated by the enemy!");
		alert.setContentText("Game Stats: \n"
				+ "\nShots Fired: " + getShotCount()
				+ "\nShots Hit: " + getHitCount()
				+ "\nShots Missed: " + getMissCount()
				+ "\n"
				+ "\nLargest Hit Streak: " + countConsecutiveHits()
				+ "\nLargest Miss Streak: " + countConsecutiveMisses()
				+ "\n"
				+ "\nUse the game menu to restart or quit the game"
				+ "\nThanks for playing!");
		alert.showAndWait();
    }
}
