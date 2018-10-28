package leetcodematch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumUniqueEmails {

    public int numUniqueEmails(String[] emails) {
        if(emails==null||emails.length==0){
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (String str:emails){
            String[] temp = str.split("@");
            int a = temp[0].length();
            a=temp[0].indexOf("+")==-1?a:temp[0].indexOf("+");
            temp[0] = temp[0].substring(0,a).replace(".","");
            set.add(temp[0]+"@"+temp[1]);
        }
        return set.size();
    }

    public static void main(String[] args){
        NumUniqueEmails nue = new NumUniqueEmails();
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.print(nue.numUniqueEmails(emails));
    }
}
