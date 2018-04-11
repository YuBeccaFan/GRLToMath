from MathTo import * 
from sympy import *
import sys

#inital all the variable
A=Symbol('A')
B=Symbol('B')
C=Symbol('C')
D=Symbol('D')
A=Min(B,Min(D,C))
#The function of Model
AnddecompositioN=((Min(B,Min(D,C)))*100.0)/100
modelName = 'AnddecompositioN' 
List=['D','C','B']#variable list
LANG = ''
langList = ['python','c','c++','java',"javascript",'matlab','r']
def allPrint():
	for j in langList:
		LANG = str(j)
		Translate('((Min(B,Min(D,C)))*100.0)/100',modelName,List,LANG)
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
			Translate('((Min(B,Min(D,C)))*100.0)/100',modelName,List,LANG)
