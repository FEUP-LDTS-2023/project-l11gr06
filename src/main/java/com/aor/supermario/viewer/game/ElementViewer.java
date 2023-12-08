package com.aor.supermario.viewer.game;

import com.aor.supermario.gui.GUI;
import com.aor.supermario.model.elements.Element;


public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
