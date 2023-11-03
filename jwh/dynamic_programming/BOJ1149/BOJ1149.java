package jwh.dynamic_programming.BOJ1149;

import java.io.*;
import java.util.*;

class BOJ1149 {
    static int n;
    static int min = Integer.MAX_VALUE;
    static int map[][];
    static int dp[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][3];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = map[0][0];
        dp[0][1] = map[0][1];
        dp[0][2] = map[0][2]; // dp에도 기본 데이터 주입

        for (int i = 1; i < n; i++) { // 행 이동
            int tmp = 0;
            for (int j = 0; j < 3; j++) { // rgb 선택
                boolean visit[] = new boolean[3];
                visit[j] = true;
                for (int k = 0; k < 3; k++) { // 다음칸 rgb 선택
                    if (!visit[k]) {
                        if (dp[i][k] == 0) {
                            dp[i][k] = map[i][k] + dp[i - 1][j];
                        } else {
                            dp[i][k] = Math.min(map[i][k] + dp[i - 1][j], dp[i][k]); // 최솟값 비교
                        }

                    }
                }
                visit[j] = false;
            }

        }

        for (int i = 0; i < 3; i++) {
            min = Math.min(dp[n - 1][i], min);
        }
        System.out.println(min);
        br.close();
    }

}