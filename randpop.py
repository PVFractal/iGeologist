import random



rockarr = ["Chalcedony", "Gold", "Gold", "Gold", "Dirt", "Granite", "Granite", "Granite", "Agate", "Garnet", "Amethyst", "Amethyst", "Amethyst", "Quartz", "Quartz", "Shale", "Shale", "Amethyst", "Granite", "Tiger Quartz", "Diamond", "Opal", "Berryl", "Lithite", "Vanadanite"]



def userNum():
    randomNum = random.randint(1,30)
    return str(randomNum)

def obsNum():
    randomNum = random.randint(1,99)
    return str(randomNum)

def projNum():
    randomNum = random.randint(1,6)
    return str(randomNum)

def randMarket():
    randomNum = random.randint(1,2)
    if (randomNum == 1):
        return "\'normal\'"
    else:
        return "\'auction\'"


def percentWild():
    randomNum = random.randint(1,20)
    if (randomNum != 1):
        return 'TRUE'
    else:
        return 'FALSE'

def randLat():
    randNum = (random.random() * 180) - 90
    return f"{randNum:.6f}"

def randLon():
    randNum = (random.random() * 360) - 180
    return f"{randNum:.6f}"

def randYear():
    randomNum = random.randint(2000,2021)
    return str(randomNum)

def randMonth():
    randomNum = random.randint(1,12)
    if (randomNum < 10):
        return '0' + str(randomNum)
    else:
        return str(randomNum)

def randDay():
    randomNum = random.randint(1,28)
    if (randomNum < 10):
        return '0' + str(randomNum)
    else:
        return str(randomNum)

def randRock():
    randomNum = random.randint(0,len(rockarr)-1)
    return "\'" + rockarr[randomNum] + "\'"
    

def randDate():
    return "\'" + randYear() + ":" + randMonth() + ":" + randDay() + "\'"

def randValue():
    randNum = (random.random() * 200)
    return f"{randNum:.2f}"

# print(randValue())


# base_string = "Insert Into Observation Values ("

# for i in range(0, 100):

#     full_str = (base_string + str(i)
#     + ', ' + userNum()
#     + ', \'common\''
#     + ", " + percentWild() 
#     + ", " + randLat() 
#     + ", " + randLon()
#     + ", " + randDate()
#     + ", " + randValue()
#     + ");")
#     print(full_str)


base_string = "Insert Into Observation (observer, common_name, wild, lat, lon, date, set_value) Values ("

for i in range(0, 100):

    full_str = (base_string
    + userNum()
    + ", " + randRock()
    + ", " + percentWild() 
    + ", " + randLat() 
    + ", " + randLon()
    + ", " + randDate()
    + ", " + randValue()
    + ");")
    print(full_str)



# base_string = "Insert Into Member Values ("

# for i in range(0, 100):

#     full_str = (base_string 
#     + obsNum()
#     + ', ' + projNum()
#     + ");")
#     print(full_str)

# base_string = "Insert Into ProjMember Values ("

# for i in range(0, 30):

#     full_str = (base_string 
#     + userNum()
#     + ', ' + projNum()
#     + ', ' + randDate()
#     + ");")
#     print(full_str)

# base_string = "Insert Into Sale Values ("

# for i in range(0, 30):

#     full_str = (base_string 
#     + obsNum()
#     + ', ' + randMarket()
#     + ', ' + randValue()
#     + ");")
#     print(full_str)
