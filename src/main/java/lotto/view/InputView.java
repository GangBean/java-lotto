package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.purchase.PurchaseManual;

public class InputView {

    public static int askAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = inputInt();
        if (amount < LottoAmount.LOTTO_AMOUNT) {
            throw new IllegalArgumentException(
                "로또 금액보다 적은 금액이 입력됐습니다. : " + amount + " < " + LottoAmount.LOTTO_AMOUNT);
        }
        return amount;
    }

    public static List<LottoNumber> askWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String line = new Scanner(System.in).nextLine();
        String[] numbers = line.split(",");
        List<LottoNumber> winningLottoNumbers = new ArrayList<>();
        for (String number : numbers) {
            winningLottoNumbers.add(new LottoNumber(Integer.parseInt(number.trim())));
        }
        return winningLottoNumbers;
    }

    public static void printPurchaseComplete(Lottos lottos) {
        System.out.println("수동으로 " + lottos.manualCount() + "개, 자동으로 " + lottos.autoCount() + "개를 구매했습니다.");
        String result = "";
        for (Lotto lotto : lottos.lottos()) {
            result += lotto.numbers();
            result += "\n";
        }
        System.out.println(result);
    }

    public static LottoNumber askBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return bonusNumber(inputInt());
    }

    private static LottoNumber bonusNumber(int number) {
        return new LottoNumber(number);
    }

    private static int inputInt() {
        return new Scanner(System.in).nextInt();
    }

    public static int askManualPurchaseCount() {
        System.out.println("수동으로 구매할 개수를 입력해 주세요.");
        return inputInt();
    }

    public static List<Lotto> askManualNumbers(int count) {
        List<Lotto> result = new ArrayList<>();
        if (count == 0) {
            return result;
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < count; i++) {
            result.add(Lotto.newInstance(PurchaseManual.instance()));
        }
        return result;
    }

}
