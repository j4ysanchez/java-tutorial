import java.util.*;

public class TopKWords {
    /*
     * 4. **(Top-K)** Find the k most frequent words sorted by frequency descending,
     * then alphabetically descending for ties.
     * `{"the","sky","is","blue","the","sky","is","sky"}`, k=2 → `["sky", "the"]`
     */

    public static void main(String[] args) {

        String[] words = { "the", "sky", "is", "blue", "the", "sky", "is", "sky" };

        int topK = 2;

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            frequencyMap.merge(word, 1, (a, b) -> a + b);
        }

        // TreeMap<Integer, List<String>> sortedMap = new TreeMap<>();

        // for (String word : frequencyMap.keySet()) {
        //     int frequency = frequencyMap.get(word);

        //     if (!sortedMap.containsKey(frequency)) {
        //         List<String> wordList = new ArrayList<>();
        //         wordList.add(word);
        //         sortedMap.put(frequency, wordList);
        //     }
        //     else {
        //         List<String> wordList = sortedMap.get(frequency);                
        //         wordList.add(word);

        //         wordList.sort(Comparator.reverseOrder());
        //     }
        // }

        // List<String> topKWords = new ArrayList<>();
        // int wordsAdded = 0;

        // while (wordsAdded < topK) {

        //     Map.Entry<Integer, List<String>> entry = sortedMap.pollLastEntry();

        //     List<String> wordList = entry.getValue();

        //     for (String word : wordList) {
        //         if (wordsAdded < topK) {
        //             topKWords.add(word);
        //             wordsAdded++;
        //         }
        //     }
        // }


        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue() == 0 ? b.getKey().compareTo(a.getKey()) : b.getValue() - a.getValue());
        maxHeap.addAll(frequencyMap.entrySet());


        List<String> topKWords = new ArrayList<>();

        while (topKWords.size() < topK) {
            topKWords.add(maxHeap.poll().getKey());
        }

        System.out.println(topKWords);



    }
}
