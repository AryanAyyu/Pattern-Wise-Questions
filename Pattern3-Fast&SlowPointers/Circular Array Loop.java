//Link : https://leetcode.com/problems/circular-array-loop/description/

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) continue;

            int slow = i;
            int fast = i;
            boolean forward = nums[i] > 0;

            while (true) {

                slow = nextIndex(nums, forward, slow);
                fast = nextIndex(nums, forward, fast);

                if (fast != -1)
                    fast = nextIndex(nums, forward, fast);

                if (slow == -1 || fast == -1)
                    break;

                if (slow == fast)
                    return true;
            }

            // mark visited
            int index = i;
            while (nums[index] != 0) {
                int next = nextIndex(nums, nums[index] > 0, index);
                nums[index] = 0;
                if (next == -1) break;
                index = next;
            }
        }

        return false;
    }

    private int nextIndex(int[] nums, boolean forward, int current) {
        boolean direction = nums[current] > 0;

        if (forward != direction)
            return -1;

        int n = nums.length;
        int next = ((current + nums[current]) % n + n) % n;

        if (next == current)
            return -1;

        return next;
    }
}
