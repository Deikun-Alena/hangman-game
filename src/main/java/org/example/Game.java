package org.example;

public class Game {
    public void play() {
        Word word = new Word();
        word.select();
        Letter letter = new Letter();
        letter.input();
    }
}
