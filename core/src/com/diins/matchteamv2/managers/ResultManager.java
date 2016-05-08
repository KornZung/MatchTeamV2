package com.diins.matchteamv2.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.diins.matchteamv2.mtx.game.AbstractGameManager;
import com.diins.matchteamv2.mtx.game.GameState;
import com.diins.matchteamv2.mtx.interfaces.IGameManager;
import com.diins.matchteamv2.mtx.screen.AbstractScreen;
import com.diins.matchteamv2.mtx.settings.AppSettings;
import com.diins.matchteamv2.screens.ResultScreen;
import com.diins.matchteamv2.worlds.WorldLayer_Scene;
import com.diins.matchteamv2.worlds.WorldMain;

import java.util.Iterator;

/**
 * Created by VM Win10 on 8/5/2559.
 */
public class ResultManager extends AbstractGameManager implements IGameManager {
    // World Screen2d
    public WorldMain worldMain;
    public WorldLayer_Scene worldLayer_Scene;

    private int people, team;

    ResultInputManager input;

    // Time
    long countDown;


//    // Tiled Map
//    private OrthogonalTiledMapRenderer renderer;
//    private OrthographicCamera cam;

    public ResultManager(Stage stage, AbstractScreen screen, int p_People, int p_Team) {
        super(stage, screen);

        //
        people = p_People;
        team = p_Team;
        //
        setUpPreManagers();
        //
        setGameState(GameState.GAME_RUNNING);

//        // set render
//        renderer = new OrthogonalTiledMapRenderer(Assets.tmObstruction, 1 / 40f);
//        cam = new OrthographicCamera();
//        cam.setToOrtho(false, Constance.WORLD_TARGET_WIDTH, Constance.WORLD_TARGET_HEIGHT);
//        cam.update();
    }

    private void setUpInputListener() {

        input = new ResultInputManager();
        input.setTouchListener(this);
    }

    @Override
    public void setUpData() {

    }

    @Override
    public void setUpPreManagers() {
        setUpWorld();
        //
        setUpInputListener();
        //
    }

    @Override
    public void setUpPostManagers() {

    }

    @Override
    public void setUpWorld() {
//
        // Create the main world and its world layers
        // #############################################################
        worldMain = new WorldMain(this, 0, 0, AppSettings.SCREEN_W,
                AppSettings.SCREEN_H);

        //
        // World layers
        // #############################################################


        worldLayer_Scene = new WorldLayer_Scene(this, 0, 0, AppSettings.SCREEN_W,
                AppSettings.SCREEN_H);

        //
        // Add all layers to world
        // #############################################################
        worldMain.addActor(worldLayer_Scene);

        //
        // Add the main world to stage
        // #############################################################
        getStage().addActor(worldMain);
    }

    @Override
    public void startLevel(int levelNumber) {

    }

    @Override
    public void checkGameCondition() {

    }

    public boolean isGameRunning(long p_CountDown) {
        boolean runGame = true;


        return runGame;
    }

    @Override
    public void update(float delta) {
        // Check Pause Game
        checkGameCondition();


        // Check Count Down
//        countDown = ((ResultScreen) getScreen()).getCountdown();
//        if (countDown <= 0) {
//            countDown = 0;
//        }

        if (isGameRunning(countDown)) {
//            //Game Running
//
            // set Label
            worldLayer_Scene.lblPeople.setText("People : " + Integer.toString(people));
            worldLayer_Scene.lblTeam.setText("Team : " + Integer.toString(team));
//
//            // Obstruction Move
//            if (worldLayer_obstruction.obsGroup.getTopObstruction() < (Constance.WORLD_TARGET_HEIGHT - Constance.OBSTRUCTION_LIMIT_TOP - (worldLayer_obstruction.obsGroup.getHeightObstruction() / 2))
//                    || worldLayer_obstruction.obsGroup.getTopObstruction() > worldLayer_ball.balls.getTopBall()) {
//                worldLayer_obstruction.obsGroup.startMove();
//            } else if (worldLayer_obstruction.obsGroup.getTopObstruction() < worldLayer_ball.balls.getTopBall()) {
//                worldLayer_obstruction.obsGroup.stopMove();
//            }
//
//            // Set Score
//            if (worldLayer_obstruction.obsGroup.getIsObsDestroyed()) {
//                // Obstuction was destroyed
//                score.setPoint(worldLayer_ball.balls.getBalls().size());
//
//                int point = score.getPoint();
//                worldLayer_Scene.lblScore.setText(point + "");
//                worldLayer_Scene.lblScore.setPosition((AppSettings.WORLD_WIDTH / 2) - (worldLayer_Scene.lblScore.getTextBounds().x / 2), (AppSettings.WORLD_HEIGHT) - 20);
//            }
//
//            // Manage balls
//            for (Iterator<Ball> items = worldLayer_ball.balls.getBalls().iterator(); items.hasNext(); ) {
//                final Ball item = items.next();
//
//                if (CollisionDetector.isActorsCollide(item, worldLayer_Scene.topSpike)) {
//                    item.destroyBall();
//
//                    items.remove();
//
//                    MtxLogger.log(logActive, true, logTag, "Ball Destroyed");
//                }
//            }
        } else {
            // End game
//            this.getStage().addAction(Actions.delay(0.5f,
//                    new Action() {
//                        @Override
//                        public boolean act(float delta) {
//                            if (!isEndgame) {
//                                MtxLogger.log(logActive, true, logTag, "EndGame");
//
//                                worldLayer_obstruction.obsGroup.stopMove();
//                                //setGameState(GameState.GAME_PAUSED);
//
//                                // Manage High Score
//                                int highScore = saveScore();
//                                ((GameScreen) getScreen()).gameHighScore.setText("High Score : " + highScore);
//
//                                ((GameScreen) getScreen()).gameMenuScreen.sendInMainMenuButtons(((GameScreen) getScreen()));
//
//                                isEndgame = true;
//                            }
//
//                            return false;
//                        }
//                    }
//            ));

        }

    }

    @Override
    public void saveGame() {

    }
}
