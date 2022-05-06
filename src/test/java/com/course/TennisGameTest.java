package com.course;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/5/6 下午 03:17
 **/
public class TennisGameTest {

    /**
     * TennisGame.
     */
    TennisGame tennisGame = new TennisGame();

    @Test
    @DisplayName("love love")
    public void test_love_love() {
        Assertions.assertEquals("love love", tennisGame.score());
    }

    @Test
    @DisplayName("forty thirty")
    public void test_forty_thirty() {
        firstPlayerScore(3);
        secondPlayerScore(2);
        Assertions.assertEquals("forty thirty", tennisGame.score());
    }

    @Test
    @DisplayName("love fifteen")
    public void test_love_fifteen() {
        secondPlayerScore(1);
        Assertions.assertEquals("love fifteen", tennisGame.score());

    }

    @Test
    @DisplayName("first player win")
    public void test_first_player_win() {
        /*When*/
        firstPlayerScore(4);
        secondPlayerScore(1);
        /*Then*/
        Assertions.assertEquals("first player win", tennisGame.score());
    }

    @Test
    @DisplayName("second player win")
    public void test_second_player_win() {
        /*When*/
        firstPlayerScore(2);
        secondPlayerScore(4);
        /*Then*/
        Assertions.assertEquals("second player win", tennisGame.score());
    }

    @Test
    @DisplayName("deuce")
    public void test_deuce() {
        firstPlayerScore(3);
        secondPlayerScore(3);
        Assertions.assertEquals("deuce", tennisGame.score());
    }

    @Test
    @DisplayName("first player advantage")
    public void test_first_player_advantage() {
        firstPlayerScore(4);
        secondPlayerScore(3);
        Assertions.assertEquals("first player advantage", tennisGame.score());
    }
    @Test
    @DisplayName("second player advantage")
    public void test_second_player_advantage(){
        firstPlayerScore(3);
        secondPlayerScore(4);
        Assertions.assertEquals("second player advantage",tennisGame.score());
    }

    @Test
    @DisplayName("first player win after deuce")
    public void test_first_player_win_after_deuce(){
        firstPlayerScore(6);
        secondPlayerScore(4);
        Assertions.assertEquals("first player win",tennisGame.score());

    }

    @Test
    @DisplayName("second player win after deuce")
    public void test_second_player_win_after_deuce(){
        firstPlayerScore(3);
        secondPlayerScore(5);
        Assertions.assertEquals("second player win",tennisGame.score());

    }

    private void firstPlayerScore(int times) {
        for (int i = 0; i < times; i++) {
            tennisGame.firstPlayerScore();
        }
    }

    private void secondPlayerScore(int times) {
        for (int i = 0; i < times; i++) {
            tennisGame.secondPlayerScore();
        }
    }

}
