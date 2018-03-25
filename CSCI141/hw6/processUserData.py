# Author : Martin Smith
# Description : HW 6, CSCI 141
# Date : November 18th 2016

#have the print statement
def statement():
    print("=========================")
    print("Select an analysis option")
    print(" ")
    print("1. Perform a keyword count from the answers to question 3")
    print("2. Calculate the average months of coding experience")
    print("3. Calculate average months of coding experience for users with")
    print("   a specific keyword in their answer to question 3")
    print("4. Calculate percentage of respondents familiar with for loops")
    print("5. Quit")
    print(" ")


#have a function computing qualities of question one
def one(word, values):
    #have accumulator value for number of people to start at 0
    people = 0

    #have a for loop to evaluate each value in the list
    for x in range(0, len(values)):
        if x == 2:
            #have a for loop to evaluate each value in the sublist
            for y in range(0, len(values[x])):
                #if the word is in value, accumulate the value of people
                if word in values[2][y]:
                    people = people + 1

    #print the answer out
    print("There were", people, "mention(s) of ", end = "")
    print("\"", word, "\"", sep = "")
    
#have a function computing qualities of question two
def two(values):
    #import the string function
    import string

    #have accumulartor values for number of people and months
    months = 0
    people = 0

    #have for loop to evaluate the three lists
    for x in range(0, len(values)):
        if x == 0:
            #in the list, evaluate each value in the sublist
            for y in range(0, len(values[x])):
                people = people + 1

                #make sure before adding up months, make sure that
                #the answer is ONLY a number, there cannot be any
                #letters in the value
                if values[x][y] in string.digits:
                    if values[x][y] not in string.ascii_letters:
                        months = months + int(values[x][y])
                
    #compute calculations based on values of months and people
    averageMonthsWhole = str(months//people)
    averageMonthsDecimal = str((months/people)%1)

    averageMonths = averageMonthsWhole + averageMonthsDecimal[1:4]

    #print the answerr out
    print("The average months coding is", averageMonths)

#have a function ccomputing qualities of question three
def three(phrase, values):
    #import the string function
    import string

    #have accumulator values for number of people and months
    people = 0
    months = 0

    #have for loop to evaluate the three lists
    for x in range(0, len(values)):
        if x == 0:
            #in the list, evaluate each value in the sublist
            for y in range(0, len(values[x])):

                #determine if the phrase is in any of the values
                if phrase in values[2][y]:
                    people = people +1

                    #determine if the only variable in the list calculated are
                    #numbers
                    if values[x][y] in string.digits:
                        if values[x][y] not in string.ascii_letters:
                            months = months + int(values[x][y])


    #calculate the values of months and compute into a string if one or
    #more people said the phrase
    if people != 0:
        
        averageMonthsWhole = str(months//people)
        averageMonthsDecimal = str((months/people)%1)

        averageMonths = averageMonthsWhole + averageMonthsDecimal[1:4]

    #if no one said the phrase, then the number of months should equal 0
    #to avoid error
    else:
        averageMonths = 0

    #print the answer out
    print("The average months coding experience is", averageMonths) 


#have a function computing qualities for question four
def four(values):
    #have accumulator values determining how many people responded
    #with "yes" or "no"
    yes = 0
    no = 0

    #have a for loop to evaluate the three lists
    for x in range(0, len(values)):
        if x == 1:
            #in the list, evaluate each value in the sublist
            for y in range(0, len(values[x])):
                #determine if the slice value of [0] is equal to "n"
                #then accumulate the value of no
                if values[x][y][0] == "n":
                    no = no + 1
                #if the slice value of [0] is not equal to "n", accumulate
                #the value of yes
                else:
                    if values[x][y][0] == "y":
                        yes = yes + 1

    #have the caluculations to compute the percentage for for loops
    totalAnswers = yes + no
    percentageCalc = (yes / totalAnswers)*100
    wholeNumbers = int(percentageCalc//1)
    decimalNumbers = str(percentageCalc%1)
    recalcPercentage = str(wholeNumbers) + "." + decimalNumbers[0] + "%"

    #print out the answer
    print("% respondents familiar with for loop :", recalcPercentage)

        
def main():
    #have a while loop to make sure that function runs
    youreAQuitter = False

    #ask the user the name of the file
    fileInput = input("What is the name of the data file ")

    #invoke the file function, save as a variable
    studentResponses = (listingItUp(fileInput))

    while youreAQuitter == False:
        #invoke statement explaining program
        statement()
        #ask user what analysis they want of program
        userInput = input("What analysis do you want to perform? ")

        #depending on what user answered, respond accordingly with
        #functions computing the analysis
        if userInput == "1":
            wordMentioned = input("What is the keyword? ")
            one(wordMentioned, studentResponses)
        elif userInput == "2":
            two(studentResponses)
        elif userInput == "3":
            keyWord = input("What is the keyword in the response to answer to question 3? ")
            three(keyWord, studentResponses)
        elif userInput == "4":
            four(studentResponses)
        elif userInput == "5":
            youreAQuitter = True

        #if the user has inputted none of the above, return
        #error statement
        else:
            print("That is an invalid option")


#define getting the file function
def listingItUp(file):
    
    #list that will hold the user data lists (inventory)
    numberHours = [ ]
    forLoop = [ ]
    occupation = [ ]

    #open the file for reading
    fileInput = open(file, "r")

    #extract answers from the file
    for line in fileInput:
        answers = line.split("|")

        for x in answers:
            if x == answers[0]:
                numberHours.append(answers[0])

            elif x == answers[1]:
                forLoop.append(answers[1])

            else:
                if x == answers[2]:
                    occupation.append(answers[2])

    #create a list with all the other lists inside
    template = [numberHours, forLoop, occupation]

    #return the list with the sublisted answers
    return template
        
main()
