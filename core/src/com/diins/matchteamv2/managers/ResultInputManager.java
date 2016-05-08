package com.diins.matchteamv2.managers;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.JointEdge;
import com.badlogic.gdx.physics.box2d.QueryCallback;
import com.badlogic.gdx.physics.box2d.joints.MouseJoint;
import com.badlogic.gdx.physics.box2d.joints.MouseJointDef;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.Array;
import com.diins.matchteamv2.mtx.input.InputIntent;
import com.diins.matchteamv2.mtx.settings.AppSettings;
import com.diins.matchteamv2.mtx.settings.MtxLogger;

/**
 * Created by VM Win10 on 8/5/2559.
 */
public class ResultInputManager {

    InputIntent inputIntent;
    float touchDragInterval;

    Vector3 testPoint = new Vector3();
    Body hitBody = null;
    MouseJoint mouseJoint = null;

    public ResultInputManager() {
        inputIntent = new InputIntent();
    }

    QueryCallback callback = new QueryCallback() {
        @Override
        public boolean reportFixture(Fixture fixture) {
            //### if the hit fixture's body is the ground body
            //### we ignore it
            //if (WorldUtil.bodyIsGround(fixture.getBody())) return true;

            //### if the hit point is inside the fixture of the body
            //### we report it
            if (fixture.testPoint(testPoint.x, testPoint.y)) {
                hitBody = fixture.getBody();
                return false;
            } else
                return true;
        }
    };

    public void setTouchListener(final ResultManager manager) {
        manager.getStage().addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //### translate the mouse coordinates to world coordinates
                testPoint.set(x / AppSettings.getWorldPositionXRatio(), y / AppSettings.getWorldPositionYRatio(), 0);
                //camera.unproject(testPoint);

                //### ask the world which bodies are within the given
                //### bounding box around the mouse pointer
                hitBody = null;
//                manager.world.QueryAABB(callback, testPoint.x - 0.1f, testPoint.y - 0.1f, testPoint.x + 0.1f, testPoint.y + 0.1f);

                  //### return ture for active touchUp anc touchDrag event
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                // if a mouse joint exists we simply destroy it
//                if(hitBody != null) {
//                    // getJoint for destroyJoint
//                    Array<JointEdge> list = hitBody.getJointList();
//
//                    if (mouseJoint != null) {
//                        MtxLogger.log(true, true, "InputManager", "mouseJoint != null " + list.size);
//                        if (list.size > 0) {
//                            manager.world.destroyJoint(mouseJoint);
//                            MtxLogger.log(true, true, "InputManager", "destroyed mouseJoint success");
//                        }
//
//                        MtxLogger.log(true, true, "InputManager", "end destroy mouseJoint");
//
//                        mouseJoint = null;
//                    }
//                }
//                else if (hitBody == null) {
//                    manager.worldLayer_ball.balls.jumpBalls();
//                }
                //Stop Rotate Obstruction
//                manager.worldLayer_obstruction.obsGroup.rotateStop();
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                // if a mouse joint exists we simply update
                // the target of the joint based on the new
                // mouse coordinates
                if (mouseJoint != null) {
                    testPoint.set(x / AppSettings.getWorldPositionXRatio(), y / AppSettings.getWorldPositionYRatio(), 0);

                    mouseJoint.setTarget(new Vector2(testPoint.x, testPoint.y));
                }
            }
        });
    }
}
