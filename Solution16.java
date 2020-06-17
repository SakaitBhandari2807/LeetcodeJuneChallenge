import java.util.HashSet;

class Solution16 {
    String chunks[];
    HashSet<Character> ipchars;
    public String validIPAddress(String IP) {

        int count1 = 0,count2 = 0;
        for (char ch:IP.toCharArray()
             ) {
            if(ch == '.') count1++;
            if(ch == ':') count2++;
        }
        if(IP.length() <= 15 && count1>count2){
            chunks = IP.split("[.]+");
            if(chunks.length != 4 || IP.charAt(IP.length()-1) == '.') return "Neither";
            return check_IPv4();
        }
        if(IP.length() <= 39 && count2>count1){
            chunks = IP.split(":");
            ipchars = new HashSet<>();

            ipchars.add('a');ipchars.add('A');
            ipchars.add('b');ipchars.add('B');
            ipchars.add('c');ipchars.add('C');
            ipchars.add('d');ipchars.add('D');
            ipchars.add('e');ipchars.add('E');
            ipchars.add('f');ipchars.add('F');

            if(chunks.length != 8 || IP.charAt(IP.length()-1) == ':') return "Neither";
            return check_IPv6();
        }
        return "Neither";
    }
    public String check_IPv6(){
        for(int i = 0; i < chunks.length;i++){
            if(chunks[i].length() > 4 || chunks[i].equals("") || chunks[i].charAt(0) == '-')
                return "Neither";
            else{
                for(int j = 0 ;j < chunks[i].length(); j++){
                    if( !isValid6(chunks[i].charAt(j)) ) return "Neither";
                }
            }
        }
        return "IPv6";
    }

    public boolean isValid6(char ch){
        return ipchars.contains(ch) || (ch>47 && ch < 58) ;
    }


    public static void main(String args[]){
//        System.out.println(new Solution16().validIPAddress("172.16.254.1")); //IPv4
//        System.out.println(new Solution16().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));//IPv6
//        System.out.println(new Solution16().validIPAddress("256.256.256.256"));//Neither
//        System.out.println(new Solution16().validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));//IPv6
//        System.out.println(new Solution16().validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"));//Ipv6
//        System.out.println(new Solution16().validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));//Neither
//        System.out.println(new Solution16().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));//Neither
//        System.out.println(new Solution16().validIPAddress("1e1.2.3.4"));//Neither
//        System.out.println(new Solution16().validIPAddress("1.1.1.1."));//Neither
//        System.out.println(new Solution16().validIPAddress("00.1.1.1"));//Neither
//        System.out.println(new Solution16().validIPAddress("-0.1.1.1"));//Neither
//        System.out.println(new Solution16().validIPAddress("2001:db8:85a3:-0::8a2E:0370:7334"));//Neither
        System.out.println(new Solution16().validIPAddress("f:f:f:f:f:f:f:f"));//Neither

    }



    public String check_IPv4(){

        for(int i = 0; i < chunks.length;i++){

            if(chunks[i].length() >1 && (chunks[i].charAt(0) == '0' || chunks[i].charAt(0) == '-')){
                return "Neither";
            }
            else{

                int ch;
                try{
                    ch = Integer.parseInt(chunks[i]);
                }
                catch(Exception e){
                    return "Neither";
                }
                if(! isValid(ch) ) return "Neither";
            }
        }
        return "IPv4";
    }
    public boolean isValid(int ch){
        return ch<256 && ch > -1;
    }
}