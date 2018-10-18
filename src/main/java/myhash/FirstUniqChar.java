package myhash;

/**
 * @author jiangliuhong
 * @since TODO
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        int[] c = new int[26];
        char[] cs = s.toCharArray();
        int db = Integer.MAX_VALUE;
        for (int i=0;i<cs.length;i++){
            if(c[cs[i]-'a']!=0){
                c[cs[i]-'a'] = db;
            }else {
                c[cs[i]-'a'] = i+1;
            }
        }
        int index = db;
        for (int _c:c){
            if (_c<db&&_c>0){
                index = Math.min(index,_c);
            }
        }
        return (index==db?-1:index-1);
    }
}
