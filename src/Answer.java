/**
 * Answer.java
 *
 *
 * Created by Calvin Wong on 9/25/14.
 *
 *
 */
import java.util.List;

public class Answer {

    private List<String> answers; // to hold answers

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) { // set
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answers=" + answers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (answers != null ? !answers.equals(answer.answers) : answer.answers != null) return false;

        return true;
    }

} // end of class