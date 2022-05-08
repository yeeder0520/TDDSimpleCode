package com.course;

import java.util.HashMap;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/5/6 下午 03:19
 **/
public class TennisGame {

    /**
     * 第一位選手分數
     */
    private int firstPlayerTotalScore;

    /**
     * 第二位選手分數
     */
    private int secondPlayerTotalScore;


    /**
     * 第一位選手
     */
    private final String FIRST_PLAYER = "first player";

    /**
     * 第二位選手
     */
    private final String SECOND_PLAYER = "second player";
    
    /**
     * 兩位選手分數大於等於三分，且平手
     */
    private final String DEUCE = "deuce";

    /**
     * 兩位選手分數大於等於三分，且其中一位選手領先一分
     */
    private final String ADVANTAGE = "advantage";

    /**
     * 獲勝
     */
    private final String WIN = "win";


    /**
     * 分數0的表示
     */
    private final String LOVE = "love";

    /**
     * 分數1的表示
     */
    private final String FIFTEEN = "fifteen";

    /**
     * 分數2的表示
     */
    private final String FORTY = "forty";

    /**
     * 分數3的表示
     */
    private final String THIRTY = "thirty";

    /**
     * 空格
     */
    private final String BLANK = " ";


    /**
     * 分數轉換規則對照表
     */
    HashMap<Integer, String> scoreMapping;

    /**
     * Constructor.
     */
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
        if (scoreGreaterThanThree(firstPlayerTotalScore) && scoreGreaterThanThree(secondPlayerTotalScore)) {

            //TODO Step1. 判斷分差 0分 → Deuce
            if (isDeuce(firstPlayerTotalScore, secondPlayerTotalScore)) {
                return DEUCE;
            }

            //TODO Step2. 先判斷哪位選手領先
            String ahead = whoIsAhead(firstPlayerTotalScore, secondPlayerTotalScore);

            //TODO Step3. 1分 → Advantage ; 2分 → 勝利
            String advantageOrWin = isAdvantageOrWin(firstPlayerTotalScore, secondPlayerTotalScore);

            //TODO Step4. 打印出結果
            return ahead + BLANK + advantageOrWin;

//            /*FirstPlayer領先1分*/
//            if (firstPlayerTotalScore > secondPlayerTotalScore
//                    && firstPlayerTotalScore - secondPlayerTotalScore == 1) {
//                return FIRST_PLAYER + BLANK + ADVANTAGE;
//                /*SecondPlayer領先1分*/
//            } else if (secondPlayerTotalScore > firstPlayerTotalScore
//                    && secondPlayerTotalScore - firstPlayerTotalScore == 1) {
//                return "second player advantage";
//                /*平手*/
//            } else if (firstPlayerTotalScore == secondPlayerTotalScore) {
//                return "deuce";
//                /*FirstPlayer領先兩分 → 獲勝*/
//            } else if (firstPlayerTotalScore > secondPlayerTotalScore
//                    && firstPlayerTotalScore - secondPlayerTotalScore == 2) {
//                return "first player win";
//                /*SecondPlayer領先兩分 → 獲勝*/
//            } else if (secondPlayerTotalScore > firstPlayerTotalScore
//                    && secondPlayerTotalScore - firstPlayerTotalScore == 2) {
//                return "second player win";
//            }
        }

        if (firstPlayerTotalScore == 4) {
            return FIRST_PLAYER + BLANK + WIN;
        } else if (secondPlayerTotalScore == 4) {
            return SECOND_PLAYER + BLANK + WIN;
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

    /**
     * 第一位選手得分
     */
    public void firstPlayerScore() {
        firstPlayerTotalScore++;
    }

    /**
     * 第二位選手得分
     */
    public void secondPlayerScore() {
        secondPlayerTotalScore++;
    }

    /**
     * 判斷選手的分數是否大於等於3分
     *
     * @param score 分數
     * @return 分數是不是大於等於3分
     */
    public boolean scoreGreaterThanThree(int score) {
        return score >= 3;
    }

    /**
     * 判斷兩位選手分數是不是相等，進入deuce狀態
     *
     * @param firstPlayerScore  第一位選手分數
     * @param secondPlayerScore 第二位選手分數
     * @return 是不是Deuce
     */
    public boolean isDeuce(int firstPlayerScore, int secondPlayerScore) {
        return firstPlayerScore == secondPlayerScore;
    }

    /**
     * 判斷哪位選手領先
     *
     * @param firstPlayerScore  第一位選手分數
     * @param secondPlayerScore 第二位選手分數
     * @return 領先的選手
     */
    public String whoIsAhead(int firstPlayerScore, int secondPlayerScore) {
        return firstPlayerScore > secondPlayerScore ? FIRST_PLAYER : SECOND_PLAYER;
    }

    /**
     * 判斷分差，決定是Advantage或是Win
     *
     * @param score1 分數1
     * @param score2 分數2
     * @return Advantage或是Win
     */
    public String isAdvantageOrWin(int score1, int score2) {
        return Math.abs(score1 - score2) == 1 ? ADVANTAGE : WIN;
    }
}
