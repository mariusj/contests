def solve(idx, out, line):    
    res = "Case #%d:" % idx
    for x in reversed(line.split(" ")):
        res += " " + x 
    res += "\n"
    out.write(res)
    

#f = open("B-test.in")
#f = open("B-small-practice.in")
f = open("B-large-practice.in")
out = open("B.out", "w")
N = int(f.readline())
for i in range(0, N):
    line = f.readline()
    solve(i+1, out, line[0:len(line)-1])
f.close()
out.close()
