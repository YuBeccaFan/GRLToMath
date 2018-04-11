from MathTo import * 
from sympy import *
import sys

#inital all the variable
B=Symbol('B')
#Actor function
ActoR=(B*100.0)/100
#The function of Model
Actor_with_ele1=(((B*100.0)/100)*100.0)/100
modelName = 'Actor_with_ele1' 
List=['B']#variable list
LANG = ''
langList = ['python','c','c++','java',"javascript",'matlab','r']
def allPrint():
	for j in langList:
		LANG = str(j)
		Translate('(((B*100.0)/100)*100.0)/100',modelName,List,LANG)
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
			Translate('(((B*100.0)/100)*100.0)/100',modelName,List,LANG)
