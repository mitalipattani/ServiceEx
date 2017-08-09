# ServiceEx
Service and IntentService
 a Service is a broader implementation for the developer to set up background operations, while an IntentService is useful for "fire and forget" operations, taking care of background Thread creation and cleanup.
 
 Differences
1 ) Service class uses the application's main thread, while IntentService creates a worker thread and uses that thread to run the service.
2 ) IntentService creates a queue that passes one intent at a time to onHandleIntent(). Thus, implementing a multi-thread should be made by extending Service class directly. Service class needs a manual stop using stopSelf(). Meanwhile, IntentService automatically stops itself when it finishes execution.
3) IntentService implements onBind() that returns null. This means that the IntentService can not be bound by default.
4) IntentService implements onStartCommand() that sends Intent to queue and to onHandleIntent().
