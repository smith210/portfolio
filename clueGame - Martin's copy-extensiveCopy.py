# Authors : Martin Smith
# Description : Final Project, CSCI 141
# Date : November 28th 2016

#define readFile
def readFile():

    #have empty lists that will hold the values
    suspects = [ ]
    weapons = [ ]
    rooms = [ ]

    #open the file for reading
    openFile = open("murderOptions.txt", "r")

    #extract answers from the file
    for line in openFile:
        options = line.split("|")
        
        #seperate and add the suspects to the suspects list
        if options[0] == "suspects":
            for x in range(1, len(options)-1):
                suspects.append(options[x])

        #seperate and add the weapons to the weapons list
        elif options[0] == "weapons":
            for x in range(1, len(options)-1):
                weapons.append(options[x])

        #seperate and add the rooms to the rooms list
        else:
            if options[0] == "rooms":
                for x in range(1, len(options)-1):
                    rooms.append(options[x])

    #put lists into one big list, and return that value
    gameList = [suspects, weapons, rooms]

    return gameList


#define function where the game will generate
#the winning pick
def randomGenerator(bigList):

    #import the random module
    import random

    #use random function to find random number within
    #the limit of the list
    randomInteger = random.randrange(0, len(bigList))

    #return the value in the winning list based on the number
    return bigList[randomInteger]


#define the function where you give the player a playing hand
def playersHand(winningChoices, gameSetList):
    newListSuspect = []
    newListWeapon = []
    newListRoom = []
    foundSuspect = False
    foundWeapon = False
    foundRoom = False
    brandNewList = [newListSuspect, newListWeapon, newListRoom]

    for x in range(0, len(gameSetList)):
        for y in range(0, len(gameSetList[x])):
            if x == 0:
                newListSuspect.append(gameSetList[0][y])
            elif x==1:
                newListWeapon.append(gameSetList[1][y])
            
            else:
                if x==2:
                    newListRoom.append(gameSetList[2][y])
            
    for z in range(0, len(brandNewList)):
        for t in range(0, len(brandNewList[z])):
            if foundSuspect == False:
                if brandNewList[0][t] == winningChoices[0]:
                    del brandNewList[0][t]
                    foundSuspect = True
            if foundWeapon == False:
                if brandNewList[1][t] == winningChoices[1]:
                    del brandNewList[1][t]
                    foundWeapon = True
            if foundRoom == False:
                if brandNewList[2][t] == winningChoices[2]:
                    del brandNewList[2][t]
                    foundRoom = True

    return brandNewList


#define a function that will generate random numbers
def playerHandRandomGenerator (aList):

    #import random module
    import random

    #have the random number generator within a for loop
    numberList = []
    wholeList = []
    
    for x in range(0, len(aList)):
        for y in range(0, len(aList[x])):
            
            if x == 0:
                numberList.append(aList[0][y])

            elif x==1:
                numberList.append(aList[1][y])
            else:
                if x==2:
                    numberList.append(aList[2][y])

    for x in range(0,6):
        randomNumber = random.randrange(0, len(numberList))
        playerHand = numberList[randomNumber]
        del numberList[randomNumber]
        wholeList.append(playerHand)

    return wholeList


#define function where the game will generate random
#numbers that will determine which answer is revealed
#to the user
def randomNumbers():
    import random

    randomNumber = random.randrange(0,6)

    return randomNumber


#define function that determines if user's input
#for number of attempts is valid
def validAttempts(attempts):
    #import string
    import string

    #check if the user has inputted correct amount of tries. If user has correctly asked
    #for valid number of tries, break loop. Otherwise, print invalid statement.
    digits = False
    otherCharacters = False

    if attempts == (""):
        print("I'm NULL")
        return True

    for character in range(0, len(attempts)):
        if attempts[character] not in string.digits:
            otherCharacters = True

    return otherCharacters


#define function prompting user for a response
def askingUser(text, options):

    correctChoice = False
    
    while correctChoice == False:
        print(text, "Your options are:")
        print(" ")

        for x in range (0, len(options)):
            print(options[x])

        print(" ")
        userGuess = input("Your guess: ")

        for y in range (0, len(options)):
            if userGuess == options[y]:
                correctChoice = True

        if correctChoice == False:
            print("Your answer is not one of the options, please re-answer the question")
            print("======================================================")

    return userGuess


#define the main function
def main():
    #have a while loop that will have the game play
    #for an infinity amount of times until the
    #player decides to quit
    playAgain = True

    while playAgain == True:

        #invoke a function that will open game file
        allGameOptions = readFile()
        
        #once file function is invoked, use random generator to pick
        #winning pick
        winningSuspect = randomGenerator(allGameOptions[0])    
        winningWeapon = randomGenerator(allGameOptions[1])
        winningRoom = randomGenerator(allGameOptions[2])

        #once winning pick is chosen, user function playersHand to determine what's left
        #on the playing field, and put them in a new list
        usersHand = playersHand([winningSuspect, winningWeapon, winningRoom], allGameOptions)

        #when all the options are place in a new list, use function playerHandRandomGenerator
        #to generate 6 options that the player will know are not any of the winnning options
        cardsInHand = playerHandRandomGenerator(usersHand)
        

        #have a explanatory statement to player explaining how to play
        print("Welcome to Tudor Mansion. Your host, Mr John Boddy,")
        print("has met an untimely end - he's the victim of foul play.")
        print("To win this game, you must determine who murdered him,")
        print("with what weapon, and where it took place before you")
        print("run out of attempts.")
        print(" ")

        #have a while loop asking user for how many tries they want
        correctNumAttempts = False

        while correctNumAttempts == False:

            #ask the user how many tries they want
            numAttempts = input("How many attempts do you want? (choose between 5-10) ")

            #use the function validAttempts to return the value for
            #notNumbers as either True or False
            notNumbers = validAttempts(numAttempts)

            #if notNumbers == True, return error statement
            if notNumbers == True:
                print("======================================================")
                print("That is an invalid option, please re-answer the question")

            #if notNumbers == False, check to make sure the integer is qualified in
            #the asked number boundaries
            elif notNumbers == False:

                #if the number is within the number boundaries, break the while loop
                if int(numAttempts) >= 5 and int(numAttempts) <=10:
                    correctNumAttempts = True

                #if the number is not within the number boundaries, don't break the
                #while loop and print an error statement
                else:
                    print("======================================================")
                    print("That is an invalid option, please re-answer the question")
                    
        #print out the options based from the variable used for playerHandRandomGenerator
        #to show player what they should know is not the winning pick
        print(" ")
        print("Here's some discovered evidence of what is known not to be")
        print("involved in the murder so far:")
        print(" ")
        for x in range(0, len(cardsInHand)):
            print(cardsInHand[x])
        
        #have variable loser that will equal False, so that loser statement
        #isn't printed until varialble attempts equal the right value
        loser = False

        #have an incumulator value so when number of attempts run out, the
        #variable loser can equal true and the loser statement is printed
        attempts = 1

        for x in range(0, int(numAttempts)):
            print(" ")
            print("======================================================")
            print("ATTEMPT NUMBER", x+1)
            print("======================================================")
            userSuspect = askingUser("Who do you think murdered Mr Boddy?", allGameOptions[0])
            print("======================================================")
            userWeapon = askingUser("What do you think Mr Boddy was murdered with?", allGameOptions[1])
            print("======================================================")
            userRoom = askingUser("Where do you think Mr Boddy was murdered?", allGameOptions[2])

            #have variables winner and choices within the for loop so that choices is evaluated
            #within each iteration of the for loop, and so winner can be evaluated if it's true
            #or not
            winner = False
            choices = False

            #have a while loop that will iterate the answer to one of the responses
            while choices == False:
                print(" ")
                print("======================================================")
                print(" ")

                #use a random number generator that will allow whichever number it
                #chooses, will iterate the random response
                revealAnswer = randomNumbers()
        
                #option one: if the reveal answer = 0
                #order of evaluation: suspect, weapon, room
                if revealAnswer == 0:
                    if winningSuspect != userSuspect:
                        print("You discover that", userSuspect,"is not the murderer." )
                        choices = True
                        break
                    if winningWeapon != userWeapon:
                        print("You discover that the", userWeapon,"is not the weapon used to kill Mr Boddy." )
                        choices = True
                        break
                    if winningRoom != userRoom:
                        print("You discover that the", userRoom,"is not the room where Mr Boddy was killed." )
                        choices = True
                        break

                #option two: if the reveal answer = 1
                #order of evaluation: suspect, room, weapon
                elif revealAnswer == 1:
                    if winningSuspect != userSuspect:
                        print("You discover that", userSuspect,"is not the murderer." )
                        choices = True
                        break
                    if winningRoom != userRoom:
                        print("You discover that the", userRoom,"is not the room where Mr Boddy was killed." )
                        choices = True
                        break
                    if winningWeapon != userWeapon:
                        print("You discover that the", userWeapon,"is not the weapon used to kill Mr Boddy." )
                        choices = True
                        break

                #option three: if the reveal answer = 2
                #order of evaluation: weapon, room, suspect
                elif revealAnswer == 2:
                    if winningWeapon != userWeapon:
                        print("You discover that the", userWeapon,"is not the weapon used to kill Mr Boddy." )
                        choices = True
                        break
                    if winningRoom != userRoom:
                        print("You discover that the", userRoom,"is not the room where Mr Boddy was killed." )
                        choices = True
                        break
                    if winningSuspect != userSuspect:
                        print("You discover that", userSuspect,"is not the murderer." )
                        choices = True
                        break

                #option four: if the reveal answer = 3
                #order of evaluation: weapon, suspect, room
                elif revealAnswer == 3:
                    if winningWeapon != userWeapon:
                        print("You discover that the", userWeapon,"is not the weapon used to kill Mr Boddy." )
                        choices = True
                        break
                    if winningSuspect != userSuspect:
                        print("You discover that", userSuspect,"is not the murderer." )
                        choices = True
                        break
                    if winningRoom != userRoom:
                        print("You discover that the", userRoom,"is not the room where Mr Boddy was killed." )
                        choices = True
                        break

                #option five: if the reveal answer = 4
                #order of evaluation: room, weapon,suspect
                elif revealAnswer == 4:
                    if winningRoom != userRoom:
                        print("You discover that the", userRoom,"is not the room where Mr Boddy was killed." )
                        choices = True
                        break
                    if winningWeapon != userWeapon:
                        print("You discover that the", userWeapon,"is not the weapon used to kill Mr Boddy." )
                        choices = True
                        break
                    if winningSuspect != userSuspect:
                        print("You discover that", userSuspect,"is not the murderer." )
                        choices = True
                        break

                #option six: if the reveal answer = 5
                #order of evaluation: room, suspect, weapon
                else:
                    if revealAnswer == 5:
                        if winningRoom != userRoom:
                            print("You discover that the", userRoom,"is not the room where Mr Boddy was killed." )
                            choices = True
                            break
                        if winningSuspect != userSuspect:
                            print("You discover that", userSuspect,"is not the murderer." )
                            choices = True
                            break
                        if winningWeapon != userWeapon:
                            print("You discover that the", userWeapon,"is not the weapon used to kill Mr Boddy." )
                            choices = True
                            break
                        
                #if user gets the guesses right before their number of attempts run out, change value
                #of winner to True, and break the while loop
                if winningSuspect == userSuspect and winningWeapon == userWeapon and winningRoom == userRoom:
                    winner = True
                    break

            #during each turn, evaluate if the number of attempts have run out.
            #If the attempts have run out, check to make sure that the user
            #has printed a not winning pick, then make loser = True
            if attempts == (int(numAttempts)):
                if (winningSuspect != userSuspect) or (winningWeapon != userWeapon) or (winningRoom != userRoom):
                    loser = True

            #if user has not run out of attempts yet, add the value of attempts
            #and keep going until player wins game or if they've reached the max
            #number of attempts
            else:
                attempts = attempts + 1

            #if winner == True, then print winning statement, and break the for loop
            #(this is done so if the player guesses right before they run out of attempts,
            # the for loop will then break).
            if winner == True:
                print("Congratulations! With your discoveries, the police were able to arrest")
                print(winningSuspect, ", who killed Mr Boddy with the ", winningWeapon, ", in the ", winningRoom,".", sep = "")
                print(" ")
                print("You win!!")
                print(" ")
                print("======================================================")
                break

            #if the player has ran out of attempts, loser should be equal to True, and the
            #losing statement should be prined.
            else:
                if loser == True:
                    print(" ")
                    print("======================================================")
                    print(" ")
                    print("You ran out of attempts, and the murderer has evaded all")
                    print("police officials.")
                    print(" ")
                    print("GAME OVER")
                    print(" ")
                    print("The murderer was", winningSuspect)
                    print("The weapon used for the murder was the", winningWeapon)
                    print("The room where the murder took place was the", winningRoom)
                    print(" ")
                    print("======================================================")

        #have a while loop that will make the user input either "yes" or
        #"no" in their answer of yesOrNo
        validityChoice = False
        while validityChoice == False:

            #ask the user if they want to play the game again
            yesOrNo = input("Do you want to play again? (choose yes or no) ")
    
            #if the user says "yes", end yesOrNo while loop, and
            #print restarting phrase
            if yesOrNo == "yes":
                validityChoice = True
                print(" ")
                print("RESTARTING")
                print(" ")
                print("======================================================")

            #if the user says "no", end yesOrNo while loop, print
            #quitting statement, and end the playAgain while loop
            elif yesOrNo == "no":
                validityChoice = True
                print(" ")
                print("Thanks for playing")
                print("QUITTING")
                playAgain = False
                break

            #if the player decides to enter anything else, return
            #an error statement, and keep yesOrNo while loop running
            else:
                if yesOrNo != "yes" or yesOrNo != "no":
                    print("That is an invalid option, please re-answer the question")
                    print(" ")
    

#invoke main function
main()
