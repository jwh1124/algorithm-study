package jwh.dynamic_programming.BOJ11057;

import java.io.*;
import java.util.*;

class BOJ11057 {
    static int n;
    static long dp[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        dp = new long[n + 1][11];
        for (int i = 10; i >= 1; i--) {
            dp[0][i] = i;
        }

        long tmp = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 10; j >= 1; j--) {
                for (int k = j; k >= 1; k--) {
                    dp[i][j] += dp[i - 1][k];
                }
                dp[i][j] %= 10007;
            }
        }

        if (n == 1) {
            System.out.println(dp[0][10]);
        } else {
            System.out.println(dp[n - 1][10]);
        }

        br.close();
    }

}