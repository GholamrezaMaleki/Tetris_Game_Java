public class Timer {
    //this class is used to show the time that you play the game

    private long startTime;

    public Timer() {
        startTime = System.currentTimeMillis();
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public int getTime() {
        long time = System.currentTimeMillis() - startTime;
        return (int) Math.floorDiv(time, 60000);
    }
}