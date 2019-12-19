package com.ft.fintech.interviews.intern.taskprocessor.task;

import static java.util.stream.IntStream.rangeClosed;

import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Created by Bartosz Piatek on 19/12/2019
 */
class TaskCreator {

  private final TaskMapper taskMapper;

  TaskCreator() {
    this.taskMapper = new TaskMapper();
  }

  /**
   * Crates some random tasks. Each task has a duration: between 1000[ms] and 10000[ms]
   */

  // I DECIDED TO MOVE MAPPING LOGIC TO TaskMapper CLASS AND "INJECT" IT HERE. WE ARE NOT INTERESTED
  // AT THIS LEVEL HOW DOES MAPPING WORK SO IT SIMPLIFIES THE METHOD AND AGAIN WE ARE DIVIDING RESPONSIBILITY
  // TO IT'S OWN CLASSES
  Collection<Task> createTasksList(int numberOfTasks) {
    return rangeClosed(1, numberOfTasks) // let's iterate 'numberOfTasks' times
        .mapToObj(taskMapper::mapToTask)
        .collect(Collectors.toCollection(LinkedList::new));
  }
}
