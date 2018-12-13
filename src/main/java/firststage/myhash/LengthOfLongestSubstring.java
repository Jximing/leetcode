package firststage.myhash;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = 0;
        char[] cs = s.toCharArray();
        int record = 0;
        boolean repeat = false;
        for (int i=0;i<cs.length;i++){
            for (int j=i-1;j>=record;j--){
                if(cs[i]==cs[j]){
                    length = Math.max(length,i-j);
                    length = Math.max(length,i-record);
                    if(!repeat){
                        repeat = true;
                    }
                    record=j+1;
                }
            }
        }
        return repeat?Math.max(length,s.length()-record-1):s.length();
    }
    public static void main(String[] args){
        LengthOfLongestSubstring lols = new LengthOfLongestSubstring();
        System.out.print(lols.lengthOfLongestSubstring("abcabcbb"));
    }
}
