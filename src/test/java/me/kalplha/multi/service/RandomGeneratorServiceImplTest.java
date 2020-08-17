package me.kalplha.multi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorServiceImplTest {
    RandomGeneratorServiceImpl randomGeneratorServiceImpl;

    @BeforeEach
    public void setUp() {
        randomGeneratorServiceImpl =  new RandomGeneratorServiceImpl();
    }

    @Test
    public void whenGenerateFactor_CorrectResponse() {
        // 무작위 숫자 1000개 생성
        List<Integer> randomFactors = IntStream.range(0, 1000)
                .map(i -> randomGeneratorServiceImpl.generateRandomFactor())
                .boxed() // boxing Stream<Integer> 생성
                .collect(Collectors.toList());

        // 생성한 인수가 11~99 범위에 있는지 확인
        List<Integer> checkedFactors = IntStream.range(11,100).boxed().collect(Collectors.toList());
        assertTrue(randomFactors.containsAll(checkedFactors));
    }

}