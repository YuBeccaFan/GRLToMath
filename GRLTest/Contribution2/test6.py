from MathTo import * 
from sympy import *
import sys

#inital all the variable
A=Symbol('A')
B=Symbol('B')
C=Symbol('C')
A=Max(0.0,Min(100.0,(25*B+-25*C)/100.0))
#The function of Model
Contribution2=((Max(0.0,Min(100.0,(25*B+-25*C)/100.0)))*100.0)/100
modelName = 'Contribution2' 
List=['C','B']#variable list
LANG = ''
langList = ['python','c','c++','java',"javascript",'matlab','r']
def allPrint():
	for j in langList:
		LANG = str(j)
		Translate('((Max(0.0,Min(100.0,(25*B+-25*C)/100.0)))*100.0)/100',modelName,List,LANG)
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
			Translate('((Max(0.0,Min(100.0,(25*B+-25*C)/100.0)))*100.0)/100',modelName,List,LANG)
