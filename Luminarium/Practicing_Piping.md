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
