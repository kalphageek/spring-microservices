package me.kalplha.multi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * {@link User}가 {@link Multiplication}을 계산한 답안을 정의한 클래스
 */
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class MultiplicaitonResultAttempt {
    private final User user;
    private final Multiplication multiplication;
    private final int resultAttempt;

    // JSON (역) 직렬화를 위한 빈 생성장
    MultiplicaitonResultAttempt() {
        user = null;
        multiplication = null;
        resultAttempt = -1;
    }

}
