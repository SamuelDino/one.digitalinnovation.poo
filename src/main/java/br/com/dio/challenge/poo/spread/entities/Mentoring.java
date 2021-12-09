package br.com.dio.challenge.poo.spread.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Mentoring extends Content{
    private LocalDate date;
    private final Integer DEFAULT_MENTORING_XP = 20;

    @Override
    public int calculateXP() {
        return DEFAULT_XP + DEFAULT_MENTORING_XP;
    }
}
