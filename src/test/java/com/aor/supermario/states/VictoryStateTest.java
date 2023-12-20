package com.aor.supermario.states;

import com.aor.supermario.controller.Controller;
import com.aor.supermario.controller.VictoryController;
import com.aor.supermario.model.Victory;
import com.aor.supermario.viewer.VictoryViewer;
import com.aor.supermario.viewer.Viewer;
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

