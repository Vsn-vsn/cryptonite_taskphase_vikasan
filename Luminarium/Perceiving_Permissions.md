> In Linux the information about directories and files is shown when we use `ls -l` command. It is denoted by 10 characters. The first character denotes the type, `-` for files and `d` for directories. The next 3 characters show the permissions for the `user` (one who owns the file termed the "owner") accessing the directory/file. The next 3 characters show the permissions for the `group` (the group that owns the file) accessing the directory/file. The next 3 characters show the permissions for the `other` (other users and other groups) accessing the directory/file.  

# Changing file ownership
Every file in Linux is owned by a user on the system. Most often,that `user` is the user we log in as every day. The `chown` command in Linux is used to change the ownership of files and directories. This command allows us to change both the `user` (owner) and the `group` that a file or directory belongs to. eg: chown [options] <user>[:<group>] <file_or_directory>. `chown` can only be invoked by the root user.  
In this level, we will practice changing the owner of the `/flag` file to the hacker user.We change the ownership to *hacker* by `chown hacker /flag` and the obtain the flag by running `. /flag` .

# Groups and Files
In Linux, files have both an owning `user` and `group`. A group can have multiple users in it, and a user can be a member of multiple groups. We can check what groups we are part of with the `id` command. A typical main `user` of a typical Linux desktop has a lot of groups.  
The `chgrp` command in Linux is used to change the group ownership of files and directories. This command allows us to specify a new `group` for a file or directory. eg: chgrp [options] <group> <file_or_directory>.  
In this level we need to access the flag by changing the group which has access to `/flag` file to `hacker`. We do `chgrp hacker /flag` and then run `. /flag`.

# Fun with group names
In this level we will need to use the `id` command to figure the name of the group, then `chgrp` to obtain the flag. First we use `id` command to get the name of the group. We fet the output as `uid=1000(hacker) gid=1000(grp9399) groups=1000(grp9399)` which says we are a part of the group `grp9399`. Thus we do `chgrp grp9399 /flag` and run `. /flag` to obtain the flag.

# Changing file permissions
File permission in Linux are as follows
 1. `r` - user/group/other can read the file (or list the directory)
 2. `w` - user/group/other can modify the files (or create/delete files in the directory)
 3. `x` - user/group/other can execute the file as a program (or can enter the directory, e.g., using `cd`)
 4. `-` - no permission (nothing)  
   
The `chmod` command in Linux is used to change the file mode bits or permissions of a file or directory. It allows you to specify who can read, write, or execute a file. eg: `chmod u=rw,g=r,o=r file.txt` give read-write permissions to user, read permission to groups and others.  
In this level `/flag` file is owned by root, and we can't change that, but we must make it readable to get the flag. We first check the permissions by `ls -l /flag` and we get the permissions `-r-xr-x---`. We then change permission to read by using the command `chmod o+r /flag` and the run `. /flag` to obtain the flag. 

# Executable files
Executable files in Linux are files that can be run as programs. These files contain binary code or scripts that the operating system can execute.  
In this level, the `/challenge/run` program will give us the `flag`, but we must first make it executable. We navigate to `cd /challenge` and then see the permissions of `run` file is `-r--r--r--` by the use of `ls -l` command. We then change it to executable by the command `chmod u+x,g+x,o+x run` and obtain the flag by running `./run`.

# Permission tweaking practice
In this level we need to change the permissions of the `/challenge/pwn` file in specific ways a few times in a row. If we get the permissions right eight times in a row, the challenge will let us `chmod /flag` to make it readable and obtain the flag.  
The level needs us to change the permissions for the file 8 times, and hence get the flag.

# Permission setting practice
In addition to adding and removing permissions, as in the previous level, `chmod` can also simply set permissions overwriting the old ones. This is done by using `=` instead of `-` or `+`. For example `u=rw` sets read and write permissions for the user, and wipes the execute permission.  
`chmod g=r,u=rw /challenge/pwn` will set the user permissions to read and write, and the group and world permissions to read-only.  
`chmod u=rw,g=r,o=- /challenge/pwn` will set the user permissions to read and write, the group permissions to read-only, and the world permissions to nothing.  
In this level we need to use more radical permission changes using `=` and ,`-` chaining to get the flag.

# The SUID bit
There are many cases in which non-root users need elevated access to do certain system tasks. The system admin can't be there to give them the password every time a user wanted to do a task that only `root/sudoers` can do. The *Set User ID* or `SUID` permissions bit allows the user to run a program as the owner of that program's file.  
For instance in `-rwsr-xr-x 1 root root 232416 Dec 1 11:45 /usr/bin/sudo`, the `s` part in place of the executable bit means that the program is executable with `SUID`. It means that, regardless of any user that runs the program, the program will be executed as the owner `user`. Syntax: **chmod u+s [program]**.  
In this level we add the `SUID` bit to the `/challenge/getroot` program by using the command `chmod u+s /chllenge/getroot`. Then we spawn our root shell by the command `/challenge/getroot` and obtain the flag by 'cat'ing `/flag` through the command `cat /flag`.
