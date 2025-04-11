import java.util.List;


public class SeatingChart
{

	private Student[][] seats;
	

	public SeatingChart(List<Student> studentList, int rows, int cols)
	{
    /* to be implemented in part (a) */ 
    seats = new Student[rows][cols];
    int ind = 0;
    for (int i = 0; i < cols; i++) {
      for (int j = 0; j < rows; j++) {
        if (ind < studentList.size()) {
          seats[j][i] = studentList.get(ind);
          ind++;
        }
      }
    }
	}
	
	
	public int removeAbsentStudents(int allowedAbsences)
	{ 
    /* to be implemented in part (b) */
    int removed = 0;
    for(int r = 0; r < seats.length; r++) {
      for(int c = 0; c < seats.length; c++) {
        if (!(seats[r][c].getAbsenceCount() <= allowedAbsences)) {
          seats[r][c] = null;
          removed++;
        }
      }
    }
    return removed;
	}

	
	public void printSeatingChart()
	{
		for(int r=0; r < seats.length; r++)
		{
			for(int c=0; c < seats[r].length; c++)
			{
				if( seats[r][c] != null )
					System.out.print( seats[r][c].getName() + seats[r][c].getAbsenceCount() + "\t\t");
				else
					System.out.print( "null" + "\t\t");
			}
			System.out.println();
		}
	}
	
	public String getSeatInfo(int r,int c)
	{
		if( seats[r][c] != null )
			return seats[r][c].getName() + seats[r][c].getAbsenceCount();
		else
			return null;
	}
}