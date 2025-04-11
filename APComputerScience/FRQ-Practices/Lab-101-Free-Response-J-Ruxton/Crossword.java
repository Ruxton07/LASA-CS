public class Crossword
{
  private Square[][] puzzle;

  /* Part (b) */

  public Crossword(boolean[][] blackSquares)
  {
    /* to be implemented in part (b) */
    puzzle = new Square[blackSquares.length][blackSquares[0].length];
    int currentNum = 1;
    for (int r = 0; r < blackSquares.length; r++) {
      for (int c = 0; c < blackSquares[0].length; c++) {
        if (blackSquares[r][c]) {
          puzzle[r][c] = new Square(true, 0);
        }
        else if (toBeLabeled(r, c, blackSquares)) {
          puzzle[r][c] = new Square(false, currentNum);
          currentNum++;
        }
        else {
          puzzle[r][c] = new Square(false, 0);
        }
      }
    }
  }

  /* Part (a) */

  private boolean toBeLabeled(int r, int c, boolean[][] blackSquares)
  {
      /* to be implemented in part (a) */
    return (!(blackSquares[r][c]) && (r == 0 || c == 0 || blackSquares[r-1][c] || blackSquares[r][c-1]));
  }

  public Square getSquare(int r, int c) { return puzzle[r][c]; }
}
