package br.com.dio.challenge.poo.spread.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dev implements Results{
    private String name;
    private Set<Content> subscribedContents = new HashSet<>();
    private Set<Content>  completedContents = new HashSet<>();

    @Override
    public int calculateXP() {
        return this.completedContents
                .stream()
                .mapToInt(Content::calculateXP)
                .sum();
    }

    public Integer countCertificates(List<Bootcamp> bootcamps){
        Integer total=0;
        for(Bootcamp bootcamp:bootcamps){
            total = (this.getCompletedContents().containsAll(bootcamp.getContents())) ? total + 1 : total;
        }
        return total;
    }

    public void enrollBootcamp(Bootcamp bootcamp){
        this.subscribedContents.addAll(bootcamp.getContents());
        bootcamp.getDevs().add(this);
    }

    public void toProgress(Content content){
        if (this.subscribedContents.remove(content)){
            this.completedContents.add(content);
        }
        else {
            System.err.println("You are not enrolled in this activity. Please enroll.");
        }
    }
}
