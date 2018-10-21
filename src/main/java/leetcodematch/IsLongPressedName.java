package leetcodematch;

public class IsLongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null || name.length() > typed.length()) {
            return false;
        }
        if(name.equals(typed)){
            return true;
        }
        if (name.length() == 1) {
            for (int j = 0; j < typed.length(); j++) {
                if (typed.charAt(j) != name.charAt(0)) {
                    return false;
                }
            }
        }
        int j = 0,i=1;
        for (; i < name.length(); i++) {
            if(j==typed.length()){
                return false;
            }
            char temp = name.charAt(i - 1);
            if(name.charAt(i)==temp){
                if(typed.charAt(j)!=temp){
                    return false;
                }
                j++;
                continue;
            }
            for (; j < typed.length(); j++) {
                if (typed.charAt(j) != temp) {
                    if(typed.charAt(j)!=name.charAt(i)||j==0){
                        return false;
                    }else {
                        j++;
                        break;
                    }
                }
            }
        }
        if(name.length()-i>typed.length()-j){
            return false;
        }
        if(name.charAt(i-1)!=typed.charAt(j-1)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsLongPressedName ilpn = new IsLongPressedName();
        String name = "kikcxmvzi", typed = "kiikcxxmmvvzz";
        System.out.print(ilpn.isLongPressedName(name, typed));

    }
}
