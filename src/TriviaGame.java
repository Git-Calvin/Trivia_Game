/**
 * TriviaGame.java
 *
 *
 * Created by Calvin Wong on 9/25/14.
 *
 *
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TriviaGame {

    static BufferedReader read;
    static String row;
    static Game game;
    static MyLinkedList questionList = new MyLinkedList(); // holds question list
    static MyLinkedList answerList = new MyLinkedList(); // holds answer list

    public static void main(String[] args) {

        try {

            TriviaGame start = new TriviaGame(); // new TriviaGame

            start.loadGameData(); // load game data

            // displays "loading complete"
            System.out.println("Loading Data Completed - " + questionList.size() + "::" + answerList.size() + "\n");

            // user input
            Scanner userInput = new Scanner(System.in); // get user input

            // welcome messages
            System.out.println("\n***Welcome to " + game.getGameName() + "***");
            System.out.println("\n\tYou will have (" + game.getNumberOfChances() + ") chances to answer (" +
                    game.getQuestionCount() + ") questions.\n");

            System.out.println("\n\tGood Luck!\n\n");

            int count = 1; // count
            int chance = 0;
            int correctAnswer = 0;

            while (chance < game.getNumberOfChances()) {

                Question question = (Question) questionList.get(count);

                if (question == null) {
                    break;
                }
                else if (question.isAnswered()) {
                    count++;
                    continue;
                }

                System.out.println(question.getCategory()); // print question category
                System.out.print(question.getQuestion() + "\t"); // print question

                String answer = userInput.nextLine(); // gets user input

                Answer answerObj = (Answer) answerList.get(count);

                if (answerObj.getAnswers().contains(answer.toUpperCase())) { // switch all to uppercase
                    System.out.println("Correct!");
                    question.setAnswered(true); // set answered to true
                    correctAnswer++;
                }
                else {
                    System.out.println("Incorrect!");
                }

                System.out.println("");
                chance++;

                if (count == game.getQuestionCount()) { // increment count
                    count = 1;
                }
                else {
                    count++;
                }

            }

            // print end game
            System.out.println("*****Game Over*****");
            System.out.println("Chances used: " + chance);
            System.out.println("Answered Correct: " + correctAnswer);
            System.out.println("\nThank you for playing.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadGameData() {

        try {

            File uploadFile = new File("questionset1.txt"); // read & load from this file

            read = new BufferedReader(new FileReader(uploadFile));

            boolean isFirst = true;
            boolean isName = false;
            boolean isQnCnt = false;
            boolean isChance = false;
            boolean isCategory = false;
            boolean isQn = false;

            Question question = null;
            Answer answer = null;

            List<String> ansList = null;

            // line checks
            while ((row = read.readLine()) != null) {
                if (row == null || row.equals("")) {
                    isName = false;
                    isQnCnt = false;
                    isChance = false;
                    isCategory = false;
                    isQn = false;

                    if (ansList != null && ansList.size() > 0) {
                        answer.setAnswers(ansList);
                    }
                    if (question != null && question.getCategory() != null && !question.getCategory().equals("") &&
                            question.getQuestion() != null && !question.getQuestion().equals("")) {
                        questionList.add(question); // add to question list
                    }
                    if (answer != null && answer.getAnswers().size() > 0) {
                        answerList.add(answer); // add to answer list
                    }

                    ansList = new ArrayList<String>();
                    answer = new Answer();
                    question = new Question();

                    continue;
                }
                if (isFirst) {
                    if (!isName) {
                        game = new Game(); // checks game name
                        game.setGameName(row);
                        isName = true;
                        continue;
                    }
                    if (!isQnCnt) {
                        game.setQuestionCount(Integer.parseInt(row));
                        isQnCnt = true;
                        continue;
                    }
                    if (!isChance) {
                        game.setNumberOfChances(Integer.parseInt(row));
                        isChance = true;
                        isFirst = false;
                        continue;
                    }
                }
                else {
                    if (!isCategory) {
                        question.setCategory(row); // checks game category
                        isCategory = true;
                        continue;
                    }
                    else if (!isQn) {
                        question.setQuestion(row);
                        isQn = true;
                        continue;
                    }
                    else {
                        ansList.add(row.toUpperCase());
                        continue;
                    }
                }
            }
            if (ansList != null && ansList.size() > 0) {
                answer.setAnswers(ansList);
            }
            if (question != null && question.getCategory() != null && !question.getCategory().equals("") &&
                    question.getQuestion() != null && !question.getQuestion().equals("")) {
                questionList.add(question); // add to question list
            }
            if (answer != null && answer.getAnswers().size() > 0) {
                answerList.add(answer); // add to answer list
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} // end of class