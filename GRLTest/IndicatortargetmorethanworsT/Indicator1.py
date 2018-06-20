from MathTo import * 
from sympy import *
import sys

#inital all the variable
Indicator1=Symbol('Indicator1')
#The function of Model
IndicatortargetmorethanworsT=((Piecewise((100,Indicator1>=300.0),(abs( (Indicator1-200.0)/100.0)*50+50,(200.0<=Indicator1)&(Indicator1<300.0)),(-abs( (Indicator1-200.0)/-170.0)*50+50,(30.0<Indicator1)&(Indicator1<200.0)),(0,True)))*100.0)/100
modelName = 'IndicatortargetmorethanworsT' 
List=['Indicator1']#variable list
LANG = ''
langList = ['python','c','c++','java',"javascript",'matlab','r']
def allPrint():
	for j in langList:
		LANG = str(j)
		Translate('((Piecewise((100,Indicator1>=300.0),(abs( (Indicator1-200.0)/100.0)*50+50,(200.0<=Indicator1)&(Indicator1<300.0)),(-abs( (Indicator1-200.0)/-170.0)*50+50,(30.0<Indicator1)&(Indicator1<200.0)),(0,True)))*100.0)/100',modelName,List,LANG)
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
			Translate('((Piecewise((100,Indicator1>=300.0),(abs( (Indicator1-200.0)/100.0)*50+50,(200.0<=Indicator1)&(Indicator1<300.0)),(-abs( (Indicator1-200.0)/-170.0)*50+50,(30.0<Indicator1)&(Indicator1<200.0)),(0,True)))*100.0)/100',modelName,List,LANG)
