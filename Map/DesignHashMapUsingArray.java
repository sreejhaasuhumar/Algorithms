package Map;

import java.util.Arrays;

public class DesignHashMapUsingArray {
    private int[] map;
    private final int SIZE = 1000001; // Size of the array to cover all possible keys

    public DesignHashMapUsingArray() {
        map = new int[SIZE];
        Arrays.fill(map, -1);   // Initialize all values to -1 indicating empty slots
    }

    public void put(int key, int value) {
        map[key] = value; // Directly map the key to its value
    }

    public int get(int key) {
        return map[key]; // Return the value at the key index, -1 if not found
    }

    public void remove(int key) {
        map[key] = -1; // Set the value at the key index to -1 indicating removal
    }
}
