from MathTo import * 
from sympy import *
import sys

#inital all the variable
B=Symbol('B')
A=Symbol('A')
C=Symbol('C')
D=Symbol('D')
A=Max(0.0,Min(100.0,(25*B)/100.0))
C=Max(0.0,Min(100.0,(25*Max(0.0,Min(100.0,(25*B)/100.0))+25*D)/100.0))
#Actor function
Actor13=(Max(0.0,Min(100.0,(25*B)/100.0))*100.0)/100
#Actor function
Actor15=(Max(0.0,Min(100.0,(25*Max(0.0,Min(100.0,(25*B)/100.0))+25*D)/100.0))*100.0)/100
#The function of Model
Modeltest7=((Max(0.0,Min(100.0,(25*B)/100.0))*100.0)/100*50+(Max(0.0,Min(100.0,(25*Max(0.0,Min(100.0,(25*B)/100.0))+25*D)/100.0))*100.0)/100*50)/100
modelName = 'Modeltest7' 
List=['D','B']#variable list
LANG = ''
langList = ['python','c','c++','java',"javascript",'matlab','r']
def allPrint():
	for j in langList:
		LANG = str(j)
		Translate('((Max(0.0,Min(100.0,(25*B)/100.0))*100.0)/100*50+(Max(0.0,Min(100.0,(25*Max(0.0,Min(100.0,(25*B)/100.0))+25*D)/100.0))*100.0)/100*50)/100',modelName,List,LANG)
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
			Translate('((Max(0.0,Min(100.0,(25*B)/100.0))*100.0)/100*50+(Max(0.0,Min(100.0,(25*Max(0.0,Min(100.0,(25*B)/100.0))+25*D)/100.0))*100.0)/100*50)/100',modelName,List,LANG)
