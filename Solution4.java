class Solution {
    public void reverseString(char[] s) {
        int start = 0,end = s.length-1;
        while(start<end){
            char ch = s[end];
            s[end] = s[start];
            s[start] = ch;
            start++;
            end--;
        }
    }
}
