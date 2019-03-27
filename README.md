# Test fails with two JPA datasources

When testing two jpa datasources with `@MicronautTest` the first test method always fails with following 
error. Unrelated to SUT. 

See: https://github.com/micronaut-projects/micronaut-test/issues/28

```
java.lang.IllegalStateException: Transaction synchronization is not active
	at org.springframework.transaction.support.TransactionSynchronizationManager.getSynchronizations(TransactionSynchronizationManager.java:311)
	at org.springframework.transaction.support.AbstractPlatformTransactionManager.triggerAfterCompletion(AbstractPlatformTransactionManager.java:959)
	at org.springframework.transaction.support.AbstractPlatformTransactionManager.processRollback(AbstractPlatformTransactionManager.java:865)
	at org.springframework.transaction.support.AbstractPlatformTransactionManager.rollback(AbstractPlatformTransactionManager.java:812)
	at io.micronaut.test.transaction.spring.SpringTestTransactionInterceptor.rollback(SpringTestTransactionInterceptor.java:55)
	at io.micronaut.test.transaction.CompositeTestTransactionInterceptor.rollback(CompositeTestTransactionInterceptor.java:54)
	at io.micronaut.test.extensions.AbstractMicronautExtension.rollback(AbstractMicronautExtension.java:84)
	at io.micronaut.test.extensions.spock.MicronautSpockExtension.lambda$visitSpecAnnotation$2(MicronautSpockExtension.java:92)
	at org.spockframework.runtime.extension.MethodInvocation.proceed(MethodInvocation.java:97)
	at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecutor.runTestClass(JUnitTestClassExecutor.java:110)
	at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecutor.execute(JUnitTestClassExecutor.java:58)
	at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecutor.execute(JUnitTestClassExecutor.java:38)
	at org.gradle.api.internal.tasks.testing.junit.AbstractJUnitTestClassProcessor.processTestClass(AbstractJUnitTestClassProcessor.java:62)
	at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.processTestClass(SuiteTestClassProcessor.java:51)
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:35)
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
	at org.gradle.internal.dispatch.ContextClassLoaderDispatch.dispatch(ContextClassLoaderDispatch.java:32)
	at org.gradle.internal.dispatch.ProxyDispatchAdapter$DispatchingInvocationHandler.invoke(ProxyDispatchAdapter.java:93)
	at org.gradle.api.internal.tasks.testing.worker.TestWorker.processTestClass(TestWorker.java:118)
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:35)
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
	at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:175)
	at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:157)
	at org.gradle.internal.remote.internal.hub.MessageHub$Handler.run(MessageHub.java:404)
	at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:63)
	at org.gradle.internal.concurrent.ManagedExecutorImpl$1.run(ManagedExecutorImpl.java:46)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at org.gradle.internal.concurrent.ThreadFactoryImpl$ManagedThreadRunnable.run(ThreadFactoryImpl.java:55)
	at java.lang.Thread.run(Thread.java:748)
```