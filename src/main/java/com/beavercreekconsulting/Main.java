package com.beavercreekconsulting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.vertx.core.Vertx;
import io.vertx.ext.bridge.BridgeOptions;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge;

public class Main
{
    static Logger log = LoggerFactory.getLogger(Main.class);
    
    public static void main(String[] args) throws InterruptedException
    {
        // start Vertx and the bridge
        Vertx vertx = Vertx.vertx();
        
        BridgeOptions bridgeOptions = new BridgeOptions()
        .addInboundPermitted(new PermittedOptions().setAddressRegex(".*"))
        .addOutboundPermitted(new PermittedOptions().setAddressRegex(".*"));
        
        TcpEventBusBridge bridge = TcpEventBusBridge.create(vertx, bridgeOptions);
        bridge.listen(15651, res ->{
            if(res.succeeded())
            {
                log.info("Bridge is up");
            }
        });

        // and lurk...
        while(true)
        {
            log.info("Publish");
            vertx.eventBus().publish("pcs.status", "Yo!");
            Thread.sleep(1000);
        }
    }
}
