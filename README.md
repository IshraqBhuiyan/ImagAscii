SwagScii
=========
Swagscii is a program with a GUI output, as well as file output that allows users to choose image files and convert them into ASCII art.

Program currently outputs .png for image files and .txt for text files.

To Run The Program: 
   - `java Drive` for full guided tutorial
   - `java Drive -h` or `java Drive --help` for help

Swagscii will have many features in addition to the basic ASCII art functions these include but are not limited to
  - Font and resolution(scale) control (with suggested values)
  - Support for multiple file formats
  - A GUI ouput of ASCII image
  
Potential features to be added in the future are:
  - GIF input support
  - GIF output support
  - Color Ascii Art
  

Progress logs:
   - December 30th - some very rudimentary, conceptual pseudocode that's not even really psuedocode. Just highlighing essential        tasks necessary to be accomplished
   - January 5th - Got working essential grayscale algorithm for turning colorimages into grayscale
   - January 6th - Started working on a divide picture and get average of each "block" in image algorithms
   - January 7th - Determined detailed structure, workings, composition and orders of program and algorithms and outlined in README. Continued to try figuring out how to get block average conversion algorithm to work, which isn't yet..
   - January 8th - Finished testing the averaging grayscale function and began writing the function that divides an array into blocks.
   - January 9th - Finished the basic version of grayscale ascii art - YAY
   - January 10th - Made the object class to hold image, and other essential classes..
   - January 11th - Attended Robotics competition at Francis Lewis HS, so nothing today, as of yet....
   - January 12th - Started organizing project into non-testing, final organization and configuration, and also worked on methods for converting RGB to appropriate Hex format for implementation of Colored Ascii art
   - January 13th - Began working on reading gif images so that they can be converted to ascii animations and also started working on user program interface, which will include options for a guided walkthrough for user or just using appropriate flags if user knows how to use the program.
   - January 14th - Continue working on main program interface and continue working on reading gif files and other image types in a better manner using ImageReader and ImageIO and other cool things.
   - January 15th - Began writing image outputting and realized that we have a lot of work left to do. Also finished gif reading and started gif writing from an arraylist of bufferedImages.
   - January 16th - continue working on refining breaking functions, reading gifs and etc
   - January 17th to 19th - work on image output, potential gif output(if possible), gui output, solidifying other structures, unifying functions
   - January 20th - finalize code, come up with multiple image output methods, choose screenshotting instead of Graphics 2D due to mysterious warping issue, finalize primary code.
  
=========
To Do List:
   - Determine ranges for Ascii character chart
   - Gif input processing
   - Reworking Image Input Processing to work more fluidly with gifs
   - Image Output Processing needs to be implemented
   - Giving color to Ascii images
   - Should we perhaps scale output image sizes using font sizes, or nahh?
   - Command line user interface needs to be finished
   - Let's make a logo/Splash!
   - Write breakblock for colored images(can't we just have a boolean parameter in our current breakblock which when true will do grayscale conversion, and when not, will just normally average without conversion, easy peasy)(Also, we essentially just need to write a universal average function)
   - Write a function for getting rgb from the binary data of normal buffered image getRGB function and then functions for averaging the red, the green and the blue and then returning one rgb with the average of all three
