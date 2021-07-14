def ishappy(num):
    sum = 0
    while num > 0:
        rem = num % 10
        sum += (rem) * (rem)
        num //= 10
    return sum

num = int(input("Enter a Number: "))
result = num
while result != 1 and result != 4:
    result = ishappy(result)
if result == 1:
    print("It is a Happy Number")
elif result ==  4:
    print("It is Not a Happy Number")