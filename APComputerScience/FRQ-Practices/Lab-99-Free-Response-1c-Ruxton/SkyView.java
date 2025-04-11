import java.util.*;
import java.io.*;
class SkyView {
  private double view[][];

  /**
   * Writes data from a telescope in an two dimensional array in a sweeping pattern when a SkyView object is created
   * @param numRows
   * @param numCols
   * @param scanned
   */
  public SkyView(int numRows, int numCols, double[] scanned) {
    /* to be implemented in part (a) */
    view = new double[numRows][numCols];
    int i = 0;
    for(int r = 0; r < numRows; r++) {
      if (r%2==0)
        for(int c = 0; c < numCols; c++) {
          view[r][c] = scanned[i];
          i++;
        }
      else
        for(int c = numCols-1; c >= 0; c--) {
          view[r][c] = scanned[i];
          i++;
        }
    }
  }

  /**
   * Returns the average for a rectangle of indexes in view
   * @param startRow
   * @param endRow
   * @param startCol
   * @param endCol
   * @return average
   */
  public double getAverage(int startRow, int startCol, int endRow, int endCol) {
    /* to be implemented in part (b) */
    ArrayList<Double> toAvg = new ArrayList<Double>();
    for(int r = startRow; r <= endRow; r++)
      for(int c = startCol; c <= endCol; c++)
        toAvg.add(view[r][c]);
    int avg=0;
    for(double val:toAvg)
      avg+=val;
    return avg/toAvg.size();   //dummy return
  }

  public double[][] getView() {
    return view;
  }
}