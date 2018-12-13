package firststage.binarysearch;

public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if(num==1){
            return true;
        }
        int left = 0;
        int right = num;
        while (left<=right){
            int mid = left + (right - left)/2;
            if(num%mid==0&&mid==num/mid){
                return true;
            }else if(mid>num/mid){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return false;
    }
}
