
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

        // ArrayList<Integer> smaller=new ArrayList<>();
        // ArrayList<Integer> equal=new ArrayList<>();
        // ArrayList<Integer> greater=new ArrayList<>();

        // for(int num:nums)
        // {
        //     if(num<pivot)
        //     {
        //         smaller.add(num);
        //     }
        //     else if(num==pivot)
        //     {
        //         equal.add(num);
        //     }
        //     else if(num>pivot)
        //     {
        //         greater.add(num);
        //     }
        // }
        //   int index=0;
        //    for(int num:smaller)
        //     nums[index++]=num;
        //     for(int num:equal)
        //     nums[index++]=num;
        //     for(int num:greater)
        //     nums[index++]=num;

        // return nums;
        
        ///Approach 3

        class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;

        // Arrays to store less-than-pivot and greater-than-pivot elements
        int[] less = new int[n];
        int[] high = new int[n];
        int[] result = new int[n];

        // Counters for different parts of the array
        int count = 0; // To count the number of pivot elements
        int j = 0; // Index for the 'less' array
        int k = 0; // Index for the 'high' array

        // Partition the input array into 'less', 'high', and count pivot occurrences
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                less[j++] = nums[i];
            } else if (nums[i] == pivot) {
                count++;
            } else {
                high[k++] = nums[i];
            }
        }

        // Fill the result array
        int index = 0;

        // Add elements less than the pivot
        for (int a = 0; a < j; a++) {
            result[index++] = less[a];
        }

        // Add the pivot element `count` times
        for (int a = 0; a < count; a++) {
            result[index++] = pivot;
        }

        // Add elements greater than the pivot
        for (int a = 0; a < k; a++) {
            result[index++] = high[a];
        }

        return result;
    }

}