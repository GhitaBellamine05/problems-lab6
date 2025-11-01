package problem4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListPerformanceComparison {

    private static final int SIZE = 100_000;        // total elements
    private static final int OPERATIONS = 10_000;   // random operations to test

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();


        System.out.println("---- Performance Comparison ----");

        System.out.println("---- Populate both lists ----");
        for (int i = 0; i < SIZE; i++) {
            int randomValue = (int) (Math.random() * 1000);
            // initializing the 2 lists with teh same random values
            arrayList.add(randomValue);
            linkedList.add(randomValue);
        }
//        System.out.println(arrayList);
//        System.out.println(linkedList);


    //  Random insertions and deletions
    testRandomInsertDelete(arrayList, "ArrayList");

    testRandomInsertDelete(linkedList, "LinkedList");

    // Sequential insertions/deletions at beginning and end
    testSequentialInsertDelete(arrayList, "ArrayList");

    testSequentialInsertDelete(linkedList, "LinkedList");

    //  Random access test
    testRandomAccess(arrayList, "ArrayList");

    testRandomAccess(linkedList, "LinkedList");
}

    private static void testRandomInsertDelete(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        // Random insertions
        for (int i = 0; i < OPERATIONS; i++) {
            int index = random.nextInt(list.size()); // return an int from 0 to list.size() -1
            list.add(index, i);
        }
        // Random deletions
        for (int i = 0; i < OPERATIONS; i++) {
            int index = random.nextInt(list.size()); // return an int from 0 to list.size() -1
            list.remove(index);
        }

        long end = System.nanoTime();
        System.out.printf("%s - Random insert/delete: %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------

    private static void testSequentialInsertDelete(List<Integer> list, String name) {
        long start = System.nanoTime();
        // Sequential insertions and deletions  for LinkedList
        if (list instanceof LinkedList) {
            LinkedList<Integer> linked = (LinkedList<Integer>) list;
            for (int i = 0; i < OPERATIONS; i++) {
                linked.addFirst(i);      // beginning
                linked.addLast(i);       // end
            }
            for (int i = 0; i < OPERATIONS; i++) {
                linked.removeFirst();
                linked.removeLast();
            }
        } else {
            // Sequential insertions and deletions for the ArrayList
            for (int i = 0; i < OPERATIONS; i++) {
                list.add(0, i);          // beginning
                list.add(i);               // end
            }
            for (int i = 0; i < OPERATIONS; i++) {
                list.remove(0);          // beginning
                list.remove(list.size() - 1); // end
            }
        }

        long end = System.nanoTime();
        System.out.printf("%s - Sequential insert/delete (start/end): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------

    private static void testRandomAccess(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        long sum = 0;
        // sum of the all elements in the list
        for(int i= 0; i< list.size(); i++){
            sum += list.get(i);
        }

        long end = System.nanoTime();
        System.out.printf("%s - Random access (get): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }
}



