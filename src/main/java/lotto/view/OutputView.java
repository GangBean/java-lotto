package lotto.view;

import java.util.Map;
import lotto.domain.WinningNumbers.Rank;
import lotto.domain.WinningPercent;

public class OutputView {

    private OutputView() {}

    public static void printRanking(Map<Rank, Integer> result, int amount) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        printRanks(result);
        System.out.println("총 수익률은 " + calculatedWinningPercent(result, amount) + "입니다.");
    }

    private static void printRanks(Map<Rank, Integer> result) {
        for (Rank rank : Rank.values()) {
            printRank(result, rank);
        }
    }

    private static void printRank(Map<Rank, Integer> result, Rank rank) {
        System.out.println(rank.matchCount() + "개 일치 (" + rank.amount() + "원)- " + result.get(rank) + "개");
    }

    private static double calculatedWinningPercent(Map<Rank, Integer> result, int amount) {
        return value(winningPercentOf(result, amount));
    }

    private static double value(WinningPercent winningPercent) {
        return winningPercent.value();
    }

    private static WinningPercent winningPercentOf(Map<Rank, Integer> result, int amount) {
        return WinningPercent.of(result, amount);
    }

}
