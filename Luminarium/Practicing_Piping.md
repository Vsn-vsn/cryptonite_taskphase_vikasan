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
Hence at first we write the PWN by `echo COLLEGE >> PWN` and then we run `/challenge/run < PWN` to obtain the flag.

# Grepping stored results
The grep command is a powerful tool used to search for patterns within text files.  
In this level we need to redirect the output of `/challenge/run` to `/tmp/data.txt`. This will result in a hundred thousand lines of text, with one of them being the flag, in `/tmp/data.txt`. We need to `Grep` that for the flag.  
So we first redirect using `/challenge/run >> /tmp/data.txt` and then we obtain the flag by doing `grep 'pwn' /tmp/data.txt`.

# Grepping live output
We can use this using the `|` (pipe) operator to avoid the need to store results to a file.  Standard output from the command to the left of the pipe will be connected to (piped into) the standard input of the command to the right of the pipe.  
In this level we need to run `/challenge/run` will output a hundred thousand lines of text, including the flag. We need to grep for the flag from that.  
First we navigate to `cd /challenges` and then obtain the flag by running `./run | grep 'pwn.college' `.
