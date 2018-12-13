package firststage.leetcodematch;

/**
 * @ClassName RecentCounter
 * @Description TODO
 * @Author jxm
 * @Date 2018/11/4 9:34
 * @Version 1.0
 **/
public class RecentCounter {

    int[] pings;
    int count = 0;
    public RecentCounter() {
        pings = new int[100001];
    }

    public int ping(int t) {
        pings[count++] = t;
        int left = 0;
        int right = count;
        int time = t<3000?0:t-3000;
        while (left<right){
            int mid = left + (right - left)/2;
            if(pings[mid]<=time&&pings[mid+1]>=time){
                left = pings[mid]==time?mid:mid+1;
                break;
            }else if(pings[mid+1]<time&&mid+1<count){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return count - left;
    }

    public static void main(String[] args){
        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(2196));
        System.out.println(rc.ping(3938));
        System.out.println(rc.ping(4723));
        System.out.println(rc.ping(4775));
        System.out.println(rc.ping(5952));
        System.out.println(rc.ping(6001));
    }
}
