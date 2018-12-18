package secondstage.string;

/**
 * @ClassName IsPalindrome
 * @Description 验证回文字符串
 * @Author mingjie
 * @Date 2018/12/19 12:24 AM
 * @Versrion 1.0
 **/
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        int length = s.length();
        if(length<=1){
            return true;
        }
        s=s.replaceAll("[^0-9A-Za-z]","");
        String temp = s.toLowerCase();
        char[] arr = temp.toCharArray();
        int prev = 0;
        int last = arr.length-1;
        while (prev<length&&last>=0){
            if(arr[prev]!=arr[last]){
                return false;
            }
            prev++;
            last--;
        }
        return true;
    }

   

}
