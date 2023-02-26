# Tennis Game
This is an implementation of a simplified Tennis game as described in [here](https://codingdojo.org/kata/Tennis/). 

### Setup
**Note**: This project was built with IntelliJ IDEA 2022.2.3 (Community Edition)

These are the requirements needed to run this project:

**Java version**: Java 1.8

### Run the application
If you are using Intellij, you can run this program by running the class `Application.java`.

Otherwise, follow these steps using a command prompt:
- Go to the root folder
- Run the following command to compile the java files: `javac -cp src -d bin /src/main/java/com/kata/tennis/*.java src/Application.java`
- Run the following command to execute the program: `java -cp bin Application`

### Getting started
To start the game, the program calls the method `startGame` that takes as an argument (`probaPlayer1WinsPoint`): the probability of player 1 winning a point in the game. 
You can change it to any double between 0 and 1 to simulate multiple behaviours.  

The console should display the players' scores at each point of the game.


