# Listing processes 
The `ps` command in Linux is used to display information about currently running processes on the system. It provides a snapshot of the active processes and their details such as process id(PID), cpu time etc.  
There are two ways to specify arguments:  
1.` Standard Syntax`: It displays all processes in a tree format with full details. We can use -e to list "every" process and -f for a "full format" output, including arguments. These can be combined into a single argument `-ef`.  
2. `BSD Syntax`: It displays a detailed list of all running processes, includg.ing those started by other users and system processes.We can use this to list processes for all users. `x` to list processes that aren't running in a terminal, and `u` for a *user-readable* output. These can be combined into a single argument aux.  
  
`ps -ef` additionally outputs the Parent Process ID (PPID), which is the PID of the process that spawns another process, whereas `ps aux` outputs the percentage of total system CPU and Memory that the process is utilizing.  
In this level `/challege/run` has been renamed and we cannot access it using `ls` command in `/challenge` directory. It has been launched and hence we can find it in the processes running. Thus we use the command `ps -ef` to list out all the running processes and we find the renamed `/run` file. We run `/challenge/6823-run-23757` to obtain the flag.

# Killing Processes
In Linux, we can kill processes by using the `kill` command or related commands like `killall` and `pkill`. `Killing` a process means terminating or stopping it from running. This can be useful when a process becomes unresponsive, consumes too many resources, or needs to be stopped. We use `kill` to terminate it by passing the process identifier (the PID from ps) as an argument. (`sleep` is a program that hangs out for the number of seconds specified on the command line.)  
In this level we have a `/challenge/dont_run` that refuses `/challenge/run` to run. Hence we need to terminate the the `dont_run` processes. At first we list out the `/challenge/dont_run` process by using the `ps` command and then kill it using  it's PID and the `kill` command as follows:  
```
ps -ef | grep dont_run  (we get it' PID as 73)
kill 73
/challenge/run 
```
  
# Interrupting processes
Sometimes we need to interrupt the processes instead of just killing it an Linux provides us such a provision too. The terminals have a hotkey for this- `Ctrl+C` sends an "interrupt" to whatever application is waiting on input from the terminal and this causes the application to cleanly exit.  
In this level `/challenge/run` refuses to give the flag until we interrupt it. We navigate to `cd /challenge` and then run `./run` but the terminal waits for user input. We need to exit it smoothly by pressing `ctrl+c` to obtain the flag.

# Suspending Processes
To get back our terminal smoothly and less drastically we suspend the processes using `ctrl+z`.  
This level's `run` wants to see another copy of itself running and using the same terminal. We use the terminal to launch it, then suspend it, then launch another copy while the first is suspended.  First we run the `/challenge/run` and then we suspend it by pressing `ctrl+z`. Then we again run `/challenge/run`
to obtain the flag.

# Resuming Processes
When we suspend processes, we will want to resume them at some point. To resume processes, the shell provides the `fg` command, a builtin that takes the suspended process, resumes it, and puts it back in the foreground of your terminal.  
In this level we first run `/challenge/run` and the suspend it by pressing `ctrl+z`. The we use the `fg` command to resume the most recent background process.

# Backgrounding Processes
We can also resume processes in the background with the `bg` command! This will allow the process to keep running, while giving the shell back to invoke more commands in the meantime.  
This level's `run` wants to see another copy of itself running, not suspended, and using the same terminal. We use the terminal to launch it, then suspend it, then background it with `bg` and launch another copy while the first is running in the background. This is done by:
```
/challenge/run
[ctrl+z to suspend it]
bg
```
and hence obtain the flag.

# Foregrounding Processes
We have a backgrounded process, and we want to play with it some more. We can foreground a backgrounded process with `fg` just like we foreground a suspended process, and we will do it in this level.  
At first we run `/challenge/run` and then we suspend it using `ctrl+z`. Then we resume `run` in the background by using `bg` command. To obtain the flag we then foreground the now backgrounded process `run` by using `fg` command.

# Starting Background processes
We can start the backgrounded right off the bat by appending a `&` to the command.  
In this level we need to launch `/challenge/run` backgrounded to get the flag. We use the command `/challenge/run &` to obtain the flag while `run` is started as teh background process.

# Process Exit codes
A process exit code (also known as a return code or exit status) is a numeric value returned by a process to its parent process when it finishes execution in Linux. This can be used by the shell, or the user of the shell to check if the process succeeded in its functionality. We can access the exit code of the most recently-terminated command using the special `?` variable like `echo $?` (`$` is used to access the value).  
Commands that succeed typically return 0 and commands that fail typically return a non-zero value, most commonly 1 but sometimes an error code that identifies a specific failure mode.  
In this level we must retrieve the exit code returned by `/challenge/get-code` and then run `/challenge/submit-code` with that error code as an argument. We first run `/challenge/get-code` whose output is an error code which is accessed through `echo $?` and then to obtain the flag run `/challenge/submit-code [error_code_generated]`. If error code is `3` then replace `[error_code_generated]` by `3`. 
