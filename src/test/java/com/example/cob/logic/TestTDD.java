package com.example.cob.logic;

import com.example.cob.model.Case;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
public class TestTDD {

    Case onboardingCase = new Case();

    @BeforeAll
    public void init() {


    }

    @Test
    public void givenClientSubmitted_whenOffBoard_thenCaseStatusCancelled() {

        // GIVEN
        onboardingCase.thenApply(Strategy.rejected());

        // WHEN
        onboardingCase.thenApply(Strategy.priReview());

        // THEN
        onboardingCase.thenApply(Strategy.verify(true));


    }

}
