import os
import webbrowser, os

n = []
m = []
b = []
solution = []
time = []

avg = 0

#paths
p = os.getcwd()
i1 = os.path.join(p,"in","1i.txt")
i2 = os.path.join(p,"in","2i.txt")
i3 = os.path.join(p,"in","3i.txt")
i4 = os.path.join(p,"in","4i.txt")

o1 = os.path.join(p,"out","1o.txt")
o2 = os.path.join(p,"out","2o.txt")
o3 = os.path.join(p,"out","3o.txt")
o4 = os.path.join(p,"out","4o.txt")

#get data to table:
#in:

f = open(i1,'r')
line = f.read().split()
n.append(line[0])
m.append(line[1])
b.append(line[2])
f.close()

f = open(i2,'r')
line = f.read().split()
n.append(line[0])
m.append(line[1])
b.append(line[2])
f.close()

f = open(i3,'r')
line = f.read().split()
n.append(line[0])
m.append(line[1])
b.append(line[2])
f.close()

f = open(i4,'r')
line = f.read().split()
n.append(line[0])
m.append(line[1])
b.append(line[2])
f.close()


#out
f = open(o1,'r')
solution.append(f.readline())
time.append(f.readline())
f.close()

f = open(o2,'r')
solution.append(f.readline())
time.append(f.readline())
f.close()

f = open(o3,'r')
solution.append(f.readline())
time.append(f.readline())
f.close()

f = open(o4,'r')
solution.append(f.readline())
time.append(f.readline())
f.close()

for i in time:
	avg = avg + int(i)
avg = avg / 4
	
#send data to .html
f = open('index.html','w')
message = """<!DOCTYPE html>
<html>
<head>
<title>Podsumowanie</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h3>WYNIKI DZIALANIA ALGORYTMU</h3>

<table style="width:100%">
<tr>
    <th>n</th>
    <th>m</th>
    <th>b</th>
    <th>b-pierwsze</th> 
    <th>czas [ms]</th> 
</tr>

"""
f.write(message)

for j in range(0,4):
    f.write("<tr>")
    f.write("<td>")
    f.write(n[j])
    f.write("</td>")

    f.write("<td>")
    f.write(m[j])
    f.write("</td>")

    f.write("<td>")
    f.write(b[j])
    f.write("</td>")

    f.write("<td>")
    f.write(solution[j])
    f.write("</td>")

    f.write("<td>")
    f.write(time[j])
    f.write("</td>")
    f.write("</tr>")
    

message = """
</table>"""
f.write(message)

f.write("Sredni czas pracy programu: " + str(avg))

message = """
</body>
</html>"""
f.write(message)

webbrowser.open('file://' + os.path.realpath('index.html'))

f.close()
