
import math
import sys

while 1:
    print("\nPrint 0 to exit.")
    try:
        n = int(input("N:\t"))
    except ValueError:
        print("Wrong input.")
        continue
    if n < 1:
        if n == 0:
            sys.exit()
        else:
            print("Number must be positive.")
            continue
    result = 0
    for k in range(1, n + 1):
        result = result + math.factorial(k)
    result /= math.factorial(n)
    print("Result:\t{:.6f}".format(result))
