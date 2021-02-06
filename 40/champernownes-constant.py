

def nextGenerator():
    current = 1
    index = 0
    def next():
        nonlocal current
        nonlocal index
        strNum = str(current)
        if index < len(strNum):
            ch = strNum[index]
            index += 1
            return int(ch)
        else:
            current += 1
            index = 1
            return int(str(current)[0])
    return next

ixs = [1, 10, 100, 1000, 10000, 100000, 1000000]

numbers = nextGenerator()
res = 1
for n in range(1000001):
    d = numbers()
    if n + 1 in ixs:
        res *= d

print(res)