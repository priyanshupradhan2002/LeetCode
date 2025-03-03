class Solution {
    public int[] pivotArray(int[] nums, int pivot) 
    {
        // Arrays.sort(nums);
        // int index=0;
        // for(int i=0;i<nums.length;i++)
        // {
        //     if(nums[i]==pivot)
        //      {
        //          index=i;
        //          break;
        //      }
        // }
        // int i=0;
        // int j=index-1;

        // while(i<j)
        // {
        //     int temp=nums[i];
        //     nums[i]=nums[j];
        //     nums[j]=temp;
        //     i++;
        //     j--;
        // }
        // return nums;

        ArrayList<Integer> smaller=new ArrayList<>();
        ArrayList<Integer> equal=new ArrayList<>();
        ArrayList<Integer> greater=new ArrayList<>();

        for(int num:nums)
        {
            if(num<pivot)
            {
                smaller.add(num);
            }
            else if(num==pivot)
            {
                equal.add(num);
            }
            else if(num>pivot)
            {
                greater.add(num);
            }
        }
          int index=0;
           for(int num:smaller)
            nums[index++]=num;
            for(int num:equal)
            nums[index++]=num;
            for(int num:greater)
            nums[index++]=num;

        return nums;
        
    }
}