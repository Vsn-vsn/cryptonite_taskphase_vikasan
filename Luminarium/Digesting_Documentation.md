# Learning from Documentation 
The correct usage of programs depends, in a large part, in the proper specification of arguments to them. The need for documentation is just to find out how to use all the programs, and a specific case of that is figuring out what arguments to specify on the command line.  
In this level we use the command `/challenge/challenge --giveflag` to obtain the flag.

# Learning Complex usage
While using most commands is straightforward, the usage of some commands can get quite complex.   
In this level, the argument to the `--printfile` argument is the path of the flag to read. For example, `/challenge/challenge --printfile /challenge/DESCRIPTION.md` will print out the description of the level!
Here we use `/challenge/challenge --printfile /flag` to obtain the flag.

# Reading manuals
This level introduces the `man` command. `man` is short for manual, and will display (if available) the manual of the command we pass as an argument. We can scroll around the manpage with the arrow keys and PgUp/PgDn. When we're done reading the manpage, you can hit `q` to quit.  
In this level we need to read the man page properly to get the correct usage of the command to obtain the flag. We use the `man challenge` command and read the description. The description gives the proper command for finding the flag, i.e, `--ekgtqd NUM, print the flag if NUM is 287` . Then we run `/challenge/challenge --ekgtqd 287` to obtain the flag.

# Searching manuals 
We can scroll man pages with the arrow keys (and PgUp/PgDn) and search with `/`. After searching, we can hit `n` to go to the next result and `N` to go to the previous result. Instead of `/`, you can use `?` to search backwards.  
In this level we man page of challenge, `man challenge`. Then we search by using `\flag` which gives the usage of the command to obtain the flag. Here we must use `/challenge/challenge  --caeo` to obtain the flag.

# Searching for manuals
This level is tricky: it hides the manpage for the challenge by randomizing its name. All of the man pages are gathered in a searchable database, so you'll be able to search the man page database to find the hidden challenge man page.  
In this level use `man man` command to find the hints. By following the steps we use `man -k challenge` to find the hints to get the flag.

# Helpful Programs
In this level, we will practice reading a program's documentation with --help.  
Here we first use `/challenge/chaallenge --help` to get the help about the flag. We get information to proceed. -g GIVE_THE_FLAG, --give-the-flag GIVE_THE_FLAG get the flag, if given the correct value and -p, --print-value     print the value that will cause the -g option to give you the flag.  
Hence we do `/challenge/challenge -p` to obtain the secret value, i.e, `688` and then use `/challenge/challenge -g 688` to obtain the flag.

# Helpful builtin
Some commands, rather than being programs with man pages and help options, are built into the shell itself. These are called builtins. Builtins are invoked just like commands, but the shell handles them internally instead of launching other programs. We can get a list of shell builtins by running the builtin `help`.  
In this level `challenge` command is a shell builtin, rather than a program. So we use `help challenge` command to get the hints to proceed forward. We are then told that we must use `--secert VALUE` with the proper value to get the flag. The VALUE is provided in the description provided by `help` itself, i.e, `0X5GmCjl`.  
Thus, we run the command `challenge --secret 0X5GmCjl` to obtain the flag.

