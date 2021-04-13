package secondstage;

/**
 * @author mingjiexian
 * @date 2021-04-12 17:32
 */
public class DFS {

    private int[] a = new int[10];
    private int[] books = new int[10];

    private int total = 0;

    public void dfs(int step){
        if(step == 10){
            int one = a[1] * 100 + a[2] * 10 + a[3];
            int two = a[4] * 100 + a[5] * 10 + a[6];
            int three = a[7] * 100 + a[8] * 10 + a[9];
            if(one + two == three){
                total++;
                System.out.println(one + "+" + two + "=" + three);
            }
            return;
        }
        for (int i = 1; i < 10; i++) {
            if(books[i] == 0){
                a[step] = i;
                books[i] = 1;
                dfs(step + 1);
                books[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
        dfs.dfs(1);
    }

}
