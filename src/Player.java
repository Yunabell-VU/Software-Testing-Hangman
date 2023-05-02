public class Player {
    public String name;
    private int score;

    public Player(String name){
        this.name = name;
        this.score = 0;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public int getScore(){
        return this.score;
    }
}
