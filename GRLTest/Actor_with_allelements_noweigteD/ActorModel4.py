from MathTo import * 
from sympy import *
import sys

#inital all the variable
B=Symbol('B')
C=Symbol('C')
D=Symbol('D')
E=Symbol('E')
B=Min(C,D)
#Actor function
ActoR=((Min(C,D))*100.0+(E)*100.0)/200
#The function of Model
Actor_with_allelements_noweigteD=((((Min(C,D))*100.0+(E)*100.0)/200)*100.0)/100
modelName = 'Actor_with_allelements_noweigteD' 
List=['E','D','C']#variable list
LANG = ''
langList = ['python','c','c++','java',"javascript",'matlab','r']
def allPrint():
	for j in langList:
		LANG = str(j)
		Translate('((((Min(C,D))*100.0+(E)*100.0)/200)*100.0)/100',modelName,List,LANG)
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
			Translate('((((Min(C,D))*100.0+(E)*100.0)/200)*100.0)/100',modelName,List,LANG)
