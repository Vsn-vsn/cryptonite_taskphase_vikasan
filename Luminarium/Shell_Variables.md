
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
>Environment variables in Linux are values that affect how applications, programs, and services behave.  
`sh` is a minimal shell implementation that invoked as a child of the main shell process.  
  

In this level we first navigate to `cd /challenge` to set the `PWN` variable as COLLEGE and `COLLEGE` variable as PWN.
```
export PWN=COLLEGE
COLLEGE=PWN
./run
```
The variable `COLLEGE` is not inherited by `/challenge/run` but variable `PWN` is. Hence we obtain the flag.

# Printing exported variables
The `env` command allows you to display your current environment or run a specified command in a changed environment. It displays or modifies environment variables.  
In this level we need to use the `env` command to find the flag. We do so by using the command `env $FLAG`, where `$` is used to access the variable value.

# Storing command output
In practice, we will often want to store the output of some command into a variable. The shell makes this quite easy using something called *Command Substitution*. *Command substitution* is a technique that allows us to execute a command within another command and use the output of the executed command as part of the outer command's argument.  
In this level we need to read the output of `/challenge/run` command directly into a variable called `PWN`, and it will contain the flag. We thus run the command `PWN=$(/challenge/run)` to store the flag value that was the output of `/challenge/run` in the variable `PWN`. Then we read the variable to obtain the flag using the command `echo $PWN`.

# Reading Inputs
The `read` command is a built-in shell utility that allows us to read user input from the standard input and store it in variables.  
*syntax:* `read [options] variable1 variable2 ...`.  
Common options used with the `read` command are-
 1. `-p` prompt: Sets a prompt to display before reading input. eg: `read -p "INPUT: " MY_VARIABLE`
 2. `-s`: Reads input silently (without echoing characters to the screen).
 3. `-n n`: Reads at most n characters.
 4. `-t` timeout: Sets a timeout in seconds.  
   
 Example:
```
 INPUT: hacker@dojo:~$ read MY_VARIABLE
 INPUT: Hello!
 INPUT: hacker@dojo:~$ echo "You entered: $MY_VARIABLE"
 OUTPUT: You entered: Hello!
```
In this level we use the command `read PWN` and then as the cursor goes to the next line as we hit ENTER we set the value `COLLEGE` by typing it and ENTERing. Thus we obtain the flag.

# Reading files
We can also combine the redirecting of files into command input and the `read` command to read user input to read file.  
In this level we read `/challenge/read_me` into the `PWN` environment variable, and we'll get the flag. This can be done by the command `read PWN < /challenge/read_me` to redirect the output of `/challenge/read_me` into the `read` input of `PWN` variable.
