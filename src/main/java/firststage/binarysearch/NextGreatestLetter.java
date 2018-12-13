package firststage.binarysearch;

public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 1;
        int right = letters.length-1;
        if(target>=letters[right]){
            return letters[0];
        }
        while (left<right){
            int mid = left +(right - left)/2;
            if(letters[mid]>target){
                if(letters[mid-1]<=target){
                    return letters[mid];
                }
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return letters[right];
    }
}
