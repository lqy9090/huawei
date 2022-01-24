public class doublePointerLc674 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int l = 0, r = 1;
        int maxLen = 0;
        int len = 1;
        while (r < nums.length) {
            System.out.print("nums[r]: " + nums[r] + "nums[l]: " + nums[l]);
            System.out.println(" len: "+len+" maxLen: "+maxLen);
            if (nums[r] > nums[l]) {
                len++;
                if (r==nums.length -1) maxLen = Math.max(len,maxLen);
            } else{
                if (len>maxLen) maxLen = len;
                len = 1;
            }

            r++;
            l++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 3, 5, 4, 7};
//        int[] nums = new int[]{1, 3, 5, 4, 7};
        int[] nums = new int[]{1,3,5,4,2,3,4,5};
        doublePointerLc674 solution = new doublePointerLc674();
        int length = solution.findLengthOfLCIS(nums);
        System.out.println(length);
    }
}
