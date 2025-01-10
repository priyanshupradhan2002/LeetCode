class Solution {
    public int[] plusOne(int[] digits) 
    {
         int n = digits.length;
        Set<Integer> resultSet = new HashSet<>();  // You can store the results in a set if required

        // Start from the last digit and propagate the carry
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // No carry needed, we can return the result
            }
            digits[i] = 0; // Set current digit to 0 if it results in carry
        }

        // If we finish the loop and there is still a carry, we need to add a new most significant digit
        int[] result = new int[n + 1];
        result[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            result[i] = digits[i - 1];
        }

        return result; // Return the new array with the incremented value
    }
}