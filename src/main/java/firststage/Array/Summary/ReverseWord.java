package firststage.Array.Summary;

public class ReverseWord {


    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        int start = 0;
        int end = strs.length-1;
        while (start < end) {
            String temp = strs[start];
            strs[start++] = strs[end];
            strs[end--] = temp;
        }
        String res = "";
        for (String _s : strs) {
            _s=_s.equals("")?"":(_s+" ");
            res = res+_s;
        }
        return res.trim();
    }


    //拆分成两个问题,1) 覆盖掉多余的空格 2)翻转字符串
    // 结合一下,边覆盖边翻转...
    /*
        限制条件：
        1) 完整的串前后不能有多处的空格
        2) 子串与子串之间可能有多个空格但是要消除
        3) 子串内部不翻转，子串与子串的位置进行翻转

        Solution: 1.先将所有字符翻转,再对每个子串进行内部翻转就完成了整体的翻转
                  2.how to solution redundency blank space?
                        双指针,j先行,i后行,j遇到" "一直前进到下一个串头,i移动一步,被一个空格覆盖,
                        然后j依次循环覆盖i位置的字符,until j再次遇到空格
                        最后,截取(0,i)的子串
    */
    public String reverseWords1(String s) {
        if(s == null || s.trim().length() == 0)
            return "";
        char[] c = s.toCharArray();
        int i = 0,j = 0;
        while(j < c.length) {
            //若一开始就为" ",则找到子串第一个开头
            while(j < c.length && c[j] == ' ')
                j++;
            //后半部分一直为" "
            if(j >= c.length)
                break;
            if(i != 0)
                c[i++] = ' ';
            int st = i;
            while(j < c.length && c[j] != ' ')
                c[i++] = c[j++];
            reverse(c,st,i-1);
        }
        reverse(c,0,i-1);
        s = new String(c);
        return s.substring(0,i);
    }

    private void reverse(char[] c,int i,int j){
        while(i < j){
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
            i++;
            j--;
        }
    }
    public static void main(String[] args){
        ReverseWord rw = new ReverseWord();
        String s = "  a   b     c     e   ff";
        System.out.println(rw.reverseWords(s));
    }
}
