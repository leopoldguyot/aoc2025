f = open("input_day3.txt")

def charge_batteries(joltage,nb):
    maxind = 0
    for j in range(0,len(joltage)-1) :
        if joltage[j] > joltage[maxind] : 
            maxind = j
    minind = maxind + 1
    for i in range(maxind+1, len(joltage)):
        if joltage[i] > joltage[minind] :
            minind = i 
    number_str = str(joltage[maxind])+str(joltage[minind])
    print(number_str)
    nb += int(number_str)
    return(nb)

nbTot=0
largest=0
for line in f.readlines():
    test = line.strip()
    largest= charge_batteries(test,largest)
print(largest)

