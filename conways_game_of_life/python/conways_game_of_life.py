import random, copy, time, sys

WIDTH = 79
HEIGHT = 20
ALIVE = '#'
DEAD = ' '

def main():
    #nextCells = getSeeds()
    nextCells = getSeedsWithGlider()

    while True:
        print('\n' * 50)
        cells = copy.deepcopy(nextCells)
        show(cells)

        getNextCells(cells, nextCells)

        try:
            time.sleep(0.1)
        except KeyboardInterrupt:
            print('Conway\'s Game of Life.')
            sys.exit()


def getNextCells(cells, nextCells):
    for x in range(WIDTH):
        for y in range(HEIGHT):
            left = (x - 1) % WIDTH
            right = (x + 1) % WIDTH
            above = (y - 1) % HEIGHT
            below = (y + 1) % HEIGHT

            numNeighbors = 0
            if cells[(left, above)] == ALIVE:
                numNeighbors += 1
            if cells[(x, above)] == ALIVE:
                numNeighbors += 1
            if cells[(right, above)] == ALIVE:
                numNeighbors += 1
            if cells[(left, y)] == ALIVE:
                numNeighbors += 1
            if cells[(right, y)] == ALIVE:
                numNeighbors += 1
            if cells[(left, below)] == ALIVE:
                numNeighbors += 1
            if cells[(x, below)] == ALIVE:
                numNeighbors += 1
            if cells[(right, below)] == ALIVE:
                numNeighbors += 1

            if cells[(x, y)] == ALIVE and (numNeighbors == 2 or numNeighbors == 3):
                nextCells[(x, y)] = ALIVE
            elif cells[(x, y)] == DEAD and numNeighbors == 3:
                nextCells[(x, y)] = ALIVE
            else:
                nextCells[(x, y)] = DEAD

def show(cells):
    for y in range(HEIGHT):
        for x in range(WIDTH):
            print(cells[(x, y)], end='')
        print()
    print('Print Ctrl-C to quit.')

def getSeeds():
    nextCells = {}
    for x in range(WIDTH):
        for y in range(HEIGHT):
            if random.randint(0, 1) == 0:
                nextCells[(x, y)] = DEAD
            else:
                nextCells[(x, y)] = ALIVE
    return nextCells

def getSeedsWithGlider():
    nextCells = {}
    for x in range(WIDTH):
        for y in range(HEIGHT):
            if (x, y) in ((1, 0), (2, 1), (0, 2), (1, 2), (2, 2)):
                nextCells[(x, y)] = ALIVE
            else:
                nextCells[(x, y)] = DEAD
    return nextCells

if __name__ == "__main__":
    main()
