
def RopeIntranet(wires):
    res = 0
    for i in range(0, len(wires) - 1):
        for j in range(i + 1, len(wires)):
            if wires[i][0] < wires[j][0] and wires[i][1] > wires[j][1]:
                res += 1
            elif wires[i][0] > wires[j][0] and wires[i][1] < wires[j][1]:
                res += 1
    return res

#fname = "A.in"
#fname = "A-small-practice.in"
fname = "A-large-practice.in"
fin = open(fname, "r")
fOutName = fname.split(".")[0] + ".out"
fout = open(fOutName, "w")
N = int(fin.readline().strip("\n"))
for i in xrange(1, N + 1):
    num_wires = int(fin.readline())
    wires = []
    for w in range(0, num_wires):
        a, b = [int(x) for x in fin.readline().split()]
        wires.append((a, b))
    str = "Case #%d: %s" % (i, RopeIntranet(wires))
    print str
    fout.write(str + "\n") 
fin.close()
fout.close()
