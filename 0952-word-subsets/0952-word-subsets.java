class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) 
    {
        // List<String> result=new ArrayList<>();
        // int length=words2.length;
        // for(int i=0;i<words1.length;i++)
        // {
        //    while(length>0)
        //    {
        //     if()
        //    }
        // }
          // Combine all words in words2 into one required frequency map
        int[] requiredFreq = new int[26];
        for (String word : words2) {
            int[] freq = countFrequency(word);
            for (int i = 0; i < 26; i++) {
                requiredFreq[i] = Math.max(requiredFreq[i], freq[i]);
            }
        }

        // Check each word in words1 against the required frequency
        List<String> result = new ArrayList<>();
        for (String word : words1) {
            if (isUniversal(word, requiredFreq)) {
                result.add(word);
            }
        }

        return result;
    }

    // Count the frequency of each character in a word
    private int[] countFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    // Check if a word meets the universal condition
    private boolean isUniversal(String word, int[] requiredFreq) {
        int[] freq = countFrequency(word);
        for (int i = 0; i < 26; i++) {
            if (freq[i] < requiredFreq[i]) {
                return false;
            }
        }
        return true;
    }
}