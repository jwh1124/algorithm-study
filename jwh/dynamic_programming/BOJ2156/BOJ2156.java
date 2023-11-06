package jwh.dynamic_programming.BOJ2156;

import java.io.*;
import java.util.*;

class BOJ2156 {

    static int n = 0;
    static int[] grape;
    static int[][] dp;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        grape = new int[n];
        dp = new int[n][3]; // dp를 2차원 배열로 만들어서, 0은 연속하지않은거, 1은 연속한거 마신거로 표기,2 내꺼 안마신거

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            grape[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = grape[0]; // 첫번쨰꺼 먹은거
        if (n > 1) {
            dp[1][0] = grape[1]; // 2번째꺼만 먹은거
            dp[1][1] = dp[0][0] + grape[1]; // 1,2번째꺼를 먹어서 dp[2]에 참조될 수 없음.
            dp[1][2] = dp[0][0]; // 2번쨰꺼 안먹기
        }

        for (int i = 2; i < n; i++) {
            int tmp = 0;
            dp[i][0] = Math.max(dp[i - 2][1] + grape[i], Math.max(dp[i - 2][0] + grape[i], dp[i - 2][2] + grape[i]));
            // 바로 전이 참조될 수 없는 상태이므로 2단계 전
            dp[i][1] = dp[i - 1][0] + grape[i]; // 바로 전이 참조 될 수 있는 상태이므로 한단계 전(대신 0스택인경우만)
            dp[i][2] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
            tmp = Math.max(dp[i][0], Math.max(dp[i][1], dp[i][2]));
            max = Math.max(tmp, max);
        }

        if (n == 1) {
            System.out.println(grape[0]);
        } else if (n == 2) {
            System.out.println(dp[1][1]);
        } else {
            System.out.println(max);
        }

        br.close();
    }

}