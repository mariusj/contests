out = open("A.out", "w")

def solve(idx, C, prices):
    solved = False
    i1 = 0
    i2 = 0
    for i1 in range(0, len(prices)):
        for i2 in range(i1 + 1, len(prices)):
            if prices[i1] + prices[i2] == C:
                solved = True
                break
        if solved:
            break
            
    res = "Case #%d: %d %d\n" % (idx, i1+1, i2+1)
    out.write(res)
    

#f = open("A-test.in")
#f = open("A-small-practice.in")
f = open("A-large-practice.in")
N = int(f.readline())
for i in range(0, N):
    C = int(f.readline())
    I = int(f.readline())
    prices = []
    p = f.readline()
    prices = [int(x) for x in p.split(" ")]
    solve(i+1, C, prices)
f.close()
out.close()

