package com.ft.fintech.interviews.intern.taskprocessor.task;

import java.util.Collection;

/**
 * Created by Bartosz Piatek on 19/12/2019
 */
// I HAVE ALSO DECIDED TO USE FACADE PATTERN (MAYBE A BIT OVERKILL FOR SUCH AN EASY PROJECT)
// BUT IT HELPS TO KEEP A LOT OF CLASSES PACKAGE PRIVATE AND HIDE IMPLEMENTATION
public class TaskFacade {

  private final TaskCreator taskCreator;
  private final TaskProcessor taskProcessor;

  public TaskFacade() {
    this.taskCreator = new TaskCreator();
    this.taskProcessor = new TaskProcessor();
  }

  public Collection<Task> createList(int numberOfTasks) {
    return taskCreator.createTasksList(numberOfTasks);
  }

  public Collection<Long> processAll(Collection<Task> tasks) {
    return taskProcessor.processThemAll(tasks);
  }
}
