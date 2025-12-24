/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		//curve(Integer.parseInt(args[0]),
		//	  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		  //    Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if(n == 0) {
			StdDraw.line(x1, y1, x2, y2);
			return;
		}
		double midX1 = x1 + (x2 - x1) / 3;
		double midY1 = y1 + (y2 - y1) / 3;
		double midX2 = x1 + 2 * (x2 - x1) / 3;
		double midY2 = y1 + 2 * (y2 - y1) / 3;

		double deltaX = midX2 - midX1;
		double deltaY = midY2 - midY1;	

		double xPeak = midX1 + deltaX / 2 - Math.sqrt(3) * deltaY / 2;
        double yPeak = midY1 + deltaY / 2 + Math.sqrt(3) * deltaX / 2;
		
		curve(n - 1, x1, y1, midX1, midY1);
		curve(n - 1, midX1, midY1, xPeak, yPeak);
		curve(n - 1, xPeak, yPeak, midX2, midY2);
		curve(n - 1, midX2, midY2, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		
		if (n >= 0) {
			double h = Math.sqrt(3) / 2;
			curve(n, 0.0, h, 1.0, h);
			curve(n, 1.0, h, 0.5, 0.0);
			curve(n, 0.5 , 0.0, 0.0, h);
		}
	}
}
