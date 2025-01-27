//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way
//import java.util.*;

class LRUCache {
    private int capacity; // Maximum capacity of the cache
    private Map<Integer, Integer> map; // To store key-value pairs
    private LinkedHashSet<Integer> order; // To maintain the order of keys

    // Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap) {
        this.capacity = cap;
        this.map = new HashMap<>();
        this.order = new LinkedHashSet<>();
    }

    // Function to return value corresponding to the key.
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1; // Key not present
        }
        // Update the usage order
        order.remove(key);
        order.add(key);
        return map.get(key); // Return the value
    }

    // Function for storing key-value pair.
    public void put(int key, int value) {
        // If the key already exists, update its value and usage order
        if (map.containsKey(key)) {
            map.put(key, value);
            order.remove(key);
            order.add(key);
            return;
        }

        // If the cache is full, remove the least recently used key
        if (map.size() >= capacity) {
            int lruKey = order.iterator().next(); // Get the least recently used key
            order.remove(lruKey); // Remove it from the usage order
            map.remove(lruKey); // Remove it from the map
        }

        // Add the new key-value pair
        map.put(key, value);
        order.add(key);
    }
}
