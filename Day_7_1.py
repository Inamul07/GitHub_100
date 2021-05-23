def binary_search(list ,n ,x):
    start,end = 0,n-1
    while start <= end:
        mid = (start + end) // 2
        if list[mid] > x:
            end = mid - 1
        elif list[mid] < x:
            start = mid + 1
        else:
            return mid
    return -1
list = []
n = int(input("Enter Total No. Of Elements: "))
for i in range(0,n):
    val = int(input())
    list.append(val)
x = int(input("Enter Search Value: "))
result = binary_search(list ,n ,x)
if result != -1:
    print("Value Is Found At Index ",result)
else:
    print("Value Not Found")