

#open existing file with ping data for London School of Economics
with open('lseping.txt') as f:
    #create new file      
    with open('ping.csv', 'w') as f2:
        for line in f:
            if 'timeout' in line or 'PING' in line:
                continue
            if '---' in line:
                break
            ttlRoundtripDelay = line.split(' ')[6].split('=')[1]

            x = float(ttlRoundtripDelay)

            #write IP address and average delay to file
            f2.write(f'{x:.2f}\n') 
