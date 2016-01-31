package com.bolyartech.forge.android.misc;

import com.squareup.otto.Bus;


interface EventPoster {
    void postEvent(Bus bus, Object o);
}
