
# Printing variables
The `echo` command is used to display text or messages on the console or in a text file. We can also print out variables with `echo`, by prepending the variable name with a $.  
In this level we need the shell print out the  `FLAG` variable and solve this challenge. It is done using the command `echo $FLAG`.

# Setting Variables
We can also write values to the variables in Linux. To set a variable value we use the `=` operator.  
To solve this level we need to set the value of the variable `PWN` to `COLLEGE`. Thus we do `PWN=COLLEGE` to obtain the flag.

# Multi-Word variables
In Linux, When the shell sees a space, it ends the variable assignment and interprets the next word as a command. So to set the multi-word variable we need to quote it using `" "`.  
In this level we need to set the variable `PWN` to `COLLEGE YEAH` using the command `PWN= "COLLEGE YEAH"`.

# Exporting variables 
By default, variables that you set in a shell session are local to that shell process. The shell variables might have sensitive or weird data, and we don't want it leaking to other programs we run unless it explicitly should. To do this we `export` the variables. We export the variables, they are passed into the environment variables of child processes.   
`Environment variables in Linux are values that affect how applications, programs, and services behave. `  



