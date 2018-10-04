package Array;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        int index = 0;
        boolean sign = true;
        while (sign) {
            if(strs[0].length()==index){
                break;
            }
            char _t = strs[0].charAt(index);
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() == index || strs[i].charAt(index) != _t) {
                    sign = false;
                    index--;
                    break;
                }
            }
            index++;
        }
        return strs[0].substring(0, index);
    }

    //更好的解法
    public String longestCommonPrefix1(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) {
                    return "";
                }
            }
        }
        return prefix;
    }
    
    public static void main(String[] args) {
        LongestCommonPrefix lcpf = new LongestCommonPrefix();
        String[] strs = {"abc"};
        System.out.println(lcpf.longestCommonPrefix(strs));
    }
}
