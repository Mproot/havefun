import random

numberOfStreaks = 0

for experimentNumber in range(10000):
    # Code that creates a list of 100 'heads' or 'tails' values.
    result = []
    for i in range(100):
        if random.randint(0, 1) == 0:
            result.append('H')
        else:
            result.append('T')
            
    # Code that checks if there is a streak of 6 heads or tails in a row.
    count = 1
    begin = result[0]
    for cur in result[1:]:
        if cur == begin:
            count += 1
        else:
            begin = cur
            count = 1
        
        if count == 6:
            numberOfStreaks += 1
            count = 0

print('Chance of streak: %s%%' % (numberOfStreaks / 100))
