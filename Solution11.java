class Solution11 {

    //Easy First Solution:This solution takes two pass of the array
    public void sortColors(int[] nums) {
        int colors[] = new int[3];
        for(int i=0;i<nums.length;i++){
            colors[nums[i]]++;
        }
        int ptr = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<colors[i];j++){
                nums[ptr] = i;
                ptr++;
            }
        }
    }
}