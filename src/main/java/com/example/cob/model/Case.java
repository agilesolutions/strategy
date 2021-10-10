package com.example.cob.model;

import com.example.cob.logic.Strategy;
import lombok.*;

import java.time.Instant;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Case implements Strategy {

    private String phase;
    private String status;
    private Instant dueDate = Instant.now();


}