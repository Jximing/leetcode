package firststage.myhash;

import java.util.Arrays;

/**
 * @author jiangliuhong
 * @since TODO
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        char[] map = new char[131072];
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        for (int i=0;i<cs.length;i++){
            if(map[cs[i]]== '\u0000'&&map[ct[i]+65536]=='\u0000'){
                map[cs[i]] = ct[i];
                map[ct[i]+65536]=cs[i];
            }else if(map[cs[i]] != ct[i]){
                return false;
            }
        }
        return true;
    }

    //更好的做法
    public boolean isIsomorphic1(String s, String t) {
        int[] s_int = func(s);
        int[] t_int = func(t);
        for(int i = 0; i < s.length(); i++){
            if(s_int[i] != t_int[i])return false;
        }
        return true;
    }
    public int[] func(String str){
        int[] res = new int[str.length()];
        for(int i = 0; i < str.length(); i++){
            int start = str.indexOf(str.charAt(i));
            if(start == i){
                res[i] = i;
            }else {
                res[i] = start;
            }
        }
        return res;
    }

    public static void main(String[] args){
        String s="egg",t = "add";
        IsIsomorphic ii=new IsIsomorphic();
        System.out.print(ii.isIsomorphic(s,t));
    }
}
