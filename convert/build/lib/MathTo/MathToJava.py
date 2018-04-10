import os
from MathToLang import *
'''
func is the formula of the model
args is all the variables and root of the Model
'''	
class convertToJava(convertToLang):
	"""docstring for ClassName"""
	def __init__(self,func,dep,args):
		convertToLang.__init__(self,func,dep,args)
		
	def writeMath(self):
		#how to get file_name and Model name 
		file_name = str(self.dep)+'.java'
		with open(file_name,'w+') as file:
			writeList = []
			writeList.append('public class Model{\n')
			variables = ['double ' + str(x) for x in self.args]

			file_head = '\t'+'public ' + 'double ' + str(self.dep) +'('+','.join(variables)+')'+'{'+'\n'


			writeList.append(file_head)
			file_expr = '\t\tdouble expr = ' + str(self.func) +';'+'\n'
			writeList.append(file_expr)
			file_return = '\t\t'+'return '+ 'expr'+';'+'\n'
			writeList.append(file_return)
			writeList.append('\t}\n')
			writeList.append('}\n')
			#print writeList
			file.writelines(writeList)

