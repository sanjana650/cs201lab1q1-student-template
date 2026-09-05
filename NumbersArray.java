import java.util.*;

public class NumbersArray {
    public static void main(String[] args) {
        Integer[] input = { 1, 2, 3, 4, 1, 5 };

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " +
                Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));

        System.out.println();

        input = new Integer[] { 1, 2, 3, 4, 1, 2, 5, 3 };

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " +
                Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));
    }

    // Write your methods here
    public static Integer findMax(Integer[] input) {
        int max = Integer.MIN_VALUE;

        for (int i : input) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }

    public static Integer[] findDuplicates(Integer[] input) {
        int len = input.length;
        TreeSet<Integer> duplicates = new TreeSet<>();
        TreeSet<Integer> seen = new TreeSet<>();

        for (int i : input) {
            if (seen.contains(i)) {
                duplicates.add(i);
            } else {
                seen.add(i);
            }
        }

        Integer[] result = new Integer[duplicates.size()];
        return duplicates.toArray(result);

    }

    public static Integer[] findUnique(Integer[] input) {
        Set<Integer> duplicateSet = new TreeSet<>(Arrays.asList(findDuplicates(input)));
        Set<Integer> unique = new TreeSet<>();

        for (int i : input) {
            if (!duplicateSet.contains(i)) {
                unique.add(i);
            }
        }

        Integer[] result = new Integer[unique.size()];
        return unique.toArray(result);

    }

}
