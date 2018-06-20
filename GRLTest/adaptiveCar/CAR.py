from MathTo import * 
from sympy import *
import sys

#inital all the variable
Reduce_the_cosT=Symbol('Reduce_the_cosT')
Comfortable_drivinG=Symbol('Comfortable_drivinG')
DrivE=Symbol('DrivE')
ControL=Symbol('ControL')
AcceleratioN=Symbol('AcceleratioN')
Fuel_enginE=Symbol('Fuel_enginE')
Electric_enginE=Symbol('Electric_enginE')
Manage_distancE=Symbol('Manage_distancE')
Manage_speeD=Symbol('Manage_speeD')
VibratioN=Symbol('VibratioN')
DistancE=Symbol('DistancE')
Reduce_the_cosT=Max(0.0,Min(100.0,(50*Fuel_enginE+-25*Electric_enginE)/100.0))
Comfortable_drivinG=Max(0.0,Min(100.0,(50*Piecewise((100,VibratioN<=0.0),(abs( (VibratioN-10.0)/10.0)*50+50,(0.0<VibratioN)&(VibratioN<=10.0)),(-abs( (VibratioN-10.0)/-10.0)*50+50,(10.0<VibratioN)&(VibratioN<20.0)),(0,True))+50*Electric_enginE+-25*Fuel_enginE)/100.0))
DrivE=Min(Max(0.0,Min(100.0,(-50*Manage_speeD+Max(Fuel_enginE,Electric_enginE)*100.0)/100.0)),Max(Max(0.0,Min(100.0,(100*Piecewise((100,DistancE>=25.0),(abs( (DistancE-10.0)/15.0)*50+50,(10.0<=DistancE)&(DistancE<25.0)),(-abs( (DistancE-10.0)/-5.0)*50+50,(5.0<DistancE)&(DistancE<10.0)),(0,True)))/100.0)),Manage_speeD))
ControL=Max(Max(0.0,Min(100.0,(100*Piecewise((100,DistancE>=25.0),(abs( (DistancE-10.0)/15.0)*50+50,(10.0<=DistancE)&(DistancE<25.0)),(-abs( (DistancE-10.0)/-5.0)*50+50,(5.0<DistancE)&(DistancE<10.0)),(0,True)))/100.0)),Manage_speeD)
AcceleratioN=Max(0.0,Min(100.0,(-50*Manage_speeD+Max(Fuel_enginE,Electric_enginE)*100.0)/100.0))
Manage_distancE=Max(0.0,Min(100.0,(100*Piecewise((100,DistancE>=25.0),(abs( (DistancE-10.0)/15.0)*50+50,(10.0<=DistancE)&(DistancE<25.0)),(-abs( (DistancE-10.0)/-5.0)*50+50,(5.0<DistancE)&(DistancE<10.0)),(0,True)))/100.0))
#Actor function
SysteM=(Min(Max(0.0,Min(100.0,(-50*Manage_speeD+Max(Fuel_enginE,Electric_enginE)*100.0)/100.0)),Max(Max(0.0,Min(100.0,(100*Piecewise((100,DistancE>=25.0),(abs( (DistancE-10.0)/15.0)*50+50,(10.0<=DistancE)&(DistancE<25.0)),(-abs( (DistancE-10.0)/-5.0)*50+50,(5.0<DistancE)&(DistancE<10.0)),(0,True)))/100.0)),Manage_speeD))*100.0)/100
#Actor function
UseR=(Max(0.0,Min(100.0,(50*Fuel_enginE+-25*Electric_enginE)/100.0))*100.0+Max(0.0,Min(100.0,(50*Piecewise((100,VibratioN<=0.0),(abs( (VibratioN-10.0)/10.0)*50+50,(0.0<VibratioN)&(VibratioN<=10.0)),(-abs( (VibratioN-10.0)/-10.0)*50+50,(10.0<VibratioN)&(VibratioN<20.0)),(0,True))+50*Electric_enginE+-25*Fuel_enginE)/100.0))*100.0)/100
#The function of Model
AdaptivecaR=((Min(Max(0.0,Min(100.0,(-50*Manage_speeD+Max(Fuel_enginE,Electric_enginE)*100.0)/100.0)),Max(Max(0.0,Min(100.0,(100*Piecewise((100,DistancE>=25.0),(abs( (DistancE-10.0)/15.0)*50+50,(10.0<=DistancE)&(DistancE<25.0)),(-abs( (DistancE-10.0)/-5.0)*50+50,(5.0<DistancE)&(DistancE<10.0)),(0,True)))/100.0)),Manage_speeD))*100.0)/100*60+(Max(0.0,Min(100.0,(50*Fuel_enginE+-25*Electric_enginE)/100.0))*100.0+Max(0.0,Min(100.0,(50*Piecewise((100,VibratioN<=0.0),(abs( (VibratioN-10.0)/10.0)*50+50,(0.0<VibratioN)&(VibratioN<=10.0)),(-abs( (VibratioN-10.0)/-10.0)*50+50,(10.0<VibratioN)&(VibratioN<20.0)),(0,True))+50*Electric_enginE+-25*Fuel_enginE)/100.0))*100.0)/100*40)/100
modelName = 'AdaptivecaR' 
List=['Manage_speeD','VibratioN','Electric_enginE','DistancE','Fuel_enginE']#variable list
LANG = ''
langList = ['python','c','c++','java',"javascript",'matlab','r']
def allPrint():
	for j in langList:
		LANG = str(j)
		Translate('((Min(Max(0.0,Min(100.0,(-50*Manage_speeD+Max(Fuel_enginE,Electric_enginE)*100.0)/100.0)),Max(Max(0.0,Min(100.0,(100*Piecewise((100,DistancE>=25.0),(abs( (DistancE-10.0)/15.0)*50+50,(10.0<=DistancE)&(DistancE<25.0)),(-abs( (DistancE-10.0)/-5.0)*50+50,(5.0<DistancE)&(DistancE<10.0)),(0,True)))/100.0)),Manage_speeD))*100.0)/100*60+(Max(0.0,Min(100.0,(50*Fuel_enginE+-25*Electric_enginE)/100.0))*100.0+Max(0.0,Min(100.0,(50*Piecewise((100,VibratioN<=0.0),(abs( (VibratioN-10.0)/10.0)*50+50,(0.0<VibratioN)&(VibratioN<=10.0)),(-abs( (VibratioN-10.0)/-10.0)*50+50,(10.0<VibratioN)&(VibratioN<20.0)),(0,True))+50*Electric_enginE+-25*Fuel_enginE)/100.0))*100.0)/100*40)/100',modelName,List,LANG)
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
			Translate('((Min(Max(0.0,Min(100.0,(-50*Manage_speeD+Max(Fuel_enginE,Electric_enginE)*100.0)/100.0)),Max(Max(0.0,Min(100.0,(100*Piecewise((100,DistancE>=25.0),(abs( (DistancE-10.0)/15.0)*50+50,(10.0<=DistancE)&(DistancE<25.0)),(-abs( (DistancE-10.0)/-5.0)*50+50,(5.0<DistancE)&(DistancE<10.0)),(0,True)))/100.0)),Manage_speeD))*100.0)/100*60+(Max(0.0,Min(100.0,(50*Fuel_enginE+-25*Electric_enginE)/100.0))*100.0+Max(0.0,Min(100.0,(50*Piecewise((100,VibratioN<=0.0),(abs( (VibratioN-10.0)/10.0)*50+50,(0.0<VibratioN)&(VibratioN<=10.0)),(-abs( (VibratioN-10.0)/-10.0)*50+50,(10.0<VibratioN)&(VibratioN<20.0)),(0,True))+50*Electric_enginE+-25*Fuel_enginE)/100.0))*100.0)/100*40)/100',modelName,List,LANG)
