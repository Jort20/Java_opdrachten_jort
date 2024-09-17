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
    private final View view;

    public Rectangle(View view, int startX, int startY, int endX, int endY) {
        if (startX > endX || startY > endY) {
            throw new IllegalArgumentException("Parameters in wrong order.");
        }
        this.horizontal = new Interval(startX, endX);
        this.vertical = new Interval(startY, endY);
        this.view = view;
        if (view != null) {
            this.view.setRectangle(this);
        }
    }
    /**
     * Create an empty Rectangle with no location.
     */
    public Rectangle(View view) {
        this.view = view;
        if (view != null) {
            this.view.setRectangle(this);
        }
    }

    public Point getCenter() {
        if (horizontal == null) return null;
        return new Point((horizontal.getStart() + horizontal.getEnd()) / 2.0,
                (vertical.getStart() + vertical.getEnd()) / 2.0);
    }

    public boolean contains(Rectangle other) {
        if (other.horizontal == null || horizontal == null) return false;

        return (horizontal.getStart() <= other.horizontal.getStart() &&
                other.horizontal.getEnd() <= horizontal.getEnd()) &&
                (vertical.getStart() <= other.vertical.getStart() &&
                        other.vertical.getEnd() <= vertical.getEnd());
    }
    /**
     * Enlarge the Rectangle just enough so that it contains the other
     * Rectangle. If the Rectangle was empty it gets the same extension
     * as the other Rectangle.
     */
    public void accommodate(Rectangle other) {
        if (other == null || other.horizontal == null) return;
        if (horizontal == null) {
            horizontal = new Interval(other.horizontal);
            vertical = new Interval(other.vertical);
        } else {
            horizontal.setStart(min(other.horizontal.getStart(), horizontal.getStart()));
            horizontal.setEnd(max(other.horizontal.getEnd(), horizontal.getEnd()));
            vertical.setStart(min(other.vertical.getStart(), vertical.getStart()));
            vertical.setEnd(max(other.vertical.getEnd(), vertical.getEnd()));
        }
        if (view != null) {
            view.redraw();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Rectangle)) return false;
        Rectangle other = (Rectangle) obj;
        if (horizontal == null) return other.horizontal == null;
        return horizontal.equals(other.horizontal) && vertical.equals(other.vertical);
    }

    @Override
    public String toString() {
        return "Rectangle(" + horizontal + " x " + vertical + ")";
    }
}
