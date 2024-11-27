class Solution {
    public String compressedString(String word) 
    {
        StringBuilder comp = new StringBuilder();
        int i = 0;
        int n = word.length();
        
        while (i < n) {
            char currentChar = word.charAt(i);
            int count = 0;
            
            // Count how many times the current character repeats consecutively, up to 9
            while (i < n && word.charAt(i) == currentChar && count < 9) {
                count++;
                i++;
            }
            
            // Append the count and the character to the result
            comp.append(count).append(currentChar);
        }
        
        return comp.toString();
    }
}