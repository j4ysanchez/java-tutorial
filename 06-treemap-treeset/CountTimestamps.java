import java.util.TreeMap;

public class CountTimestamps {

    /*
    2. Given a `TreeMap<Integer, String>` of event timestamps, 
    count how many events fall between times 5 and 12 (inclusive). 
    Use `subMap`. Timeline: `{1:"wake", 3:"breakfast", 7:"work", 10:"lunch", 15:"dinner"}`.
     */
    public static void main(String[] args) {

        TreeMap<Integer,String> eventMap = new TreeMap<>();

        eventMap.put(1, "wake");
        eventMap.put(3, "breakfast");
        eventMap.put(7, "work");
        eventMap.put(10, "lunch");
        eventMap.put(15, "dinner");


        System.out.println(eventMap.subMap(5, true, 12, true).size());
    }
}
