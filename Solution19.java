import java.util.HashMap;

class Solution19 {
    public int[] twoSum(int[] nums, int target) {
        //O(n2) solution , no extra space
        int indices [] = new int[2];

        for(int i = 0 ; i < nums.length - 1; i++){
            for(int j = i+1 ;j < nums.length; j++ ){
                if( nums[i] + nums[j] == target){
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }
        return indices;
    }

    public int[] twoSumFast(int[] nums, int target) {
        //O(n) solution , using o(n) extra space
        HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < nums.length; i++){

            if(hs.containsKey( target - nums[i] ) ){
                int indices[] = { hs.get(target - nums[i]), i};
                return indices;
            }
            else hs.put(nums[i], i );

        }
        return null;
    }
}