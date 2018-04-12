from MathTo import * 
from sympy import *
import sys

#inital all the variable
Indicator2=Symbol('Indicator2')
#The function of Model
IndicatortargetlessthanworsT=((Piecewise((100,Indicator2<=100.0),(abs( (Indicator2-500.0)/-80000.0)+50,(100.0<=Indicator2)&(Indicator2<500.0)),(-abs( (Indicator2-500.0)/60000.0)+50,(500.0<Indicator2)&(Indicator2<800.0)),(0,True)))*100.0)/100
modelName = 'IndicatortargetlessthanworsT' 
List=['Indicator2']#variable list
LANG = ''
langList = ['python','c','c++','java',"javascript",'matlab','r']
def allPrint():
	for j in langList:
		LANG = str(j)
		Translate('((Piecewise((100,Indicator2<=100.0),(abs( (Indicator2-500.0)/-80000.0)+50,(100.0<=Indicator2)&(Indicator2<500.0)),(-abs( (Indicator2-500.0)/60000.0)+50,(500.0<Indicator2)&(Indicator2<800.0)),(0,True)))*100.0)/100',modelName,List,LANG)
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
			Translate('((Piecewise((100,Indicator2<=100.0),(abs( (Indicator2-500.0)/-80000.0)+50,(100.0<=Indicator2)&(Indicator2<500.0)),(-abs( (Indicator2-500.0)/60000.0)+50,(500.0<Indicator2)&(Indicator2<800.0)),(0,True)))*100.0)/100',modelName,List,LANG)
