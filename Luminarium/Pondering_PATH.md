# The PATH variable
There is a special shell variable, called `PATH`, that stores a bunch of directory paths in which the shell will search for programs corresponding to commands.  
In this level, we will disrupt the operation of the `/challenge/run` program. This program will DELETE the flag file using the `rm` command. However, if it can't find the `rm` command, the flag will not be deleted, and the challenge will us the flag.  
First we do `export PATH=" "` to modify the *PATH* environment variable. Then we confirm that `rm` directory is removed by using `rm` command and the shell says `rm: command not found`. We then run `/challenge/run` to obtain the flag.

# Setting PATH 
We would, for example, add a new directory of programs to our command repertoire. `PATH` stores a list of directories to find commands in and, for commands in nonstandard places, we must typically execute them via their path. By adding directories to or replacing directories in this list, we can expose these programs to be launched using their bare name. eg: **PATH=/home/hacker/scripts**.  

This level's `/challenge/run` will run the `win` command via its bare name, but this command exists in the `/challenge/more_commands/` directory, which is not initially in the PATH. The `win` command is the only thing that `/challenge/run` needs, so we can just overwrite PATH with that one directory.  
We first set ` PATH=/challenge/more_commands/` and then run `/challenge/run` to obtain the flag. The `PATH` now has the path to the directory containing `win` command.

# Adding commands
In this level we meed to make a shell script called `win`, add its location to the `PATH`, and enable `/challenge/run` to find the flag.  
First write the script `nano win` and in it we write `read flag < /flag` along with `echo $flag`, to redirect the `/flag` as the value to `flag` variable. We then give the `execute` permission to `win` as `chmod a+x win` and set the `PATH` variable to `PATH="/home/hacker"`. We then run `/challenge/run` to obtain the flag.

# Hijacking commands
This level will delete the flag using the `rm` command.  
Since we dont want the `rm` to delete the flag, we can create our own version of `rm` command that will read and print the flag instead.Hence we do `nano rm` and in it we  write `read flag < /flag` along with `echo $flag`, to redirect the `/flag` as the value to `flag` variable.  
```
chmod a=rwx rm
PATH=/home/hacker
/challenge/run
```
