class Solution {
    public int maxSubarraySumCircular(int[] nums)
    {
        //int current_sum=0;
        int total_arr_sum=0;
        // int maxsum=Integer.MIN_VALUE;
        // int minsum=Integer.MAX_VALUE;
        for(int num:nums)
        {
            total_arr_sum+=num;//Calculating The total sum
            // current_sum+=num;
            // maxsum=Math.max(current_sum,maxsum);
            // minsum=Math.min(current_sum,minsum);
            // if(current_sum<0)
            //    current_sum=0;
        }
        //  int circular_sum=total_arr_sum-(minsum);
        //  if(maxsum>0)
        //     Math.max(circular_sum,maxsum);

        //  return maxsum;
        //Calculating the minimum sum by kadens algorithim
        int min_sum=kadensMin(nums);

        //calciulating the maximum sum by kadens algorithim
        int max_sum=kadensMax(nums);

        //calculating the circular sum
        int circular_sum=total_arr_sum - min_sum;

        //checking the condition whether maxsum value is positive or not
        if(max_sum>0)
          return Math.max(max_sum, circular_sum);
        return max_sum;
    }
//Calculating the Minimum sum by using kadens algorithim
    public static int kadensMin(int[] arr)
    {
        int sum=arr[0];
        int minsum=arr[0];

        for(int i=1;i<arr.length;i++)
        {
            sum=Math.min(sum+arr[i],arr[i]);
            minsum=Math.min(sum,minsum);
        }
        return minsum;
    }
  //Calculating the Maximum sum by using kadens algorithim
     public static int kadensMax(int[] arr)
    {
        int sum=arr[0];
        int maxsum=arr[0];

        for(int i=1;i<arr.length;i++)
        {
            sum=Math.max(sum+arr[i],arr[i]);
            maxsum=Math.max(sum,maxsum);
        }
        return maxsum;
    }
}