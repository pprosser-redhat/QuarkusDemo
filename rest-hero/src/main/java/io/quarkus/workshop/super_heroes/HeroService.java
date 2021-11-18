package io.quarkus.workshop.super_heroes;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

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
}