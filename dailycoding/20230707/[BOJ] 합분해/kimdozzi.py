from math import factorial, sqrt
from itertools import permutations, combinations, accumulate
from bisect import bisect_left, bisect_right
from collections import defaultdict, deque, Counter
import sys
import heapq
si = sys.stdin.readline
sys.setrecursionlimit(10**6)
mn, mx = float('inf'), float('-inf')


def backtrack(depth):
    if depth == k:
        if sum(lst) == n:
            # print(lst)
            global cnt
            cnt += 1
        return

    for i in range(n+1):
        # if not visited[i] :
        # visited[i] = True
        lst.append(i)
        backtrack(depth+1)
        # visited[i] = False
        lst.pop()


n, k = map(int, si().split())
visited = [False for _ in range(n+1)]
cnt = 0
lst = []
backtrack(0)
print(cnt % 1_000_000_000)
