package firststage.myhash;

public class NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }
        char[] ss = S.toCharArray();
        int num=0;
        for (char s:ss){
            if(J.indexOf(s)!=-1){
                num++;
            }
        }
        return num;
    }
}
