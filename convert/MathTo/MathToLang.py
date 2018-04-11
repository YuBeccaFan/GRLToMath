''' the father class '''
#MathToLang.py
import os

class convertToLang(object):

	def __init__(self,func,dep,args):
		self.func = func
		self.dep = dep
		self.args = args

	def writeMath(self):

		file_name = str(dep)+'/'+str(dep)
		if not os.path.exists(str(dep)):
			os.makedirs(str(dep))
		with open(file_name,'w+') as file:
			writeList = []
			file.writelines(writeList)