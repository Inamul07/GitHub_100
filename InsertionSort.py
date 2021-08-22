# Write a Python program to perform insertion sort
def sort(list):
    for i in range(1, len(list)):
        val = list[i]
        j = i-1
        while j >= 0 and val < list[j]:
                list[j + 1] = list[j]
                j -= 1
        list[j + 1] = val
list = []
n = int(input())
for i in range(0,n):
    val = int(input())
    list.append(val)
sort(list)
print(list)
