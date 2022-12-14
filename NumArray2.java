package org.jetbrains.annotations;
public class NumArray2 {
    private int[] sum;
    public NumArray2(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }



    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
