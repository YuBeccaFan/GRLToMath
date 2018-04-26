from MathTo import * 
from sympy import *
import sys

#inital all the variable
Take_privatetransporT=Symbol('Take_privatetransporT')
Regular_buS=Symbol('Regular_buS')
Monthly_infrastructurecosT=Symbol('Monthly_infrastructurecosT')
Work_during_commutE=Symbol('Work_during_commutE')
Express_buS=Symbol('Express_buS')
Average_work_timE=Symbol('Average_work_timE')
Minimize_travel_timE=Symbol('Minimize_travel_timE')
Hitch_a_ridE=Symbol('Hitch_a_ridE')
Share_ongoing_cosT=Symbol('Share_ongoing_cosT')
Minimize_cost_for_commutE=Symbol('Minimize_cost_for_commutE')
Take_publictransporT=Symbol('Take_publictransporT')
Average_ongoing_cosT=Symbol('Average_ongoing_cosT')
Average_travel_timE=Symbol('Average_travel_timE')
Minimize_infrastructure_cosT=Symbol('Minimize_infrastructure_cosT')
Take_own_caR=Symbol('Take_own_caR')
Minimize_time_lost_by_commutE=Symbol('Minimize_time_lost_by_commutE')
CommutinG=Symbol('CommutinG')
Take_privatetransporT=Max(Take_own_caR,Hitch_a_ridE)
Work_during_commutE=Max(0.0,Min(100.0,(100*Piecewise((100,Average_work_timE>=60.0),(abs( (Average_work_timE-5.0)/11000.0)+50,(5.0<=Average_work_timE)&(Average_work_timE<60.0)),(-abs( (Average_work_timE-5.0)/-1000.0)+50,(0.0<Average_work_timE)&(Average_work_timE<5.0)),(0,True)))/100.0))
Minimize_travel_timE=Max(0.0,Min(100.0,(100*Piecewise((100,Average_travel_timE<=20.0),(abs( (Average_travel_timE-40.0)/-4000.0)+50,(20.0<=Average_travel_timE)&(Average_travel_timE<40.0)),(-abs( (Average_travel_timE-40.0)/8000.0)+50,(40.0<Average_travel_timE)&(Average_travel_timE<80.0)),(0,True)))/100.0))
Share_ongoing_cosT=Max(0.0,Min(100.0,(100*Piecewise((100,Average_ongoing_cosT<=60.0),(abs( (Average_ongoing_cosT-100.0)/-8000.0)+50,(60.0<=Average_ongoing_cosT)&(Average_ongoing_cosT<100.0)),(-abs( (Average_ongoing_cosT-100.0)/20000.0)+50,(100.0<Average_ongoing_cosT)&(Average_ongoing_cosT<200.0)),(0,True)))/100.0))
Minimize_cost_for_commutE=Max(0.0,Min(100.0,(60*Max(0.0,Min(100.0,(100*Piecewise((100,Monthly_infrastructurecosT<=0.0),(abs( (Monthly_infrastructurecosT-50.0)/-10000.0)+50,(0.0<=Monthly_infrastructurecosT)&(Monthly_infrastructurecosT<50.0)),(-abs( (Monthly_infrastructurecosT-50.0)/90000.0)+50,(50.0<Monthly_infrastructurecosT)&(Monthly_infrastructurecosT<500.0)),(0,True)))/100.0))+40*Max(0.0,Min(100.0,(100*Piecewise((100,Average_ongoing_cosT<=60.0),(abs( (Average_ongoing_cosT-100.0)/-8000.0)+50,(60.0<=Average_ongoing_cosT)&(Average_ongoing_cosT<100.0)),(-abs( (Average_ongoing_cosT-100.0)/20000.0)+50,(100.0<Average_ongoing_cosT)&(Average_ongoing_cosT<200.0)),(0,True)))/100.0)))/100.0))
Take_publictransporT=Max(Regular_buS,Express_buS)
Minimize_infrastructure_cosT=Max(0.0,Min(100.0,(100*Piecewise((100,Monthly_infrastructurecosT<=0.0),(abs( (Monthly_infrastructurecosT-50.0)/-10000.0)+50,(0.0<=Monthly_infrastructurecosT)&(Monthly_infrastructurecosT<50.0)),(-abs( (Monthly_infrastructurecosT-50.0)/90000.0)+50,(50.0<Monthly_infrastructurecosT)&(Monthly_infrastructurecosT<500.0)),(0,True)))/100.0))
Minimize_time_lost_by_commutE=Max(0.0,Min(100.0,(50*Max(0.0,Min(100.0,(100*Piecewise((100,Average_work_timE>=60.0),(abs( (Average_work_timE-5.0)/11000.0)+50,(5.0<=Average_work_timE)&(Average_work_timE<60.0)),(-abs( (Average_work_timE-5.0)/-1000.0)+50,(0.0<Average_work_timE)&(Average_work_timE<5.0)),(0,True)))/100.0))+50*Max(0.0,Min(100.0,(100*Piecewise((100,Average_travel_timE<=20.0),(abs( (Average_travel_timE-40.0)/-4000.0)+50,(20.0<=Average_travel_timE)&(Average_travel_timE<40.0)),(-abs( (Average_travel_timE-40.0)/8000.0)+50,(40.0<Average_travel_timE)&(Average_travel_timE<80.0)),(0,True)))/100.0)))/100.0))
CommutinG=Max(Max(Regular_buS,Express_buS),Max(Take_own_caR,Hitch_a_ridE))
#Actor function
CommuteR=(Max(0.0,Min(100.0,(50*Max(0.0,Min(100.0,(100*Piecewise((100,Average_work_timE>=60.0),(abs( (Average_work_timE-5.0)/11000.0)+50,(5.0<=Average_work_timE)&(Average_work_timE<60.0)),(-abs( (Average_work_timE-5.0)/-1000.0)+50,(0.0<Average_work_timE)&(Average_work_timE<5.0)),(0,True)))/100.0))+50*Max(0.0,Min(100.0,(100*Piecewise((100,Average_travel_timE<=20.0),(abs( (Average_travel_timE-40.0)/-4000.0)+50,(20.0<=Average_travel_timE)&(Average_travel_timE<40.0)),(-abs( (Average_travel_timE-40.0)/8000.0)+50,(40.0<Average_travel_timE)&(Average_travel_timE<80.0)),(0,True)))/100.0)))/100.0))*100.0+Max(0.0,Min(100.0,(60*Max(0.0,Min(100.0,(100*Piecewise((100,Monthly_infrastructurecosT<=0.0),(abs( (Monthly_infrastructurecosT-50.0)/-10000.0)+50,(0.0<=Monthly_infrastructurecosT)&(Monthly_infrastructurecosT<50.0)),(-abs( (Monthly_infrastructurecosT-50.0)/90000.0)+50,(50.0<Monthly_infrastructurecosT)&(Monthly_infrastructurecosT<500.0)),(0,True)))/100.0))+40*Max(0.0,Min(100.0,(100*Piecewise((100,Average_ongoing_cosT<=60.0),(abs( (Average_ongoing_cosT-100.0)/-8000.0)+50,(60.0<=Average_ongoing_cosT)&(Average_ongoing_cosT<100.0)),(-abs( (Average_ongoing_cosT-100.0)/20000.0)+50,(100.0<Average_ongoing_cosT)&(Average_ongoing_cosT<200.0)),(0,True)))/100.0)))/100.0))*100.0)/150
#The function of Model
Commuting_examplE=(((Max(0.0,Min(100.0,(50*Max(0.0,Min(100.0,(100*Piecewise((100,Average_work_timE>=60.0),(abs( (Average_work_timE-5.0)/11000.0)+50,(5.0<=Average_work_timE)&(Average_work_timE<60.0)),(-abs( (Average_work_timE-5.0)/-1000.0)+50,(0.0<Average_work_timE)&(Average_work_timE<5.0)),(0,True)))/100.0))+50*Max(0.0,Min(100.0,(100*Piecewise((100,Average_travel_timE<=20.0),(abs( (Average_travel_timE-40.0)/-4000.0)+50,(20.0<=Average_travel_timE)&(Average_travel_timE<40.0)),(-abs( (Average_travel_timE-40.0)/8000.0)+50,(40.0<Average_travel_timE)&(Average_travel_timE<80.0)),(0,True)))/100.0)))/100.0))*100.0+Max(0.0,Min(100.0,(60*Max(0.0,Min(100.0,(100*Piecewise((100,Monthly_infrastructurecosT<=0.0),(abs( (Monthly_infrastructurecosT-50.0)/-10000.0)+50,(0.0<=Monthly_infrastructurecosT)&(Monthly_infrastructurecosT<50.0)),(-abs( (Monthly_infrastructurecosT-50.0)/90000.0)+50,(50.0<Monthly_infrastructurecosT)&(Monthly_infrastructurecosT<500.0)),(0,True)))/100.0))+40*Max(0.0,Min(100.0,(100*Piecewise((100,Average_ongoing_cosT<=60.0),(abs( (Average_ongoing_cosT-100.0)/-8000.0)+50,(60.0<=Average_ongoing_cosT)&(Average_ongoing_cosT<100.0)),(-abs( (Average_ongoing_cosT-100.0)/20000.0)+50,(100.0<Average_ongoing_cosT)&(Average_ongoing_cosT<200.0)),(0,True)))/100.0)))/100.0))*100.0)/150)*100.0)/100
modelName = 'Commuting_examplE' 
List=['Express_buS','Average_travel_timE','Regular_buS','Average_work_timE','Hitch_a_ridE','Monthly_infrastructurecosT','Average_ongoing_cosT','Take_own_caR']#variable list
LANG = ''
langList = ['python','c','c++','java',"javascript",'matlab','r']
def allPrint():
	for j in langList:
		LANG = str(j)
		Translate('(((Max(0.0,Min(100.0,(50*Max(0.0,Min(100.0,(100*Piecewise((100,Average_work_timE>=60.0),(abs( (Average_work_timE-5.0)/11000.0)+50,(5.0<=Average_work_timE)&(Average_work_timE<60.0)),(-abs( (Average_work_timE-5.0)/-1000.0)+50,(0.0<Average_work_timE)&(Average_work_timE<5.0)),(0,True)))/100.0))+50*Max(0.0,Min(100.0,(100*Piecewise((100,Average_travel_timE<=20.0),(abs( (Average_travel_timE-40.0)/-4000.0)+50,(20.0<=Average_travel_timE)&(Average_travel_timE<40.0)),(-abs( (Average_travel_timE-40.0)/8000.0)+50,(40.0<Average_travel_timE)&(Average_travel_timE<80.0)),(0,True)))/100.0)))/100.0))*100.0+Max(0.0,Min(100.0,(60*Max(0.0,Min(100.0,(100*Piecewise((100,Monthly_infrastructurecosT<=0.0),(abs( (Monthly_infrastructurecosT-50.0)/-10000.0)+50,(0.0<=Monthly_infrastructurecosT)&(Monthly_infrastructurecosT<50.0)),(-abs( (Monthly_infrastructurecosT-50.0)/90000.0)+50,(50.0<Monthly_infrastructurecosT)&(Monthly_infrastructurecosT<500.0)),(0,True)))/100.0))+40*Max(0.0,Min(100.0,(100*Piecewise((100,Average_ongoing_cosT<=60.0),(abs( (Average_ongoing_cosT-100.0)/-8000.0)+50,(60.0<=Average_ongoing_cosT)&(Average_ongoing_cosT<100.0)),(-abs( (Average_ongoing_cosT-100.0)/20000.0)+50,(100.0<Average_ongoing_cosT)&(Average_ongoing_cosT<200.0)),(0,True)))/100.0)))/100.0))*100.0)/150)*100.0)/100',modelName,List,LANG)
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
			Translate('(((Max(0.0,Min(100.0,(50*Max(0.0,Min(100.0,(100*Piecewise((100,Average_work_timE>=60.0),(abs( (Average_work_timE-5.0)/11000.0)+50,(5.0<=Average_work_timE)&(Average_work_timE<60.0)),(-abs( (Average_work_timE-5.0)/-1000.0)+50,(0.0<Average_work_timE)&(Average_work_timE<5.0)),(0,True)))/100.0))+50*Max(0.0,Min(100.0,(100*Piecewise((100,Average_travel_timE<=20.0),(abs( (Average_travel_timE-40.0)/-4000.0)+50,(20.0<=Average_travel_timE)&(Average_travel_timE<40.0)),(-abs( (Average_travel_timE-40.0)/8000.0)+50,(40.0<Average_travel_timE)&(Average_travel_timE<80.0)),(0,True)))/100.0)))/100.0))*100.0+Max(0.0,Min(100.0,(60*Max(0.0,Min(100.0,(100*Piecewise((100,Monthly_infrastructurecosT<=0.0),(abs( (Monthly_infrastructurecosT-50.0)/-10000.0)+50,(0.0<=Monthly_infrastructurecosT)&(Monthly_infrastructurecosT<50.0)),(-abs( (Monthly_infrastructurecosT-50.0)/90000.0)+50,(50.0<Monthly_infrastructurecosT)&(Monthly_infrastructurecosT<500.0)),(0,True)))/100.0))+40*Max(0.0,Min(100.0,(100*Piecewise((100,Average_ongoing_cosT<=60.0),(abs( (Average_ongoing_cosT-100.0)/-8000.0)+50,(60.0<=Average_ongoing_cosT)&(Average_ongoing_cosT<100.0)),(-abs( (Average_ongoing_cosT-100.0)/20000.0)+50,(100.0<Average_ongoing_cosT)&(Average_ongoing_cosT<200.0)),(0,True)))/100.0)))/100.0))*100.0)/150)*100.0)/100',modelName,List,LANG)
