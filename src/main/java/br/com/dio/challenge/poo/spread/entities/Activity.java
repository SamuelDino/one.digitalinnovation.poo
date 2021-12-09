package br.com.dio.challenge.poo.spread.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Activity extends Content{
    private Integer workload;

    @Override
    public int calculateXP() {
        return DEFAULT_XP * getWorkload();
    }

}
