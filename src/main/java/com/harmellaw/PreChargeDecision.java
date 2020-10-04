package com.harmellaw;

public class PreChargeDecision {
    private PNCId pncId;
    private Repository repository;

    public PreChargeDecision(PNCId pncId, Repository repository) {
        this.pncId = pncId;
        this.repository = repository;
    }

    public void alternativeOffenceAdvice(Suspect suspect, CriminalOffence alternativeOffence) {
        repository.add(new AlternativeOffenceAdvice(pncId, suspect, alternativeOffence));
    }
}
