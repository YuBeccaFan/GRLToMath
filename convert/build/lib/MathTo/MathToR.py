import os
from MathToLang import *

class convertToR(convertToLang):
	"""docstring for ClassName"""
	def __init__(self,func,dep,args):
		convertToLang.__init__(self,func,dep,args)

	'''
	myfunction <- function(a,b){
		
	}
	'''
	def writeMath(self):
		#how to get file_name and Model name 
		file_name = str(self.dep)+'/'+str(self.dep)+'.r'
		if not os.path.exists(str(self.dep)):
			os.makedirs(str(self.dep))
		with open(file_name,'w+') as file:
			writeList = []
			variables = [ str(x) for x in self.args]
			file_head = str(self.dep)+' <- '+'function'+'( '+','.join(variables)+')'+'{'+'\n'
			writeList.append(file_head)

			file_expr = '\texpr = ' + str(self.func) +" "
			writeList.append(file_expr)
			#file_return = '\t'+'return '+ 'expr'+'\n'
			#writeList.append(file_return)
			writeList.append('}')
			file.writelines(writeList)