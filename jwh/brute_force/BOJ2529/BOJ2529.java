package jwh.brute_force.BOJ2529;

import java.io.*;
import java.util.*;

class BOJ2529 {
    static int k;
    static long tmp = 0;
    static String[] s;
    static long min = Long.MAX_VALUE;
    static long max = 0;
    static boolean[] visit;
    static List<Long> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        s = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            s[i] = st.nextToken();
        }

        for (long i = 0; i < 10; i++) {
            visit = new boolean[10];
            list = new ArrayList<>();
            visit[(int) i] = true;
            list.add(i);
            dfs(i, 0);
            visit[(int) i] = false;
            list.remove(list.size() - 1);
        }

        System.out.println(max);

        long[] min_r = new long[2];
        long pow = (long) Math.pow(10, k);
        if (min < pow) { // 앞에 0이 나올때는 이렇게 출력해야함
            min_r[0] = 0;
            min_r[1] = min;
            for (int i = 0; i < 2; i++) {
                System.out.print(min_r[i]);
            }
        } else {
            System.out.println(min);
        }

        br.close();
    }

    static void check() { // 0도 생각해야함.
        tmp = 0;
        double size = list.size();
        for (int i = 0; i < size; i++) { // 자릿수 분배
            long pow = (long) Math.pow(10, size - 1 - i);
            tmp += list.get(i) * pow;
        }
        max = Math.max(max, tmp);
        min = Math.min(min, tmp);
    }

    static void dfs(long idx, int dep) { // dfs 돌면서 dep를 통해 자릿수 채워지나 보고, list에 저장해둠.

        if (dep == k) {
            check();
            return;
        }

        for (long i = 0; i < 10; i++) {
            if (!visit[(int) i]) {
                if (s[dep].equals("<")) {
                    if (idx < i) {
                        visit[(int) i] = true;
                        list.add(i);
                        dfs(i, dep + 1);
                        visit[(int) i] = false;
                        list.remove(list.size() - 1);
                    } else {
                        continue;
                    }
                }
                if (s[dep].equals(">")) {
                    if (idx > i) {
                        visit[(int) i] = true;
                        list.add(i);
                        dfs(i, dep + 1);
                        visit[(int) i] = false;
                        list.remove(list.size() - 1);
                    } else {
                        continue;
                    }
                }

            }
        }
    }
}