package com.sofkau.race.racespringbootconcepts.domain.usecase;

import com.sofkau.race.racespringbootconcepts.domain.Game;

public interface GameRepository {
    Game findById (String id);

    Game save(Game game);
}
