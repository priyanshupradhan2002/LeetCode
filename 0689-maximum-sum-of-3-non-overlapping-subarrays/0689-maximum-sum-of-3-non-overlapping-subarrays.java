class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sums = new int[nums.length-k+1];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        for (int i = k; i < nums.length; i++) {
            sums[i-k] = sum;
            sum += nums[i]-nums[i-k];
        }
        sums[sums.length-1] = sum;
        int[] l = new int[nums.length], r = new int[nums.length];
        int curr = 0;
        for (int i = k; i < nums.length-2*k+1; i++) {
            if (sums[i-k]>sums[curr]) curr = i-k;
            l[i] = curr;
        }
        curr = sums.length-1;
        for (int i = nums.length-2*k; i >= k; i--) {
            if (sums[i+k]>=sums[curr]) curr = i+k;
            r[i] = curr;
        }
        curr = 0;
        int[] res = new int[3];
        for (int i = k; i < nums.length-2*k+1; i++) {
            int pot = sums[l[i]]+sums[r[i]]+sums[i];
            if (pot>curr) {
                curr = pot;
                res[0] = l[i];
                res[1] = i;
                res[2] = r[i];
            }
        }
        return res;
    }
}