package com.harmellaw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.harmellaw.CriminalOffence.CORRUPTION_IN_PUBLIC_OFFICE;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class APreChargeDecision {

    @Mock
    Repository repository;
    PNCId pncId;
    Suspect suspect;

    @BeforeEach
    public void setup() {
        pncId = new PNCId("1234-ESDT");
        suspect = new Suspect(CriminalOffence.FALSE_ACCOUNTING);
    }

    @Test
    public void shouldRecordAlternativeOffenceAdviceAgainstSuspects() {
        Suspect suspect = new Suspect(CriminalOffence.FALSE_ACCOUNTING);
        PreChargeDecision preChargeDecision = new PreChargeDecision(pncId, repository);

        preChargeDecision.alternativeOffenceAdvice(suspect, CORRUPTION_IN_PUBLIC_OFFICE);

        verify(repository).add(any());
    }

}
