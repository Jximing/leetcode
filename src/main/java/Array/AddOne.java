package Array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddOne {

    public int[] plusOne(int[] digits) {
        boolean sign = true;
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if(sign){
                if (digits[i] == 9) {
                    sign = true;
                    digits[i] = 0;
                } else {
                    sign = false;
                    digits[i] +=1;
                }
            }
        }

        if(sign){
            int [ ] copy = new int[length+1];
            System.arraycopy(digits,0,copy,1,length);
            digits = copy;
            digits[0] = 1;
        }
        return digits;
    }

    public static void main(String[] args) {
        AddOne ao = new AddOne();
        int[] digits = {9};
//        int[] digits = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Arrays.stream(ao.plusOne(digits)).boxed().collect(Collectors.toList()).forEach(System.out::println);
    }
}
