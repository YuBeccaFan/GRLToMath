from MathTo import * 
from sympy import *
import sys

#inital all the variable
#Actor function
ActoR=0
#The function of Model
Actor_with_inportancE=(0*25)/100
modelName = 'Actor_with_inportancE' 
List=[]#variable list
LANG = ''
langList = ['python','c','c++','java',"javascript",'matlab','r']
def allPrint():
	for j in langList:
		LANG = str(j)
		Translate('(0*25)/100',modelName,List,LANG)
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
			Translate('(0*25)/100',modelName,List,LANG)
