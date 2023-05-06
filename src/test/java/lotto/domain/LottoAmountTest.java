package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoAmountTest {

    @Test
    void 로또금액생성() {
        assertThat(LottoAmount.of(1000)).isEqualTo(LottoAmount.of(1000));
    }

}
