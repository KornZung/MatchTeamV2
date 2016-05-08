package com.diins.matchteamv2.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Pakorn on 22/7/2558.
 */
public class Constance {
    // ####### RATE PIXEL -> WORLD = PIXEL * 0.025 (W : 540 , H : 960) ######
    // World Screen2d
    public final static float WORLD_TARGET_WIDTH = 14f;//13.5f; // 540;
    public final static float WORLD_TARGET_HEIGHT = Gdx.graphics.getHeight() * WORLD_TARGET_WIDTH / Gdx.graphics.getWidth();//24f; // 960;
    public final static float PIXEL_TO_WORLD = 1/72f;

    // Game System

    // Result Scene
    public final static float LABEL_PEOPLE_X = 2f;
    public final static float LABEL_PEOPLE_Y = 2f;
    public final static float LABEL_TEAM_X = 2f;
    public final static float LABEL_TEAM_Y = 2f;


    // Game Boundary
//    public final static float BOUNDARY_MARGINX = 2f;
//    public final static float BOUNDARY_MARGINY = 2f;
//    public final static float BOUNDARY_SHADOW_GAP = 0.25f;
//    public final static float BOUNDARY_TOP_MARGIN = 2f;
//    public final static float BOUNDARY_TOP_WIDTH = 10f;
//    public final static float BOUNDARY_TOP_HEIGHT = 0.7f;
    // Game Line
//    public final static float GAMELINE_WIDTH = 4.775f; //191f;
//    public final static float GAMELINE_HEIGHT = 0.5f; //20f;
//    public final static float GAMELINE_TOP = 0.5f;
//    public final static float GAMELING_DENSITY = 0f;
//    public static final float GAMELINE_SPEED = 1.5f;
    // Game Item
    public static final float GAMELINE_ICON = 1f;

    // World Box2d
    public final static Vector2 WORLD_GRAVITY = new Vector2(0, -9.81f);

    // Loading
//    public final static float LOADING_LOGO_WIDTH = 96f;
//    public final static float LOADING_LOGO_HEIGHT = 317f;
//
//    public final static float LOADING_WIDTH = 2.5f;
//    public final static float LOADING_HEIGHT = 2.5f;

    // End menu screen
//    public final static float MENU_PANEL_WIDTH = 11f;
//    public final static float MENU_PANEL_HEIGHT = 10f;
//    public final static float SCORE_WIDTH = 11f;
//    public final static float SCORE_HEIGHT = 3.75f;
//    public final static float HIGHSCORE_WIDTH = 11f;
//    public final static float HIGHSCORE_HEIGHT = 3.75f;

    // Control
//    public final static float BUTTON_MENU_REPLAY_WIDTH = 3.75f;
//    public final static float BUTTON_MENU_REPLAY_HEIGHT = 3.75f;
    public final static float TEXTBOX_WIDTH = 4.65f;
    public final static float TEXTBOX_HEIGHT = 2.2f;
    public final static float BUTTON_WIDTH = 4.65f;
    public final static float BUTTON_HEIGHT = 2.2f;

    // Balls
//    public final static int BALL_NUMBER_IN_GAME = 1;
//    public final static float BALL_WIDTH = 1.5f;
//    public final static float BALL_HEIGHT = 1.5f;
//    public final static float BALL_DENSITY = 0.5f;
//    public final static float BALL_RESTITUTION = 0.5f;
//    public final static float BALL_GRAVITY_SCALE = 3f;
//    public final static Vector2 BALL_LINEAR_VELOCITY = new Vector2(0, -9.81f);
//    public final static float BALL_ACCELERATION = 250f;

    // Obstruction
//    public final static float OBSTRUCTION_SCALE = 10f;
//    public final static float OBSTRUCTION_LIMIT_TOP = BOUNDARY_TOP_HEIGHT + BOUNDARY_TOP_MARGIN + 2.75f;
//    public final static float OBSTRUCTION_SPEED_LINEAR_X = 0f;
//    public final static float OBSTRUCTION_SPEED_LINEAR_Y = 5f;
//    public final static float OBSTRUCTION_ROTATE_LEFT = 1f;
//    public final static float OBSTRUCTION_ROTATE_RIGHT = -1f;
//    public final static float OBSTRUCTION_GapY = 2f;
//    public final static int OBSTRUCTION_SIZE = 8; // �ӹǹ��觡մ��ҧ
//    public final static int OBSTRUCTION_SIZE_SHOW = 5;
//    public final static String OBSTRUCTION_NUMBER_1 = "Obstruction001";
//    public final static String OBSTRUCTION_NUMBER_2 = "Obstruction002";
//    public final static String OBSTRUCTION_NUMBER_3 = "Obstruction003";
//    public final static String OBSTRUCTION_NUMBER_3_1 = "Obstruction003_1";
//    public final static String OBSTRUCTION_NUMBER_3_2 = "Obstruction003_2";

}
