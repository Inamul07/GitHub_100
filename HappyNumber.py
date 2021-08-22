# In number theory, a happy number is a number which eventually reaches 1 when replaced by the sum of the square of each digit. 
# For instance, 13 is a happy number because (1^2)+(3^2)=10, and (1^2)+(0^2)=1. On the other hand, 4 is not a happy number because 
# the sequence starting with (4^2)=16 and (1^2)+(6^2)=37 eventually reaches (2^2)+(0^2)=4, the number that started the sequence, 
# and so the process continues in an infinite cycle without ever reaching 1. A number which is not happy is called sad or unhappy.

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
