# Author : Martin Smith
# Description : HW 5, CSCI 141
# Date : November 11th 2016
# Assignment : passwordChecker


# have function validatePassword
def validatePassword (userPassword) :
    import string

    #if there is a space in password, return False
    if " " in userPassword:
        return False

    #start with all values being False
    digits = False
    upperCase = False
    lowerCase = False

    #have a for loop to determine what characters are in the password
    for variable in (userPassword):
        if variable not in string.ascii_lowercase:
            if variable in string.digits:
                digits = True
            if variable in string.ascii_uppercase:
                upperCase = True
        elif variable not in string.ascii_uppercase:
            lowerCase = True

    #determine what value to return depending on what the for loop outputted
    if digits != True:
        return False
    elif upperCase != True:
        return False
    elif lowerCase != True:
        return False
    else:
        return True


# have main function
def main () :

    import string

    #have while loop
    inputtingPasswords = False

    #print explanatory statement
    print("Please input passwords one-by-one for validation.")
    print("Input END after you've entered your last password.")
    
    #have a value for the empty list
    passwordList = []
    
    #ask the user for passwords until they don't want to enter anymore
    while inputtingPasswords == False:
        passwordInput = input("")

        #add each password to the list
        passwordList.append(passwordInput)

        #when user enters "END", end the while loop
        if passwordInput == "END":
            inputtingPasswords = True

    #have a for loop to evaluate each password in the list
    for x in range(0, len(passwordList)-1):

        #evaluate if the validatePassword function returns True or False
        passwordRight = validatePassword (passwordList[x])

        #if the value returns True, tell user their password is good
        if passwordRight ==True:
            print("Password", passwordList[x], "is good.")
        else:

            #if there is a space in the password, tell user their password
            #is bad and explain why
            if " " in passwordList[x]:
                print("Password", passwordList[x],"is bad. It has a white space.")
            else:

                #have all values equal False until evaluated in for loop
                upperCase = False
                lowerCase = False
                digits = False

                #evaluate each character in each for loop to determine
                #if there is upper case, lower case, or numbers in the
                #said password
                for value in passwordList[x]:
                    if value not in string.digits:
                        if value not in string.ascii_lowercase:
                            upperCase = True
                        else:
                            if value not in string.ascii_uppercase:
                                lowerCase = True
                    else:
                        digits = True

                #based on the evaluataions, determine how to tell user why their password
                #is bad
                if digits == False:
                    print ("Password", passwordList[x], "is bad. It has no digits.")
                elif upperCase == False:
                    print ("Password", passwordList[x], "is bad. It has no upper case letters.")
                else:
                    if lowerCase == False:
                        print("Password", passwordList[x], "is bad. It has no lower casee letters.")

#declare main function
main()
