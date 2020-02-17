import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {
    public static int solutionsCounter=0;
    public static boolean solutionCheck=true;
    public static void main(String[] args)
    {
        int table[]=new int[writingQuantity()];
        fillingTable(table);
        permuting(table, table.length);
    }

    public static int writingQuantity()
    {
        Scanner input= new Scanner(System.in);
        System.out.print("How many numbers do you want to permute?: ");
        return input.nextInt();
    }

    public static void fillingTable(int [] table)
    {
        for (int i=0; i<table.length;i++)
        {
            table[i] = i+1;
        }
    }

    public static void permuting(int [] table, int length)
    {
        int iTemp=0;
        if(length==1)
        {
            checkingCorrectness(table,table.length);
            if(solutionCheck) {
                displayingResults(table);
            }
            solutionCheck=true;
        }

        else
        {
            for(int i=0; i<length;i++)
            {
                iTemp=table[i];
                table[i]=table[length-1];
                table[length-1]=iTemp;

                permuting(table,length-1);

                iTemp=table[i];
                table[i]=table[length-1];
                table[length-1]=iTemp;
            }
        }


    }

    public static void displayingResults(int [] table)
    {
        solutionsCounter++;
        System.out.print("Permutation "+ solutionsCounter+": ");
        for(int i=0;i<table.length;i++) {
            System.out.print(table[i]+ " ");
        }
        System.out.println("");
    }

    public static boolean checkingCorrectness(int [] table, int iTableLength)
    {

        for(int i=0;i+1<iTableLength;i++)
        {

            if(abs((table[i]-table[iTableLength-1]))==((iTableLength-1)-i))
            {
                solutionCheck=false;
            }

            else {
                solutionCheck= checkingCorrectness(table,iTableLength-1);
            }

        }
        return solutionCheck;
    }

}





