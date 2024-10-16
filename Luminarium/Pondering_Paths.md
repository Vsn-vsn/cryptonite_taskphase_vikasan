# The Root
The Linux files ystem,which is a tree, starts at /. Under that, there are a whole lot of other directories, configuration files, programs, and (here) flags.We can invoke a program by providing its path on the command line. In this level, the flag was hidden in a program right in / (root), called pwn. We had to invoke this program using the command `/pwn`. 

# Program and Absolute paths
In this level we navigated to directories other than the root using absolute path. Here the flag was in 'run' file, which was in turn kept in the `challenge` directory. 
We invoked the 'run' through the command `/challenge/run` which is an absolute path.

# Position thy self
In this level we had to navigate to another directory using the `cd` command. The `cd` command is used to change our present working directory. For this challenge we had to navigate using 
`cd  /usr/bin` and then run `/challenge/run` to obtain the flag.

# Position elsewhere
In this level we had to run the `/challenge/run` command which gave the incorrect directory warning and thus gave the actual path. After navigating to the given directory using `cd` command we ran the command again to obtain the flag. 

# Position yet elsewhere
In this challenge we need to execute the `/challenge/run` program from a specific path (which it will tell us). You'll need use `cd` command to navigate to that directory before rerunning the challenge program and then obtain the flag.

# Implicit relative paths, from /
A relative path is any path that does not start at root (i.e., it does not start with /). 
A relative path is interpreted relative to your current working directory (cwd).First we get into the root directory and then run the `challenge/run`.

# Explicit relative paths, from /
In most operating systems, including Linux, every directory has two implicit entries that you can reference in paths: . and ... The first, ., refers right to the same directory, so 
This challenge we use `.` in our relative paths to get the flag. We use the commands `cd /` to navigate to root and then `./challenge/run` to obtain the flag. `.` indicates the current directory we navigated to at the beginning. 

# Implicit relative path
In this level, we'll practice referring to paths using `.` a bit more. This challenge we run it from the `/challenge` directory.
We navigate using `cd /challenge` and the use `./run` , a relative path, invoked from the right directory to obtain the flag.

# Home sweet home
In this challenge, /challenge/run will write a copy of the flag to any file you specify as an argument on the command line, with these constraints:
    1. The argument must be an absolute path.
    2. The path must be inside your home directory.
    3. Before expansion, the argument must be three characters or less.
 
It is given that an absolute path to the target file is to be given as argument to `/challenge/run`.
It is also given that the argument should be less than or equal to 3 characters before expanding (`~/` is a must for an absolute path in home directory, leaving us to choose a single letter for the filename).
>T he command is `/challenge/run ~/r` where 'r' is the filename.
    




