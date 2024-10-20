> In Linux the information about directories and files is shown when we use `ls -l` command. It is denoted by 10 characters. The first character denotes the type, `-` for files and `d` for directories. The next 3 characters show the permissions for the `user` (one who owns the file termed the "owner") accessing the directory/file. The next 3 characters show the permissions for the `group` (the group that owns the file) accessing the directory/file. The next 3 characters show the permissions for the `other` (other users and other groups) accessing the directory/file.  

# Changing file ownership
Every file in Linux is owned by a user on the system. Most often,that `user` is the user we log in as every day. The `chown` command in Linux is used to change the ownership of files and directories. This command allows us to change both the `user` (owner) and the `group` that a file or directory belongs to. eg: chown [options] <user>[:<group>] <file_or_directory>. `chown` can only be invoked by the root user.  
In this level, we will practice changing the owner of the `/flag` file to the hacker user.We change the ownership to *hacker* by `chown hacker /flag` and the obtain the flag by running `./flag` .

# Groups and Files

