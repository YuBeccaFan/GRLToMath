from MathTo import * 
from sympy import *
import sys

#inital all the variable
Indicator3=Symbol('Indicator3')
X=Symbol('X')
X=Max(0.0,Min(100.0,(25*Piecewise((100,Indicator3<=-100.0),(abs( (Indicator3-200.0)/-60000.0)+50,(-100.0<Indicator3)&(Indicator3<200.0)),(-abs( (Indicator3-200.0)/60000.0)+50,(200.0<Indicator3)&(Indicator3<500.0)),(0,True)))/100.0))
#The function of Model
IndicatorwithelemenT=((Max(0.0,Min(100.0,(25*Piecewise((100,Indicator3<=-100.0),(abs( (Indicator3-200.0)/-60000.0)+50,(-100.0<Indicator3)&(Indicator3<200.0)),(-abs( (Indicator3-200.0)/60000.0)+50,(200.0<Indicator3)&(Indicator3<500.0)),(0,True)))/100.0)))*100.0)/100
modelName = 'IndicatorwithelemenT' 
List=['Indicator3']#variable list
LANG = ''
langList = ['python','c','c++','java',"javascript",'matlab','r']
def allPrint():
	for j in langList:
		LANG = str(j)
		Translate('((Max(0.0,Min(100.0,(25*Piecewise((100,Indicator3<=-100.0),(abs( (Indicator3-200.0)/-60000.0)+50,(-100.0<Indicator3)&(Indicator3<200.0)),(-abs( (Indicator3-200.0)/60000.0)+50,(200.0<Indicator3)&(Indicator3<500.0)),(0,True)))/100.0)))*100.0)/100',modelName,List,LANG)
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
			Translate('((Max(0.0,Min(100.0,(25*Piecewise((100,Indicator3<=-100.0),(abs( (Indicator3-200.0)/-60000.0)+50,(-100.0<Indicator3)&(Indicator3<200.0)),(-abs( (Indicator3-200.0)/60000.0)+50,(200.0<Indicator3)&(Indicator3<500.0)),(0,True)))/100.0)))*100.0)/100',modelName,List,LANG)
