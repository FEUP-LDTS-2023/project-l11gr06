package com.ldts.supermario.viewer.game;

import com.ldts.supermario.gui.GUI;
import com.ldts.supermario.model.elements.Element;


public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
