import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Collection;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Extractor.java. Implements feature extraction for collinear points in
 * two dimensional data.
 *
 * @author  Chih-Jye Wang
 * @version 2014-10-31
 *
 */
public class Extractor {
   
    // resolution settings for stdlib drawing
    private static int HI_RES = 32768;
    private static int LO_RES = 32;
    
    private Point[] points;
    
    // Build an extractor based on the points in the
    // file named by filename. 
    public Extractor(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        int n = scanner.nextInt();
        
        points = new Point[n];
        
        for(int i = 0; i < n; i++)
           points[i] = new Point(scanner.nextInt(), scanner.nextInt());
    }
  
    // Build an extractor based on the points in the
    // Collection named by c
    public Extractor(Collection<Point> c) {
        points = new Point[c.size()];
        int i = 0;
        for(Point p : c){
            points[i] = p;
            i++;
        }
    }
  

    
    // Draw all points to a graphics window. 
    // This method assumes that the stdlib.jar file is on your
    // CLASSPATH.
    // This method also assumes that all the points you want to draw
    // are in an Iterable container of Points (points below).
    public void drawPoints() {
        initDrawing();
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show(0);
    }
  
  // Draw all identified lines, if any, to a graphics window. 
  // This method assumes that the stdlib.jar file is on your
  // CLASSPATH.
  // This method also assumes that all the lines you want to draw
  // are in an Iterable container of Lines (lines below).
   // public void drawLines() {
      // initDrawing();
      // for (Line line : lines) {
         // line.first().drawTo(line.last());
      // }
      // StdDraw.show(0);
   // }
   
    // initializes the drawing canvas for StdDraw.
    // If you decide to use the two public 'draw' methods
    // above, uncomment the following method.
    // Note that you can change the resolution for
    // large and small data sets.
    private void initDrawing() {
        // rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, 10000);
        StdDraw.setYscale(0, 10000);
        StdDraw.show(0);
    }
   
    public static void main(String[] args) throws Exception {
        Extractor e = new Extractor(args[0]);
        e.drawPoints();
    }
}