package Array;

public class ImplementStringStr {

    public int strStr(String haystack, String needle) {
        char[] _h = haystack.toCharArray();
        char[] _n = needle.toCharArray();
        if(_n.length>_h.length){
            return -1;
        }
        if(_n.length==0){
            return 0;
        }
        return 0;
    }

}
