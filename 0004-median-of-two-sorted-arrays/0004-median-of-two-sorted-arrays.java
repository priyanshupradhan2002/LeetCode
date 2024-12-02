class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
     {
        
        int[] num3=new int[nums1.length+nums2.length];
        double result;
        for(int i=0;i<nums1.length;i++)
        {
            num3[i]=nums1[i];
        }
        for(int j=0;j<nums2.length;j++)
        {
            num3[nums1.length+j]=nums2[j];
        }
        Arrays.sort(num3);
        if(num3.length%2==1)
        {
           return (double) num3[ num3.length/2];
        }
        else 
        {
            return(num3[num3.length/2 -1]+num3[num3.length/2])/2.0;
        }
    }
}