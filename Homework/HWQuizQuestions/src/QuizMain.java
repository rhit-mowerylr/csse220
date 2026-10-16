import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is used to demonstrate a functional design involving Quizzes and
 * Questions which can be updated and displayed
 * 
 * 
 *************************************************************************************** 
 *         REQUIRED HELP CITATION
 * 
 *         DONE: cite your help here or say "only used CSSE220 materials"
 *         Used CSSE220 materials and SRT Kaylee Franklin
 *************************************************************************************** 
 */
public class QuizMain {
	
	//DONE add instance variables here
	HashMap<Integer, Quiz> quizzes= new HashMap<Integer,Quiz>();
	HashMap<Integer, Question> new_questions= new HashMap<Integer,Question>();

	public QuizMain() {
		// DONE In order to demonstrate functionality, please follow the TODOs below
		// You will have to create questions and quizzes when a QuizMain is created
		
		
		// DONE 1 Create five questions (can be silly/basic questions) use id 1,2,3,4,5 ...
		Question Q1= new Question(1, "Who is your favorite Marvel Super Hero?");
		Question Q2= new Question(2, "Which country would like to a week vacation at?");
		Question Q3= new Question(3, "What is the air-speed velocity of a unladen swallow?");
		Question Q4= new Question(4, "If you can meet anyone living celebrity, who will it be and why?");
		Question Q5= new Question(5, "Would you like to help me with a movie project?");
		new_questions.put(1, Q1);
		new_questions.put(2, Q2);
		new_questions.put(3, Q3);
		new_questions.put(4, Q4);
		new_questions.put(5, Q5);

		// DONE 2 Create three or more quizzes  use id 1,2,3...
		//      (One quiz should share at least one question with another )
		Quiz Test1= new Quiz(1);
		Quiz Test2= new Quiz(2);
		Quiz Test3= new Quiz(3);

		Test1.QuestionsinQuiz(Q4);
		Test1.QuestionsinQuiz(Q3);
		Test1.QuestionsinQuiz(Q2);
		Test2.QuestionsinQuiz(Q4);
		Test2.QuestionsinQuiz(Q3);
		Test2.QuestionsinQuiz(Q1);
		Test3.QuestionsinQuiz(Q5);
		quizzes.put(1, Test1);
		quizzes.put(2, Test2);
		quizzes.put(3, Test3);
	}
	
	public static void main(String[] args) {
		//We want to use instance variables of the QuizMain class so we need to construct a QuizMain object
		QuizMain myQuizSimulator = new QuizMain();
		
		// DONE 3 Display three or more different quizzes
		System.out.println("--------------------------------------------------");
		System.out.println("Showing three or more original quizzes:");
		System.out.println("--------------------------------------------------");
		myQuizSimulator.handleDisplayQuiz(1);
		myQuizSimulator.handleDisplayQuiz(2);
		myQuizSimulator.handleDisplayQuiz(3);
		
		
		
		// DONE 4 Change two quiz questions
		// A. (One should be shared with two or more quizzes)
		// B. (One should be unique to one quiz)
		myQuizSimulator.handleUpdateQuizQuestion(1,"What is your favorite DC Super Hero?");
		myQuizSimulator.handleUpdateQuizQuestion(3,"What is the air-speed velocity of a laden swallow?");

		
		// DONE 5 Display the same three (or more) quizzes
		//	   A. One that has a unique question which changed
		//	   B. Two which share a question that has been changed		
		System.out.println("--------------------------------------------------");
		System.out.println("Showing three or more changed quizzes:");
		System.out.println("--------------------------------------------------");
		myQuizSimulator.handleDisplayQuiz(1);
		myQuizSimulator.handleDisplayQuiz(2);
		myQuizSimulator.handleDisplayQuiz(3);
		
	}
	
	/**
	 *  This method should display a quiz in a very similar fashion to the output provided
	 *  in exampleOutput.txt, which is located in your repository
	 * 
	 * 
	 * @param quizId
	 */
	public void handleDisplayQuiz(int quizId) {
		//DONE complete this method
		System.out.println("Quiz: " + quizId);
		for (int i=0; i<quizzes.get(quizId).questionsInQuiz.size(); i++){
			Question q= quizzes.get(quizId).questionsInQuiz.get(i);
			System.out.println("	Question["+q.id+"]: "+q.questionQuery);
		}


	}
	
	/**
	 * 
	 * This method should replace the data in the question with id=questionId with the new questionData 
	 * 
	 * @param questionId
	 * @param questionData
	 */
	public void handleUpdateQuizQuestion(int questionId, String questionData) {
		//DONE complete this method
		/**
		 * This void will change the enitre question that matches the question Id. In other words,
		 * if QuestionId=4, Question 4 will have a new question to be answered.
		 */
		Question nq = new_questions.get(questionId);
		nq.updateQuestionQuery(questionData);
	}

}
