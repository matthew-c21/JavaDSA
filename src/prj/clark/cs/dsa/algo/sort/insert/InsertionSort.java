package prj.clark.cs.dsa.algo.sort.insert;

import prj.clark.cs.dsa.algo.sort.Sorter;

import java.util.Comparator;

public class InsertionSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] objs) {
        sort(objs, Comparator.naturalOrder());
    }

    @Override
    public <T> void sort(T[] objs, Comparator<T> cmp) {
        for (int i = 0; i < objs.length; ++i) {
            // Move from the current position back through the array.
            for (int j = i; j > 0; --j) {
                // If the previous element is smaller, then swap it.
                if (cmp.compare(objs[j], objs[j - 1]) < 0) {
                    exch(objs, j, j - 1);
                } else {
                    // Otherwise, the array up to that point should be in order, and we can stop.
                    break;
                }
            }
        }
    }

    private static <T> void exch(T[] objs, int a, int b) {
        T tmp = objs[a];
        objs[a] = objs[b];
        objs[b] = tmp;
    }
}
