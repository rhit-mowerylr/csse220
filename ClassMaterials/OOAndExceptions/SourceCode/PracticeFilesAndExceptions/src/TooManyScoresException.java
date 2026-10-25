package basicSolution;


public class TooManyScoresException extends RuntimeException {
    private int actual;
    private int allowed;

    public TooManyScoresException(int actual, int allowed){
        this.actual =actual;
        this.allowed = allowed;
    }

    @Override
    public String getMessage() {
        return String.format("Too many scores: recieved" + actual +"but only need allowed" + allowed);
    }
}
