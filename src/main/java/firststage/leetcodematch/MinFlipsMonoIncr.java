package firststage.leetcodematch;

public class MinFlipsMonoIncr {

    public int minFlipsMonoIncr(String S) {
        char[] arr = S.toCharArray();
        int count = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                while (arr[i] == arr[i - 1] && i < arr.length - 1) {
                    i++;
                }
            }
            count = Math.min(count, reverse(arr, i));
        }
        return count;
    }

    private int reverse(char[] arr, int index) {
        int count = 0;
        for (int j = 0; j < arr.length; j++) {
            if (j < index && arr[j] == '1') {
                count++;
            } else if (j > index && arr[j] == '0') {
                count++;
            }
        }
        return count;
    }

    public int minFlipsMonoIncr1(String S) {
        int zeros = 0;
        int ones = 0;
        int res = 0;
        for(int loop = 0; loop < S.length(); loop++){
            if(S.charAt(loop) == '0') zeros++;
            if(S.charAt(loop) == '1') ones++;
        }
        int start = 0;
        int end = S.length() - 1;
        while(end > start){
            if(ones >= zeros){
                if(S.charAt(end) == '1') ones--;
                if(S.charAt(end) == '0'){
                    zeros--;
                    res++;
                }
                end--;
            }else{
                if(S.charAt(start) == '0') zeros--;
                if(S.charAt(start) == '1'){
                    ones--;
                    res++;
                }
                start++;
            }
        }
        return res;
    }

    public int minFlipsMonoIncr2(String S) {
        char[] A = S.toCharArray();
        int n = A.length;
        int[] one = new int[n + 1];
        int[] zero = new int[n + 1];

        zero[0] = one[0] = 0;

        int i;
        for (i = 1; i <= n; i++) {
            //满足递增的最小次数(one[i-1]>zero[i-1]时代表之前应该全是0)
            one[i] = A[i - 1] == '1' ? Math.min(one[i - 1], zero[i - 1]) :
                    Math.min(one[i - 1], zero[i - 1]) + 1;
            //计算将前i之前的全变成0需要的次数
            zero[i] = A[i - 1] == '0' ? zero[i - 1] : zero[i - 1] + 1;
        }
        return Math.min(zero[n], one[n]);
    }
    public static void main(String[] args) {
        MinFlipsMonoIncr mfm = new MinFlipsMonoIncr();
        String S
            = "00110011000100111110001110011111001100001101011111111111011010110111101011001010000011110110110110101010000001011110101110010101010010010110101101110000000100100101011000010101001110000101001010000011100110100000010001100011110100010101011011000101010011111010111001111100111111100000110010110111000001010111011100100011001111000010001111100000000010110000100100100010001011110111110000111000011011111110111111010001101011110100100101101110011010001000011011000110110101111000001110111001000011100110010010010100111110011101000010111110000100011010111101101000101101001111111111010111000011100101110100010001110110110001001001110010110010111010100110001100101100100011011101110010000110011110101001011000111111101110011100110110111010101110111110001110110101111011111101010000001100111001000100010100101011100001100011010010011101010101111100011111011111110001100010000000001010001101100011111011000100100000101010010111110001111010001110001101100010100101110110000101001010011110101111111110111111101101100000001101001101010101101110000011110010100100010001011011101111000111011011010110001101011011011001111001100100001001010011011010010001001010101010110000011000000100111110110010111110101111001011111101110011000101001111001000101100011100101111111111110110010011110010101001011010100001110101000000000110111111000010111000111010101000010000011100000100010001111011001101010000000100001001100010101001100010111101111001000101011001111111001010011001011011000011111011001111001011111111101010010100111111011101001011110010001100110010001000100100011010011011010100011111111101100000010110001101101011100101110010001000010100110100000110110011000011110101111111111110001011100001111100100001010011110000111101101010010111111000010010111101111110101010000001101010101100100001100110011001011111001011101000001101000000010000000000010100011111111011010010110000000100110010001101000000001110100100111110010000111000001011111000011001001110011111110110101110111010010100010000010100101101000101110001111001100011000011001001000101101101011111000001001001100101001101011110111101010110011101010011110010100000100010100111011110010100011101100110100000100010111010011011101000011101111100000001010010111110000111101001110000011001110000010010010101100101111111100100000000001101011001000011100010000000110110000011100010010110110011101000100100000100001111101011011000110101010101111000110001010110001111001010111110110110100010100001000110010110100000000001111010010001101010100101010100111101110100000010010011011101101011100000100101000011010001111100010101110101000011010011011110101011000101011001110100000100010110001010011000000001011101100111101011100111110100111110110010010000001010110001101010000110110101010101001000011110100011011001110001111101110010100010101000011011010110000011101000101000001011010001110111011011110111010111110010100000011001000110001000111011000110010001000111111010001101100001010001000111100011100100001101000101001000110001010111001011000001011011111000100111000101011001010010000010100111110000001110001101011100011010010111011000101110110111000001110101100101100101011100001111001111110010101011110001000100111111011101010000010111101010111010110000110011101101000101010100011010011011001011110110100100010001100011001100000111010111010110010011111100001110100101110010001111101010100101110110110100111000110101000111000110010010001000110110110011111100110100000101010000010000001011001000100100000100010011110101111100000100001000110101011000111010111000001000110011110110010010110011101111111011110110111100110101001011111100100100000001000001000001011011100110000000111010011001101100010110111110011000000010001000001001101111111010100100100011011110100011010011001110011101001101100110010000011011111000101100111111101011010110001110100101011000100011111011110011011100011000011001000010110110111110110100001000001100110011101111001001111100111000010010100000111000101100111011011011011001001101111111100100011100101111111111100000110000001100110100010111101000110110100000010011100000110100110011100001101011010111100011010001011101100001101100110100100101100010001000111100101100111011010101011101110101001110110100010100010010011101011100001101010111111100111101110100011010111001110111111011111111100111000111100110000000101101010010101101001111000111110100011010101011101101110001111111111111100110101100101101000111011011010010110000000111000010101000010011011001111111111101011011100111010011001110110101100011101001100010000000000110101111110000110110101111001111100010010101111101000010001010000010010010011110001010111001110110000110110010010011110100101011010101001010001100000100001110111000001000011001110111100001011110110010010000010101000111000110100001101000100010110011110101001111010101111100010101011010001011011011001000000111110000000111111001100100000000010001011101000001001000010110010110100100101101100010010101000111010111101000011111011000110010011001001101100001110010110101110100110100011000101001100010101000000110100100110000110110101010001001101010111100110001101010000110011100000101010101100001010011010011011100011001010000001110011001101110110000011001010111101011011101111100100010011001010001101111010001001100101001000100011001010100001000000110011001000000100111101101010010010100010001011001010100111111000110011111110101100010011101000111010110110011110011101010011001101000001111000000111010001110111110010100000110011001101010011110101000100010101101000101111100100100111111100100001101001001001001011101100111100110000110000011110110100100110100111011111000101110010100100001100000100000110100100101011110001111101011101011101110100010001000110011111001001000101001110010001001011000001110011000000010111100111101100010001010100001010101110000000000100101100101110101101001101001000111000100111011100010110110110011001011001101010001011100000110000001000011001010000000011001111110110110011101001110110010100100100111011100100100001111010010001011010100011000110001110111100011000001000011011001110111010000000001001010000010001111100111101010110000100111011110000001000000111110011011101010101011101011110110010011010000100100101001100101011110100110110111010001111010111100110111011010001001111101011010111011101110100111001100011000001000010110001000111011100010001010100001101000000011001000000100010011101111101110101001001111101010011100110000100001100111001001011110000100100100011111010000101000010110100101100100010110110100000111000111101111110001000110110111011101001110100100100100111001010001001110011100011011000101011010001101001110111110011001101110100110000011101101001001010001011110010011000001101011010001001010011011111010110000010111111110011101011111100100011111111011101111011101111000011111010100001111011100011111010011100100101111000110011100000101000010101100101000000100000101011110101001001100011000001010000010010110010011111011111011111000000000010101110011111010011000110101111101100001000100101011111110111000001000000110100000001110011011101000100000111001100001011010111010111010000101010011010001110110000101100011100101111111010000110010000000111001110001001000100101000000100111101101101110000100011011110100001011100001101111110101100011111110110010001101001010110110101111100001101001001111101001011111101001000101011111111000001000000101111101111100110000000111110001000011000111001001100011111100110011010001110111010010001001101110000000110100010010000111111110011011101000000100111001101100011100010011101001111110101000111010111000100001010110001010001001110101101010010001100110100011001110110110011000000000010001011101100110111000011010110111110101110100011101101101000001001110011000111111001100101010011010000100010001101100000111000101010010101110011001110110110101000111011000000001101010010101010011011110000000010001101100100101101010000011100001110010101111001001110000010011001101111010000111011011111110000111000101001011011010001111001010001000101100001101001111111110100101010010111111000010110010011000111111101110001101001010000100100010001101100101110110011101111101001010010100010110011011101111001010101111110101000011111111011111000111111011011111010100000010000100100011000000110110111001000101010110111010100000111110010100100000010110000101010101110111110011100000001000101011100001101110011000001111000100101000101101010001101010111001100100110100000110100101000110000100111100100011000001101100001000110010100011100100001010101000101110001101100110010101001011101111010001001001101100110011111001000100000001011010001101110001011111111000101101010001111101101011000000010010110110101100111110011101011110101110101011000001110001001001111000011010111001100011111000110111010011011010010010000011010000011011010000000000011111001111000010001100101100010101100111010001110001100110101011001101000110010000110011000000100111110111011110101110011110010010001111101000110110000110011110101110011010001010011010000011100100110100000101010100101110101110000001000100000000001010000011000011111111110101000011111001110010000011011001111111100001001000101111111101011100001001001100110101010010001110001011110011010000011011000011111011001011011001011110001011000001000111101001111110010001110011111111100010110011110100110000110101101100011110000100101000001101111110010110010011001001011011101000100011111110111011100011101011010100000011110000110110111100000001001010011101010101111101011110100010100011101111100110111010111011010110000010011100110010000011110001111001000110100101110110110011110110100110011100111011100001000000000001000011111110011000010000000001011010010011001010001100001111101000110010001001101110001111010001101010101100000000001010110000010110011111110001010010100111000111010101100010110010011010101110101110101111010001011010000010100111110000100100011000110010001001011001001010011100101110111101010000011111110010011100011001101001011100111110101000010101011101011000110100000110011010111100011101000111001111010111100111100110101110001001010000100010100100100011000100010110100001101001100110111100011011100011111010000001011101111001011100001001001100001100111101110101110011010001111101111011011010000101010101010001001000010011101010101111110010111010000010000000111000100111001111010010001010011100001001110000001111101100111010000101011001101001000001100111110111100011101011000010110101110110111001010000001100100111001010110011010000100110100001101001100101011101100110110000011100111001110111001110110011100110110001010111010100110111010111110110000000010011110100010011110010001000111000111001100111010010001100110110001100000111000111010010111011101111000001101101101111001000101111000011010101101011011011110110111000101101111010000111010100110001100100101010011001011011001011000001101100111000100011100101100001111101000010101000011101110101001100011100010010011010010011101001001001110010000010001110010000100010000010101101100100111111110000101100000110011010110111101100111111100011110010000101010110001100110101111111001011011101000110110100001101011100001101001001011000111101000100110001111010101100011101110100110100100010011010000101100100100100101101001000001000010010110101110010001111110000010111011101101000001010101111000111100001010010111011110110101111110010000001000011000100010110111101100010100001010000101000111110001011100101010100110100001001010011110101000101101001110100011110011111010000100001001000101100011100101100100001100110011000100010011010101000000110101110101101101001101100010101011000110001000111101101010000011000110111111101001101100111101000001111011011011011111010101111000000100011110010100101101001110011111110101110100010011011100010000100110101110000000111100010000001111101010011110011010010101111011001011110010110100110010101001110110101000101111100010011100010000110100010001011111111000001001001000010000100001111101100011100011101001001011110011001100011010101100111010100110111110110000111001100001000110101011110010111001111101000001111110000010101011101001001010000101010000111010100110101110000011011001011100100011110110100000001110011111101010001111100001001010001101011011010000110011001111010010011100000010001010101000110001010111000000110010001010110111100011110011100101100000000010011000001011001000010111000100100111100011011010100000010001011101101010101101101000010101100110111100011000100000100011110011001111111001000101100001000011000100100111011110010111111010000101000011100010111001110011110101110111000000100010000010100100011011001011100110101110011111000100001000010001010010110101110101001101111101001101011010001001010111110011111101001100010001111111100001111100101001011001100011001001011000000111110110010001100111000011101000001100100101011111010110101010010110011101101111111101101110001110001101110110000101111000100100010000110010010010011101000100000011011110111011101111110111011100000111101001101000101001011010110101101101011100111000111101111101111110010010110000010001010011111100101010010101000101000011000110000000110110010101010110100000111000010011011100011100001001000101111101001101001001111000110100001101100100110000011100001001011010100000010000110010001101110010100100110010111111101001000010111011010110000110101101110010111001000000100011110011010010010001000011101100000101011110110101010010011011010010111011101000010010010001110101101100110100110110101011101010011100010010100000011001110101001010010011001011000100100000101100101100011111000011011011100111110001011001100011001111010011011111001001000110000011001110100000011110011101100110111111000111000011110111001010001001111011010111000100001000011010001011001001100001101110111000010001110001101010111000011100110100110100000101000001011010000011101101100100100111001110100111100011011110110101100001100111110110110100010000010011101011111010000000111111111101011111101011000010001001011111110101100000100111110001110001010000110101010001011011011000110101100111010001100001001010110010000001100111110110101001100011111110000000111010011011011000111001100000010111001010001010011101011111111101001111010110001100011100010001101100111000110100011101011010010000000111100111000110110011110101001110010100011110000110001110101001101101101000111000011011001111100101001001011100100000000110111001010110010011011010101010101011110001100110100000110110110001001000000110000110010101001000111011100111011001010001100010010101111100100111111011101110000101111110000011110100001110100101010010000000010101100100011010100010011101001100011111100001000011000010000101000110011110000111100111010000111000010010010100111101000100010010111011001100111110010000011010010011110001000000000001001001111000010100101101001111100101100101001110101011100101111000011000010010110010011101000110001001100100100110110001010101000001110100010000101001101110111111111011001001100000010100100011100001001111011111101111000101101000000000101010101100000010100010110110111100000110001001111100110011011100101011001111110111001001010011010000001101100010001011010001000000011110010011110111001100001010011101001100001101000010001110011101010110110110100100101101000010100000011010100101011101001010001001110010000110100001100100000000111111000010001101101100110110010110111100111111001101001111000010110010101100010110001000111001001101110101010000010110001111101101000110110010010011101111111111010010110101010110101011000101110011010111011001000001110001010001001000101100010001001011011110011011101110011110110111101001100010111111011000010100100111001101011101011100010101101001011011011100101101101111001100001010000001001100101101010111001010001111011110101010001010010100101010010001101100101111100100101111001010000001110011000100111101101111001010111000100101110111010001000100101100101011010010000001011011101101010101011101001100110010101001010111011111100001111100011111111100011111001101100001100010111000001011110110101101100000100100011101011100000100010011001101101111101011001001000100101111010000000000001010101100011000010100100001000010010001111100110000111010111100101110001011010001111100101101011110111101101111010100001001001000111010010001100100111010010011101111101011010001000010101101001101110101110101110101001010010111010001100101001011001111111101011001001010110110100000010010111000010100101110100010011001110010001011000111100000101010101010111100011101000011101011110111111011100001100000011110001001011001110001100010100101111110001000011001010001110110111011010010111010010011111101110111101010010110011110111010100101000111110110111011010110101001100000001001001111010001101100110001000111001100010010111101100111011001010010011111111010110011010101110111011100001010001100000110110001100001011110111100101000110100001100000011101101100110101101011001101000110010000001001000101100000011011010101010101000100111011111110010110111000100111011000001101000111100110001111111010101000010111001000110100000111000011110011010011100100111101110000110000110000100010010101100101110101010000100000001011000001010101111010011000111000010011010000101011010011111101011010010101011010110111011010110000011011111100011110100110100010110110000101011100001001011111101011101100101001110001001111110100000100001110010001001111101011011001010110101101110101110000000110001010110100000110100000111010110110011010101110101011101010000001001011001101110100110011111001001101100100111010110001001001101011101001001110010101101110000001111111000010100000010011001101110100001000001111110010100001111111110100001110000101100100000000010001010110011011000110111010001001001000000010100111111000010111110001000100110000011111011001111001011110101000101100111001010011110110011011110001110101111010000100101010011111110010010011101000011110111010101100001100110100111111111010000001000101101100011001101111001101110111011111110111000000101110111100110101100111111101101010101101000010100111000111101011011001100101010010000100101100100110100100101101011010010001011000101011111010100111011011010010110110001101011100111010010100010001011100110111001100100010100011010111011001110101101001001111111101110011110111101011011000110001001010000101111111000110111011011101010001100011011101111111101001010001011101111100001101010100111011110011001001110001000101010000110000010000111010101100110010100011011010000101001010001000111101110100001101001000101110111100011001001010000010011100001010011000001101011000111111011100111111010101101010101101000011010000010100101010010011010111110100010100110001111100011110110110001001001011101001000000100001110000101101011000111110111100000000101100001111000001011001110100111001001111000110011001001011000011001100001001010111000111101110111101011110010101110010001011010000101000010100000100101010000000110110100100101011100111011001111100100100010000000001110101101110011111111000110011010101000010011111000101001110000000101011110010001001101010101101110000101010010100010011000100110110110111001110111100000101000101100001001101101110110101110011000000001010011011111111110011010001000100000111000000001000011101011111101001100001110101011011010001110001010011100111101100010001111010101100001101010001010110011001001000101000001101101000111011011100101101011101001100000111100100110011010110101100001101000000100111110110011011101011101101010001001011010100001101110111000010100111110010000010010011101101000110011101000100010000011110110011000111111111111101100010010100110001001011000111001100100101100010100111000110001001100011110000101000000011010110000100111110011101001001010010100111000100101101110011000110100000010101111000111110001010101001111100111110000010110000011011000001110111100010001011110001111101000111011100011100111100110100001001100000010011111110011101011011000010111100010100101010111001010101100001001010000011011111111111011000111100000001010000101010111101011000100110010111010010011101100110100101011001111101100000110001110000010100111111010101011001101011110111000100100111001111001100011110110010110101000111100000110110011011001110100101001101001111110111000101101111001011110000011100001101010110100110101010101001101001001110111100010111001110100101110010010111100001000101011111011011";
        System.out.println(mfm.minFlipsMonoIncr(S));
        String S1 = "00001110000";
        long start = System.currentTimeMillis();
        mfm.minFlipsMonoIncr(S);
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        start = System.currentTimeMillis();
        mfm.minFlipsMonoIncr1(S);
        end=System.currentTimeMillis();
        System.out.println(end-start);

        start = System.currentTimeMillis();
        mfm.minFlipsMonoIncr2(S);
        end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}