package com.example.cob.logic;

import com.example.cob.model.Case;
import com.example.cob.model.CasePhase;
import com.example.cob.model.CaseStatus;

import java.time.Instant;
import java.util.function.Consumer;

public interface Strategy {

    default Case thenApply(Consumer<Case> logic) {
        logic.accept((Case)this);
        return (Case)this;

    }

    public static Consumer<Case> kycReview() {
        return c -> c.setPhase(CasePhase.KYC_REVIEW.name());
    }

    public static Consumer<Case> priReview() {
        return c -> c.setPhase(CasePhase.PRI_REVIEW.name());
    }

    public static Consumer<Case> rejected() {
        return c -> c.setStatus(CaseStatus.REJECTED.name());
    }

    public static Consumer<Case> verify(Boolean check) {
        return c -> {
            if (check && c.getDueDate().isBefore(Instant.now())) {
                c.setStatus(CaseStatus.DECLINED.name());
            }
        };
    }
}
