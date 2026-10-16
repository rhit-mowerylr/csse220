/**
  * 
  * DONE (1) Implement this class and (2) Document using Javadoc comments as well as regular comments
  * 
  * If you are running a recent version of Eclipse, you can command Eclipse to generate the Javadoc .html file
  * by using the command from the menu bar: Project | Generate Javadoc...
  *
  * 
 */
import java.util.ArrayList;
public class Quiz {
    int id;
    ArrayList<Question> questionsInQuiz= new ArrayList<Question>();


    public Quiz(int id){
        this.id=id;

    }

    /**
     * This void will add questions to a specific quiz.
     *
     * @param  question  -a question that will be added to the quiz.
     */
    public void QuestionsinQuiz(Question question){
        questionsInQuiz.add(question);

    }
}
