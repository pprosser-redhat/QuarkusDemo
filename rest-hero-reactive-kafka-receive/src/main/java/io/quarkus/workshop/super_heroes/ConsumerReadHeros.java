package io.quarkus.workshop.super_heroes;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import io.smallrye.reactive.messaging.kafka.Record;

@ApplicationScoped
public class ConsumerReadHeros {
    
    private final Logger logger = Logger.getLogger((ConsumerReadHeros.class));
    @Incoming("hero-in")
    public void receiveHero(Record<Long, String> record) {
        logger.infof("The hero read was %s", record.value());
    }
    
}
