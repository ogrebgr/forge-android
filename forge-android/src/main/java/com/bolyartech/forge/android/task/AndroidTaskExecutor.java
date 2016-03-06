package com.bolyartech.forge.android.task;

import android.support.test.espresso.IdlingResource;

import com.bolyartech.forge.base.task.TaskExecutor;


public interface AndroidTaskExecutor<T> extends TaskExecutor<T>, IdlingResource {
}
