from MathTo import * 
from sympy import *
import sys

#inital all the variable
A=Symbol('A')
B=Symbol('B')
C=Symbol('C')
D=Symbol('D')
E=Symbol('E')
F=Symbol('F')
H=Symbol('H')
G=Symbol('G')
J=Symbol('J')
A=Min(Max(0.0,Min(100.0,(25*G)/100.0)),Max(0.0,Min(100.0,(75*J)/100.0)))
B=Max(0.0,Min(100.0,(25*G)/100.0))
C=Max(0.0,Min(100.0,(75*J)/100.0))
D=Min(Max(0.0,Min(100.0,(-25*G)/100.0)),Max(0.0,Min(100.0,(25*J)/100.0)))
E=Max(0.0,Min(100.0,(-25*G)/100.0))
F=Max(0.0,Min(100.0,(25*J)/100.0))
H=Min(G,J)
#Actor function
Actor1=((Min(Max(0.0,Min(100.0,(25*G)/100.0)),Max(0.0,Min(100.0,(75*J)/100.0))))*100.0)/100
#Actor function
Actor2=((Min(Max(0.0,Min(100.0,(-25*G)/100.0)),Max(0.0,Min(100.0,(25*J)/100.0))))*100.0)/100
#Actor function
Actor3=((Min(G,J))*100.0)/100
#The function of Model
MultirootmodeL=(((Min(Max(0.0,Min(100.0,(25*G)/100.0)),Max(0.0,Min(100.0,(75*J)/100.0))))*100.0)/100*75+((Min(Max(0.0,Min(100.0,(-25*G)/100.0)),Max(0.0,Min(100.0,(25*J)/100.0))))*100.0)/100*25+((Min(G,J))*100.0)/100*0)/100
modelName = 'MultirootmodeL' 
List=['J','G']#variable list
LANG = ''
langList = ['python','c','c++','java',"javascript",'matlab','r']
def allPrint():
	for j in langList:
		LANG = str(j)
		Translate('(((Min(Max(0.0,Min(100.0,(25*G)/100.0)),Max(0.0,Min(100.0,(75*J)/100.0))))*100.0)/100*75+((Min(Max(0.0,Min(100.0,(-25*G)/100.0)),Max(0.0,Min(100.0,(25*J)/100.0))))*100.0)/100*25+((Min(G,J))*100.0)/100*0)/100',modelName,List,LANG)
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
			Translate('(((Min(Max(0.0,Min(100.0,(25*G)/100.0)),Max(0.0,Min(100.0,(75*J)/100.0))))*100.0)/100*75+((Min(Max(0.0,Min(100.0,(-25*G)/100.0)),Max(0.0,Min(100.0,(25*J)/100.0))))*100.0)/100*25+((Min(G,J))*100.0)/100*0)/100',modelName,List,LANG)
