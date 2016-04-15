# Vertx TCP Event Bus Bridge example

A small project to reproduce an issue.

Start Vertx with "gradle execute".  This process publishes to the event bus.

Then try to subscribe to the event bus with client.py.

The vertx instance should have the following stack trace


```
Apr 15, 2016 8:52:03 AM io.vertx.core.impl.ContextImpl
SEVERE: Unhandled exception
java.lang.ClassCastException: java.lang.String cannot be cast to io.vertx.core.json.JsonObject
	at io.vertx.ext.eventbus.bridge.tcp.impl.TcpEventBusBridgeImpl.lambda$null$4(TcpEventBusBridgeImpl.java:194)
	at io.vertx.core.eventbus.impl.HandlerRegistration.handleMessage(HandlerRegistration.java:207)
	at io.vertx.core.eventbus.impl.HandlerRegistration.handle(HandlerRegistration.java:201)
	at io.vertx.core.eventbus.impl.EventBusImpl.lambda$deliverToHandler$127(EventBusImpl.java:498)
	at io.vertx.core.impl.ContextImpl.lambda$wrapTask$18(ContextImpl.java:335)
	at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:358)
	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:357)
	at io.netty.util.concurrent.SingleThreadEventExecutor$2.run(SingleThreadEventExecutor.java:112)
	at java.lang.Thread.run(Thread.java:745)
```



