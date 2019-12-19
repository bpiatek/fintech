package com.ft.fintech.interviews.intern.taskprocessor;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * This is the processor. It's able to process all the tasks and return the <code>Collection</code>
 * with the results.
 *
 * @author William Shakespeare <william.shakespeare@franklintempleton.com>
 * @since 10/24/2019
 */
public class TaskProcessor {

    <T> Collection<T> processThemAll(Collection<Task<T>> tasks) {

        return tasks.parallelStream()
                .map(Task::compute)
                .collect(Collectors.toList());
    }
}
