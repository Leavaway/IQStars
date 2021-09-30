## Code Review

Reviewed by: Xiao Mu, u7375367

Reviewing code written by: Jiayong Zhu u7374681

Component: https://gitlab.cecs.anu.edu.au/u7374681/comp1110-ass2-thu16m/-/blob/master/src/comp1110/ass2/gui/Viewer.java#L43-322

### Comments 

The code divided the game state string into separate strings, storing them in the piece arraylist to move them, and display images in correct position.
The code comments well, but some variables are takes some time to understand(e.g. boolean com means complicated game state string consists both piece and wizard).
It has good class and method structure. However, some code seems to be duplicated because there are many color of piece and wizard, and might be improved by writing it as a method.
It follows Java code conventions, and style is consistent throughout the code.
The code seems no error at the moment.


