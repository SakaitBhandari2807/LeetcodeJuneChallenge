Problem Url: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3354/

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 1) return true;
        if(n%2 !=0) return false;
        int count =0;
        while(n>0){
            count+=n%2;
            n = n/2;
        }
        if(count==1) return true;
        else return false;
    }
}
