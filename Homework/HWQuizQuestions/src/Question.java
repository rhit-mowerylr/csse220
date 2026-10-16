/**
  * 
  * DONW (1) Implement this class and (2) Document using Javadoc comments as well as regular comments
  *
  * If you are running a recent version of Eclipse, you can command Eclipse to generate the Javadoc .html file
  * by using the command from the menu bar: Project | Generate Javadoc...
  * 
 */
public class Question {
    int id;
    String questionQuery;

    public  Question(int id, String questionQuery){
        this.id=id;
        this.questionQuery=questionQuery;
    }

    /**
     * This void will change one of the specific questions given by QuizMain and will be reflected on
     * every quiz that contains this number Question.
     * @param newQuery -The new question to replace the old question.
     *
     */
    public void updateQuestionQuery(String newQuery){
        this.questionQuery=newQuery;
    }
}
