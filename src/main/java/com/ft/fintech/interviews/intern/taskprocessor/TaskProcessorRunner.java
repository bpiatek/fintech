package com.ft.fintech.interviews.intern.taskprocessor;

import org.apache.log4j.Logger;

import java.time.Duration;
import java.time.Instant;
import java.util.Collection;

/**
 * The main class running our program - formally: our test scenario(s).
 *
 * @author William Shakespeare <william.shakespeare@franklintempleton.com>
 * @since 10/24/2019
 */

// I DON'T LIKE THAT EVERY CLASS IS PUBLIC. PACKAGE SCOPE IS PREFERABLE WHENEVER POSSIBLE
// I DELETED WORD "PUBLIC" FROM MY OWN IDE TEMPLATES WHEN GENERATING CLASSES
class TaskProcessorRunner {

    private static final Logger LOGGER = Logger.getLogger(TaskProcessorRunner.class);

    // I PREFER TO HAVE CONSTANTS WHICH ARE EASIER TO READ AND MAINTAIN
    private static final int NUMBER_OF_TASKS = 10;
    private static final int TIME_LIMIT = 10500;

    /*
        I DID NOT LIKE STATIC METHODS HERE SO I DECIDED TO MOVE CREATING TASKS
        TO IT'S OWN CLASS TaskCreator SO EACH OF THE CLASSES IS SPECIALIZED IN ONE PROCESS
     */

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

        // few tasks to be processed, they will have some random duration
        Collection<Task> tasks = new TaskCreator().createTasksList(NUMBER_OF_TASKS);

        // the time is measured here, and our goal is to reduce the overall processing time (!!!)
        Instant start = Instant.now();
        int entriesNo = new TaskProcessor().processThemAll(tasks).size();
        Instant finish = Instant.now();

        long timeElapsed = Duration.between(start, finish).toMillis();
        LOGGER.info(String.format("Processed tasks after %d [ms], and got %d entries", timeElapsed, entriesNo));

        if (timeElapsed > TIME_LIMIT) {
            LOGGER.info("Man! It took too much time, but I know you can make it run faster!");
        }
    }

}
