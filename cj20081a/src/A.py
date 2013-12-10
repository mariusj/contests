
def MinimumScalarProduct(v1, v2):
    res = 0
    v1.sort()
    v2.sort(reverse=True)
    for x in range(0, len(v1)):
        res += v1[x]*v2[x]
    return res

#fname = "A.in"
#fname = "A-small-practice.in"
fname = "A-large-practice.in"
fin = open(fname, "r")
fOutName = fname.split(".")[0] + ".out"
fout = open(fOutName, "w")
N = int(fin.readline().strip("\n"))
for i in xrange(1, N + 1):
    T = int(fin.readline())
    v1 = [int(x) for x in fin.readline().split()]
    v2 = [int(x) for x in fin.readline().split()]
    str = "Case #%d: %s" % (i, MinimumScalarProduct(v1, v2))
    print str
    fout.write(str + "\n") 
fin.close()
fout.close()
