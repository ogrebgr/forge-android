package com.bolyartech.forge.android.task;

import android.support.test.espresso.IdlingResource;

import com.bolyartech.forge.base.task.TaskExecutor;


@SuppressWarnings("WeakerAccess")
public interface AndroidTaskExecutor<T> extends TaskExecutor<T>, IdlingResource {
}
