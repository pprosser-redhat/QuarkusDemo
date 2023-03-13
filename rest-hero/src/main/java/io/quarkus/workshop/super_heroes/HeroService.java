package io.quarkus.workshop.super_heroes;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class HeroService {

    @Channel("new-hero") Emitter<Hero> heroEmitter;
    
    
    public List<Hero> findAllHeros() {

        System.out.println ("You called!! ");
        return Hero.listAll();
    }
    public Hero findHeroById(Long id) {
        System.out.println("You called and asked for Hero " + id);
        return Hero.findById(id);
    }

    @Transactional
    public Hero createHero(Hero hero){
        Hero.persist(hero);

        heroEmitter.send(hero);

        return hero;
    }

    @Transactional
    public void deleteHero(Long id) {
        Hero.deleteById(id);
    }

    @Transactional
    @Incoming("hero-event")
    public void receiveHero(JsonObject heroEvent) {
        System.out.println(heroEvent.toString());

        // Contruct Object from JSON
        Hero hero = heroEvent.mapTo(Hero.class);
        System.out.println(hero.toString());
    }
}