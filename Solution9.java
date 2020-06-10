// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3355/

class Solution9 {
    public boolean isSubsequence(String s, String t) {
        int s_ptr = 0;
        for(int i=0;i<t.length();i++){
            if(s_ptr<s.length() && s.charAt(s_ptr) == t.charAt(i)){
                s_ptr++;
            }
        }
        if(s_ptr==s.length()){
            return true;
        }
        else return false;
    }
}
