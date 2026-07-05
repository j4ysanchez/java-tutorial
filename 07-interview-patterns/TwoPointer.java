import java.util.*;

public class TwoPointer {

    /*
    2. **(Two Pointer)** Given a sorted `int[]`, find all **unique** pairs that sum to a target 
    and print each pair.
   `{1, 1, 2, 3, 4, 5, 6, 7}`, target=8 → `(1,7) (2,6) (3,5)`
    */

   public static void main(String[] args) {
    int[] ints = {1, 1, 2, 3, 4, 5, 6, 7};
    int target = 8;

    Map<Integer, Set<List<Integer>>> sums = new HashMap<>();

    // for (int i = 0; i < ints.length; i++) {
    //     for (int j = i+1 ; j < ints.length; j++) {

    //         int sum = ints[i] + ints[j];

    //         Integer[] orderedPair = {ints[i],ints[j]};
    //         Arrays.sort(orderedPair);

    //         List<Integer> orderedPairList = List.of(orderedPair);

    //         if (sums.containsKey(sum)) {
    //             Set<List<Integer>> uniquePairs = sums.get(sum);
    //             uniquePairs.add(orderedPairList);
    //         } else {
    //             Set<List<Integer>> uniquePairs = new HashSet<List<Integer>>();
    //             uniquePairs.add(orderedPairList);
    //             sums.put(sum,uniquePairs);
    //         }
    //     }

    // System.out.printf("Unique pairs for target %d:%n", target);
    // Set<List<Integer>> pairsForTarget = sums.get(target);
    // for(List<Integer> pair : pairsForTarget) {
    //     System.out.printf("%s ", pair.toString());
    // }

    Arrays.sort(ints);

    int left = 0;
    int right = ints.length -1;

    List<List<Integer>> pairs = new ArrayList<>();
    while (left < right) {

        if (ints[left] + ints[right] == target) {
            List<Integer> matchingPair = new ArrayList<>();
            matchingPair.add(ints[left]);
            matchingPair.add(ints[right]);

            Collections.sort(matchingPair);

            pairs.add(matchingPair);
            left++;
        }
        else if (ints[left] + ints[right] > target) {
            right--;
        } else if (ints[left] + ints[right] < target) {
            left++;
        }
    }

    Set<List<Integer>>uniquePairs = new HashSet<>();
    uniquePairs.addAll(pairs);

    List<List<Integer>> newList = new ArrayList<>(uniquePairs);
    newList.sort(Comparator.comparing(pair -> pair.get(0)));

    // // Set<List<Integer>>uniquePairs = new HashSet<>(pairs);
    // Comparator<List<Integer>> byFirstThensecond = Comparator.<List<Integer>, Integer>comparing(
    //     p-> p.get(0)).thenComparing(p->p.get(1));

    // Set<List<Integer>> uniquePairs = new TreeSet<>(byFirstThensecond);
    // uniquePairs.addAll(pairs);

    System.out.printf("Unique pairs for target %d:%n", target);
    for (List<Integer> pair : newList) {
        System.out.printf("%s ", pair);
    }    



   }
}
