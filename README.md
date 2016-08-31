# forge-android
Forge framework's Android part. Provides auxiliary infrastructure which helps you create easily professional applications. Convenient handling
of device rotation, task execution, HTTP **exchanges** and unit testing.

Documentation is [here](https://github.com/ogrebgr/forge-android/wiki).

Download

Gradle: TODO



The other parts of the Forge framework:

* [forge-base](https://github.com/ogrebgr/forge) - Base client classes of Forge framework.
`forge-android` depends on `forge-base`
* [forge-android-skeleton-basic](https://github.com/ogrebgr/forge-android-skeleton-basic) - App that serves as base/skeleton for user applications. Uses Dagger2 dependency injection. Contains functionality for user autoregistration,manual registration, login, public/screen name changing.
* [forge-android-admin](https://github.com/ogrebgr/forge-android-admin) - admin app that works with `forge-server` and provides functionality for user administration.
* [forge-server](https://github.com/ogrebgr/forge-server) - Server-side part of the Forge framework. If you need to create fast a backend for your application `forge-server` can be used as a base which provides functionality for admin and regular user administration. Based on [Spark java](http://sparkjava.com/) (micro framework for creating web applications in Java 8).
