package firststage.binarysearch;
 class GuessGame {
    int guess(int num){
        return 0;
    }
}

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

 class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 0;
        int end = n;
        int mid = 0;
        while (start<=end){
            mid = (start+end)/2;
            int guess = guess(mid);
            if(guess==0){
                return mid;
            }else if (guess==1){
                start = mid+1;
            }else {
                end = mid - 1;
            }
        }
        return mid;
    }

    public int guessNumber1(int n) {
        int i = 0, j = n;
        while(i <= j) {
            //不能写成（i+j）/2因为有可能溢出造成死循环
            int mid = i + (j - i) / 2;
            if(guess(mid) == 0) {
                return mid;
            } else if(guess(mid) == 1) {
                i = mid + 1;
            } else {
                j = mid-1;
            }
        }
        return i;
    }
}