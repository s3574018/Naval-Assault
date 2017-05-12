package application;

public class Ship {
    private String shipID;
    private int health;
    private boolean shipHit; // this is not yet used
    private int hitCount;
    private boolean isAShip; // this is not yet used
    private boolean shipVertical;

    public Ship(String shipID, int health, boolean shipHit, int hitCount,
            boolean isAShip) {
        this.shipID = shipID;
        this.health = health;
        this.shipHit = shipHit;
        this.hitCount = hitCount;
        this.isAShip = isAShip;
        this.shipVertical = false;
    }

    public Ship(String shipID, int health) {
        this.shipID = shipID;
        this.health = health;
    }

    public Ship(String shipID) {
        this.shipID = shipID;
        this.health = -1;
        this.shipHit = false;
        this.hitCount = -1;
        this.isAShip = false;
    }

    public String getShipID() {
        return shipID;
    }

    public int getHealth() {
        return health;
    }

    public boolean getShipHit() {
        return shipHit;
    }

    public int getHitCount() {
        return hitCount;
    }
    
    public boolean getIsAShip() {
        return isAShip;
    }

    public void deacreaseHealth() {
        this.health--;
    }

    public void setShipHit() {
        this.shipHit = true;
    }

    public void increaseHitCount() {
        this.hitCount++;
    }

    public boolean getShipVertical() {
        return shipVertical;
    }

    public void setShipVertical(boolean shipVertical) {
        this.shipVertical = shipVertical;
    }

}
