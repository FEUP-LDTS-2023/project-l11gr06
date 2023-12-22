package com.ldts.supermario.states;
import com.ldts.supermario.Game;
import com.ldts.supermario.controller.Controller;
import com.ldts.supermario.controller.MapController;
import com.ldts.supermario.controller.MonsterMoving;
import com.ldts.supermario.controller.TurtleShellMoving;
import com.ldts.supermario.model.Map;
import com.ldts.supermario.viewer.Viewer;
import com.ldts.supermario.viewer.game.GameViewer;

public class GameState extends State<Map> {
    private Game game;
    Thread t1 = new Thread(new MonsterMoving(
            this.getViewer().getModel(),
            this.getViewer(),
            game));

    public GameState(Map map) {
        super(map);
        t1.start();
    }

    @Override
    public Viewer<Map> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Map> getController() {
        return new MapController(getModel(), getViewer());
    }
}
