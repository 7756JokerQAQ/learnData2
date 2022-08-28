public class NumArray3 {
    private int[] sum;
    private int[] data;
    private SegmentTree<Integer> segmentTree;

    public NumArray3(int[] nums) {
        data = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public void update(int index, int val) {
        data[index] = val;
        for (int i = index + 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + data[i - 1];
        }

    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
    //超时间限制
}
