package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Money;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호의 개수가 6개가 되지 않으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("로또 구입 금액이 1000원으로 나누어지지 않는 경우 예외가 발생한다.")
    @Test
    void ValidateMoneyTest1() {
        Integer money = 4500;
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000원 보다 작은 경우 예외가 발생한다.")
    @Test
    void ValidateMoneyTest2() {
        Integer money = 900;
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
