package com.course;

import java.util.HashMap;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/5/6 下午 03:19
 **/
public class TennisGame {

    private int firstPlayerTotalScore;
    private int secondPlayerTotalScore;
    private final String LOVE = "love";
    private final String FIFTEEN = "fifteen";
    private final String FORTY = "forty";
    private final String THIRTY = "thirty";
    private final String BLANK = " ";
    HashMap<Integer, String> scoreMapping;

    public TennisGame() {
        this.scoreMapping = new HashMap<>();
        scoreMapping.put(0, LOVE);
        scoreMapping.put(1, FIFTEEN);
        scoreMapping.put(2, THIRTY);
        scoreMapping.put(3, FORTY);
    }

    /**
     * 計分規則與展示
     *
     * @return score
     */
    public String score() {

        /*如果雙方選手分數都大於3，那會有三種狀況
        1.Deuce
        2.Advantage
        3.勝利
        */
        if (scoreOverThree(firstPlayerTotalScore) && scoreOverThree(secondPlayerTotalScore)) {

            //TODO Step1. 判斷分差 0分 → Deuce
            //TODO Step2. 先判斷哪位選手領先
            //TODO Step3. 1分 → Advantage ; 2分 → 勝利
            //TODO Step4. 打印出結果

            /*FirstPlayer領先1分*/
            if (firstPlayerTotalScore > secondPlayerTotalScore
                    && firstPlayerTotalScore - secondPlayerTotalScore == 1) {
                return "first player advantage";
                /*SecondPlayer領先1分*/
            } else if (secondPlayerTotalScore > firstPlayerTotalScore
                    && secondPlayerTotalScore - firstPlayerTotalScore == 1) {
                return "second player advantage";
                /*平手*/
            } else if (firstPlayerTotalScore == secondPlayerTotalScore) {
                return "deuce";
                /*FirstPlayer領先兩分 → 獲勝*/
            } else if (firstPlayerTotalScore > secondPlayerTotalScore
                    && firstPlayerTotalScore - secondPlayerTotalScore == 2) {
                return "first player win";
                /*SecondPlayer領先兩分 → 獲勝*/
            } else if (secondPlayerTotalScore > firstPlayerTotalScore
                    && secondPlayerTotalScore - firstPlayerTotalScore == 2) {
                return "second player win";
            }
        }

        if (firstPlayerTotalScore == 4) {
            return "first player win";
        } else if (secondPlayerTotalScore == 4) {
            return "second player win";
        }


        String score1 = scoreMapping.get(firstPlayerTotalScore);
        String score2 = scoreMapping.get(secondPlayerTotalScore);
        return score1 + BLANK + score2;

//        if (firstPlayerTotalScore == 3 && secondPlayerTotalScore == 2) {
//            return FORTY + BLANK + THIRTY;
//        } else if (firstPlayerTotalScore == 0 && secondPlayerTotalScore == 1) {
//            return LOVE + BLANK + FIFTEEN;
//        }
//        return LOVE + BLANK + LOVE;
    }

    public void firstPlayerScore() {
        firstPlayerTotalScore++;
    }

    public void secondPlayerScore() {
        secondPlayerTotalScore++;
    }

    /**
     * 判斷選手的分數是否大於3
     *
     * @param score 分數
     * @return boolean
     */
    public boolean scoreOverThree(int score) {
        return score >= 3;
    }

    public boolean isDeuce(int firstPlayerScore, int secondPlayerScore) {

    }

}
