# Write a python program to perform linear search
list = []
n = int(input("Enter Total No. Of Elements: "))
for i in range(0,n):
    val = int(input())
    list.append(val)
x = int(input("Enter Search Value: "))
temp = 0
for i in range(0,n):
    if (list[i] == x):
        temp = 1
        print("The Value Is Found At Index ",i)
        break
if temp == 0:
    print("Value Not Found")
