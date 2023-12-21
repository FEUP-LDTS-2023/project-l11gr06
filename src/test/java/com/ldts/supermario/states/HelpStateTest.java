package com.ldts.supermario.states;

import com.ldts.supermario.controller.Controller;
import com.ldts.supermario.controller.HelpController;
import com.ldts.supermario.model.Help;
import com.ldts.supermario.viewer.HelpViewer;
import com.ldts.supermario.viewer.Viewer;
import org.junit.jupiter.api.Test;

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
