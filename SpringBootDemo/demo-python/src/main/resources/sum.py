import plus
import sys

def sum(start, end):
    total = 0
    for i in range(start, end):
        total = plus.add(total, i)

    print(total)
    return total

if __name__ == '__main__':
    param = sys.argv[1]
    params = param.split(',')
    start = int(params[0])
    end = int(params[1])
    print(start)
    print(end)
    sum(start, end)
