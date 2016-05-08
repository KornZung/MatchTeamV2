package com.diins.matchteamv2;

import com.badlogic.gdx.Gdx;
import com.diins.matchteamv2.assets.Assets;
import com.diins.matchteamv2.assets.Constance;
import com.diins.matchteamv2.mtx.game.AbstractGame;
import com.diins.matchteamv2.mtx.settings.AppSettings;
import com.diins.matchteamv2.mtx.settings.MtxLogger;
import com.diins.matchteamv2.screens.MainScreen;

public class MatchTeamV2 extends AbstractGame {
	@Override
	public void create() {
		super.create();
		setScreen(new MainScreen(this, "Match Team v.2.0"));
	}

	@Override
	public void setUpAppSettings() {
		AppSettings.setUp(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),
				Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), Constance.WORLD_TARGET_WIDTH, Constance.WORLD_TARGET_HEIGHT);

		// Set log true/false (Very informative logs during development)
		// When you publish the game set as false for performance
		// ##########################################
		MtxLogger.setLogs(true);
	}

	@Override
	public void setUpAssets() {
		Assets assets = new Assets();
		assets.loadAll();
		setAssets(assets);
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setUpLoadingScreen() {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
