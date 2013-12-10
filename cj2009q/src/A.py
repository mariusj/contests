res = 0
words = []

#def gen_word(token, pos, word):
#    global res
#    while pos < len(token) and token[pos] != '(':
#        word += token[pos]
#        pos += 1
#    if pos >= len(token):
#        if word in words:
#            res += 1
#    else:
#        pos += 1
#        letters = []
#        while token[pos] != ')':
#            letters.append(token[pos])
#            pos += 1
#        pos += 1
#        for l in letters:
#            gen_word(token, pos, word + l)


def verify_char(token, idx, pos, words):
    for w in words:
        if w[idx] == token[pos]:
            return True
    return False


def AlienLanguage(L, words, token):
    #gen_word(token, 0, "")
    
    words2 = []
    words2.extend(words)
    
    pos = 0
    for idx in range(0, L):
        if token[pos] == '(':
            pos += 1
            letters = []
            while token[pos] != ')':
                letters.append(token[pos])
                pos += 1
            for i in reversed(range(0, len(words2))):
                if words2[i][idx] not in letters:
                    words2.remove(words2[i])
            pos += 1
            
        else:
            for i in reversed(range(0, len(words2))):
                if words2[i][idx] != token[pos]:
                    words2.remove(words2[i])
            pos += 1
    return len(words2)

#fname = "A.in"
#fname = "A-small-practice.in"
fname = "A-large-practice.in"
fin = open(fname, "r")
fOutName = fname.split(".")[0] + ".out"
fout = open(fOutName, "w")
L, D, N = [int(x) for x in fin.readline().strip("\n").split()]
for d in xrange(1, D + 1):
    words.append(fin.readline().strip("\n"))
for i in xrange(1, N + 1):
    token = fin.readline().strip("\n")
    str = "Case #%d: %s" % (i, AlienLanguage(L, words, token))
    print str
    fout.write(str + "\n") 
fin.close()
fout.close()
