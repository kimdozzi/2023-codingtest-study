from math import factorial, sqrt
from itertools import permutations, combinations, accumulate
from bisect import bisect_left, bisect_right
from collections import defaultdict, deque, Counter
import sys
import heapq
si = sys.stdin.readline
sys.setrecursionlimit(10**6)
mn, mx = float('inf'), float('-inf')

x = int(si())
dp = [[0 for _ in range(3)] for _ in range(x)]
dp[0][0] = 1
dp[0][1] = 1
dp[0][2] = 1
for n in range(1, x):
    dp[n][0] = (dp[n-1][0] + dp[n-1][1] + dp[n-1][2]) % 9901
    dp[n][1] = (dp[n-1][0] + dp[n-1][2]) % 9901
    dp[n][2] = (dp[n-1][0] + dp[n-1][1]) % 9901
print(sum(dp[x-1]) % 9901)
