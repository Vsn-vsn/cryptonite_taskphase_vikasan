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
