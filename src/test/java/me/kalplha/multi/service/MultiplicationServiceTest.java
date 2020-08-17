package me.kalplha.multi.service;

import me.kalplha.multi.entity.Multiplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class MultiplicationServiceTest {
    @MockBean
    private RandomGeneratorService randomGeneratorService;

    @Autowired
    MultiplicationService multiplicationService;

    @Test
    public void whenGenerateResult_CorrectResponse() {
        //the given return values - first 50, and then 30
        given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);

        //when
        Multiplication multiplication = multiplicationService.createRandomMultiplication();

        //test
        assertTrue(multiplication.getFactorA() == 50);
        assertTrue(multiplication.getFactorB() == 30);
        assertTrue(multiplication.getResult() == 1500);
    }
}