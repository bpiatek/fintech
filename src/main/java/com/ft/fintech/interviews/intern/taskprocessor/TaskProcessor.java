package com.ft.fintech.interviews.intern.taskprocessor;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

/**
 * This is the processor. It's able to process all the tasks and return the <code>Collection</code>
 * with the results.
 *
 * @author William Shakespeare <william.shakespeare@franklintempleton.com>
 * @since 10/24/2019
 */
public class TaskProcessor {

    private static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool(10);

    Collection<CompletableFuture<Long>> processThemAll(Collection<Task> tasks) {
        return tasks.stream()
            .map(t -> CompletableFuture.supplyAsync(t::compute, FORK_JOIN_POOL))
            .collect(Collectors.toList());
    }


    /* MY FIRST ATTEMPT WAS JUST TO INVOKE parallelStream() METHOD LIKE BELOW
       BUT THE CODE WAS RUNNING ON ONLY 8 THREADS ON MY MACHINE AND SOMETIMES
       I WAS NOT ABLE TO FINISH PROCESSING WITHIN 10500 ms
       THAT IS WHY SOLUTION ABOVE IS PREFERABLE

    Collection<Long> processThemAll(Collection<Task> tasks) {

        return tasks.parallelStream()()
            .map(Task::compute)
            .collect(Collectors.toList());

    }
     */
}
