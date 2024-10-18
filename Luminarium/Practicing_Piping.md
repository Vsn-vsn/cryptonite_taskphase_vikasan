> Piping in Linux is a powerful feature that allows you to chain multiple commands together, sending the output of one command as the input to another. This helps create efficient workflows by processing data step-by-step without needing to store intermediate results in temporary files.

# Redirecting output
The redirect stdout(standard output) to files is done with the `>` character. For example `echo hi > asdf` will redirect the output of `echo hi` to the file `asdf`.  
In this level we have to redirect the word 'PWD' into another file 'COLLEGE'. We do `echo "PWN" > COLLEGE` to obtain the flag.

# Redirecting more output
Aside from redirecting the output of echo, we can redirect the output of any command.  
In this level, `/challenge/run` will once more give us a flag only if we redirect its output to the file myflag. Thus we run `/challenge/run > myflag` to pass all the tests performed. Once we pass, it is shown and we use `cat myflag` to obtain the flag.

# Appending Output
We might want all that output to keep appending to the same file, but `>` will create a new output file every time, deleting the old contents. We can redirect input in append mode using `>>` instead of `>`.  
In this level we need to run `/challenge/run` with an append-mode redirect of the output to the file `/home/hacker/the-flag`. The practice will write the first half of the flag to the file, and the second half to stdout if stdout is redirected to the file. If we properly redirect in append-mode, the second half will be appended to the first, but if we redirect in truncation mode (>), the second half will overwrite the first and we won't get the flag.  
Hence we first navigate to `cd /challenges` and then we do `./run >> /home/hacker/the-flag` to obtain the flag without any overwriting. 

# Redirecting errors
We can also redirect the error channel of commands. Here, we'll learn about File Descriptor numbers. A File Descriptor (FD) is a number the describes a communication channel in Linux.
1. FD 0: Standard Input
2. FD 1: Standard Output
3. FD 2: Standard Error
   
When we redirect process communication, we do it by FD number. But some FD numbers need not be written explicitly. For example, a `>` without a number implies `1>`, which redirects FD 1 (Standard Output), both the usages yield the same result.  
If we have a command that might produce data via standard error, then we can redirect those errors. For example `run 2> errors.log` will redirect standard error (FD 2) to the `errors.log` file.   
In this level, we need to redirect the output of `/challenge/run`, to `myflag`, and the "errors" to `instructions`. So we write the command `/challenge/run >myflag 2>instructions` to redirect the flag into `myflag` file and errors into the `instructions` file.

# Redirecting input
We can redirect input to programs! This is done using `<`.  
In this level, we will practice using `/challenge/run`, which will require us to redirect the `PWN` file to it and have the `PWN` file contain the value `COLLEGE`.  
Hence at first we write the PWN file by `echo COLLEGE >> PWN` and then we run `/challenge/run < PWN` to obtain the flag.

# Grepping stored results
The grep command is a powerful tool used to search for patterns within text files.  
In this level we need to redirect the output of `/challenge/run` to `/tmp/data.txt`. This will result in a hundred thousand lines of text, with one of them being the flag, in `/tmp/data.txt`. We need to `Grep` that for the flag.  
So we first redirect using `/challenge/run >> /tmp/data.txt` and then we obtain the flag by doing `grep 'pwn' /tmp/data.txt`.

# Grepping live output
We can use this using the `|` (pipe) operator to avoid the need to store results to a file.  Standard output from the command to the left of the pipe will be connected to (piped into) the standard input of the command to the right of the pipe.  
In this level we need to run `/challenge/run` will output a hundred thousand lines of text, including the flag. We need to grep for the flag from that.  
First we navigate to `cd /challenge` and then obtain the flag by running `./run | grep 'pwn.college' `.

# grepping errors
The `>` operator redirects a given fd to a file, and we've used `2>` to redirect `fd 2`, the standard error. The `|` operator redirects only standard output to another program, and there is no `2|` form of the operator. It can only redirect standard output. However, the shell has `>&` operator, which redirects a file descriptor to another `fd`. We can have a two-step process to `grep` through errors: At first, we redirect standard error to standard output `2>& 1` and then pipe normally using `|`.  
In this level we need to redirect the error using `2>& 1` command. At first we need to navigate to `cd /challenge` and then we follow the command `./run 2>& 1 | grep pwn.college` to obtain the flag. The stderr is redirected to the stdout and then we can easily `grep` to get our flag.

# Duplicating piping data with tee
The `tee` command in Linux is a utility that allows you to redirect the output of a command to both a file and standard output simultaneously. This is useful when we want to see the data as it flows through between the commands to debug undesired outcomes. The `tee` command, named after a "T-splitter" from plumbing pipes, duplicates data flowing through our pipes to any number of files specified.   
Here we do `/challenge/pwn | tee check | /challenge/college`  to monitor the output of pwn to `check` file and the terminal. The we use `cat check` to get the hint in finding the flag. The contents display the hint that we need to use  
Usage: /challenge/pwn --secret [SECRET_ARG]
SECRET_ARG should be "U3WQ7YK_"  
The we use the command `/challenge/pwn --secret U3WQ7YK_ | /challenge/college` to obtain the flag.

# Writing to multiple programs
We can duplicate our files with `tee` command. Linux follows the philosophy that "everything is a file". This is, the system strives to provide file-like access to most resources, including the input and output of running programs.The shell follows this philosophy, allowing you to, for example, use any utility that takes file arguments on the command line (such as tee) and hook it up to the input or output side of a program. This is done using what's called `Process Substitution`. If you write an argument of `>(rev)`, bash will run the rev command (this command reads data from standard input, reverses its order, and writes it to standard output), but hook up its input to a temporary file that it will create. This is not a real file, so it is called a `named pipe`.  
In this level we need to duplicate the output of `/challenge/hack` as input to both the `/challenge/the` and the `/challenge/planet` commands. This can be done as `/challenge/hack | tee >( /challenge/the) | /challenge/planet`to obtain the flag. Output of `/challenge/hack` will be written to both the terminal and the output of a process substitution. The process substitution. `>( /challenge/the)` creates a temporary file and redirects the output of tee to that file. The file is then passed as an argument to the `/challenge/planet` command.

# Split-piping stderr and stout
`/challenge/hack`: this produces data on stdout and stderr
`/challenge/the`: you must redirect hack's stderr to this program
`/challenge/planet`: you must redirect hack's stdout to this program  

We need to redirect output of `/challenge/hack` as input into `/challenge/planet` and its error into `/challenge/the`
`/challenge/hack 2> >(/challenge/the) > >(/challenge/planet)`
