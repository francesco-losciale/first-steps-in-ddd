package com.harmellaw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.harmellaw.CriminalOffence.CUTTING_AWAY_BUOYS_ETC;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnAlternativeOffenceAdvice {

    private Suspect suspect;
    private PNCId pncId;

    @BeforeEach
    void setUp() {
        pncId = new PNCId("1234-ESDT");
        suspect = new Suspect(CriminalOffence.FALSE_ACCOUNTING);
    }

    @Test
    void cannotBeCreatedWithAnEmptyPncId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            new AlternativeOffenceAdvice(null, suspect, CUTTING_AWAY_BUOYS_ETC));
        assertTrue(exception.getMessage().contains("You must provide a PNC Id"));
    }

    @Test
    void cannotBeCreatedWithAnEmptySuspect() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            new AlternativeOffenceAdvice(pncId, null, CUTTING_AWAY_BUOYS_ETC));
        assertTrue(exception.getMessage().contains("You must provide a suspect"));
    }

    @Test
    void cannotBeCreatedWithAnEmptyAlternativeCriminalOffence() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            new AlternativeOffenceAdvice(pncId, suspect, null));
        assertTrue(exception.getMessage().contains("You must provide an alternative criminal offence"));
    }
}