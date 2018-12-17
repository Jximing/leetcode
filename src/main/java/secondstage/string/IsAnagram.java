package secondstage.string;

/**
 * @ClassName IsAnagram
 * @Description 有效的字母异位词
 * @Author mingjie
 * @Date 2018/12/17 11:01 PM
 * @Versrion 1.0
 **/
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        int length = s.length();
        if (length != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < length; i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
