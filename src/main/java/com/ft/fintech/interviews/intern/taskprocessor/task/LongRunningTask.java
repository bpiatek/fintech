package com.ft.fintech.interviews.intern.taskprocessor.task;

import static java.lang.String.format;

import org.apache.log4j.Logger;

/**
 * This is an implementation of the {@link Task} - and there you go, this will be a really long-running process -
 * it'll take the <code>duration</code>, defined in milliseconds.
 *
 * @author William Shakespeare <william.shakespeare@franklintempleton.com>
 * @since 10/24/2019
 */
class LongRunningTask implements Task {

    private static final Logger LOGGER = Logger.getLogger(LongRunningTask.class);

    private final String name;
    private final long duration;

    LongRunningTask(String name, long duration) {
        this.name = name;
        this.duration = duration;
    }

    @Override
    public Long compute() {

        // I PREFER TO USE LOGGER SO WE CAN EASILY SEE E.G. THE NAME OF THE THREAD WHICH PROCESSES THE TASK
        LOGGER.info(format("Task [%s] starting...", name));
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException("Whoops, failed to process this quite complex stuff! :-(");
        }

        LOGGER.info(format("Task [%s] completed after %d [ms]...", name, duration));

        // 'duration' is returned only because it matches the expected return type: Long
        // but it's not relevant - for this exercise we could return 0L as well - simply a random or a fixed number

        return duration;
    }
}
