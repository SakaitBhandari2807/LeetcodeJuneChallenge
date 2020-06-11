class Solution11 {

    // Easy First Solution:This solution takes two pass of the array
//    public void sortColors(int[] nums) {
//        int colors[] = new int[3];
//        for(int i=0;i<nums.length;i++){
//            colors[nums[i]]++;
//        }
//        int ptr = 0;
//        for(int i=0;i<3;i++){
//            for(int j=0;j<colors[i];j++){
//                nums[ptr] = i;
//                ptr++;
//            }
//        }
//    }

    public void sortColors(int []nums){
        int len_nums = nums.length;
        int ptr=0,ptrZero = 0,ptrTwo = len_nums-1;

        while(ptr<=ptrTwo){
            if(nums[ptr] == 2){
                nums[ptr] = nums[ptrTwo];
                nums[ptrTwo] = 2;
                ptrTwo--;
            }
            else if(nums[ptr] == 0){
                nums[ptr] = nums[ptrZero];
                nums[ptrZero] = 0;
                ptrZero++;
                ptr++;
            }
            else {
                ptr++;
            }
        }
        for (int a:nums
             ) {
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        new Solution11().sortColors(new int[]{1,1,0,0,0,2,2});
        new Solution11().sortColors(new int[]{2,0,2,1,1,0});
        new Solution11().sortColors(new int[]{0,2,2,2,0,2,1,1});
        new Solution11().sortColors(new int[]{1,2,0});
        new Solution11().sortColors(new int[]{0});
    }
}