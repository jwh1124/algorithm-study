3단계 이상 마실 수 없는건데, 최대 3단계 까지 마시는거로 봐서 시간이 오래 걸렸던 문제..실수

일단 dp를 2차원 배열로 만들어서, 0은 연속하지않은거, 1은 연속한거 마신거,2 내꺼 안마신거
3가지 상태를 저장해둔다.

이전 포도주를 마셨다면 1, 이전 포도주를 마시지 않고, 내 포도주를 마실거라면 0, 내 포도주를 안마신다면 2

해당 상태에 따라서,
0 일때는 다음 상태는 1 또는 2로 넘어갈 수 있고,
1 일떄는 2 로 넘어갈 수 있다.

해서
0인 상태를 최신화 하려면, i-2의 0,1,2 상태 중 최대를 최신화
1인 상태를 최신화 하려면, i-1의 0인 상태 + 현재의 포도주를 최신화
2인 상태를 최신화하려면, i-1의 0 1 2 상태 중 최대를 최신화

이렇게 진행했다.

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        if (N > 1) {
            dp[2] = arr[1] + arr[2];
        }
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }
        // 바로 이전 값이거나, 한칸 띄거나, 두칸 띄거나
        System.out.println(dp[N]);
    }

}
```

이런 방법도 있어서 새로 공유한다..
