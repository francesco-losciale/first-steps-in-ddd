package com.harmellaw;

public class AlternativeOffenceAdvice {
    private final PNCId pncId;
    private final Suspect suspect;
    private final CriminalOffence alternativeOffence;

    public AlternativeOffenceAdvice(PNCId pncId, Suspect suspect, CriminalOffence alternativeOffence) {
        if (pncId == null) {
            throw new IllegalArgumentException("You must provide a PNC Id");
        }
        if (suspect == null) {
            throw new IllegalArgumentException("You must provide a suspect");
        }
        if (alternativeOffence == null) {
            throw new IllegalArgumentException("You must provide an alternative criminal offence");
        }
        this.pncId = pncId;
        this.suspect = suspect;
        this.alternativeOffence = alternativeOffence;
    }
}
