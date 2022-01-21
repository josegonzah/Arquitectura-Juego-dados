package com.sofkau.race.racespringbootconcepts.infra.repository;

import com.sofkau.race.racespringbootconcepts.domain.Game;
import com.sofkau.race.racespringbootconcepts.domain.User;
import com.sofkau.race.racespringbootconcepts.domain.factory.GameBuilder;
import com.sofkau.race.racespringbootconcepts.domain.usecase.GameRepository;
import com.sofkau.race.racespringbootconcepts.infra.documents.GameDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class MongoGameRepository implements GameRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Game findById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        var document = mongoTemplate.findOne(query, GameDocument.class, "race");
        var builder = new GameBuilder();
        Optional.ofNullable(document).ifPresent((doc)->{
            builder.withTitle(doc.getTitle());
            builder.withTrackDistance(doc.getNumberOfThrows());
            builder.withState(doc.isState());
            builder.withPodium(doc.getPositions());
            builder.withNumberOfPlayers(doc.getNumberOfPlayers());
            doc.getUsers().forEach((key, userDocument)->{
                builder.withUser(User.from(key,
                        userDocument.getUserName(),
                        userDocument.getNumberOfWins(),
                        userDocument.getScoreTotal(),
                        userDocument.getAvatar()));
            });
        });
        return Game.from(id, builder);
    }

    @Override
    public Game save(Game game) {
        var raceDocument = new GameDocument();
        raceDocument.setId(game.id());
        raceDocument.setTitle(game.title());
        raceDocument.setPositions(game.positions());
        raceDocument.setNumberOfPlayers(game.numberOfPlayers());
        raceDocument.setNumberOfThrows(game.numberOfThrows());
        raceDocument.setState(game.state());
        game.users().forEach((key, user)->{
            raceDocument.withUser(user);
        });
        mongoTemplate.save(raceDocument, "race");
        return game;
    }
}
