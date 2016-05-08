package com.diins.matchteamv2.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.diins.matchteamv2.mtx.animation.AnimationCreator;
import com.diins.matchteamv2.mtx.asset.AbstractAssets;
import com.diins.matchteamv2.mtx.interfaces.IAssets;

public class Assets extends AbstractAssets implements IAssets {
	private final static String ASSETS_FOLDER = "data";
	private final static String FILE_IMAGE_ATLAS = ASSETS_FOLDER + "/imageatlas.atlas";
	private final static String FILE_UI_SKIN = "skin/uiskin.json";
	private final static String FILE_OBSTRUCTION = ASSETS_FOLDER + "/physics/Obstruction001.json";
	//private final static String FILE_TILEDMAP = "tiledmap/Obstruction_001.tmx";
	public static TextureAtlas imageAtlas;
	public static Skin skin;
	
	//##### Images #####
	// Loading
//	public static TextureRegion imgBGLoading;
	public static TextureRegion imgBG;
//	public static TextureRegion imgLoadingLogo;
//	public static TextureRegion imgLoading;

	// End Screen
//	public static TextureRegion imgMenuModel;
//	public static TextureRegion imgMenuPanel;
//	public static TextureRegion imgGameOver;
//	public static TextureRegion imgScore;

	// Ball
//	public static TextureRegion imgCircle;

	// Game screen
//	public static TextureRegion imgGameBG;
//	public static TextureRegion imgGameBoundary;
//	public static TextureRegion imgGameBoundaryLeft;
//	public static TextureRegion imgGameBoundaryRight;
//	public static TextureRegion imgGameLine;
//	public static TextureRegion imgTopLine;
	public static TextureRegion imgClock;

	// Obstruction
//	public static TextureRegion imgObs001;
//	public static TextureRegion imgObs002;
//	public static TextureRegion imgObs003;
//	public static TextureRegion imgObs003_1;
//	public static TextureRegion imgObs003_2;

	//#####################

	// Animation
//	public static Animation animCircle;
//	public static Animation animeBallExplosion;
	
	// Fonts
	public static BitmapFont fontScore;
	public static BitmapFont fontText;
//	public static BitmapFont fontGameOver;

	// Buttons
	public static TextureRegion btnMainPlay;
//	public static TextureRegion btnMainCredit;
//	public static TextureRegion btnReplay;

	// Tiled Map
	//public static TiledMap tmObstruction;

	// File for JSON
	public static FileHandle fObstructor;
	
	public static Texture loadTexture (String file) {
		return new Texture(Gdx.files.internal(file));
	}
	
	public static TextureAtlas getAtlas(){
        if( imageAtlas == null ) {
        	imageAtlas = new TextureAtlas( Gdx.files.internal(FILE_IMAGE_ATLAS));
        }
        return imageAtlas;
    }
	
    public Skin getSkin(){
        if( skin == null ) {
            FileHandle skinFile = Gdx.files.internal(FILE_UI_SKIN);
            skin = new Skin( skinFile );
        }
        return skin;
    }
	
	public void loadAll(){
		relaseResources();
		loadImages();
		loadButtons();
		loadFonts();
		loadAnimations();
		loadTiledMap();
		loadFile();
	}

	private static void relaseResources() {
		skin = null;
		imageAtlas = null;
	}

	public void loadImages(){
//		imgMtxBg = new TextureRegion(loadTexture(ASSETS_FOLDER + "/bgmtx.jpg"), 0, 0, 800, 480);

//		imgBGLoading = getAtlas().findRegion("img_splash_smallbg");
//		imgLoadingLogo = getAtlas().findRegion("img_splash_logo");
		imgBG = getAtlas().findRegion("img_main_smallbg");
//		imgLoading = getAtlas().findRegion("img_loading_01_");

		// Ball
//		imgCircle = getAtlas().findRegion("img_circle_01_");

		// Game Screen
//		imgGameBG = getAtlas().findRegion("img_game_small_bg");
//		imgGameBoundary = getAtlas().findRegion("img_game_white_small_bg");
//		imgGameBoundaryLeft = getAtlas().findRegion("img_boundary_left");
//		imgGameBoundaryRight = getAtlas().findRegion("img_boundary_right");
//		imgGameLine = getAtlas().findRegion("img_line");
//		imgTopLine = getAtlas().findRegion("img_top_boundary");
		imgClock = getAtlas().findRegion("img_game_time");

		// Game End screen
//		imgMenuModel = getAtlas().findRegion("img_model_smallbg");
		//imgMenuPanel =  getAtlas().findRegion("");
		//imgGameOver =  getAtlas().findRegion("");
		//imgScore =  getAtlas().findRegion("");

		// Obstruction
//		imgObs001 = getAtlas().findRegion("img_obstruction_001_");
//		imgObs002 = getAtlas().findRegion("img_obstruction_002_");
//		imgObs003 = getAtlas().findRegion("img_obstruction_003_");
//		imgObs003_1 = getAtlas().findRegion("img_obstruction_003_1_");
//		imgObs003_2 = getAtlas().findRegion("img_obstruction_003_2_");
	}
	
	public void loadButtons(){
		btnMainPlay = getAtlas().findRegion("btn_main_play");
//		btnMainCredit = getAtlas().findRegion("btn_main_credit");

		// End Game Screen
//		btnReplay =getAtlas().findRegion("btn_menu_replay");
	}
	
	public void loadFonts(){
		fontScore = new BitmapFont(Gdx.files.internal("skin/bevanfont.fnt"), Gdx.files.internal("skin/bevanfont.png"), false);
		fontText = new BitmapFont(Gdx.files.internal("skin/robotofont.fnt"), Gdx.files.internal("skin/robotofont.png"), false);
	}
	
	public void loadAnimations(){
//		animBatFlyRight = AnimationCreator.getAnimationFromSingleTexture(getAtlas(), "animbatflyright", 6, 0.065f);
//		animCircle = AnimationCreator.getAnimationFromMultiTextures(getAtlas(), "ball1/img_circle", 8, 0.065f, false, false);
	}

	public void loadTiledMap() {
		//tmObstruction = new TmxMapLoader().load(FILE_TILEDMAP);
	}

	public void loadFile(){
		fObstructor = Gdx.files.internal(FILE_OBSTRUCTION);
	}

    @Override
    public void loadSkin() {
    }

    @Override
    public void loadTextureAtlas() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void loadSoundsAndMusics() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
