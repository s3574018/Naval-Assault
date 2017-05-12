package application;

public class Ship {
    private String shipID;
    private int health;
    private boolean shipHit;
    private int hitCount;
    private boolean isAShip;

    public Ship(String shipID, int health, boolean shipHit, int hitCount,
            boolean isAShip) {
        this.shipID = shipID;
        this.health = health;
        this.shipHit = shipHit;
        this.hitCount = hitCount;
        this.isAShip = isAShip;
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

    public void deacreaseHealth(int health) {
        this.health -= health;
    }

    public void setShipHit(int health) {
        this.shipHit = true;
    }

    public void increaseHitCount(int hitCount) {
        this.hitCount += hitCount;
    }

}
