from MathTo import * 
from sympy import *
import sys

#inital all the variable
A=Symbol('A')
B=Symbol('B')
C=Symbol('C')
D=Symbol('D')
A=Max(B,Max(D,C))
#The function of Model
OrdecompostioN=((Max(B,Max(D,C)))*100.0)/100
modelName = 'OrdecompostioN' 
List=['D','C','B']#variable list
LANG = ''
langList = ['python','c','c++','java',"javascript",'matlab','r']
def allPrint():
	for j in langList:
		LANG = str(j)
		Translate('((Max(B,Max(D,C)))*100.0)/100',modelName,List,LANG)
if(len(sys.argv)==1):
	allPrint()
else:
	for i in sys.argv:
		if(sys.argv.index(i)==0):continue
		if  (i.lower() not in langList):
			for j in langList:
				LANG = str(j)
				allPrint()
		else:
			print 'in'
			LANG = str(i.lower())
			Translate('((Max(B,Max(D,C)))*100.0)/100',modelName,List,LANG)
