import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
// import java.util.*   // can be used instead of above 2 lines

public class Main
{

    public static void main(String[] args)
    {

        DIYsort diy = new DIYsort();

        int[] array1 = new int[10];
        int[] array2 = new int[10];
        int[] array3 = new int[10];
        int[] array4 = new int[10];
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list4 = new ArrayList<Integer>();

/*
        for(int i = 0; i < 10; i++)
        {
            array1[i] = (int)(Math.random()*20)+1;
            array2[i] = (int)(Math.random()*20)+1;
            array3[i] = (int)(Math.random()*20)+1;
            array4[i] = (int)(Math.random()*20)+1;
            list1.add((int)(Math.random()*20)+1);
            list2.add((int)(Math.random()*20)+1);
            list3.add((int)(Math.random()*20)+1);
            list4.add((int)(Math.random()*20)+1);
        }
*/
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; i++)
        {
            array1[i] = sc.nextInt();
        }
        for(int i = 0; i < 10; i++)
        {
            array2[i] = sc.nextInt();

        }
        for(int i = 0; i < 10; i++)
        {
            array3[i] = sc.nextInt();
        }
        for(int i = 0; i < 10; i++)
        {
            array4[i] = sc.nextInt();
        }
        for(int i = 0; i < 10; i++)
        {
            list1.add(sc.nextInt());
        }
        for(int i = 0; i < 10; i++)
        {
            list2.add(sc.nextInt());
        }
        for(int i = 0; i < 10; i++)
        {
            list3.add(sc.nextInt());
        }
        for(int i = 0; i < 10; i++)
        {
            list4.add(sc.nextInt());
        }
        System.out.println("TESTING bubbleSort()");
        diy.bubbleSort(array1,true);
        System.out.println("array1 asc  " + Arrays.toString(array1));
        diy.bubbleSort(array2,false);
        System.out.println("array2 desc " + Arrays.toString(array2));
        System.out.println("list1       " + list1);
        diy.bubbleSort(list1,true);
        System.out.println("list1 asc   " + list1);
        System.out.println("list2       " + list2);
        diy.bubbleSort(list2,false);
        System.out.println("list2 desc  " + list2);

        System.out.println("\nTESTING selectionSort()");
        diy.selectionSort(array3,true);
        System.out.println("array3 asc     " + Arrays.toString(array3));
        diy.selectionSort(array4,false);
        System.out.println("array4 desc    " + Arrays.toString(array4));
        System.out.println("list3          " + list3);
        diy.selectionSort(list3,true);
        System.out.println("list3 asc      " + list3);
        System.out.println("list4          " + list4);
        diy.selectionSort(list4,false);
        System.out.println("list4 desc     " + list4); 


    }
 

}
