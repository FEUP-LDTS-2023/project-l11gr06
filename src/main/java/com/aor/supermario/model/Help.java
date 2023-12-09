package com.aor.supermario.model;

import java.util.Arrays;
import java.util.List;

public class Help {
    private final List<String> entries;
    private int currentEntry = 0;

    public Help() {
        this.entries = Arrays.asList("Return to Menu");
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }
    public boolean isSelected(int i) {
        return currentEntry == i;
    }
    public boolean isSelectedMenu() {
        return isSelected(0);
    }
    public int getNumberEntries() {
        return this.entries.size();
    }
}