package tugofcards;

public class GameConfig {
    private static GameConfig instance;
    private int winThreshold; 

    private GameConfig() {
        this.winThreshold = 10;
    }

    public static synchronized GameConfig getInstance() {
        if (instance == null) {
            instance = new GameConfig();
        }
        return instance;
    }

    public int getWinThreshold() { return winThreshold; }
    public void setWinThreshold(int val) { this.winThreshold = val; }
}