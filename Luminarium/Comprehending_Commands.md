# cat: not the pet but the command!
The `cat` command is one of the most used command in Linux. It is often used in reading files. `cat` can also concatenate multiple files if we provide multiple arguments.
For example, `cat testbackup.txt example.txt` merges the contents of the files testbackup.txt and example.txt .
If we give no arguments at all, `cat` will read from the terminal input and output it.
In this level course we had to read the fie located in our home directory.After navigating to home using the command `cd /`, the command used was `cat flag`to obtain the flag, where 'flag' was the name of the file containing the flag.

# catting absolute paths
In the arguments of the `cat` command we can specify the absolute paths as the arguments. In this level we need to specify the absolute path as the argument for the `cat` command and obtain the flag.
We use the command `cat /flag` to read the flag file in our home directory `/`.

# more catting practice 
In this level we must use different paths to read the flag file without changing the directory. By using the `cd /` command a message shows up that tells us the absolute path of the flag file. Then we use the command `cat /opt/aflplusplus/benchmark/flag` to obtain the flag.

# grepping for a needle in haystack
One of the most important commands in the Linux system is the `grep` command. We use this command to search for the contents we need in the file.
We can us e the grep command as `grep SEARCH /path/direc/fl.txt`, where SEARCH is the content to be searched in the file fl.txt and /path/direc/fl.txt is the path to the file.
In this level we need to use `grep` to find the flag in a text file. The command used is `grep pwn.college /challenge/data.txt`, where the text file `data.txt` is the file to be searched and `/challenge/data.txt` is the path to it.

# listing files 
The `ls` command will list files in all the directories provided to it as arguments, and in the current directory if no arguments are provided.
In this level the `run` file has been renamed to `7308-renamed-run-20471`. Hence we need to change the directory to `cd challenges` and the use `ls` command to get the renamed file. Then we use the command `/challenge/7308-renamed-run-20471` to obtain the flag.

# touching files
We can use the command `touch` to create new files in our directory.
In this level we need to create two files, namely 'pwn' and 'college' and then obtain the flag by running `/challenge/run`. We create the new file in 'tmp' directory by using the command `touch pwn` and `touch college` after we navigate to 'tmp' using `cd /tmp`.

# removing file
In a practical scenario we need to remove the unwanted files or the files that are needed no longer. In such cases `rm` command is helpful. The `rm` command is used to remove files.  
In this level  we need to remove the `delete_me` file from our home directory. At first we run the `ls` command to check if the file is there in the directory. Once confirmed, we use the `rm delete_me` command to remove the file. We check if the file has been deleted or not by using the `ls` command again. To obtain the flag we run the `/challenge/check`. 

# hidden files
The `ls` command when used does not list all the directories and files. The files/directories that start with a `.` is categorized as hidden and they are not listed out when we use the `ls` command. To overcome this we use the `ls -la` command, which means list-all files and directories including the hidden ones.  
In this level we need to find the flag by accessing a hidden file in the directory `/`. We navigate `cd /` and then list out all the files using `ls -la` command. A hidden file `.flag-80982409812209` is found. The we use the `cat flag-80982409812209` command to obtain the flag.

# An Epic Filesystem Quest
In this level we have to use all the knowledge about the `ls`,`cd`,`cat` commands and the `path navigation` to find clues and obtain the flag. Patience and reading the clues carefully is important in this level to move ahead. 

# making directories
Linux also provides the provision to make directories using the command line.To make a directory we use the `mkdir` command. eg: `mkdir new_dir`.  
In this level we make a directory inside the `tmp` directory. We use the command `mkdir pwn` after we navigate `cd /tmp`. We can check if the directory is made using the `ls` command. Then we navigate `cd pwn` and make a file, college, using the command `touch college`. To obtain the flag we run `/challenge/run` to indicate that we have followed the steps.

# finding files
The `find` command in Linux is used to search for files and directories within a directory hierarchy. It has a wide range of options to filter the search results based on different criteria like name, size, type, permissions, etc. If we don't specify a search criteria, `find` matches every file. eg: `find -name my_subfile`,finds the my_subfile file.  
In this level we have to use the `find -name flag` command to search for files and directories named flag. Then we need to navigate into different directories to obtain the flag. 

# linking files
In Linux, "links" typically refer to symbolic links (symlinks) and hard links. These allow files and directories to reference other files or directories without duplicating data.
1. A symbolic link is a file that points to another file or directory. It's like a shortcut in Windows. If the original file is deleted, the symbolic link becomes broken.
2. A hard link is a direct reference to the same inode as the original file. Unlike symlinks, hard links are tied directly to the file’s data, so even if the original file is deleted, the hard link still holds the data.

  
In this level, we will learn about symbolic links. Symbolic links are created with the `ln` command with the `-s` argument. `ln -s /path/to/original /path/to/link` is how we create a symlink.  
A symlink can be identified as such with a few methods. For example, the `file` command, will recognize symlinks.  
In this level we need to first create a symlink of the `/flag` by using the command `ln -s /flag /home/hacker/not-the-flag`. After this a symlink to the `flag` file is created. Then we run `/challenge/catflag` which reads out the contents from the `/home/hacker/not-the-flag` file.

