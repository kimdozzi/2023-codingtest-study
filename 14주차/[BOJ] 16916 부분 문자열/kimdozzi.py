import sys
input = sys.stdin.readline
str1 = input().rstrip()
str2 = input().rstrip()
if str2 in str1:
    print(1)
else:
    print(0)
