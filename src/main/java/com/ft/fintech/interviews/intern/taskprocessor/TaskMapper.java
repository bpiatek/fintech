package com.ft.fintech.interviews.intern.taskprocessor;

import java.util.Random;

/**
 * Created by Bartosz Piatek on 19/12/2019
 */
// MAPPING LOGIC MOVED TO SEPARATE CLASS WHICH IS USED IN TaskCreator
// WE ARE USING HERE ONLY ONE INSTANCE OF RANDOM OBJECT SO IT DOES NOT HAVE TO
// BE CREATED FOR MAPPING EACH ELEMENT
class TaskMapper {

  private final Random random;

  TaskMapper() {
    this.random = new Random(System.currentTimeMillis());
  }

  LongRunningTask mapToTask(int index) {
    String taskName = String.format("Task %d", index); // task name - to make sure we can distinguish the tasks
    long duration = 1000 + Math.abs(random.nextLong() % 10) * 1000; // duration: between 1000[ms] and 10000[ms]

    return new LongRunningTask(taskName, duration);
  }
}
