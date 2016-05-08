package com.diins.matchteamv2.worlds;

import com.diins.matchteamv2.managers.ResultManager;
import com.diins.matchteamv2.mtx.game.GameState;
import com.diins.matchteamv2.mtx.scene2d.AbstractWorldScene2d;

/**
 * Created by VM Win10 on 8/5/2559.
 */
public class WorldMain extends AbstractWorldScene2d {
    ResultManager resultManager;

    public WorldMain(ResultManager gameManager, float posX, float posY,
                         float worldWidth, float worldHeight) {
        super(posX, posY, worldWidth, worldHeight);
        //
        this.resultManager = gameManager;


    }

    @Override
    public void act(float delta) {
        //
        // Actors act under the world if only game state is Running
        // ####################################################################
        if (resultManager.getGameState() == GameState.GAME_RUNNING) {
            super.act(delta);
        }
    }
}

