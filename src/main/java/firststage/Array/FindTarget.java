package firststage.Array;

public class FindTarget {

    public int[] twoSum(int[] numbers, int target) {
        int bindex = 0;
        int eindex = numbers.length - 1;
        int sum = 0;
        while (eindex > bindex) {
            sum = numbers[bindex] + numbers[eindex];
            if(sum == target ){
                break;
            }
            if (sum > target) {
                eindex--;
            }
            if (sum < target) {
                bindex++;
            }
        }
        int[] res = {bindex + 1, eindex + 1};
        return res;
    }

    public static void main(String[] args) {
        FindTarget ft = new FindTarget();
        int[] numbers = {0, 0, 3, 4};
        int target = 0;
        ft.twoSum(numbers,target);
    }
}
