package com.ft.fintech.interviews.intern.taskprocessor;

/**
 * This is an implementation of the {@link Task} - and there you go, this will be a really long-running process -
 * it'll take the <code>duration</code>, defined in milliseconds.
 *
 * @author William Shakespeare <william.shakespeare@franklintempleton.com>
 * @since 10/24/2019
 */
public class LongRunningTask implements Task {

    private final String name;
    private final long duration;

    public LongRunningTask(String name, long duration) {
        this.name = name;
        this.duration = duration;
    }

    @Override
    public Long compute() {

        System.out.printf("Task [%s] starting...\n", name);

        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException("Whoops, failed to process this quite complex stuff! :-(");
        }

        System.out.printf("Task [%s] completed after %d[ms]...\n", name, duration);

        // 'duration' is returned only because it matches the expected return type: Long
        // but it's not relevant - for this exercise we could return 0L as well - simply a random or a fixed number

        return duration;
    }
}
