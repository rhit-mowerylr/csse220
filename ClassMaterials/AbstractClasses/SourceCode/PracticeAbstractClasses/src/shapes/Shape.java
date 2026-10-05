package shapes;

/**
 * This interface has the same methods as the AbstractShape class.
 * Why do we prefer AbstractShape?
 * 
 * @author Claude Anderson (Modified Mark Weiss's code)
 * @author Ian Ludden, modified Oct 2026
 *
 */
public interface Shape {
	
	/**
	 * @return the area of this shape
	 */
	double getArea();

	/**
	 * @return the perimeter of this shape
	 */
	double getPerimeter();

	/**
	 * @return half the perimeter of this shape
	 */
	double calcSemiPerimeter();

	/**
	 * @return whether this shape's area is larger than other's
	 */
	boolean hasLargerArea(AbstractShape other);
}
