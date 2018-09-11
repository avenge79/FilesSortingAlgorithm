package com.rado.Interview;

import java.util.Arrays;

public class TelescopicArray {
    private static boolean isTelescopic(int[] a) {
        boolean result = false;
        if (a.length == 1)
            if (a[0] == 1)
                return true;
        if (a.length % 2 != 0) {
            if (a[a.length / 2] != a[a.length / 2 + 1] + 1) {
                return false;
            }
        }
        for (int i = 1; i <= a.length / 2; i++) {
            int first = a[i - 1];
            int last = a[a.length - i];
            result = first == i && last == i;
            if (!result) break;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 2, 3, 4, 5, 3, 2, 1};
        int[] a2 = new int[]{1, 2, 3, 3, 5, 3, 2, 1};
        int[] a3 = new int[]{1, 4, 4, 1};
        int[] a4 = new int[]{1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1};
        int[] a5 = new int[]{1, 2, 3, 2, 1};

        System.out.println("Is " + Arrays.toString(a1) + " telescopic array? " + isTelescopic(a1));
        System.out.println("Is " + Arrays.toString(a2) + " telescopic array? " + isTelescopic(a2));
        System.out.println("Is " + Arrays.toString(a3) + " telescopic array? " + isTelescopic(a3));
        System.out.println("Is " + Arrays.toString(a4) + " telescopic array? " + isTelescopic(a4));
        System.out.println("Is " + Arrays.toString(a5) + " telescopic array? " + isTelescopic(a5));
    }
}
