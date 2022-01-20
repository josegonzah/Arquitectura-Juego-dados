package com.sofkau.race.racespringbootconcepts.infra.entrypoints;


import com.sofkau.race.racespringbootconcepts.infra.documents.GameDocument;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class GameQueryController {

    private final MongoTemplate repository;

    public GameQueryController(MongoTemplate template){
        this.repository = template;
    }

    @GetMapping("/game/{id}")
    public GameDocument getGame(@PathVariable("id") String id){
        Query query = new Query(Criteria.where("_id").is(id));
        return repository.findOne(query, GameDocument.class, "game");
    }
}
