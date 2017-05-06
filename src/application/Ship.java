package application;


public class Ship {
    private String shipID;
    private int health;

    public Ship(String shipID, int health) {
        this.shipID = shipID;
        this.health = health;
    }

    public String getShipID() {
        return shipID;
    }

    public int getHealth() {
        return health;
    }

    public void deacreaseHealth(int health) {
        this.health -= health;
    }
}
