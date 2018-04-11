from MathTo import * 
from sympy import *
import sys

#inital all the variable
B=Symbol('B')
C=Symbol('C')
D=Symbol('D')
Softgoal33=Symbol('Softgoal33')
#Actor function
ActoR=(B*100.0+C*100.0)/175
#The function of Model
Actor_with_ele3=(((B*100.0+C*100.0)/175)*100.0)/100
modelName = 'Actor_with_ele3' 
List=['D','C','B','Softgoal33']#variable list
LANG = ''
langList = ['python','c','c++','java',"javascript",'matlab','r']
def allPrint():
	for j in langList:
		LANG = str(j)
		Translate('(((B*100.0+C*100.0)/175)*100.0)/100',modelName,List,LANG)
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
			Translate('(((B*100.0+C*100.0)/175)*100.0)/100',modelName,List,LANG)
