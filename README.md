SwagScii
=========
Swagscii is a program with a built in GUI that allows users to choose image files and convert them into ASCII art

Swagscii will have many features in addition to the basic ASCII art functions these include but are not limited to
  Colored ASCII art
  Size and resolution control (with suggested values)
  Support for multiple file formats
  A GUI
  
Potential features to be added in the future are:
  GIF input support
  GIF output support
  
=========
Project Structure:

Essential Classes and Objects:
  - An object class which would be the image/picture that we want to convert to ASCII grayscale. Would contain all the methods to return a grayscale ASCII
  - An object class for the colored ASCII image
  - A static class which would contain useful methods, like splitting the image into specific blocks with average value, converting to grayscale, etc..
  - A main class for running the program

=========
How project runtime should go:

- The user runs the program
- The program displays splash and whatever other goodies
- Asks whether if they would like to convert an image, gif, etc., or exit the program
- Allows user to navigate directories to find the image they would like to convert
- Asks for image specifics, i.e resolution of ASCII images, color or black and white
- Shows the user the converted image
- Asks whether user would like to put image into a jpeg, text file, etc..
- Asks whether user would like to exit or convert another image
- Perhaps allow for conversion of multiple images..
  
=========
Progress logs:
  - December 30th - some very rudimentary, conceptual pseudocode that's not even really psuedocode. Just highlighing essential        tasks necessary to be accomplished
  - January 5th - Got working essential grayscale algorithm for turning colorimages into grayscale
  - January 6th - Started working on a divide picture and get average of each "block" in image algorithms
  - January 7th - Determined detailed structure, workings, composition and orders of program and algorithms and outlined in README. Continued to try figuring out how to get block average conversion algorithm to work, which isn't yet..
  - January 8th - Finished testing the averaging grayscale function and began writing the function that divides an array into blocks.
