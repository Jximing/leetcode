package myhash;

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

    public static void main(String[] args){
        String s="egg",t = "add";
        IsIsomorphic ii=new IsIsomorphic();
        System.out.print(ii.isIsomorphic(s,t));
    }
}
