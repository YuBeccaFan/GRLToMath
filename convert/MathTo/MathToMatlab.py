import os
from MathToLang import *
class convertToMatlab(convertToLang):
	"""docstring for convertToMatlab"""
	def __init__(self,func,dep,args):
		convertToLang.__init__(self,func,dep,args)

	'''
	function y = my_func(n)
	y = ...
	end
	'''
	def writeMath(self):
		#how to get file_name and Model name 
		file_name = str(self.dep)+'.m'
		with open(file_name,'w+') as file:
			writeList = []
			variables = [ str(x) for x in self.args]
			file_head = 'function '+'expr'+'='+str(self.dep)+'( '+','.join(variables)+')'+'\n'
			writeList.append(file_head)

			file_expr = '\texpr = ' + str(self.func) +'\n'
			writeList.append(file_expr)
			file_return =  'end'+'\n'
			writeList.append(file_return)

			file.writelines(writeList)