import java.util.TreeSet;

public class FindEvent {
    /*
    1. Given `int[] events = {10, 3, 7, 15, 1, 8}` and `int query = 6`, 
    find the closest event time to the query (either floor or ceiling — whichever is nearer). 
    If tied, pick the floor.
     */

    public static void main(String[] args) {
        int[] events = {10, 3, 7, 15, 1, 8};
        int query = 6;

        TreeSet<Integer> eventTree = new TreeSet<>();

        for (int event : events) {
            eventTree.add(event);
        }


        int closest;


        // note: unboxing may throw null pointer exception
        int beforeQuery = eventTree.floor(query);

        int afterQuery = eventTree.ceiling(query);

        



        if (query - beforeQuery <= afterQuery - query) {
            closest = beforeQuery;
        } else {
            closest = afterQuery;
        }

        System.out.println(closest);
    }
}
