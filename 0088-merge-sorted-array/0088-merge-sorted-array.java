class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // int i = m - 1; // Pointer for the last element in nums1's actual elements
        // int j = n - 1; // Pointer for the last element in nums2
        // int index = m + n - 1; // Pointer for the last position in nums1

        // // Merge nums1 and nums2 from the end
        // while (i >= 0 && j >= 0) {
        //     if (nums1[i] > nums2[j]) {
        //         nums1[index] = nums1[i];
        //         i--;
        //     } else {
        //         nums1[index] = nums2[j];
        //         j--;
        //     }
        //     index--;
        // }

        // // If there are remaining elements in nums2
        // while (j >= 0) {
        //     nums1[index] = nums2[j];
        //     j--;
        //     index--;
        // }

        for(int i=0;i<nums2.length;i++)
        {
            nums1[m+i]=nums2[i];
        }
        Arrays.sort(nums1);
    }
}
