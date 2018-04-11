#Translation.py
from sympy import *
from MathToJava import *
from MathToC import *
from MathToCpp import *
from MathToJS import *
from MathToPython import *
from MathToMatlab import *
from MathToR import *
from MathToLang import *
init_printing()

''' translate Sympy formula into target language
	Java
	Matlab
	C
	C++
	JavaScript
	Python
    R
'''

def Translate(formula,dep,args,Type):

    i = 0
    for arg in args:
        arg = str(arg)+"="+"Symbol"+"("+"'"+str(arg)+"'"+")"
        i = i+1
        exec(arg)
        
    func = simplify(eval(formula)).evalf()
    #print func
    if Type == "java":
        convertToJava(jcode(func),dep,args).writeMath()
        print 'java'
        return
    if Type == "python":
        print "python"
        from sympy.printing.pycode import (PythonCodePrinter,pycode)
        pr = PythonCodePrinter()
        convertToPy( pr.doprint(func),dep,args).writeMath()
        return
    if Type == "javascript":
        convertToJS(jscode(func),dep,args).writeMath()
        print 'js'
        return
    if Type == "matlab":
        print 'matlab'
        convertToMatlab(octave_code(func),dep,args).writeMath()
        return

    if Type == "c":
        convertToC(ccode(func),dep,args).writeMath()
        print 'c'
        return
    if Type == "c++":
        convertToCpp(cxxcode(func),dep,args).writeMath()
        print "c++"
        return
    if Type == "r":
        convertToR(rcode(func),dep,args).writeMath()
        print "R"
        return



'''
test
print Translate('E1=Min(E2,E3)',"Java")'''
