import sys, heapq
si = sys.stdin.readline
sys.setrecursionlimit(10**6)
from collections import defaultdict, deque, Counter
from bisect import bisect_left, bisect_right
from math import factorial,sqrt
from itertools import permutations, combinations, accumulate
mn, mx = float('inf'), float('-inf')

t=int(si())


def dfs(start,flag):
    # 현재 정점을 flag(1)로 표시
    visited[start] = flag

    # 해당 정점과 인접한 정점을 순회
    for x in graph[start] :

        # 방문한 적이 없다면
        if visited[x] == 0 :

            # flag(-1 = 처음에 정한 1과 다른 팀) 표시변경 후 순회
            res = dfs(x,-flag)

            # 아래의 else를 통해 false를 반환받았다면 NO
            if not res : return False

        # 방문한 적이 있고
        else :
            # 현재 팀과 같은 팀이라면
            if visited[x] == flag :
                # NO
                return False

    # 모든 순회가 끝나면
    return True


for _ in range(t) :
    v,e=map(int,si().split())
    graph = [[] for _ in range(v+1)]
    visited = [0 for _ in range(v+1)]
    for i in range(e) :
        edge, node = map(int,si().split())
        graph[edge].append(node)
        graph[node].append(edge)
    for i in range(1,v+1) :
        if visited[i] == 0 :
            ans = dfs(i,1)
            if not ans : break
    print("YES") if ans else print("NO")

