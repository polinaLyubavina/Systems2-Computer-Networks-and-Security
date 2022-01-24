import ipaddress
import re
import string
import csv
import matplotlib.pyplot as plt 

#open existing file with IP info for London School of Economics
with open('lse.txt') as f:
    #create new file      
    with open('traceroute.csv', 'w') as f2:
        for line in f:
            IPaddress = line.split(' (')[1].split(')')[0]
            averageDelaysLong = line.split(')')[1].split(' ')
            
            #make an array for average delays
            averageDelays = []

            # get average delays values away from 'ms'
            for x in averageDelaysLong:
                try:
                    x = float(x)
                    averageDelays.append(x)
                except ValueError:
                    pass

            averages = sum(averageDelays) / len(averageDelays)

            #write IP address and average delay to file
            f2.write(f'{IPaddress},{averages:.2f}\n')


#separate IP addresses and average delays from the second experiment
#open existing file with IP info for London School of Economics
with open('lse2.txt') as f:
    #create new file      
    with open('traceroute2.csv', 'w') as f2:
        for line in f:
            IPaddress = line.split(' (')[1].split(')')[0]
            averageDelaysLong = line.split(')')[1].split(' ')
            
            #make an array for average delays
            averageDelays = []

            # get average delays values away from 'ms'
            for x in averageDelaysLong:
                try:
                    x = float(x)
                    averageDelays.append(x)
                except ValueError:
                    pass

            averages = sum(averageDelays) / len(averageDelays)

            #write IP address and average delay to file
            f2.write(f'{IPaddress},{averages:.2f}\n') 


#read in the data
x = []
y = []
x2 = []
y2 = []

with open('traceroute.csv', 'r') as csvfile:
    lines = csv.reader(csvfile, delimiter = ',')

    for row in lines:
        x.append(row[0])
        y.append(float(row[1]))

with open('traceroute2.csv', 'r') as csvfile:
    lines = csv.reader(csvfile, delimiter = ',')

    for row in lines:
        x2.append(row[0])
        y2.append(float(row[1]))

#creating the plot
plt.plot(x, y, color = 'g', linestyle = 'dashed', marker = 'o', label = 'first attempt')
plt.plot(x2, y2, color = 'b', linestyle = 'dashed', marker = 'o', label = 'second attempt')

plt.xticks(rotation = 25)
plt.xlabel('IP Address')
plt.ylabel('Average delay(ms)')
plt.title('Traceroute', fontsize = 10)
plt.grid()
plt.legend()
plt.show()