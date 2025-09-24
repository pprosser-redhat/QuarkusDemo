package quarkus.workshop.super_heroes;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import jakarta.transaction.Transactional;

public class HeroKafkaResource {


    @Transactional
    @Incoming("hero-event")
    public void receiveHero(org.acme.kafka.hero.Hero heroEvent) {

        // Contruct Object from AVRO

        Hero hero = new Hero( heroEvent.getName(), heroEvent.getOtherName(), heroEvent.getLevel(), heroEvent.getPicture(), heroEvent.getPowers());
        
        System.out.println(hero.toString());
    }

}
