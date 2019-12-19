Howdy!

These are the simple assignments for the interns applying for our FinTech internship.

This is a Maven project, but you can open this in your favourite IDE, because all what it requires is Java 8
with its core classes. Make sure your IDE compiles this code with JDK 1.8+, and similarly the language level
is set to 8+.

Whatever is going to happen - DO NOT WORRY! You don't have to resolve all the assignments,
simply write as much as you can and let us asses your results. In many cases we're more
interested in you aptitude rather than hard skills.

All the assignments are related to the attached java source code. Please spend some time on
becoming acquainted with the code, and with analysing what the code does. The main purpose
the code serves is:

  - generate few random tasks,
  - instantiate the processor that will process the tasks,
  - and then the processor processes the tasks.

Please check the 'main' method in the TaskProcessorRunner class, that's the entry point to the program.

After becoming familiar with the code please accomplish the following assignments:


+ =========================================================================== +
| Assignment 1:                                                               |
+ =========================================================================== +

Conduct the code review and share your thoughts on the code. All the criticism
is welcome, we especially love to hear/read the healthy criticism :-)


+ =========================================================================== +
| Assignment 2:                                                               |
+ =========================================================================== +

Think how the TaskProcessor could process the tasks faster and re-implement
TaskProcessor's processThemAll() method, introducing some parallelism.

We don't expect you adding any 3rd party libraries here, but if you think
it's really required, just do it and add them to the project's pom.xml.


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


That being said...

Good luck!
