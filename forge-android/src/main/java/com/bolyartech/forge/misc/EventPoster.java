package com.bolyartech.forge.misc;

import com.squareup.otto.Bus;


interface EventPoster {
    void postEvent(Bus bus, Object o);
}
