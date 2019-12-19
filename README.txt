
+ =========================================================================== +
| Assignment 3:                                                               |
+ =========================================================================== +

Imagine there's a new requirement: the Task's compute() method is expected to
return not only Long, but also String results.

Please re-design the program, so that it's able to meet this requirement.

We expect that TaskProcessor's processThemAll() method accepts the Tasks
resulting in Long or String - similarly the returned collection will be a
Collection<Long> or Collection<String>. The types of the requested tasks
(Long vs String) will be consistent, they will not intermingle  - so we
don't expect requests like:
    [ Task(Long), Task(String), Task(Long), Task(String) ]

Here are the valid requests:
    [ Task(Long), Task(Long), Task(Long), ... only Long ... ]
    [ Task(String), Task(String), Task(String), ... only String ... ]


I hope that I understood the task to be honest :)
