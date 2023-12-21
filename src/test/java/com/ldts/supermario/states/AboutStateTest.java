package com.ldts.supermario.states;

import com.ldts.supermario.controller.AboutController;
import com.ldts.supermario.controller.Controller;
import com.ldts.supermario.model.About;
import com.ldts.supermario.viewer.AboutViewer;
import com.ldts.supermario.viewer.Viewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class AboutStateTest {

    @Test
    void getViewer() {
        About about = new About();
        AboutState aboutState = new AboutState(about);
        Viewer<About> viewer = aboutState.getViewer();
        assertEquals(AboutViewer.class, viewer.getClass());
    }

    @Test
    void getController() {
        About about = new About();
        AboutState aboutState = new AboutState(about);
        Viewer<About> mockViewer = mock(AboutViewer.class);
        Controller<About> controller = aboutState.getController();
        assertEquals(AboutController.class, controller.getClass());
    }
}
