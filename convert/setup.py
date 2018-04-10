from setuptools import setup, find_packages  
  
setup(  
    name = "MathTo",  
    version = "1.0",  
    keywords = ("MathTo"),  
    description = "convert",  
    long_description = "convert to Lang",  
    license = "MIT Licence",  
  
     
    author = "Yuxuan Fan",  
    author_email = "filuwan@gmail.com",  
  
    #packages = find_packages(),
    packages = ['MathTo'],
    include_package_data = True,  
    platforms = "any",  
    install_requires = [],  
  
    scripts = []
    # entry_points = {  
    #     'console_scripts': [  
    #         'test = test.help:main'  
    #     ]  
    #}  
)
