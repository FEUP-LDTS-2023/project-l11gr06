package com.ldts.supermario.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AboutTest {

    @Test
    void testNextEntry() {
        About about = new About();

        about.nextEntry();
        assertTrue(about.isSelectedMenu());
    }

    @Test
    void testPreviousEntry() {
        About about = new About();

        about.previousEntry();
        assertTrue(about.isSelectedMenu());
    }

    @Test
    void testGetEntry() {
        About about = new About();

        assertEquals("RETURN TO MENU", about.getEntry(0));
    }

    @Test
    void testIsSelectedMenu() {
        About about = new About();

        assertTrue(about.isSelectedMenu());
        about.nextEntry();
        assertTrue(about.isSelectedMenu());
        about.previousEntry();
        assertTrue(about.isSelectedMenu());
    }

    @Test
    void testGetNumberEntries() {
        About about = new About();

        assertEquals(1, about.getNumberEntries());
    }
}
