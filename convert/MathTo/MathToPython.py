import os
from MathToLang import *

class convertToPy(convertToLang):
	"""docstring for ClassName"""
	def __init__(self,func,dep,args):
		convertToLang.__init__(self,func,dep,args)
	
	'''
	def func(var1,var2):
		expr = max(var1,var2)
		return expr
	}'''

	def writeMath(self):
		#how to get file_name and Model name 
		file_name = str(self.dep)+'.py'
		with open(file_name,'w+') as file:
			writeList = []
			variables = [ str(x) for x in self.args]
			file_head = 'def '+str(self.dep)+'( '+','.join(variables)+')'+':'+'\n'
			writeList.append(file_head)

			file_expr = '\texpr = ' + str(self.func) +'\n'
			writeList.append(file_expr)
			file_return = '\t'+'return '+ 'expr'+'\n'
			writeList.append(file_return)

			file.writelines(writeList)
