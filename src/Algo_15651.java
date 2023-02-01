import java.io.*;
import java.util.StringTokenizer;

public class Algo_15651 {
    public static int N;
    public static int M;
    public static int RET[];
    public static boolean CHK[];

    public static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("test_case/15651.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        RET = new int[M];
        CHK = new boolean[N+1];
        dfs(0);

        bw.flush();
        bw.close();
        br.close();
        /* 4 2

        1 1
        1 2
        1 3
        1 4
        2 1
        2 2
        2 3
        2 4
        3 1
        3 2
        3 3
        3 4
        4 1
        4 2
        4 3
        4 4*/
    }

    private static void dfs(int depth) throws IOException {
        if(depth == M){
            for (int i = 0; i < M; i++) {
                bw.write(Integer.toString(RET[i]));
                bw.write(" ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= N; i++) {
            RET[depth] = i;
            dfs(depth + 1);
        }
    }
}
