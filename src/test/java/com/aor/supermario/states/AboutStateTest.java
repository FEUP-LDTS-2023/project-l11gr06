package com.aor.supermario.states;

import com.aor.supermario.controller.AboutController;
import com.aor.supermario.controller.Controller;
import com.aor.supermario.model.About;
import com.aor.supermario.viewer.AboutViewer;
import com.aor.supermario.viewer.Viewer;
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
