package application;

<<<<<<< HEAD
import javafx.scene.Parent;

public class Ship extends Parent {
    public int type;
    public boolean vertical = true;

    private int health;

    public Ship(int type, boolean vertical) {
        this.type = type;
        this.vertical = vertical;
        health = type;

        /*VBox vbox = new VBox();
        for (int i = 0; i < type; i++) {
            Rectangle square = new Rectangle(30, 30);
            square.setFill(null);
            square.setStroke(Color.BLACK);
            vbox.getChildren().add(square);
        }

        getChildren().add(vbox);*/
    }

    public void hit() {
        health--;
    }

    public boolean isAlive() {
        return health > 0;
=======

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
>>>>>>> refs/remotes/origin/master
    }
}
