package com.aor.supermario.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelpTest {

    @Test
    void testNextEntry() {
        Help help = new Help();

        help.nextEntry();
        assertTrue(help.isSelectedMenu());
    }

    @Test
    void testPreviousEntry() {
        Help help = new Help();

        help.previousEntry();
        assertTrue(help.isSelectedMenu());
    }

    @Test
    void testGetEntry() {
        Help help = new Help();

        assertEquals("RETURN TO MENU", help.getEntry(0));
    }

    @Test
    void testIsSelectedMenu() {
        Help help = new Help();

        assertTrue(help.isSelectedMenu());
        help.nextEntry();
        assertTrue(help.isSelectedMenu());
        help.previousEntry();
        assertTrue(help.isSelectedMenu());
    }

    @Test
    void testGetNumberEntries() {
        Help help = new Help();

        assertEquals(1, help.getNumberEntries());
    }
}
