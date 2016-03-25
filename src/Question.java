/**
 * Question.java
 *
 *
 * Created by Calvin Wong on 9/25/14.
 *
 *
 */
public class Question {

    private String category; // holds category
    private String question; // holds question
    private boolean isAnswered; // check if question has been answered

    // Constructor
    public Question(String category, String question, boolean isAnswered) {
        this.category = category;
        this.question = question;
        this.isAnswered = isAnswered;
    }

    // Empty Constructor
    public Question() {
        this.category = "";
        this.question = "";
        this.isAnswered = false;
    }

    public boolean isAnswered() { // isAnswered
        return isAnswered;
    }

    public void setAnswered(boolean isAnswered) { // set isAnswered
        this.isAnswered = isAnswered;
    }

    public String getCategory() { // get category
        return category;
    }

    public void setCategory(String category) { // set category
        this.category = category;
    }

    public String getQuestion() { // get question
        return question;
    }

    public void setQuestion(String question) { // set question
        this.question = question;
    }

    @Override
    public String toString() {
        return "Question{" +
                "category='" + category + '\'' +
                ", question='" + question + '\'' +
                ", isAnswered=" + isAnswered +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question1 = (Question) o;

        if (isAnswered != question1.isAnswered) return false;
        if (category != null ? !category.equals(question1.category) : question1.category != null) return false;
        if (question != null ? !question.equals(question1.question) : question1.question != null) return false;

        return true;
    }
} // end of class
