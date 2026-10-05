package shapes;

/**
 * Here we implement the functions from the Shape interface that
 * we can implement without knowing the specific shape.
 *
 * How does this prevent code duplication?
 *
 * @author Claude Anderson
 * @author Ian Ludden, modified Oct 2026
 */
public abstract class AbstractShape {

    /**
     * Computes the area of this 2D shape.
     * @return the shape's area, as a double
     */
    public abstract double calcArea();

    /**
     * Computes the perimeter of this 2D shape.
     * @return the shape's perimeter, as a double
     */
    public abstract double calcPerimeter();

    /**
     * Even though this class does not know how to compute any perimeters,
     * polymorphism lets us call calcPerimeter() from this class.
     */
    public double calcSemiPerimeter() {
        return this.calcPerimeter() / 2;
    }

    /**
     * Even though this class does not know how to compute any areas,
     * polymorphism lets us call calcArea() from this class.
     *
     * @param other another AbstractShape object (i.e.,
     *              an instance of one of its subclasses)
     * @return true if this shape has a larger area than other,
     *         false if the other shape has an equal or larger area
     */
    public boolean hasLargerArea(AbstractShape other) {
        return this.calcArea() > other.calcArea();
    }
}
