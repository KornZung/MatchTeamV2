package com.diins.matchteamv2.worlds;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.diins.matchteamv2.assets.Assets;
import com.diins.matchteamv2.assets.Constance;
import com.diins.matchteamv2.managers.ResultManager;
import com.diins.matchteamv2.mtx.scene2d.AbstractWorldScene2d;
import com.diins.matchteamv2.mtx.scene2d.models.EmptyActorLight;
import com.diins.matchteamv2.mtx.settings.AppSettings;

/**
 * Created by VM Win10 on 8/5/2559.
 */
public class WorldLayer_Scene extends AbstractWorldScene2d {
    ResultManager manager;

    // Game Actor
//    public EmptyActorLight topLine;
//    public EmptyActorLight topSpike;
//    public EmptyActorLight leftLine;
//    public EmptyActorLight rightLine;
    //
    public EmptyActorLight clockTime;
    //
    public Label lblPeople;
    public Label lblTeam;


    public WorldLayer_Scene(ResultManager gameManager, float posX, float posY,
                            float worldWidth, float worldHeight) {
        super(posX, posY, worldWidth, worldHeight);
        //
        this.manager = gameManager;
        //
//        setUpBoundary();
        //
        setOther();
        //
        setLabel();

    }

    private void setUpBoundary() {
//        // Top
//        topSpike = new EmptyActorLight(Constance.BOUNDARY_TOP_WIDTH, Constance.BOUNDARY_TOP_HEIGHT, true);
//        topSpike.setTextureRegion(Assets.imgTopLine, true);
//        topSpike.setPosition(Constance.BOUNDARY_MARGINX * AppSettings.getWorldSizeRatio()
//                , (Constance.WORLD_TARGET_HEIGHT - Constance.BOUNDARY_TOP_HEIGHT - Constance.BOUNDARY_TOP_MARGIN) * AppSettings.getWorldSizeRatio());
//        addActor(topSpike);
//
//        // Left / Right
//        leftLine = new EmptyActorLight(Constance.BOUNDARY_MARGINX + Constance.BOUNDARY_SHADOW_GAP, Constance.WORLD_TARGET_HEIGHT, true);
//        leftLine.setTextureRegion(Assets.imgGameBoundaryLeft, true);
//        leftLine.setPosition(0, 0);
//        addActor(leftLine);
//        rightLine = new EmptyActorLight(Constance.BOUNDARY_MARGINX + Constance.BOUNDARY_SHADOW_GAP, Constance.WORLD_TARGET_HEIGHT, true);
//        rightLine.setTextureRegion(Assets.imgGameBoundaryRight, true);
//        rightLine.setPosition((Constance.WORLD_TARGET_WIDTH - (Constance.BOUNDARY_MARGINX + Constance.BOUNDARY_SHADOW_GAP)) * AppSettings.getWorldSizeRatio(), 0);
//        addActor(rightLine);
//
//
//        groundUC = new GroundUnderConstructor(WorldUtil.createGroundUC(gameManager.world));
//        addActor(groundUC);
//
//        // Top Line
//        topLine = new EmptyActorLight(Constance.WORLD_TARGET_WIDTH, Constance.BOUNDARY_TOP_MARGIN, true);
//        topLine.setTextureRegion(Assets.imgGameBoundary, true);
//        topLine.setPosition(0, (Constance.WORLD_TARGET_HEIGHT - Constance.BOUNDARY_TOP_MARGIN) * AppSettings.getWorldSizeRatio());
//        addActor(topLine);
    }

    private void setOther() {
        // Clock
//        clockTime = new EmptyActorLight(Constance.GAMELINE_ICON, Constance.GAMELINE_ICON, true);
//        clockTime.setTextureRegion(Assets.imgClock, true);
//        float x = 0;
//        float y = ((Constance.WORLD_TARGET_HEIGHT - 6)  * AppSettings.getWorldSizeRatio());
//        clockTime.setPosition(x, y);
//        addActor(clockTime);
    }

    private void setLabel() {
        lblPeople = new Label("", new Label.LabelStyle(Assets.fontText, Color.BLACK));
        lblPeople.setFontScale(AppSettings.getWorldSizeRatio() * Constance.PIXEL_TO_WORLD / 1.75f);
        float x = (Constance.LABEL_PEOPLE_X * AppSettings.getWorldSizeRatio());
        float y = ((Constance.WORLD_TARGET_HEIGHT - Constance.LABEL_PEOPLE_Y)  * AppSettings.getWorldSizeRatio());
        lblPeople.setPosition(x, y);
        addActor(lblPeople);

        lblTeam = new Label("", new Label.LabelStyle(Assets.fontText, Color.BLACK));
        lblTeam.setFontScale(AppSettings.getWorldSizeRatio() * Constance.PIXEL_TO_WORLD / 1.75f);
        x = (((Constance.WORLD_TARGET_WIDTH / 2) + Constance.LABEL_TEAM_X) * AppSettings.getWorldSizeRatio());
        y = ((Constance.WORLD_TARGET_HEIGHT - Constance.LABEL_TEAM_Y)  * AppSettings.getWorldSizeRatio());
        lblTeam.setPosition(x, y);
        addActor(lblTeam);

    }
}
