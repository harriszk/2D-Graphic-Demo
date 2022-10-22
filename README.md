This project is a graphing calculator. You can graph any equation that takes the form
f(x) = ax^i + bx^j + cx^k where the user can define a, b, c, i, j, and k. The calculator
does the math to find each y and it is correct however, when translating from (0, 0) to
my defined origin it is off by a bit. I cannot find out why it is this way. So the accuracy
of the curve is correct but where it is located in space may not be. I wanted to have the
scaling be 'wrappable' in the sense that you would only every see at most 5 division of the quadrants
and you know the scale from labeled units. I also wanted to have the user input any equation 
and then have a parser to decide if the function is valid and how to solve it but I didn't. 

To compile and run the program you can enter 'make' into the command line to generate the
.class files and 'make run' to run the program. You will need to have Java installed on your
machine. 