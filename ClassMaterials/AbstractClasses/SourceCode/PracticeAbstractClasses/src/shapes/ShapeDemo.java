package shapes;

/**
 * Illustrate polymorphism and inheritance, using several AbstractShape classes.
 *
 * @author Claude Anderson, modifying code by Mark Weiss
 * @author Ian Ludden, modified Oct 2026
 */
class ShapeDemo {

    public static void main(String[] args) {
        AbstractShape[] shapes = {
                new Circle(2.0),
                new Rectangle(1.0, 3.0),
                null,
                new Square(2.0)
        };

        System.out.println();
        System.out.println("Total area          = " + totalArea(shapes));
        System.out.println("Total semiperimeter = " + totalSemiperimeter(shapes));
        System.out.println();

        AbstractShape largestShape = findLargestArea(shapes);
        System.out.println("The shape with the largest area is:\n\t" + largestShape + "\n");

        printAll(shapes);
    }

    public static double totalArea(AbstractShape[] shapeArray) {
        double total = 0;
        for (AbstractShape s : shapeArray) {
            if (s != null)
                total += s.calcArea();
        }
        return total;
    }

    public static double totalSemiperimeter(AbstractShape[] shapeArray) {
        double total = 0;
        for (AbstractShape s : shapeArray) {
            if (s != null)
                total += s.calcSemiPerimeter();
        }
        return total;
    }

    public static AbstractShape findLargestArea(AbstractShape[] shapeArray) {
        if (shapeArray == null || shapeArray.length == 0) {
            System.out.println("No largest shape");
            return null;
        }

        AbstractShape largestShape = shapeArray[0];
        for (AbstractShape s : shapeArray) {
            if (s == null) {
                continue; // a handy Java keyword for
                          // skipping to the next iteration
            }
            if (s.hasLargerArea(largestShape)) {
                largestShape = s;
            }
        }
        return largestShape;
    }

    public static void printAll(AbstractShape[] shapeArray) {
        for (AbstractShape s : shapeArray)
            System.out.println(s); // uses each custom toString(), if it exists
    }
}
