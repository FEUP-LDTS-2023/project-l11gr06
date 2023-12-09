package com.aor.supermario.controller;

import com.aor.supermario.controller.Controller;
import com.aor.supermario.model.Map;
import com.aor.supermario.viewer.Viewer;

public abstract class GameController extends Controller<Map> {
    public GameController(Map map, Viewer v) {
        super(map, v);
    }
}