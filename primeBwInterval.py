#Program to find prime numbers b/w intervals
def isPrime(n):
    temp = 0
    if n == 1:
        return False
    for i in range(2, n):
        if n%i == 0:
            temp = 1
            break
    if temp == 0:
        return True
    return False
n1 = int(input("Enter the Interval: "))
n2 = int(input())
for i in range(n1, n2+1):
    if(isPrime(i)):
        print(i, end=" ")
