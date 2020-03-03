/*
 * Write a description of class Sorting2 her4e.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList; 
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.Collections;
import java.util.Scanner;
public class Sorting
{
    public static void main() {
        long startTime;
        long endTime;
        long timeElapsed;
        int arrayLength = 100;

        Scanner input = new Scanner (System.in);
        System.out.print("Input a specific method of sorting. If you want to do all methods, push 'ENTER'\n\n1) Bubble Sort\n2) Selecion Sort\n3) Insertion Sort\n4) Merge Sort\n5) Quick Sort");
        String response = input.nextLine();

        System.out.println("\f          SORTING METHODS\n");

        if (response.equalsIgnoreCase("1") || response.isEmpty()) {
            ArrayList<Integer> list1 = new ArrayList<Integer>();         
            fillArray1(list1, arrayLength);
            ArrayList<Integer> list1og = new ArrayList<Integer>(list1);         

            startTime = new Date().getTime();
            System.out.println("Bubble:         " + bubble(list1) + "\nCorrect:        " + testForCorrectSort1(list1, list1og));
            endTime = new Date().getTime();
            timeElapsed = endTime - startTime;
            System.out.println("Time Elapsed:   " + timeElapsed + " Milliseconds \n");
        }

        if (response.equalsIgnoreCase("2") || response.isEmpty()) {
            ArrayList<Integer> list2 = new ArrayList<Integer>();       
            fillArray1(list2, arrayLength);
            ArrayList<Integer> list2og = new ArrayList<Integer>(list2); 

            startTime = new Date().getTime();
            System.out.println("Selection:      " + selection(list2) + "\nCorrect:        " + testForCorrectSort1(list2, list2og));
            endTime = new Date().getTime();
            timeElapsed = endTime - startTime;
            System.out.println("Time Elapsed:   " + timeElapsed + " Milliseconds \n");
        }

        if (response.equalsIgnoreCase("3") || response.isEmpty()) {
            ArrayList<Integer> list3 = new ArrayList<Integer>();         
            fillArray1(list3, arrayLength);
            ArrayList<Integer> list3og = new ArrayList<Integer>(list3);            

            startTime = new Date().getTime();
            System.out.println("Insertion:      " + insertion(list3) + "\nCorrect:        " + testForCorrectSort1(list3, list3og));
            endTime = new Date().getTime();
            timeElapsed = endTime - startTime;
            System.out.println("Time Elapsed:   " + timeElapsed + " Milliseconds \n");
        }

        if (response.equalsIgnoreCase("4") || response.isEmpty()) {
            ArrayList<Integer> list4 = new ArrayList<Integer>();         
            fillArray1(list4, arrayLength);
            ArrayList<Integer> list4og = new ArrayList<Integer>(list4);          

            startTime = new Date().getTime();
            System.out.println("Merge:          " + mergeSort(list4, 0, list4.size()-1) + "\nCorrect:        " + testForCorrectSort1(list4, list4og));
            endTime = new Date().getTime();
            timeElapsed = endTime - startTime;
            System.out.println("Time Elapsed:   " + timeElapsed + " Milliseconds \n");
        }

        if (response.equalsIgnoreCase("5") || response.isEmpty()) {

            ArrayList<Integer> list5 = new ArrayList<Integer>();         
            fillArray1(list5, arrayLength);
            ArrayList<Integer> list5og = new ArrayList<Integer>(list5);  

            startTime = new Date().getTime();
            System.out.println("Quick:          " + quick(list5, 0, list5.size()-1) + "\nCorrect:        " + testForCorrectSort1(list5, list5og));
            endTime = new Date().getTime();
            timeElapsed = endTime - startTime;
            System.out.println("Time Elapsed:   " + timeElapsed + " Milliseconds \n");
        }

    }

    public static ArrayList<Integer> fillArray1(ArrayList<Integer> list, int arrayLength) {       
        for (int i = 0; i < arrayLength; i++) {
            list.add((int)(Math.random() * 51) + 50);            
        }              
        return list;
    }

    //***  Below is the code for the Bubble Sort  ***
    public static ArrayList<Integer> bubble(ArrayList<Integer> list) {
        for (int j = list.size(); j > 0; j--) {
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i) > list.get(i+1)) {
                    swap(list, i, i+1);
                }
            }
        }
        return list;
    }

    //***  Below is the code for the Insertion Sort  ***
    public static ArrayList<Integer> insertion(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i - 1;
            while (j >= 0 && key < list.get(j)) {
                swap(list, j, j+1);              
                j--;
            }      
        }               
        return list;
    }

    //***  Below is the code for the Selection Sort  ***
    public static ArrayList<Integer> selection(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int min = i;
            for (int j = i; j < list.size(); j++) {
                if (list.get(j) < list.get(min))
                    min = j;
            }
            swap(list, i, min);
        }
        return list;
    }

    //***  Below is the code for the Merge Sort  ***
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> list, int l, int r) {
        if (l < r) {
            int m = (l+r)/2;

            mergeSort(list, l, m);
            mergeSort(list , m+1, r);
            merge(list, l, m, r);
        }
        return list;
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> list, int l, int m, int r) {
        int leftSize = m - l + 1;
        int rightSize = r - m;

        ArrayList<Integer> leftList = new ArrayList<Integer>();
        ArrayList<Integer> rightList = new ArrayList<Integer>();

        for (int i = 0; i < leftSize; i++) {
            leftList.add(i,list.get(l + i));
        }
        for (int j = 0; j < rightSize; j++) {
            rightList.add(j,list.get(m + 1+ j));
        }

        int i = 0, j = 0;
        int k = l;

        while (i < leftSize && j < rightSize) {
            if (leftList.get(i) <= rightList.get(j)) {
                list.set(k,leftList.get(i));
                i++;
            }
            else {
                list.set(k,rightList.get(j));
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            list.set(k,leftList.get(i));
            i++;
            k++;
        }
        while (j < rightSize) {
            list.set(k,rightList.get(j));
            j++;
            k++;
        }
        return list;
    }

    //***  Below is the code for the Quick Sort  ***
    public static ArrayList<Integer> quick(ArrayList<Integer> list, int l, int r) {
        if (l >= r) {
            return list;
        }
        int i = l;
        int j = r;
        int pivot = list.get((l+r)/2);
        while (i < j) {
            while (list.get(i) < pivot) {
                i++;
            }
            while (pivot < list.get(j)) {
                j--;
            }
            if (i <= j) {
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
                j--;
            }            
        }
        quick(list, l, j);           
        quick(list, i, r);
        return list;
    }

    public static void displayDisplay(ArrayList<Integer> list) {
        System.out.print("\f");
        sleep(2000);
        display(list);
    }

    public static void display(ArrayList<Integer> list) {
        int max = Collections.max(list);
        for (int i = max-1; i >= 0; i-=3) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) <= i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
        }
    }

    //***  Below is the code to test if the sorting is correct  ***
    public static boolean testForCorrectSort1(ArrayList<Integer> testIfCorrect, ArrayList<Integer> correctSort) {
        Collections.sort(correctSort);
        if (testIfCorrect.equals(correctSort)) {
            return true;
        } else 
            return false;        
    }

    //***  Below is the code that swaps two things in an array list  ***
    public static ArrayList<Integer> swap (ArrayList<Integer> list, int x, int y) {
        int temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp);
        return list;
    }

    public static void sleep (int wait) {
        try {
            Thread.sleep(wait);
        } 
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }   
    }
}