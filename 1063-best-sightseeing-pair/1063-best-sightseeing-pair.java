// class Solution {
//     public int maxScoreSightseeingPair(int[] values) 
//     {
//         int max=0;
//         for(int i=0;i<values.length-1;i++)
//         {
//             for(int j=i+1;j<values.length;j++)
//             {
//                 int cal=0;
//                 cal=values[i]+values[j]+i-j;
//                 if( max<cal)
//                 {
//                     max=cal;
//                 }
//             }
//         }
//         return max;
//     }
// }
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;
        int maxLeft = values[0]; // Initialize with the first value's contribution to values[i] + i
        
        for (int j = 1; j < values.length; j++) {
            // Calculate the current score using the best left value
            maxScore = Math.max(maxScore, maxLeft + values[j] - j);
            
            // Update the maxLeft for the next iteration
            maxLeft = Math.max(maxLeft, values[j] + j);
        }
        
        return maxScore;
    }
}
