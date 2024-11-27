class Solution {
    public int minSubArrayLen(int target, int[] nums) 
    {
        int total_arraySum=0;
        int count=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            total_arraySum+=nums[i];

        while((total_arraySum)>=target)
        {
            ans=Math.min(ans,i-count+1);
            total_arraySum-=nums[count];
            count++;
        }
        }
    //    if(count!=nums.length)
          return ans==Integer.MAX_VALUE?0:ans;
       //return 0;

    //  int n = nums.length;
	// 	int ans = Integer.MAX_VALUE;
    //     int w_sum = 0;
    //     int start = 0;
		
	// 	for(int i = 0; i<n; i++){
	// 	    w_sum+=nums[i];
		    
	// 	    while(w_sum>=target){
	// 	        ans= Math.min(ans, i-start+1);
	// 	        w_sum-=nums[start];
	// 	        start++;
	// 	    }
		    
	// 	}
		
	// 	return ans == Integer.MAX_VALUE?0:ans;
    }
}