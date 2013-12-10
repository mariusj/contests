import itertools


def gap(T, R):
    print("gap " + str(T) + " " + R)
    all_results = set()
    for i in range(1, len(T)+1):
        for T_part in itertools.combinations(T, i):
            if (len(T_part) == 1):
                all_results.add(T_part[0])
            else:
                pass

    min_res = 1
    while (True):
        if (min_res not in all_results):
            return min_res
        min_res += 1
    return 0

def find_the_gap(M, N, R):
    max_gap = 0
    for T in itertools.combinations(range(1, M+1), N):
        g = gap(T, R)
        print(g)
        if (g > max_gap):
            max_gap = g
    return max_gap


if __name__ == '__main__':
    print(find_the_gap(5, 2, "+*-"))

