class Solution18 {
    public int subarraySum(int[] nums, int k) {

        int la = nums.length;

        int count = 0;
        int sum = 0;
        for (int i = 0;i < la ; i++){
            if ( nums[i] == k){
                count++;

            }
            sum = nums[i];
            for(int j = i + 1 ; j < la ; j++){
                if ( sum + nums[j] == k ){
                    count++;

                }
                sum += nums[j];
            }
            // System.out.println(i + " : " +sum);
        }
        return count;

    }

    public static void main(String[] args) {
        Solution18 sol = new Solution18();
        sol.subarraySum(new int[] {1,-1,0},0);
    }
}