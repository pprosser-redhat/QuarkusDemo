package io.quarkus.workshop.super_heroes;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HeroService {
    
    public List<Hero> findAllHeros() {

        return Hero.listAll();
    }
    public Hero findHeroById(Long id) {
        return Hero.findById(id);
    }
}