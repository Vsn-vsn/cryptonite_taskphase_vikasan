> The full list of users on a Linux system is specified in the /etc/passwd file and now in /etc/shadow file.

# Becoming root with su
Becoming root is a fairly common action that Linux users take. There are two utilities used for this purposes: `su` (switch user) and `sudo` (superuser do). Because it has the `SUID` bit set, `su` runs as root. Running as root, it can start a root shell and before allowing the user to access the privileges of root, it checks to make sure that the user knows the root password.  
This level have a root password. That password is `hack-the-planet`, and we must provide it to `su` to become the root and get the flag.  
```
$ su
Password: hack-the-planet
/home/hacker# cat /flag
```

# Other users with su
With no arguments, `su` will start a root shell but we can also give a username as an argument to switch to that user instead of root.  
In this level, we must switch to the `zardus` user and then run `/challenge/run`. `zardus` password is `dont-hack-me`.  
```
$ su zardus
Password: dont-hack-me
zardus@users~other-users-with-su:/home/hacker$ /challenge/run
```

# Cracking Passwords
When we enter a password for `su`, it compares it against the stored password for that `user`. These passwords used to be stored in `/etc/passwd`, but because `/etc/passwd` is a globally-readable file, it wasn't not good for passwords. So these were moved to `/etc/shadow`.  
In `/etc/shadow` passwords are stored.  Separated by `:s`, the first field of each line is the username and the second is the password. A value of * or ! functionally means that password login for the account is disabled, a blank field means that there is no password and the long string is the result of one-way-encrypting(hashing).  
When we input a password into `su`, it one-way-encrypts the password and compares the result against the stored value. If the result matches, `su` grants you access to the user.  
If we don't know the password and if we have the hashed value of the password, we can crack it though `/etc/shadow` is only readable by root. If a hacker gets their hands on a leaked `/etc/shadow`, they can start cracking passwords and wreaking havoc. The cracking can be done via the famous `John the Ripper` as `john ./my-leaked-shadow-file`.  
In this leveel we need to crack the password of zardus and then `su` into zardus to obtain the flag.  
```
$ john /challenge/shadow-leak
Created directory: /home/hacker/.john
Loaded 1 password hash (crypt, generic crypt(3) [?/64])
Press 'q' or Ctrl-C to abort, almost any other key for status
aardvark         (zardus)
1g 0:00:00:20 100% 2/3 0.04911g/s 286.0p/s 286.0c/s 286.0C/s Johnson..buzz
Use the "--show" option to display all of the cracked passwords reliably
Session completed

$ su zardus
Password: aardvark
zardus@users~cracking-passwords:/home/hacker$ /challenge/run
```

# Using sudo
The `sudo` (short for "superuser do") command in Linux allows a permitted user to execute a command as the superuser (root) or another user, as specified by the security policy. It's a way to perform tasks or execute commands that require elevated privileges without logging in as the root user. Syntax: **sudo [options] <command>**.  
Unlike `su`, which defaults to launching a shell as a specified user, `sudo` defaults to running a command as root. Rather than authenticating via password, `sudo` relies on policies that it checks to determine the user's authorization run things as root.  
In this level we get the `sudo` access to get the flag. We just run `sudo cat /flag` to obtain the flag.
