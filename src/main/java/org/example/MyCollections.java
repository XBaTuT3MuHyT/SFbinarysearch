package org.example;

import java.util.List;
import java.util.Comparator;

public class MyCollections {

    // binarySearch для List с ключом
    public static <T extends Comparable<T>> int binarySearch(List<T> list, T key) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Сравниваем средний элемент с ключом
            int comparison = list.get(mid).compareTo(key);
            if (comparison == 0) {
                return mid; // Найден элемент
            } else if (comparison < 0) {
                left = mid + 1; // Искать в правой половине
            } else {
                right = mid - 1; // Искать в левой половине
            }
        }

        return -1; // Элемент не найден
    }

    // binarySearch для List с ключом и Comparator
    public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = c.compare(list.get(mid), key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // Элемент найден
            }
        }
        return -(low + 1); // Элемент не найден
    }
}

