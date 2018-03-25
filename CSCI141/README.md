# CSCI141

### About:
Intended for students majoring in computer science. Basic concepts of computer programming using an object oriented programming language. 
Topics covered: introduction to the development environment, introduction to algorithms, elements of a programming language, including 
data types, packages, control structures, procedures and functions, basic input and output, arrays and records, text files, strings, 
variant records. Algorithm development, problem solving and software engineering are emphasized. Programming is required in implementation 
of concepts. Lab.

### Files:
**hw5**
   
   Includes file passwordChecker.py. Goal of this assignment was to understand defining functions outside main. Program asks user to type in
a password, and if it satisifies the cases, the program will alert the user if their input satisifies the password parameters or not.

**hw6**
   
   Includes files processUserData.py, and two text files called studentResponses.txt & studentResponsesBrief.txt. Goal of the assignment
was to be able to effectively implement functions by parsing in a file. What the file does is that it asks the user which text file it 
wants to impelement into the program, which after asking the text file it'll parse it through. The program then can perform various tasks
for the user asking about the data.

**finalProject**
   
   A partner project, the goal was to implement all the content we learned in the course and create our own code. The files include
clueGame.py & murderOptions.txt. Parsing the file murderOptions.txt, the program randomly selects 3 items from the file making it
the options the user has to guess. The program asks for the number of attempts the user wants, and after it asks, the program prints
six options of what is not the right answers. The program is a guessing game, where the program will tell the user if they got the 
right combination of answers or not. If the user doens't get the right combination of answers within their number of tries, the program
will let the user know they lost and print out the right combination. The program goes on until the user wants to end the game.

**monopoly**

   A ridiculous little file that I used to practice coding and understanding concepts. The files include monopolyGame.py and
monopolyGameTiles.txt. The program parses the text file, and then sets up the game. When the user inputs the right input, the 
program will "roll" its dice, and move the player around the board. The program then does the following:
  * If the player passes completely around the board, the program prints a statement letting the user know they passed "GO".
  * If the player lands on a property, the program will let the user know what the property is and how much it costs.
  * If the player lands on "GO TO JAIL", the program will then place you on jail, where the user can either pay or attempt to roll 
    doubles to get out of jail.

   The program is considered incomplete, as there is not a way (yet) for the user to exit the program.
