package com.ldts.supermario.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOverTest {

    @Test
    void testNextEntry() {
        GameOver gameOver = new GameOver();

        gameOver.nextEntry();
        assertTrue(gameOver.isSelectedMenu());
    }

    @Test
    void testPreviousEntry() {
        GameOver gameOver = new GameOver();

        gameOver.previousEntry();
        assertTrue(gameOver.isSelectedExit());
    }

    @Test
    void testGetCurrentEntry() {
        GameOver gameOver = new GameOver();

        assertEquals(0, gameOver.getCurrentEntry());
    }

    @Test
    void testGetEntry() {
        GameOver gameOver = new GameOver();

        assertEquals("RESTART", gameOver.getEntry(0));
        assertEquals("RETURN TO MENU", gameOver.getEntry(1));
        assertEquals("EXIT", gameOver.getEntry(2));
    }

    @Test
    void testIsSelectedRestart() {
        GameOver gameOver = new GameOver();

        assertTrue(gameOver.isSelectedRestart());
        gameOver.nextEntry();
        assertFalse(gameOver.isSelectedRestart());
        gameOver.nextEntry();
        assertFalse(gameOver.isSelectedRestart());
    }

    @Test
    void testIsSelectedMenu() {
        GameOver gameOver = new GameOver();

        assertFalse(gameOver.isSelectedMenu());
        gameOver.nextEntry();
        assertTrue(gameOver.isSelectedMenu());
        gameOver.nextEntry();
        assertFalse(gameOver.isSelectedMenu());
    }

    @Test
    void testIsSelectedExit() {
        GameOver gameOver = new GameOver();

        assertFalse(gameOver.isSelectedExit());
        gameOver.nextEntry();
        assertFalse(gameOver.isSelectedExit());
        gameOver.nextEntry();
        assertTrue(gameOver.isSelectedExit());
    }

    @Test
    void testGetNumberEntries() {
        GameOver gameOver = new GameOver();

        assertEquals(3, gameOver.getNumberEntries());
    }
}

