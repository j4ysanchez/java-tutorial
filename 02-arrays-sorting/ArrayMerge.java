import java.util.Arrays;
import java.util.Comparator;

// 3. Merge `int[] a = {1, 3, 5, 7}` and `int[] b = {2, 4, 6, 8}` into one sorted array and print it.
public class ArrayMerge {
    
    public static void main (String[] args) {

        int[] a = {1,3,5,7};
        int[] b = {2,4,6,8};

        // int[] c = Arrays.copyOf(a, a.length + b.length);

        // System.out.println(Arrays.toString(c));

        // for (int x = 0, i = a.length - 1; x < b.length; i++, x++) {
        //     c[i] = b[x];
        // }

        int[] c = new int[a.length+b.length];

        int i = 0;

        for (int j = 0; j < a.length; j++, i++) {
            c[i] = a[j];
        }

        for (int j = 0; j < b.length; j++, i++) {
            c[i] = b[j];
        }

        Arrays.sort(c);

        System.out.println(Arrays.toString(c));
    }

}
