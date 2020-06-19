class Solution7 {
    public int change(int amount,int []coins){
        // Time complexity O(coins.size * amount)
        // Space complexity is also same O(coins.size * amount)
        // TODO: Reduce space complexity to O(n)


        int dp[][] = new int[coins.length+1][amount+1];
        for (int i = 0; i < coins.length+1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < amount+1; i++) {
            dp[0][i] = 0;
        }
        for(int i = 1;i < coins.length+1;i++){
            for (int j = 1; j < amount+1; j++) {
                if(coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }

        return dp[coins.length][amount];
    }
    public static void main(String args[]){
        System.out.println(new Solution7().change(5,new int[]{1,2,5}));
        System.out.println(new Solution7().change(3,new int[]{2}));
        System.out.println(new Solution7().change(10,new int[]{10}));
    }
}
