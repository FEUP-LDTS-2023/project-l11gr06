package com.aor.supermario.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class VictoryTest {

    @Test
    void nextEntryTest() {
        Victory victory = new Victory();

        victory.nextEntry();
        assertTrue(victory.isSelectedMenu());
        assertFalse(victory.isSelectedPlayAgain());
        assertFalse(victory.isSelectedExit());

        victory.nextEntry();
        assertTrue(victory.isSelectedExit());
        assertFalse(victory.isSelectedMenu());
        assertFalse(victory.isSelectedPlayAgain());

        victory.nextEntry();
        assertTrue(victory.isSelectedPlayAgain());
        assertFalse(victory.isSelectedExit());
        assertFalse(victory.isSelectedMenu());
    }

    @Test
    void previousEntryTest() {
        Victory victory = new Victory();

        victory.previousEntry();
        assertTrue(victory.isSelectedExit());
        assertFalse(victory.isSelectedMenu());
        assertFalse(victory.isSelectedPlayAgain());

        victory.previousEntry();
        assertTrue(victory.isSelectedMenu());
        assertFalse(victory.isSelectedPlayAgain());
        assertFalse(victory.isSelectedExit());

        victory.previousEntry();
        assertTrue(victory.isSelectedPlayAgain());
        assertFalse(victory.isSelectedExit());
        assertFalse(victory.isSelectedMenu());
    }

    @Test
    void getEntryTest() {
        Victory victory = new Victory();

        assertEquals("PLAY AGAIN", victory.getEntry(0));
        assertEquals("MENU", victory.getEntry(1));
        assertEquals("EXIT", victory.getEntry(2));
    }

    @Test
    void isSelectedExitTest() {
        Victory victory = new Victory();

        assertFalse(victory.isSelectedExit());
        victory.nextEntry();
        assertFalse(victory.isSelectedExit());
        victory.nextEntry();
        assertTrue(victory.isSelectedExit());
    }

    @Test
    void isSelectedPlayAgainTest() {
        Victory victory = new Victory();

        assertTrue(victory.isSelectedPlayAgain());
        victory.nextEntry();
        assertFalse(victory.isSelectedPlayAgain());
        victory.nextEntry();
        assertFalse(victory.isSelectedPlayAgain());
    }

    @Test
    void isSelectedMenuTest() {
        Victory victory = new Victory();

        assertFalse(victory.isSelectedMenu());
        victory.nextEntry();
        assertTrue(victory.isSelectedMenu());
        victory.nextEntry();
        assertFalse(victory.isSelectedMenu());
    }

    @Test
    void getNumberEntriesTest() {
        Victory victory = new Victory();

        assertEquals(3, victory.getNumberEntries());
    }
}
