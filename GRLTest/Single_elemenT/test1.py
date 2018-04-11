from MathTo import * 
from sympy import *
import sys

#inital all the variable
X=Symbol('X')
#The function of Model
Single_elemenT=((X)*100.0)/100
modelName = 'Single_elemenT' 
List=['X']#variable list
LANG = ''
langList = ['python','c','c++','java',"javascript",'matlab','r']
def allPrint():
	for j in langList:
		LANG = str(j)
		Translate('((X)*100.0)/100',modelName,List,LANG)
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
			Translate('((X)*100.0)/100',modelName,List,LANG)
