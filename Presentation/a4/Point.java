import java.util.Comparator;

/**
 * Point.java. Models a two dimensional point in terms
 * of (x, y) coordinates.
 *
 * @author:  Dean Hendrix (dh@auburn.edu)
 * @version: 2013-10-08
 *
 */
public class Point implements Comparable<Point> {

 // compare points by slope
 // You must assign this to an instance of an appropriate
 // Comparator class. (Write your own nested class.)
   public final Comparator<Point> SLOPE_ORDER = new PointComparator();

 // x,y coordinates
   private int x;
   private int y;

   // DO NOT MODIFY
   public Point(int x, int y) {
      this.x = x;
      this.y = y;
   }
   
 // plot this point to standard drawing
   public void draw() {
      // If you choose to use this, simply uncomment the following line.
      StdDraw.point(x, y);
   }

 // draw line between this point and that point to standard drawing
   public void drawTo(Point that) {
      // If you choose to use this, simply uncomment the following line.
      StdDraw.line(this.x, this.y, that.x, that.y);
   }
   
 // slope between this point and that point
   public double slopeTo(Point that) {
      //Degenerate line
      if (this.x == that.x && this.y == that.y)
         return Double.NEGATIVE_INFINITY;
         
      //Vertical line
      if (this.x == that.x)
         return Double.POSITIVE_INFINITY;
         
      return (double)(that.y - this.y) / (that.x - this.x);
   }
   
 // Does this point precede that point in natural order?
 // comparing y-coordinates and breaking ties by x-coordinates
   public int compareTo(Point that) {
      if (this.y < that.y)
         return -1;
      else if (this.y > that.y)
         return 1;
      else
      {
         if (this.x < that.x)
            return -1;
         else if (this.x > that.x)
            return 1;
         else
            return 0;
      }
   }
   
   @Override
   public String toString() {
    // DO NOT MODIFY
      return "(" + x + ", " + y + ")";
   }
   
   public boolean equals(Object o)
   {
      if (o == null)
         return false;
      
      Point p = (Point)o;
      return ((x == p.x) && (y == p.y));
   }
   
   public int hashCode()
   {
      int hash = 7;
      hash = 71 * hash + this.x;
      hash = 71 * hash + this.y;
      return hash; 
   }
   
   class PointComparator implements Comparator<Point>
   {
      public int compare(Point p, Point q)
      {
         Point o = new Point(x, y);
         double s1 = o.slopeTo(p);
         double s2 = o.slopeTo(q);
         if (s1 < s2)
            return -1;
         if (s1 > s2)
            return 1;
         else
            return 0;
      }
   }
   
}