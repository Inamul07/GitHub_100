def bubbleSort(list):
    n = len(list)
    for i in range(n):
        for j in range(0, n - 1):
            if list[j] > list[j + 1]:
                list[j], list[j + 1] = list[j + 1], list[j]
n = int(input("Enter the no.of elements: "))
print("Enter the elements:")
list = [int(input()) for i in range(n)]
bubbleSort(list)
print(list)