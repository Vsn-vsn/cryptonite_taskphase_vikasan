# Chaining with semicolons
The easiest way to chain commands is `;`. Example: `echo COLLEGE > pwn; cat pwn`.  
In this level, we must run `/challenge/pwn` and then `/challenge/college`, chaining them with a semicolon like `/challenge/pwn ; /challenge/college` to obtain the flag.

# Your first shell script
As we combine more and more commands to achieve complex effects, the length of the combined prompt quickly gets really annoying to deal with. To avoid this we can put these commands in a file, called a `shell script`, and run them by executing the file. We can create a shell script called, for example,`pwn.sh` (by convention, shell scripts are frequently named with a `sh` suffix). And then we can execute by passing it as an argument to a new instance of our shell (bash). When a shell is invoked like this, rather than taking commands from the user, it reads commands from the file. It is run as `bash pwn.sh` .  
In this level we run the same command as the previous ones but using a script. We run `nano x.sh` and write in the nano editor `/challenge/pwn ; /challenge/college`. Then we run `bash x.sh` to obtain the flag.

# Redirecting Script output
As far as the shell is concerned, our script is just another command. That means we can redirect its input and output. For example `bash script.sh > output` and then we can `cat output`. All of the various redirection methods work: `>` for stdout, `2>` for stderr, `<` for stdin, `>>` and `2>>` for append-mode redirection, `>&` for redirecting to other file descriptors, and `|` for piping to another command.  
In this level, we need to create a script that calls the `/challenge/pwn` command followed by the `/challenge/college` command, and pipe the output of the script into a single invocation of the `/challenge/solve` command. We use the `x.sh` file and the use the command `bash x.sh | /challenge/solve` to obtain the flag.

# Executable shell scripts
When we invoke `bash script.sh`, it tells bash to read its commands from script.sh instead of standard input, and thus our shell script is executed.  We can avoid the need to manually invoke bash. If our shell script file is `executable` we can invoke it via its relative or absolute path. For example, if we create `script.sh` in our home directory and make it `executable`, we can invoke it via `/home/hacker/script.sh` or `~/script.sh` or (if our working directory is `/home/hacker` then) `./script.sh`.  
In this level we must make a *shellscript* that will invoke `/challenge/solve`, make it executable, and run it without explicitly invoking `bash`.  
First we use nano editor to make a file `nano x.sh` that has `/challenge/solve`. Then we change the permissions of `x.sh` by the command `chmod u=rwx,g=rwx,o=rwx x.sh` and we run `./x.sh` to obtain the flag. 
