# jobintentservicex - a fix for JobIntentService (from Android X) crashes

JobIntentService in Android X has a bug (or maybe Android has a bug) which
may crash your app.

```
java.lang.RuntimeException: An error occurred while executing doInBackground()
        at android.os.AsyncTask$3.done(AsyncTask.java:353)
        at java.util.concurrent.FutureTask.finishCompletion(FutureTask.java:383)
        at java.util.concurrent.FutureTask.setException(FutureTask.java:252)
        at java.util.concurrent.FutureTask.run(FutureTask.java:271)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        at java.lang.Thread.run(Thread.java:764)
Caused by: java.lang.SecurityException: Caller no longer running, last stopped +1s328ms because: timed out while starting
        at android.os.Parcel.readException(Parcel.java:2005)
        at android.os.Parcel.readException(Parcel.java:1951)
        at android.app.job.IJobCallback$Stub$Proxy.dequeueWork(IJobCallback.java:191)
        at android.app.job.JobParameters.dequeueWork(JobParameters.java:208)
        at android.support.v4.app.JobIntentService$JobServiceEngineImpl.dequeueWork(SourceFile:314)
        at android.support.v4.app.JobIntentService.dequeueWork(SourceFile:639)
        at android.support.v4.app.SafeJobIntentService.dequeueWork(SourceFile:31)
        at android.support.v4.app.JobIntentService$CommandProcessor.doInBackground(SourceFile:389)
        at android.support.v4.app.JobIntentService$CommandProcessor.doInBackground(SourceFile:382)
        at android.os.AsyncTask$2.call(AsyncTask.java:333)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1162)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:636)
        at java.lang.Thread.run(Thread.java:764)
```

Please see [Google Issue Tracker, issue #63622293](https://issuetracker.google.com/issues/63622293) for more details.

This repository provides a drop-in replacement called JobIntentServiceX which fixes
(avoid) the crash.

The license is Apache 2.0, the code is Kotlin (should not be a problem to use
from Java).

## Installation

At this time I don't have a repository for Gradle, so please clone the project
either into a `git submodule` in your project, or just copy the files over. Add
the directory as a dependency in your `build.gradle`.

## Your service class

Just derive your service from `JobIntentServiceX` instead of `JobIntentService`. 

---

Copyright (c) 2020 Kostya Vasilyev

Apache License 2.0
