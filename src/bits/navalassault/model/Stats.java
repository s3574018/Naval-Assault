package bits.navalassault.model;

public class Stats {
    private static int hitCount;
    private static int missCount;
    private static int shotCount;

    public Stats() {
        hitCount = 0;
        missCount = 0;
        shotCount = 0;
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
}
