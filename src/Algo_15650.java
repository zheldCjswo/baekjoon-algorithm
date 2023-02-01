import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_15650 {
    public static int N;
    public static int M;
    public static int RET[];
    public static boolean CHK[];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("test_case/15650.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        RET = new int[M];
        CHK = new boolean[N+1];
        dfs(0, 1);

       /* 4 2

        1 2
        1 3
        1 4
        2 3
        2 4
        3 4*/
    }

    private static void dfs(int depth, int start) {
        if(depth == M){
            for (int i = 0; i < M; i++) {
                System.out.print(RET[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            if(!CHK[i]){
                CHK[i] = true;
                RET[depth] = i;
                dfs(depth + 1, i + 1);
                CHK[i] = false;
            }
        }
    }
}
