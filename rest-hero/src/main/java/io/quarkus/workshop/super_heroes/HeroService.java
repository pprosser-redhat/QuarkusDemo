package io.quarkus.workshop.super_heroes;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class HeroService {
    
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
        return hero;
    }

    @Transactional
    public void deleteHero(Long id) {
        Hero.deleteById(id);
    }
}