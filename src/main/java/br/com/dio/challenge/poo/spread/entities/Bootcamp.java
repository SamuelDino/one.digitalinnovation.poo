package br.com.dio.challenge.poo.spread.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bootcamp implements Results {
    private String name;
    private String description;
    private final LocalDate INITIAL_DATE = LocalDate.now();
    private final Integer PLUS_DAYS = 45;
    private final LocalDate FINAL_DATE = LocalDate.now().plusDays(PLUS_DAYS);
    private Set<Content> contents = new LinkedHashSet<>();
    private Set<Dev> devs = new LinkedHashSet<>();

    public void addContent(Content content){
        this.contents.add(content);
    }

    @Override
    public int calculateXP() {
        return this.contents
                .stream()
                .mapToInt(Content::calculateXP)
                .sum();
    }

    public Integer totalEnrolled() {
        return this.devs.size();
    }

    public Integer totalCertificates() {
        return this.devs
                .stream()
                .mapToInt(dev -> dev.countCertificates(List.of(this)))
                .sum();
    }
}
