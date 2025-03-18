import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      System.out.println("Unsorted Array ---------------------------------------------------");
      ArrayList<Integer> integerList = Lab4.getList();
      Lab4.outputList(integerList);

      System.out.println("\n\nBubble sort results ----------------------------------------------");
      ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(integerList);
      Lab4.outputList(bubbleSortedList);

      System.out.println("\n\nInsertion sort results -------------------------------------------");
      ArrayList<Integer> insertionSortedList = Lab4.insertionSort(integerList);  
      Lab4.outputList(insertionSortedList);
    }
}

class Lab4 {
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
    // Step 1 - Implement insertion sort algorithm here
    ArrayList<Integer> list = new ArrayList<>(integerList);

    long startTime = System.nanoTime();
    for (int i = 1; i < list.size(); i++) {
      int key = list.get(i);
      int j = i - 1;

      // Move elements of list that are greater than key to one position ahead.
      while (j >= 0 && list.get(j) > key) {
        list.set(j + 1, list.get(j));
        j = j - 1;
      }
      list.set(j + 1, key);
    }
    long endTime = System.nanoTime(); //end timing.
    long duration = endTime - startTime; //calculate time duration.
    System.out.println("Insertion sort took " + duration + " nanoseconds");

    return list; //changed so that we return new sorted list.
  }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
    // Step 2 - Implement the bubble sort algorithm here
    ArrayList<Integer> list = new ArrayList<>(integerList);

    long startTime = System.nanoTime(); //start the timing.

    int n = list.size();
    boolean swapped;

    for (int i = 0; i < n - 1; i++) {
      swapped = false;
      for (int j = 0; j < n - i - 1; j++) {
        if (list.get(j) > list.get(j + 1)) {
          // swap elements if they are in the wrong order.
          int temp = list.get(j);
          list.set(j, list.get(j + 1));
          list.set(j + 1, temp);
          swapped = true;
        }
      }
      // If no two elements were swapped in the inner loop, then break loop.
      if (!swapped) break;
    }

    long endTime = System.nanoTime(); //end timing.
    long duration = endTime - startTime; //calculate duration.
    System.out.println("Bubble sort took " + duration + " nanoseconds");

    return list; //changed so that we return sorted list.
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> integerList = new ArrayList<>();
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
        while ((line = br.readLine()) != null) {
            integerList.add(Integer.parseInt(line));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return integerList;
  }

  public static void outputList(ArrayList<Integer> integerList) {
    for (int i = 0; i < integerList.size(); i++) {
        System.out.print(integerList.get(i) + " ");
    }
  }
}