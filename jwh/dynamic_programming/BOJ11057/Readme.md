1 - 10개
2 - 55개
3 - 220개

1은 0~9까지의 수의 갯수
2는 0~9까지 더한거
3은 0~1,0~2 ... 0~9 까지 다 더한거
4는 또 위에꺼의 더한거

1 - 0 1 2 3 4 5 6
2 - 0+1+2+3+4..
3 - 0+1+2+3+4+5+6+&+9 + 0+1+2+3+4+5+6+7+8 + 0+1+2+3+4+5+6
10
9
8
7
6
5
4
3
2
1
dp[i]

55 - 10
45 - 9
36 - 8
28 - 7
21 - 6
15 - 5
10 -4
6 - 3
3 -2
1 -1
0
dp[i+1] - dp[i]
220 - 55
165 - 45
120 - 36
84 - 28
56 - 21
35 - 15
20 - 10
10 - 6
4 - 3
1 -1
0
