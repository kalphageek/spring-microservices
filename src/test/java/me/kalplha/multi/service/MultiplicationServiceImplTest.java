package me.kalplha.multi.service;

import me.kalplha.multi.entity.MultiplicaitonResultAttempt;
import me.kalplha.multi.entity.Multiplication;
import me.kalplha.multi.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class MultiplicationServiceImplTest {
    private MultiplicationServiceImpl multiplicationServiceImpl;
    @Mock
    private RandomGeneratorService randomGeneratorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        multiplicationServiceImpl = new MultiplicationServiceImpl(randomGeneratorService);
    }

    @Test
    public void whenCreateRandomMultiplication_CorrectResponse() {
        given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);

        Multiplication multiplication = multiplicationServiceImpl.createRandomMultiplication();

        assertTrue(multiplication.getFactorA() == 50);
        assertTrue(multiplication.getFactorB() == 30);
        assertTrue(multiplication.getResult() == 1500);
    }

    @Test
    public void whenCheckAttempt_CorrectResponse() {
        //given
        Multiplication multiplication = new Multiplication(50, 60);
        User user = new User("John Doe");
        MultiplicaitonResultAttempt attempt = new MultiplicaitonResultAttempt(
                user, multiplication, 3000);

        //when
        boolean correct = multiplicationServiceImpl.checkAttempt(attempt);

        //test
        assertTrue(correct);
    }

    @Test
    public void whenCheckAttempt_WrongResponse() {
        //given
        Multiplication multiplication = new Multiplication(50, 60);
        User user = new User("John Doe");
        MultiplicaitonResultAttempt attempt = new MultiplicaitonResultAttempt(
                user, multiplication, 3001);

        //when
        boolean correct = multiplicationServiceImpl.checkAttempt(attempt);

        //test
        assertFalse(correct);

    }
}