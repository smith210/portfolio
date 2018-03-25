#assignment: monopolyGame

#define another function
def readFile():

    fileOpen = open("monopolyGameTiles.txt", "r")

    emptyList = []

    for number in fileOpen:
        tile = number.split("|")

        emptyList.append(tile[:(len(tile)-1)])

    return emptyList
        

#define numberGenerator function
def numberGenerator(number,aList):

    if number > 40:
        variable = number - 40

    elif number == 40:
        variable = 0

    else:
        variable = number

    return variable

#define dice rolling function
def twoDice():

    #import random module
    import random

    #using random module, pick number of dice One
    dice = random.randrange(1,7)

    return dice


#define money calculating function
def calculateMoney(tile):
    if tile == 1 or tile == 3:
        money = 60
    elif tile == 5 or tile == 15 or tile == 19 or tile == 25 or tile == 35:
        money = 200
    elif tile == 6 or tile == 8:
        money = 100
    elif tile == 9:
        money = 120
    elif tile == 11 or tile == 13:
        money = 140
    elif tile == 12 or tile == 28:
        money = 150
    elif tile == 14:
        money = 160
    elif tile == 16 or tile == 18:
        money = 180
    elif tile == 21 or tile == 23:
        money = 220
    elif tile == 24:
        money = 240
    elif tile == 26 or tile == 27:
        money = 260
    elif tile == 29:
        money = 280
    elif tile == 31 or tile == 32:
        money = 300
    elif tile == 34:
        money = 320
    elif tile == 37:
        money = 350
    elif tile == 39:
        money = 400
    else:
        money = 0

    return money
    

#define main function
def main():

    #have a function that will open and read the file
    gameBoard = readFile()

    #print introductory statement
    print("Welcome to Monopoly! Your objective:")
    print("buy as much property as you can as you")
    print("go around the board. :)")

    print("you'll start the game at", gameBoard[0][0])

    isItRolling = False
    playingGame = True
    inJail = False
    

    while playingGame == True:

        runningOnBoard = 0

        while isItRolling == False:

            if inJail == False:
                diceRolling = input("type \"roll\" to roll the dice ")

            if diceRolling != "roll":
                print(" ")

            else:
                if diceRolling == "roll":
                    if inJail != True:
                        passedGo = False

                        print(" ")

                        diceOne = twoDice()
                        diceTwo = twoDice()

                        valueDice = diceOne + diceTwo

                        print("You've rolled a", valueDice)

                        if diceOne == diceTwo:
                            print("You've rolled doubles!")

                        #use numberGenerator function to determine
                        #where the player will end up on the board
                        
                        runningOnBoard = runningOnBoard + valueDice

                        if runningOnBoard >= 40:
                            runningOnBoard = runningOnBoard - 40
                            passedGo = True

                        placeOnBoard = numberGenerator(runningOnBoard, gameBoard)

                        print("You land on",gameBoard[0][placeOnBoard])

                        boardTile = gameBoard[0][placeOnBoard]

                        moneyWorth = calculateMoney(placeOnBoard)

                        if passedGo == True:
                            print("Woo! You passed START! You gain $200!")

                        if moneyWorth != 0:
                            print("You can buy this property for $", moneyWorth, sep = "")

                        else:
                            if moneyWorth == 0:
                                if placeOnBoard == 4:
                                    print("Oh no! You have to pay $200!")
                                elif placeOnBoard == 30:
                                    print("Oh no! You have to go to Jail.")
                                    runningOnBoard = 10
                                    inJail = True
                                elif placeOnBoard == 38:
                                    print("Oh no! You have to pay $100")
                    else:
                        if inJail == True:
                            print("You must roll doubles or decide to pay $50")
                            print(" ")
                            jailChoiceInput = False
                            attempts = 1
                            
                            while jailChoiceInput == False:
                                jailedChoice = input("Which do you choose? (pay or roll) ")

                                if jailedChoice == "pay":
                                    jailChoiceInput = True
                                    inJail = False
                                    break
                                elif jailedChoice == "roll":
                                    jailChoiceInput = True

                                    diceThree = twoDice()
                                    diceFour = twoDice()

                                    doublesDice = diceThree + diceFour

                                    if attempts != 3:
                                        if diceThree == diceFour:
                                            print("Congrats, you rolled doubles and now you are out of jail")
                                            print(" ")
                                            inJail = False
                                            break
                                        elif diceThree != diceFour:
                                            print("Oh that sucks, you did not roll doubles and you're still in jail. :(")
                                            attempts = attempts + 1
                                            print(" ")
                                            jailChoiceInput = False
                                            
                                    else:
                                        if attempts == 3:
                                            print("Aw damn, you ran out of attempts, now you have to pay :'(")
                                            print(" ")
                                            jailChoiceInput = True
                                            inJail = False
                                            break
                                    
                                else:
                                     print("That is not one of your choices, please reanswer the question.")

                    
main()
