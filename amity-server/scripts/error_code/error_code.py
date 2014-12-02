import sys, re, os

def generate_java_header(f):
	header = '''package com.jingyusoft.amity.common;

public abstract class ErrorCodes {

'''
	f.write(header)

def generate_java_footer(f):
	footer = '''}
'''
	f.write(footer)

def generate_java_line(f, code, name):
	f.write('\tpublic static final int ' + name + ' = ' + code + ';' + os.linesep)


fin = open(sys.argv[1], 'r')
fout = open(sys.argv[2], 'w')

generate_java_header(fout)

for line in fin:
	m = re.split('\s+', line)
	code = m[0]
	name = m[1]
	if code != "" and name != "":
		generate_java_line(fout, code, name)

generate_java_footer(fout)