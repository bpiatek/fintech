package com.ft.fintech.interviews.intern.taskprocessor;

/**
 * A task - think about this as a piece of logic, what may be a possibly long-running activity.
 *
 * @author William Shakespeare <william.shakespeare@franklintempleton.com>
 * @since 10/24/2019
 */
public interface Task<T> {
   T compute();
}
