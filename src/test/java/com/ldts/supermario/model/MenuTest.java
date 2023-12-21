package com.ldts.supermario.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void testNextEntry() {
        Menu menu = new Menu();

        menu.nextEntry();
        assertTrue(menu.isSelectedHelp());
        assertFalse(menu.isSelectedStart());
        assertFalse(menu.isSelectedExit());

        menu.nextEntry();
        assertTrue(menu.isSelectedAbout());
        assertFalse(menu.isSelectedHelp());
        assertFalse(menu.isSelectedStart());

        menu.nextEntry();
        assertTrue(menu.isSelectedExit());
        assertFalse(menu.isSelectedHelp());
        assertFalse(menu.isSelectedStart());

        menu.nextEntry();
        assertTrue(menu.isSelectedStart());
        assertFalse(menu.isSelectedHelp());
        assertFalse(menu.isSelectedExit());

    }

    @Test
    void testPreviousEntry() {
        Menu menu = new Menu();

        menu.previousEntry();
        assertTrue(menu.isSelectedExit());
        assertFalse(menu.isSelectedHelp());
        assertFalse(menu.isSelectedStart());

        menu.previousEntry();
        assertTrue(menu.isSelectedAbout());
        assertFalse(menu.isSelectedExit());
        assertFalse(menu.isSelectedHelp());
    }

    @Test
    void GetCurrentEntryTest() {
        Menu menu = new Menu();
        assertEquals(0, menu.getCurrentEntry());

        menu.nextEntry();
        assertEquals(1, menu.getCurrentEntry());

        menu.previousEntry();
        assertEquals(0, menu.getCurrentEntry());
    }
    @Test
    void testGetEntry() {
        Menu menu = new Menu();

        assertEquals("START", menu.getEntry(0));
        assertEquals("HELP", menu.getEntry(1));
        assertEquals("ABOUT", menu.getEntry(2));
        assertEquals("EXIT", menu.getEntry(3));
    }

    @Test
    void testIsSelectedExit() {
        Menu menu = new Menu();

        assertFalse(menu.isSelectedExit());
        menu.nextEntry();
        assertFalse(menu.isSelectedExit());
        menu.nextEntry();
        assertFalse(menu.isSelectedExit());
        menu.nextEntry();
        assertTrue(menu.isSelectedExit());
    }

    @Test
    void testIsSelectedStart() {
        Menu menu = new Menu();

        assertTrue(menu.isSelectedStart());
        menu.nextEntry();
        assertFalse(menu.isSelectedStart());
        menu.nextEntry();
        assertFalse(menu.isSelectedStart());
        menu.nextEntry();
        assertFalse(menu.isSelectedStart());
    }

    @Test
    void testIsSelectedHelp() {
        Menu menu = new Menu();

        assertFalse(menu.isSelectedHelp());
        menu.nextEntry();
        assertTrue(menu.isSelectedHelp());
        menu.nextEntry();
        assertFalse(menu.isSelectedHelp());
        menu.nextEntry();
        assertFalse(menu.isSelectedHelp());
    }

    @Test
    void testIsSelectedAbout() {
        Menu menu = new Menu();

        assertFalse(menu.isSelectedAbout());
        menu.nextEntry();
        assertFalse(menu.isSelectedAbout());
        menu.nextEntry();
        assertTrue(menu.isSelectedAbout());
        menu.nextEntry();
        assertFalse(menu.isSelectedAbout());
    }

    @Test
    void testGetNumberEntries() {
        Menu menu = new Menu();

        assertEquals(4, menu.getNumberEntries());
    }
}

