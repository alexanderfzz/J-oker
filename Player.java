public class Player {
    String name;
    int capital;
    double VIPI;

    public Player(String name, int capital) {
        this.name = name;
        this.capital = capital;
    }

    public void withdrawCaptial(int amount) {
        this.capital -= amount;
    }
    public void depositCapital(int amount) {
        this.capital += amount;
    }

    public void showHand() {
        // if endgamecondition perform action
    }
}
