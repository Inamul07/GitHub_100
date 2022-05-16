# Write a python program to store Student details

def grader(avg):
    if avg >= 90:
        return 'A'
    if avg >= 80:
        return 'B'
    if avg >= 70:
        return 'C'
    if avg >= 60:
        return 'D'
    if avg >= 50:
        return 'E'
    return 'F'

n = int(input("Enter the no. of students: "))
dataBase = {}
for i in range(n):
    print("Student ",(i+1),": ")
    rno = int(input("Enter roll no: "))
    name = input("Enter name: ")
    sub = []
    print("Enter marks of 5 subjects: ")
    for j in range(5):
        val = int(input())
        sub.append(val)
    avg = sum(sub) / len(sub)
    grade = grader(avg)
    dataBase[rno] = [rno, name, avg, grade]

print(dataBase)
