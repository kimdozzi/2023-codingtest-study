import sys
input = sys.stdin.readline
n,k = map(int,input().split())
lst = []
cnt = 0
for i in range(n):
    lst.append(int(input()))
lst.sort(reverse=True)
for i in range(len(lst)) :
    if k >= 0 :
        while lst[i] <= k:
            k -= lst[i]
            cnt += 1
print(cnt)