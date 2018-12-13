package firststage.Array;

public class ArrayPairSum {

    //先排序再隔一个取一个
    public int arrayPairSum(int[] nums) {
        for (int i =1;i<nums.length;i++){
            int numi = nums[i];
            int j;
            for (j =i-1;j>=0&&nums[j]>numi;j--){
                nums[j+1]=nums[j];
            }
            nums[j+1]=numi;
        }
        int sum = 0;
        for (int j=0;j<nums.length;j+=2){
            sum+=nums[j];
        }
        return sum;
    }


    //更好的做法
    public int arrayPairSum1(int[] nums) {
        int[] bucket = new int[20001];
        //将nums中的数字+10000转换为bucket的下标
        for(int i=0;i<nums.length;i++){
            bucket[nums[i]+10000]++;
        }
        int sum=0;
        boolean b =true;
        //从小到达遍历
        for(int i=0;i<20001;i++){
            while(bucket[i]>0){
                if(b){
                    sum+=i-10000;
                }
                //隔一个加一个
                b = !b;
                bucket[i]--;
            }
        }
        return sum;

        // Arrays.sort(nums);
        // int sum =0;
        // for(int i=0;i<nums.length;i+=2){
        //     sum+=nums[i];
        // }
        // return sum;
    }

    public static void main(String[] args){
        ArrayPairSum aps = new ArrayPairSum();
//        int[ ] sums = {1,2,5,4,8,7,6};
        int[ ] sums = {9,8,7,6,5,4,3,2,1,0};
        System.out.println(aps.arrayPairSum(sums));
        System.out.println(aps.arrayPairSum1(sums));
    }

}
