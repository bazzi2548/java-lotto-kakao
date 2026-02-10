package lotto;

public class Money {
    private long money;

    public Money(long money) {
        validateUnit(money);
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    private void validateUnit(long money) {
        if (money % 1000 != 0){
            throw new IllegalArgumentException("천원 단위로만 입력이 가능합니다.");
        }
    }
}
