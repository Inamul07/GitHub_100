# Write a python program to perform merge sort
def mergeSort(list):
    if len(list) > 1:
        m = len(list) // 2
        L = list[:m]
        R = list[m:]
        mergeSort(L)
        mergeSort(R)
        i = j = k = 0
        while i < len(L) and j < len(R):
            if L[i] < R[j]:
                list[k] = L[i]
                i += 1
            else:
                list[k] = R[j]
                j += 1
            k += 1
        while i < len(L):
            list[k] = L[i]
            i += 1
            k += 1
        while j < len(R):
            list[k] = R[j]
            j += 1
            k += 1

list = []
n = int(input("Enter the no. of elements: "))
print("Enter the elements:",end="\n");
for i in range(n):
    val = int(input())
    list.append(val)
mergeSort(list)
print(list)
