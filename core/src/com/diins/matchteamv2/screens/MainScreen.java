package com.diins.matchteamv2.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.diins.matchteamv2.assets.Assets;
import com.diins.matchteamv2.assets.Constance;
import com.diins.matchteamv2.mtx.game.AbstractGame;
import com.diins.matchteamv2.mtx.input.InputIntent;
import com.diins.matchteamv2.mtx.interfaces.IScreen;
import com.diins.matchteamv2.mtx.scene2d.effects.EffectCreator;
import com.diins.matchteamv2.mtx.scene2d.models.SmartActor;
import com.diins.matchteamv2.mtx.scene2d.ui.TableModel;
import com.diins.matchteamv2.mtx.screen.AbstractScreen;
import com.diins.matchteamv2.mtx.settings.AppSettings;

import java.util.Random;

/**
 * Created by VM Win10 on 7/5/2559.
 */
public class MainScreen  extends AbstractScreen implements IScreen {
    public Label lblText;
    public TextField txtPeople, txtTeam;
    public TableModel menuTable;
    public SmartActor btnPlay;

    // Manage Buttons

    // Swipe controls
    InputIntent inputIntent;
    float touchDragInterval;

    public MainScreen(AbstractGame game, String screenName) {
        super(game, screenName);

        setUpScreenElements();
        setUpMenu();
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

        // Screen time / Fps
        // Update by overriding render
        // #########################################################
        lblText = new Label("", getGame().getAssets().getSkin());
//        lblText = new Label("", new Label.LabelStyle(Assets.fontText, Color.WHITE));
        lblText.setPosition(20, (AppSettings.WORLD_HEIGHT) - 40);
        getStage().addActor(lblText);

        //
        // InputIntent for swipes/drags
        // #################################################################
        inputIntent = new InputIntent();
        touchDragInterval = AppSettings.SCREEN_H / 3.0f;
        inputIntent.setTouchDragIntervalRange(touchDragInterval);
    }

    @Override
    public void setUpMenu() {
        setUpMainMenuButtons();
        sendInMainMenuButtons();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        lblText.setText("Time : " + getScreenTime());

    }

    public void setUpMainMenuButtons() {
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
        // Text Box
        // #################################################################
        txtPeople = new TextField("", getGame().getAssets().getSkin());
        txtPeople.setOrigin(txtPeople.getWidth() / 2.0f, txtPeople.getHeight() / 2.0f);
        txtPeople.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());

        txtTeam = new TextField("", getGame().getAssets().getSkin());
        txtTeam.setOrigin(txtTeam.getWidth() / 2.0f, txtTeam.getHeight() / 2.0f);
        txtTeam.setTextFieldFilter(new TextField.TextFieldFilter.DigitsOnlyFilter());
        //
        // Btn Play
        // #################################################################
        btnPlay = new SmartActor(btnWidth,
                btnHeight, rnd, true);
        btnPlay.setTextureRegion(Assets.btnMainPlay, true);
        btnPlay.setOrigin(
                btnPlay.getWidth() / 2.0f,
                btnPlay.getHeight() / 2.0f);
        btnPlay.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y,
                                  int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                //
                btnPlay.clearActions();
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                //
                EffectCreator.create_SC_SHK_BTN(btnPlay,
                        1.3f, 1.3f, 5f, 0, 0.05f, null, false);

                btnPlay.addAction(Actions.sequence(
                        Actions.fadeOut(0.8f),
                        new Action() {
                            @Override
                            public boolean act(float delta) {
                                int people = 0, team = 0;

                                if(txtPeople.getText() != null && !txtPeople.getText().isEmpty())
                                {
                                    people = Integer.parseInt(txtPeople.getText());
                                }

                                if(txtTeam.getText() != null && !txtTeam.getText().isEmpty())
                                {
                                    team = Integer.parseInt(txtTeam.getText());
                                }

                                getGame().setScreen(new ResultScreen(getGame(), "Select card!!", people, team));
                                return false;
                            }
                        }
                ));

                txtPeople.addAction(Actions.sequence(
                        Actions.fadeOut(0.8f)
                ));
                txtTeam.addAction(Actions.sequence(
                        Actions.fadeOut(0.8f)
                ));
            }
        });


        //
        // Add TO Table
        // #################################################################
        menuTable.add(txtPeople).pad(10);
        menuTable.row();
        menuTable.add(txtTeam).pad(10);
        menuTable.row();
        menuTable.add(btnPlay).pad(40);

        //
        getStage().addActor(menuTable);
    }

    // ### Show Button ###
    public void sendInMainMenuButtons() {

        EffectCreator.create_SC_BTO(txtPeople, 1.3f, 1.3f, 0.4f, null, false);
        EffectCreator.create_SC_BTO(txtTeam, 1.3f, 1.3f, 0.4f, null, false);
        EffectCreator.create_SC_BTO(btnPlay, 1.3f, 1.3f, 0.6f, null, false);

        //
        btnPlay.setTouchable(Touchable.enabled);
    }

    // ### Hide Button ###
    public void sendAwayMainMenuButtons() {

        EffectCreator.create_SC(txtPeople, 0f, 0f, 0.4f, null, false);
        EffectCreator.create_SC(txtTeam, 0f, 0f, 0.4f, null, false);
        EffectCreator.create_SC(btnPlay, 0f, 0f, 0.4f, null, false);

        //
        btnPlay.setTouchable(Touchable.disabled);
    }
}
