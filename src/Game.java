/**
 * Game.java
 *
 *
 * Created by Calvin Wong on 9/25/14.
 *
 *
 */
public class Game {

    private String gameName; // holds game name
    private int questionCount; // holds question count
    private int numberOfChance; // holds number of chances

    // Constructor
    public Game(String gameName, int questionCount, int numberOfChance) {
        this.gameName = gameName;
        this.questionCount = questionCount;
        this.numberOfChance = numberOfChance;
    }

    // Empty Constructor
    public Game() {
        this.gameName = "";
        this.questionCount = 0;
        this.numberOfChance = 0;
    }

    public String getGameName() { // get game name
        return gameName;
    }

    public void setGameName(String gameName) { // set game name
        this.gameName = gameName;
    }


    public int getQuestionCount() { // get question count
        return questionCount;
    }


    public void setQuestionCount(int questionCount) { // set question count
        this.questionCount = questionCount;
    }


    public int getNumberOfChances() { // get number of chances
        return numberOfChance;
    }


    public void setNumberOfChances(int numberOfChance) { // set number of chances
        this.numberOfChance = numberOfChance;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameName='" + gameName + '\'' +
                ", questionCount=" + questionCount +
                ", numberOfChance=" + numberOfChance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (numberOfChance != game.numberOfChance) return false;
        if (questionCount != game.questionCount) return false;
        if (gameName != null ? !gameName.equals(game.gameName) : game.gameName != null) return false;

        return true;
    }
} // end of class
