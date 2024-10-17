> File globbing in Linux (and Unix-like systems) refers to the process of using special characters (called wildcards) to match multiple files or directories in the shell.

# Matching with *
When the shell encounters a `*` character in any argument, it will treat it as *wildcard* and try to replace that argument with any files that match the pattern. The glob can match 
multiple arguments and also it can simply match only one too.When zero files are matched, by default, the shell leaves the glob unchanged.The `*` matches any part of the filename except for `/` or a leading `.` character.  
In this level we first get to the `challnge` directory using the glob `*`. We run the command `cd /ch*`, because the level specifies that we ,use 4 characters at most in the command. Once we navigate we then obtain the flag by `./run` command.

# Matching with ?
When the shell encounters a `?` character in any argument, it treats it as single-character `wildcard`. This works like `*`, but only matches one character.  
In this level we have to use `?` glob to navigate to the `/challenges` directory but replace 'c','l' using the `?` wildcard argument. We do `cd /?ha??enge` to navigate to the the directory and then run the `./run` command to obtain the flag.

# Matching with []
The square brackes, `[]` are a limited form of `?`. In this instead of matching any character, `[]` is a wildcard for some subset of potential characters, specified within the brackets. For example, `[pwn]` will match the character 'p', 'w', or 'n'.  
In this level we must change our working directory to `/challenge/files` and run `/challenge/run` with a single argument that bracket-globs into `file_b, file_a, file_s, and file_h`.  
After navigating to `cd /challenge/files`, we run `/challenge/run file_[bash]` to obtain the flag.

# Matching paths with []
Globbing happens on a path basis, so we can expand entire paths with your globbed arguments.  
In this level a bunch of files are kept in `/challenges/files` directory.We need to run `/challenge/run` with a single argument that `bracket-globs` into the absolute paths to the `file_b, file_a ,file_s and file_h` files.  
Here we need to use the command `/challenge/run` along with `/challenge/files/file_[bash]` as a single argument to obtain the flag. The command used is `challenge/run /challenge/files/file_[bash]` to obtain the flag.

# Mixing globs
In this level using the globbing that we have learnt, write a single, short (6 characters or less) glob that will match the files "challenging", "educational", and "pwning.  
First we navigate to `cd /challenges/files`, then run `ls` command to list out all files. After a series of trial and error to use all globs, we use `ls [cep]*` command which matches any filename starting with `c,e or p`. Then we obtain the flag by navigating to `cd /challenges` and using the command `./run [cep]*`. 

# Exclusionary Globbing
Sometimes, we want to filter out files in a glob. The `[]` helps us to do this. If the first character in the brackets is a `!` or (in newer versions of bash) a `^`, the glob inverts, and that bracket instance matches characters that aren't listed.  
In this level we need to navigate to `cd /challenge/files` and run `/challenge/run` with all files that don't start with `p, w, or n`. We use the command `../run [!pwn]*` to list all the that do not start with `p,w,n`.
> `../run` is equivalent to `/challenge/run` command
