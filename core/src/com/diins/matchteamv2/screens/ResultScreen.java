package com.diins.matchteamv2.screens;


import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.diins.matchteamv2.assets.Assets;
import com.diins.matchteamv2.assets.Constance;
import com.diins.matchteamv2.managers.ResultManager;
import com.diins.matchteamv2.mtx.game.AbstractGame;
import com.diins.matchteamv2.mtx.game.GameState;
import com.diins.matchteamv2.mtx.input.InputIntent;
import com.diins.matchteamv2.mtx.interfaces.IScreen;
import com.diins.matchteamv2.mtx.scene2d.ui.TableModel;
import com.diins.matchteamv2.mtx.screen.AbstractScreen;
import com.diins.matchteamv2.mtx.settings.AppSettings;

import java.util.Random;

/**
 * Created by VM Win10 on 8/5/2559.
 */
public class ResultScreen extends AbstractScreen implements IScreen {
    ResultManager manager;

    private int people, team;
    private Label lblText;
    private TableModel menuTable;


    private final float TIME_STEP = 1 / 300f;
    private long nanotime = System.nanoTime();

    // Swipe controls
    InputIntent inputIntent;
    float touchDragInterval;


    public ResultScreen(AbstractGame game, String screenName, int p_People, int p_Team) {
        super(game, screenName);

        // Setup debug render
//        DebugRenderUtil.initialDebugRender();

        people = p_People;
        team = p_Team;

        setUpScreenElements();
        setUpGameManager();
        setUpMenu();
    }

    public void setUpGameManager() {
        manager = new ResultManager(getStage(), this, people, team);
    }

    @Override
    public void setUpScreenElements() {
        // Reset system
        // #################################################################
        setSecondsTime(0);

        //
        // Set background image
        // #################################################################
        setBackgroundTexture(Assets.imgBG);

    }

    @Override
    public void setUpMenu() {
        setUpMainMenuButtons();
        sendInMainMenuButtons();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        float timeStep = TIME_STEP;

        //###### Box2D PAUSE GAME #####//
        if (manager.getGameState() == GameState.GAME_RUNNING) {
            // Timer
            if (System.nanoTime() - nanotime >= 1000000000) {
                nanotime = System.nanoTime();
            }

            //
            // Update game manager, (Useful for checking game condition)
            // ######################################################
            if (manager != null) {
                manager.update(delta);
            }
        } else {
            timeStep = 0;
        }
        //#######################//
    }

    public void setUpMainMenuButtons() {
        // After click number
        // Control Table
        // #################################################################
        menuTable = new TableModel(null,
                AppSettings.SCREEN_W, AppSettings.SCREEN_H);
        menuTable.setPosition(0, 50);
        menuTable.setFillParent(true);

        menuTable.setDebug(false);

        //
        // Btn Values
        // #################################################################
        Random rnd = new Random();
        float btnWidth = Constance.BUTTON_WIDTH;
        float btnHeight = Constance.BUTTON_HEIGHT;



        //
        getStage().addActor(menuTable);
    }

    // ### Show Button ###
    public void sendInMainMenuButtons() {


    }

    // ### Hide Button ###
    public void sendAwayMainMenuButtons() {


    }
}
