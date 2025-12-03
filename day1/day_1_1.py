import math 
f = open("input.txt")

count = 50
nbZero = 0
for line in f.readlines() :
    direction = line[0]
    number = int(line[1:-1])
    print("turn direction :",direction)
    print("value to add :",number)
    if direction == "R":
        if number > 99 :
            nbZero += number//100
            number = number % 100
        if count + number > 99:
            count = count+number-100
            nbZero += 1
        else:
            count += number
            if count == 0:
                nbZero += 1
    else:
        if number > 99 :
            nbZero+=number//100
            number = number % 100
        if count - number < 0:
            newpos = count - number
            if newpos != -number:
                nbZero += 1
            count = newpos + 100
        else:
            count -= number
            if count == 0:
                nbZero += 1
    print("count :",count)
    print("nbZero:", nbZero)

