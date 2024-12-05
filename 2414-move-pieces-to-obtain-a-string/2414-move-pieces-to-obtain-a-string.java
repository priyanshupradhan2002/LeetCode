class Solution {
    public boolean canChange(String start, String target) {
        // Check if the 'L' and 'R' counts are the same in both strings
        if (start.replace("_", "").equals(target.replace("_", ""))) {
            int n = start.length();
            
            // Traverse both strings, comparing the relative positions of 'L' and 'R'
            int i = 0, j = 0;

            while (i < n && j < n) {
                // Skip underscores in both strings
                while (i < n && start.charAt(i) == '_') i++;
                while (j < n && target.charAt(j) == '_') j++;

                if (i < n && j < n) {
                    // If both start[i] and target[j] are 'L'
                    if (start.charAt(i) == 'L' && target.charAt(j) == 'L') {
                        // 'L' should not move right, it must stay to the left or move left
                        if (i < j) return false;
                    }
                    // If both start[i] and target[j] are 'R'
                    else if (start.charAt(i) == 'R' && target.charAt(j) == 'R') {
                        // 'R' should not move left, it must stay to the right or move right
                        if (i > j) return false;
                    }
                    // If 'start' and 'target' mismatch in their 'L' or 'R' placement
                    else return false;
                }
                // Move the pointers for next valid characters
                i++;
                j++;
            }

            return true;
        }
        return false;
    }
}
