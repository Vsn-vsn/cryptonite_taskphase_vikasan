# Learning from Documentation 
The correct usage of programs depends, in a large part, in the proper specification of arguments to them. The need for documentation is just to find out how to use all the programs, and a specific case of that is figuring out what arguments to specify on the command line.  
In this level we use the command `/challenge/challenge --giveflag` to obtain the flag.

# Learning Complex usage
While using most commands is straightforward, the usage of some commands can get quite complex.   
In this level, the argument to the `--printfile` argument is the path of the flag to read. For example, `/challenge/challenge --printfile /challenge/DESCRIPTION.md` will print out the description of the level!
Here we use `/challenge/challenge --printfile /flag` to obtain the flag.

# Reading manuals
This level introduces the man command. man is short for manual, and will display (if available) the manual of the command you pass as an argument. We can scroll around the manpage with your arrow keys and PgUp/PgDn. When we're done reading the manpage, you can hit `q` to quit.  
In this level we ned to read the man page properly to get the correct usage of the command to obtain the flag. When we use the `man challenge` command and read the description. The description gives the proper command for finding the flag, i.e, `--ekgtqd NUM, print the flag if NUM is 287` . Then we run `/challenge/challenge --ekgtqd 287` to obtain the flag.

# Searching manuals 
We can scroll man pages with the arrow keys (and PgUp/PgDn) and search with `/`. After searching, we can hit `n` to go to the next result and `N` to go to the previous result. Instead of `/`, you can use `?` to search backwards.  
In this level we man page of challenge, `man challenge`. Then we search by using `\flag` which gives the usage of the command to obtain the flag. Here we must use `/challenge/challenge  --caeo` to obtain the flag.

# Searching for manuals
This level is tricky: it hides the manpage for the challenge by randomizing its name. All of the man pages are gathered in a searchable database, so you'll be able to search the man page database to find the hidden challenge man page.  
In this level use `man man` command to find the hints. By following the steps we use `man -k challenge` to find the hints to get the flag.
