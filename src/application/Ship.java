package application;

public class Ship {
    private String shipID;
    private int health;
    private int hitCount;
    private boolean isAShip;
    private boolean shipVertical;
    private boolean sinkStatusSent;
//    private static boolean allShipsSunk;

    public Ship(String shipID, int health, boolean shipHit, int hitCount,
            boolean isAShip) {
        this.shipID = shipID;
        this.health = health;
        this.hitCount = hitCount;
        this.shipVertical = false;
        this.isAShip = isAShip;
    }

    public Ship(String shipID, int health) {
        this.shipID = shipID;
        this.health = health;
    }

    public Ship(String shipID) {
        this.shipID = shipID;
        this.health = -1;
        this.hitCount = -1;
    }

    public String getShipID() {
        return shipID;
    }

    public int getHealth() {
        return health;
    }

//    public boolean getShipHit() {
//        return shipHit;
//    }

    public int getHitCount() {
        return hitCount;
    }
    
    public boolean getIsAShip() {
        return isAShip;
    }

    public void deacreaseHealth() {
        this.health--;
    }

//    public void setShipHit() {
//        this.shipHit = true;
//    }

    public void increaseHitCount() {
        this.hitCount++;
    }

    public boolean getShipVertical() {
        return shipVertical;
    }

    public void setShipVertical(boolean shipVertical) {
        this.shipVertical = shipVertical;
    }

    public boolean isSinkStatusSent() {
        return sinkStatusSent;
    }

    public void setSinkStatusSent(boolean sinkStatusSent) {
        this.sinkStatusSent = sinkStatusSent;
    }

//    public static boolean isAllShipsSunk() {
//        return allShipsSunk;
//    }
//
//    public static void setAllShipsSunk(boolean allShipsSunk) {
//        Ship.allShipsSunk = allShipsSunk;
//    }

}
