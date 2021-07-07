#Program to perform Selection Sort
def selectionSort(list, n):
    for i in range(0,n):
        min = i
        for j in range(i+1,n):
            if list[j] < list[min]:
                min = j
        temp = list[i]
        list[i] = list[min]
        list[min] = temp
n = int(input())
list = []
for i in range(0,n):
    val = int(input())
    list.append(val)
selectionSort(list, n)
print(list)
