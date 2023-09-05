import sys, random

print('ROCK, PAPER, SCISSORS')

wins = 0
losses = 0
ties = 0

setOfChoices = ['r', 'p', 's']

while True:
    while True:
        print('%s Wins, %s Losses, %s Ties' % (wins, losses, ties))
        print('Enter your playerMove: (r)ock (p)aper (s)cissors or (q)uit')
        playerMove = input()

        if playerMove.lower().startswith('q'):
            sys.exit()
        elif playerMove == 'r' or playerMove == 'p' or playerMove == 's':
            break

    if playerMove == 'r':
        print('ROCK versus...')
    elif playerMove == 'p':
        print('PAPER versus...')
    elif playerMove == 's':
        print('SCISSORS versus...')

    computerMove = setOfChoices[random.randint(0, 2)]
    if computerMove == 'r':
        print('ROCK')
    elif computerMove == 'p':
        print('PAPER')
    elif computerMove == 's':
        print('SCISSORS')

    if playerMove == computerMove:
        ties += 1
        print('It is a tie!')
    elif playerMove == 'r' and computerMove == 'p':
        losses += 1
        print('You lose!')
    elif playerMove == 'p' and computerMove == 's':
        losses += 1
        print('You lose!')
    elif playerMove == 's' and computerMove == 'r':
        losses += 1
        print('You lose!')
    elif playerMove == 'r' and computerMove == 's':
        wins += 1
        print('You win!')
    elif playerMove == 'p' and computerMove == 'r':
        wins += 1
        print('You win!')
    elif playerMove == 's' and computerMove == 'p':
        wins += 1
        print('You win!')