from math import factorial, sqrt
from itertools import permutations, combinations, accumulate
from bisect import bisect_left, bisect_right
from collections import defaultdict, deque, Counter
import sys
import heapq
si = sys.stdin.readline
sys.setrecursionlimit(10**6)
mn, mx = float('inf'), float('-inf')

dir = [[-1, -2], [-2, -1], [-2, 1], [-1, 2], [1, 2], [2, 1], [2, -1], [1, -2]]


def bfs(a, b):
    q = deque([])
    q.append([a, b, 0])
    visited[a][b] = True
    ans = 0
    while q:
        r, c, cnt = q.popleft()
        if r == tarX and c == tarY:
            ans = cnt
            break
        for i in range(8):
            nx = r + dir[i][0]
            ny = c + dir[i][1]
            if nx < 0 or nx >= x or ny < 0 or ny >= x:
                continue
            if visited[nx][ny]:
                continue
            q.append((nx, ny, cnt+1))
            visited[nx][ny] = True
    print(ans)


t = int(si())
for _ in range(t):
    x = int(si())
    grid = [[0 for _ in range(x)] for _ in range(x)]
    visited = [[False for _ in range(x)] for _ in range(x)]
    curX, curY = map(int, si().split())
    tarX, tarY = map(int, si().split())
    bfs(curX, curY)
