package com.bolyartech.forge.android.task;

import android.support.test.espresso.IdlingResource;

import com.bolyartech.forge.base.task.TaskExecutor;


/**
 * Task executor for Android.
 * Implements IdlingResource and thus supports mockito unit testing
 *
 * @param <T>
 */
@SuppressWarnings("WeakerAccess")
public interface AndroidTaskExecutor<T> extends TaskExecutor<T>, IdlingResource {
}
