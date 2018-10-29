package binarysearch;

public class FirstBadVersion  extends VersionControl{
    public int firstBadVersion(int n) {
        int left = 0, right = n;
        while (left<right){
            int mid = left + (right - left)/2;
            boolean flag = isBadVersion(mid);
            if (flag){
                right  = mid;
            }else {
                left = mid + 1;
            }
        }
        if(left==right&&isBadVersion(left)){
            return left;
        }
        return -1;
    }
}

class VersionControl{
    boolean isBadVersion(int n){
        return false;
    }
}