def swap(list, i, j):
    temp = list[i]
    list[i] = list[j]
    list[j] = temp
def partition(list, l, r):
    pivot = list[r]
    i = l - 1
    for j in range(l, r):
        if list[j] < pivot:
            i += 1
            swap(list, i, j)
    swap(list, i + 1, r)
    return i + 1
def quickSort(list, l, r):
    if l < r:
        pi = partition(list, l, r)
        quickSort(list, l, pi - 1)
        quickSort(list, pi + 1, r)
n = int(input("Enter the no. of elements: "))
list = []
print("Enter the elements:")
for i in range(n):
    val = int(input())
    list.append(val)
quickSort(list, 0, n-1);
print(list)