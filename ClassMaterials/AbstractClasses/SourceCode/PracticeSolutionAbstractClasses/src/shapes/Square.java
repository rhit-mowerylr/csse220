package shapes;

/**
 * A square is a special case of Rectangle, so this code is very simple.
 *
 * @author Claude Anderson, modifying an example by Mark Weiss.
 *
 */
public class Square extends Rectangle {
    public Square(double side) {
        super(side, side); // re-use the Rectangle(length, width) constructor
    }

    @Override
    public String toString() {
        return "Square: " + this.getLength();
    }
}
