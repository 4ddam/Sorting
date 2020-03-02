/*
 * Write a description of class Sorting2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Collections;
public class Sorting
{
    public static void main() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();         
        fillArray1(list1, 20);
        ArrayList<Integer> list1og = new ArrayList<Integer>(list1);         

        System.out.println("         SORTING\n");
        System.out.println("Bubble:         " + bubble(list1) + "\nCorrect:        " + testForCorrectSort1(list1, list1og) + "\n");

        ArrayList<Integer> list2 = new ArrayList<Integer>();       
        fillArray1(list2, 20);
        ArrayList<Integer> list2og = new ArrayList<Integer>(list2); 

        System.out.println("Selection:      " + selection(list2) + "\nCorrect:        " + testForCorrectSort1(list2, list2og) + "\n");

        ArrayList<Integer> list3 = new ArrayList<Integer>();         
        fillArray1(list3, 20);
        ArrayList<Integer> list3og = new ArrayList<Integer>(list3);            

        System.out.println("Insertion:      " + insertion(list3) + "\nCorrect:        " + testForCorrectSort1(list3, list3og) + "\n");

        ArrayList<Integer> list4 = new ArrayList<Integer>();         
        fillArray1(list4, 20);
        ArrayList<Integer> list4og = new ArrayList<Integer>(list4);  
        
        mergeSort(list4, 0, list4.size()-1);
        
        System.out.println("Merge:          " + list4 + "\nCorrect:        " + testForCorrectSort1(list4, list4og) + "\n");
        

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
                list.remove(j+1);   
                list.add(j, key);               
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
    public static void mergeSort(ArrayList<Integer> list, int l, int r) {
        if (l < r) {
            int m = (l+r)/2;

            mergeSort(list, l, m);
            mergeSort(list , m+1, r);
            merge(list, l, m, r);
        }
    }

    public static void merge(ArrayList<Integer> list, int l, int m, int r) {
        int leftSize = m - l + 1;
        int rightSize = r - m;

        ArrayList<Integer> leftList = new ArrayList<Integer>();
        ArrayList<Integer> rightList = new ArrayList<Integer>();

        for (int i=0; i<leftSize; ++i) {
            leftList.add(0);
            leftList.set(i,list.get(l + i));
        }
        for (int j=0; j<rightSize; ++j) {
            rightList.add(0);
            rightList.set(j,list.get(m + 1+ j));
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
    }

    //***  Below is the code for the Quick Sort  ***

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
}