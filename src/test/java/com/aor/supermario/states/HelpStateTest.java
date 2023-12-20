package com.aor.supermario.states;

import com.aor.supermario.controller.Controller;
import com.aor.supermario.controller.HelpController;
import com.aor.supermario.model.Help;
import com.aor.supermario.viewer.HelpViewer;
import com.aor.supermario.viewer.Viewer;
import com.aor.supermario.states.HelpState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class HelpStateTest {

    @Test
    void getViewer() {
        Help help = new Help();
        HelpState helpState = new HelpState(help);
        Viewer<Help> viewer = helpState.getViewer();
        assertEquals(HelpViewer.class, viewer.getClass());
    }

    @Test
    void getController() {
        Help help = new Help();
        HelpState helpState = new HelpState(help);
        Viewer<Help> mockViewer = mock(HelpViewer.class);
        Controller<Help> controller = helpState.getController();
        assertEquals(HelpController.class, controller.getClass());
    }
}
