import os
from MathToLang import *

class convertToC(convertToLang):
	"""docstring for ClassName"""
	def __init__(self,func,dep,args):
		convertToLang.__init__(self,func,dep,args)

	def writeMath(self):
		#how to get file_name and Model name 
		file_name = str(self.dep)+'.c'
		with open(file_name,'w+') as file:
			writeList = []
			writeList.append('#include <stdio.h>\n\n')
			variables = ['double ' + str(x) for x in self.args]
			file_head = 'double '+str(self.dep)+'( '+','.join(variables)+')'+'{'+'\n'
			writeList.append(file_head)

			file_expr = '\tdouble expr = ' + str(self.func) +';'+'\n'
			writeList.append(file_expr)
			file_return = '\t'+'return '+ 'expr'+';'+'\n'
			writeList.append(file_return)
			writeList.append('}\n')

			file.writelines(writeList)