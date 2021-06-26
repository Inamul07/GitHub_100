print("Enter M1rows & M1cols:")
M1rows = int(input())
M1cols = int(input())
print("Enter M2rows & M2cols:")
M2rows = int(input())
M2cols = int(input())
M1, M2, M3 = [], [], []
print("Enter the elements of M1:")
for i in range(M1rows):
    row = []
    for j in range(M1cols):
        val = int(input())
        row.append(val)
    M1.append(row)
print("Enter the elements of M2:")
for i in range(M2rows):
    row = []
    for j in range(M2cols):
        val = int(input())
        row.append(val)
    M2.append(row)
for i in range(M1rows):
    row = []
    for j in range(M2cols):
        row.append(0)
    M3.append(row)
for i in range(M1rows):
    for j in range(M2cols):
        for k in range(M1cols):
            M3[i][j] += M1[i][k] * M2[k][j]
print("M1 * M2:")
for i in range(M1rows):
    for j in range(M2cols):
        print(M3[i][j], end=" ")
    print("\n")
