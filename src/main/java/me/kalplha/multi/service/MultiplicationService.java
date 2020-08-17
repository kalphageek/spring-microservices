package me.kalplha.multi.service;

import me.kalplha.multi.entity.MultiplicaitonResultAttempt;
import me.kalplha.multi.entity.Multiplication;

/**
 * @return Random Parameter(11~99) {@link Multiplication} Object
 */
public interface MultiplicationService {
    /**
     * @return 무작위 인수를 담은 {@link Multiplication} 객체
     */
    Multiplication createRandomMultiplication();

    boolean checkAttempt(final MultiplicaitonResultAttempt resultAttempt);
}
