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
