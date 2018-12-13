package firststage.Array;

public class RevertString {

    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] _s = s.toCharArray();
        int start = 0;
        int end = _s.length-1;
        for (int i =end/2;i>=0;i--){
            char t=_s[start];
            _s[start++] = _s[end];
            _s[end--]=t;
        }
        return new String(_s);
    }

    public static void main(String[] args){
        RevertString rs= new RevertString();
        System.out.println(rs.reverseString("hel1lo"));
    }
}
