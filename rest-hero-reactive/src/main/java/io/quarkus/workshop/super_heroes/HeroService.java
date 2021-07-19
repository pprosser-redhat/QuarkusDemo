package io.quarkus.workshop.super_heroes;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import io.smallrye.mutiny.Uni;
import io.smallrye.reactive.messaging.kafka.Record;
import java.util.List;
@ApplicationScoped
public class HeroService {

    @Inject
    @Channel ("hero")
    Emitter<Record<Long, String>> emitter;

    public Uni<Hero> findHeroById(Long id) {
        Uni<Hero> hero = Hero.findById(id);
        return hero.onItem().invoke(i -> {
            emitter.send(Record.of (i.id, i.name));        
            });
    }
    public Uni<List<Hero>> findAllHeros() {
        return Hero.listAll();
    }
}
