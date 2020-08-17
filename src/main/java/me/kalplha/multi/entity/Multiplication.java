package me.kalplha.multi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor

public final class Multiplication {
    private final int factorA;
    private final int factorB;
    private final int result;

    public Multiplication(int factorA, int factorB) {
        this.factorA = factorA;
        this.factorB = factorB;
        result = factorA * factorB;
    }

    // JSON (역) 직렬화를 위한 빈 생성장
    public Multiplication() {
        this(0, 0);
    }
}
