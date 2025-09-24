package quarkus.workshop.super_heroes;

import java.util.List;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HeroService {

    @Channel("new-hero") Emitter<org.acme.kafka.hero.Hero> heroEmitter;

    public List<Hero> findAllHeroes(){
        return Hero.listAll();
    }

    public Hero findHeroById(Long id) {
        Hero hero = Hero.findById(id);

        if (hero != null){

            org.acme.kafka.hero.Hero avroHero = new org.acme.kafka.hero.Hero(hero.name, hero.otherName, hero.level, hero.picture, hero.powers);
            
            heroEmitter.send(avroHero);

            return hero;
        } else {
            return null;
        }
    }
}
