from MathTo import * 
from sympy import *
import sys

#inital all the variable
A=Symbol('A')
B=Symbol('B')
C=Symbol('C')
D=Symbol('D')
E=Symbol('E')
A=Min(B,Min(D,E))
C=Min(D,E)
#Actor function
ActoR=((Min(D,E))*100.0)/100
#The function of Model
Actor_contain_part_elE=((((Min(D,E))*100.0)/100)*100.0)/100
modelName = 'Actor_contain_part_elE' 
List=['E','D','B']#variable list
LANG = ''
langList = ['python','c','c++','java',"javascript",'matlab','r']
def allPrint():
	for j in langList:
		LANG = str(j)
		Translate('((((Min(D,E))*100.0)/100)*100.0)/100',modelName,List,LANG)
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
			Translate('((((Min(D,E))*100.0)/100)*100.0)/100',modelName,List,LANG)
