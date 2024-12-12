

class Solution {
    public long pickGifts(int[] gifts, int k) {
        // Create a max-heap (priority queue) to track the largest element
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        // Add all elements of gifts array to the heap
        for (int gift : gifts) {
            maxHeap.offer(gift);
        }

        // Perform the operation k times
        while (k > 0) {
            // Extract the largest gift
            int max = maxHeap.poll();

            // Calculate its square root and update the heap with the new value
            int root = (int) Math.sqrt(max);
            maxHeap.offer(root);

            k--; // Decrement the number of operations remaining
        }

        // Calculate the sum of the gifts remaining in the heap
        long sum = 0;
        while (!maxHeap.isEmpty()) {
            sum += maxHeap.poll();
        }

        return sum;
    }
}
