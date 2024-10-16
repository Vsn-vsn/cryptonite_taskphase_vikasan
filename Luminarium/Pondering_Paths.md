# The Root
The Linux filesystem,which is a tree, starts at /. Under that, there are a whole lot of other directories, configuration files, programs, and (here) flags.We can invoke a program by providing its path on the command line. In this level, the flag was hidden in a program right in / (root), called pwn. We had to invoke this program using the command /pwn. 

# Program and Absolute paths
In this level we navigated to directories other than the root using absolute path. Here the flag was in 'run' file, which was inturn kept in the 'challenge' directory. 
We invoked the 'run' through the command '/challenge/run' which is an absolute path.

# Position thy self
In this level we had to navigate to another directory using th 'cd' command. The 'cd' command is used to change our present working directory. For this challenge we had to navigate using 
'cd  /usr/bin' and then run '/challenge/run' to obtain the flag.
