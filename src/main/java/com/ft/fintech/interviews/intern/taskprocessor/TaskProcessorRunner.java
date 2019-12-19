package com.ft.fintech.interviews.intern.taskprocessor;

import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The main class running our program - formally: our test scenario(s).
 *
 * @author William Shakespeare <william.shakespeare@franklintempleton.com>
 * @since 10/24/2019
 */
public class TaskProcessorRunner {

    /**
     * Crates some random tasks. Each task has a duration: between 1000[ms] and 10000[ms]
     */
    private static Collection<Task> createTasksList(int numberOfTasks) {

        Random random = new Random(System.currentTimeMillis());

        return IntStream.rangeClosed(1, numberOfTasks) // let's iterate 'numberOfTasks' times
                .mapToObj(i -> {
                    String taskName = String.format("Task %d", i); // task name - to make sure we can distinguish the tasks
                    long duration = 1000 + Math.abs(random.nextLong() % 10) * 1000; // duration: between 1000[ms] and 10000[ms]

                    return new LongRunningTask(taskName, duration);
                })
                .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * This is our ugly main method triggering the test scenario(s).
     * In general we want to:
     * <ol>
     *     <li>create some long-running tasks</li>
     *     <li>run them - all they must be executed</li>
     *     <li>we want it happen in the fastest way ever!</li>
     * </ol>
     */
    public static void main(String[] args) {

        int numberOfTasks = 10;

        // few tasks to be processed, they will have some random duration
        Collection<Task> tasks = createTasksList(numberOfTasks);

        // now let's process the tasks! let's create the processor first
        TaskProcessor processor = new TaskProcessor();

        // the time is measured here, and our goal is to reduce the overall processing time (!!!)
        Instant start = Instant.now();

        Collection<Long> results = processor.processThemAll(tasks).stream()
            .map(CompletableFuture::join)
            .collect(Collectors.toList());

        Instant finish = Instant.now();

        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.printf("Processed tasks after %d [ms], and got %d entries\n", timeElapsed, results.size());

        if (timeElapsed > 10500) {
            System.out.println("Man! It took too much time, but I know you can make it run faster!");
        }
    }

}
