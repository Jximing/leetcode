package Array;

public class ImplementStringStr {

    public int strStr(String haystack, String needle) {
        char[] _h = haystack.toCharArray();
        char[] _n = needle.toCharArray();
        if (_n.length > _h.length) {
            return -1;
        }
        if (_n.length == 0) {
            return 0;
        }
        int max = _h.length - _n.length;
        char first = _n[0];
        for (int i = 0; i <= max; i++) {
            if (_h[i] != first)
                while (++i <= max && _h[i] != first) ;
            if (i <= max) {
                int j = i + 1;
                int end = j + _n.length - 1;
                for (int k = 1; j < end && _h[j] == _n[k]; j++, k++) ;
                if (j == end) {
                    return i;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args){
        ImplementStringStr iss = new ImplementStringStr();
        iss.strStr("mississippi","a");
    }
}
