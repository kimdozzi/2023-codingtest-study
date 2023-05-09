import sys
import heapq
input = sys.stdin.readline
N = int(input())
heap = []
for i in range(N):
    tmp = int(input())
    if tmp == 0:
        if heap:
            print(-heapq.heappop(heap))
        else:
            print(0)
    else:
        heapq.heappush(heap, -tmp)
