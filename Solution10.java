class Solution10 {
    public static void main(String args[]){
        Solution10 sol = new Solution10();
        System.out.println(sol.searchInsert(new int[]{1,3,5,6},5));
        System.out.println(sol.searchInsert(new int[]{1,3,5,6},2));
        System.out.println(sol.searchInsert(new int[]{1,3,5,6},7));
        System.out.println(sol.searchInsert(new int[]{1,3,5,6},0));
    }
    public int searchInsert(int[] nums, int target) {
        int start = 0,end = nums.length-1;

        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]>target){
                end = mid -1;
            }
            else {
                start = mid +1;
            }
        }

        return start;
    }

}
