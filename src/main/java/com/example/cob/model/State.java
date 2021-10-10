package com.example.cob.model;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class State {

    private String status;

    private String phase;
}

