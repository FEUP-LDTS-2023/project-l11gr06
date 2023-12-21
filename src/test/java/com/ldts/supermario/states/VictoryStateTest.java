package com.ldts.supermario.states;

import com.ldts.supermario.controller.Controller;
import com.ldts.supermario.controller.VictoryController;
import com.ldts.supermario.model.Victory;
import com.ldts.supermario.viewer.VictoryViewer;
import com.ldts.supermario.viewer.Viewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class VictoryStateTest {

    @Test
    void getViewer() {
        Victory victory = new Victory();
        VictoryState victoryState = new VictoryState(victory);
        Viewer<Victory> viewer = victoryState.getViewer();
        assertEquals(VictoryViewer.class, viewer.getClass());
    }

    @Test
    void getController() {
        Victory victory = new Victory();
        VictoryState victoryState = new VictoryState(victory);
        Viewer<Victory> mockViewer = mock(VictoryViewer.class);
        Controller<Victory> controller = victoryState.getController();
        assertEquals(VictoryController.class, controller.getClass());
    }
}

