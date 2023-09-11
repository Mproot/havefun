import sys

def collatz(integer):
    if integer % 2 == 0:
        evenResult = integer // 2
        print(evenResult)
        return evenResult
    else:
        oddResult = 3 * integer + 1
        print(oddResult)
        return oddResult

def main():
    try:
        while True:
            print('Enter a integer:')
            try:
                integer = int(input())
            except ValueError:
                print('Must be integer!')
                continue
            break

        while True:              
            if integer == 1:
                main()
            integer = collatz(integer)
    except KeyboardInterrupt:
        sys.exit()

if __name__ == "__main__":
    main()
