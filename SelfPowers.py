__author__ = 'PrateekMehrotra'
L = int(input())
d = 10
s = sum(pow(n, n, 10**d) for n in range(1, L+1))
print(s%10**d)