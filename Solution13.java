import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution13 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len_nums = nums.length,index=len_nums-1,max=1,gmax=0;
        List<Integer> subsetelements = new ArrayList<>();
        Arrays.sort(nums);
        int index_arr[] = new int[len_nums];
        int max_arr[] = new int[len_nums];
        Arrays.fill(max_arr,1);
        Arrays.fill(index_arr,-1);

        for (int i = len_nums-2; i >= 0 ; i--) {
            index = i;max=1;
//            System.out.println("INDEX before"+index);
            for (int j = i+1; j < len_nums ; j++) {
                if(nums[j] % nums[i] == 0){
                    if(max_arr[j]>=max) {
                        max = max_arr[j];
                        index = j;
                    }
//                    System.out.println("INDEX j: "+index);
                }
            }
//            System.out.println("INDEX after "+index);
            if(index != i) {
                index_arr[i] = index;
                max_arr[i] = 1 + max_arr[index];
            }
        }
        for (int i = 1; i < len_nums ; i++) {
            if(max_arr[gmax]<max_arr[i]) gmax  = i;
        }
//        for (int n:index_arr
//             ) {
//            System.out.print(n+" ");
//        }
//        System.out.println();
//
//        for (int n:max_arr
//        ) {
//            System.out.print(n+" ");
//        }
//        System.out.println();
//        System.out.println("MAX "+gmax);

        while( gmax != -1 && gmax < len_nums ) {
            subsetelements.add(nums[gmax]);
            gmax = index_arr[gmax];
        }
        return subsetelements;
    }
    public static void main(String args[]){
//        System.out.println(new Solution13().largestDivisibleSubset(new int[]{2,3,8,9,27}));
        System.out.println(new Solution13().largestDivisibleSubset(new int[]{1,2,3}));
    }
}
