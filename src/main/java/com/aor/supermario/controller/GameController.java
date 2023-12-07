package com.aor.supermario.controller;

import com.aor.supermario.controller.Controller;
import com.aor.supermario.model.Map;

public abstract class GameController extends Controller<Map> {
    public GameController(Map map) {
        super(map);
    }
}