# Tetris
This is a tetris clone that I made a while back in my spare time. Looking back on it the design was pretty bad and was taking a 
slight performance hit as a result. It uses the Processing Framework for graphics. Processing can be downloaded here 

https://processing.org/download/ 

Libraries that need to be included in the classpath in order for proper functionality are:

core.jar
gluegen-rt.jar
jogl-all.jar

All three of these jars are located in the core/library/ directory of the download

#Overview
The center of the functionality for the game is the Game class, which inherits from PApplet. PApplet is the Processing 
application that handles drawing objects, input, etc. The Game class overrides a few of these methods, specifically settings, which
sets the initial settings for the game, setup, which runs once before the game starts, and draw, which runs every frame. All the 
pieces are implemented in their own classes and inherit from a base Piece class. Factory classes are implemented to create new
pieces. There are a few enumns to keep track of the different possible rotational positions for each piece. 

#Changes
I changed pretty much the entire design of this program. Originally, the entire program was built into 3 classes: Game, Block, 
and Piece. There was a lot of code duplication and shared resources amongst these three classes. I started by first making
each specific piece its own class, which inherit from a base Piece class. Each of these classes implement a few abstract methods,
namely rotate and setColor. setColor is part of a template method, and the rotate method is used as part of the strategy pattern
in the Controller class. All of the controls and game components were removed from the Piece and Game classes and put into a specific
Controller class. This includes things such as movements, clearing rows, checking if rows can be cleared, etc. A factory method
is used to create new pieces. Finally, I implemented a score feature to keep track of the user's score.
