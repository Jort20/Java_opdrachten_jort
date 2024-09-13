package section6_design.part0_refactoring;

import static java.lang.Math.*;

/**
 * Gratefully borrowed and adapted from https://sewiki.iai.uni-bonn.de/teaching/lectures/oosc/2012/assignment_12
 * @author Michiel Noback (&copy; 2017)
 * @version 0.01
 */
public class Rectangle {
    private Interval horizontal;
    private Interval vertical;
    private View view;

    public Rectangle(View view, int startX, int startY, int endX, int endY) {
        if ((startX > endX) || (startY > endY))
            throw new IllegalArgumentException("Parameters in wrong order.");
        this.horizontal = new Interval(startX, endX);
        this.vertical = new Interval(startY, endY);
        this.view = view; view.rectangle = this;
    }

    /**
     * Create an empty Rectangle with no location.
     */
    public Rectangle(View view) {
        this.horizontal = null;
        this.vertical = null;
        this.view = view; view.rectangle = this;
    }

    public Point getCenter() {
        if (horizontal == null)
            return null;
        return new Point((horizontal.start + horizontal.end) / 2,
                (vertical.start + vertical.end) / 2);
    }

    public boolean contains(Rectangle parameter) {
        if (parameter.horizontal == null)
            return false;
        if (horizontal == null)
            return false;
        // check whether the horizontal interval
        // contains the horizontal interval
        // in the other rectangle
        // AND
        // check whether the vertical interval
        // contains the vertical interval
        // in the other rectangle
        return ((horizontal.start <= parameter.horizontal.start)
                && (parameter.horizontal.end <= horizontal.end))
                && ((vertical.start <= parameter.vertical.start)
                && (parameter.vertical.end <= vertical.end));
    }

    /**
     * Enlarge the Rectangle just enough so that it contains the other
     * Rectangle. If the Rectangle was empty it gets the same extension
     * as the other Rectangle.
     */
    public void accommodate(Rectangle other) {
        if ((other == null) || (other.horizontal == null))
            return;
        if (horizontal == null) {
            horizontal = new Interval(other.horizontal);
            vertical = new Interval(other.vertical);
            return;
        }
        horizontal.start = min(other.horizontal.start, horizontal.start);
        horizontal.end = max(other.horizontal.end, horizontal.end);
        vertical.start = min(other.vertical.start, vertical.start);
        vertical.end = max(other.vertical.end, vertical.end);
        view.redraw();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Rectangle))
            return false;
        Rectangle other = (Rectangle) obj;
        if (horizontal == null)
            return (other.horizontal == null);
        return (horizontal.equals(other.horizontal))
                && (vertical.equals(other.vertical));
    }

    public String toString() {
        return "Rectangle(" + horizontal + " x " + vertical + ")";
    }

    public class Interval {
        private int start;
        private int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }

        public Interval (Interval interval) {
            this.start = interval.start;
            this.end = interval.end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    static class View{
        public Rectangle rectangle;
        public void redraw() {
            System.out.println(rectangle);
        }
    }

    static class Point {
        public final double x;
        public final double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}