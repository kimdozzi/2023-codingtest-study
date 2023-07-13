from math import factorial, sqrt
from itertools import permutations, combinations, accumulate
from bisect import bisect_left, bisect_right
from collections import defaultdict, deque, Counter
import sys
import heapq
si = sys.stdin.readline
sys.setrecursionlimit(10**6)
# mn, mx = float('inf'), float('-inf')


def bfs(a, b):
    q = deque([])
    q.append((a, 0))
    visited[a] = True
    while q:
        x, cnt = q.popleft()
        if x == b:
            return cnt
        for i in graph[x]:
            if not visited[i]:
                q.append((i, cnt+1))
                visited[i] = True
    return -1


a, b = map(int, si().split())
n, m = map(int, si().split())
visited = [False for _ in range(n + 1)]
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    u, v = map(int, si().split())
    if u == v:
        continue
    graph[u].append(v)
    graph[v].append(u)

flag = True
if a == b:
    print(0)
    exit(0)

print(bfs(a, b))
