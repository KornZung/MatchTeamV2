package com.diins.matchteamv2.mtx.screen;

import com.diins.matchteamv2.mtx.game.AbstractGame;
import com.diins.matchteamv2.mtx.interfaces.IScreenLoading;

public abstract class AbstractScreenLoading extends AbstractScreen implements
		IScreenLoading {

	// Loading time before proceed to next screen
	private float loadingTime;

	public AbstractScreenLoading(AbstractGame game, String screenName) {
		super(game, screenName);
		loadingTime = 1f;
		//
		setUpLoading();
	}

	/**
	 * Get loading time
	 * */
	public float getLoadingTime() {
		return loadingTime;
	}

	/**
	 * Set a loading / splash time. Sometimes AssetManager loads very fast. It
	 * may needed to wait specific amount of time to show logo, spash image,
	 * etc... before proceeding next screen
	 * */
	public void setLoadingTime(float loadingTime) {
		this.loadingTime = loadingTime;
	}
}
