class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minWhite = Integer.MAX_VALUE;
        int whiteCount = 0;

        // Count 'W' in the first window of size k
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }
        minWhite = whiteCount;

        // Slide the window through the string
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') whiteCount++; // Add new character
            if (blocks.charAt(i - k) == 'W') whiteCount--; // Remove old character

            minWhite = Math.min(minWhite, whiteCount);
        }

        return minWhite;
    }
}
