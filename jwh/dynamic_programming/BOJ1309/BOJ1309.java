package jwh.dynamic_programming.BOJ1309;

import java.io.*;
import java.util.*;

class BOJ1309 {
    static int n;
    static long dp[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        dp = new long[n + 1];
        dp[0] = 3;
        dp[1] = 7;

        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9901;
        } // 값이 long을 벗어나기때문에, 미리 9901을 나누어줍시다.

        if (n == 1) {
            System.out.println(dp[0]);
        } else {
            System.out.println(dp[n - 1]);
        }

        br.close();
    }

}