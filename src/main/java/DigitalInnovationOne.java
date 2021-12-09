import br.com.dio.challenge.poo.spread.entities.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class DigitalInnovationOne {

    public static void main(String[] args) {

        Content boasVindasAoBootcamp = Activity.builder()
                .title("Boas-vindas ao Bootcamp Spread Java Developer")
                .description("Boas-vindas ao Bootcamp Spread Java Developer")
                .workload(1)
                .build();

        Content bemVindoADio = Activity.builder()
                .title("Bem-vindo à DIO")
                .description("O que é a Digital Innovation One?")
                .workload(2)
                .build();

        Content mentoria1 = Mentoring.builder()
                .title("Mentoria #1: Aula Inaugural Spread Java Developer")
                .description("A aula inaugural tem a função de dar boas vindas aos Devs inscritos " +
                        "no bootcamp e ambientalizá-los na plataforma da DIO. Nesta aula será demonstrado " +
                        "como será todo o processo a partir daqui até a etapa de uma possível contratação. " +
                        "Também serão explicados os como o bootcamp é dividido, o que são cursos, mentorias, " +
                        "projetos e desafios de código.")
                .date(LocalDate.now())
                .build();

        Content logicaProgramacaoEssencial = Activity.builder()
                .title("Lógica de Programação Essencial")
                .description("Entendendo o que é lógica")
                .workload(4)
                .build();

        Bootcamp spreadJavaDeveloper = new Bootcamp();
        spreadJavaDeveloper.setName("Spread Java Developer");
        spreadJavaDeveloper.setDescription(
                "Olá Dev, chegou o momento de você se tornar ainda mais potente para o mercado! " +
                "Com o Bootcamp Spread Java Developer, você aprenderá sobre os principais fundamentos " +
                "de Java e se especializará dentro desta área. Se inscreva agora, aprimore os seus domínios " +
                "e tenha chances de contratação!");

        spreadJavaDeveloper.addContent(boasVindasAoBootcamp);
        spreadJavaDeveloper.addContent(bemVindoADio);
        spreadJavaDeveloper.addContent(mentoria1);
        spreadJavaDeveloper.addContent(logicaProgramacaoEssencial);

        Dev samuel = new Dev();
        samuel.setName("Samuel");
        samuel.enrollBootcamp(spreadJavaDeveloper);

        Dev erica = new Dev();
        erica.setName("Erica");
        erica.enrollBootcamp(spreadJavaDeveloper);

        System.out.println("");
        System.out.println("----------------- Before Erica progress -------------------");
        ShowBootcamp.toPrint(spreadJavaDeveloper);

        erica.toProgress(boasVindasAoBootcamp);
        erica.toProgress(bemVindoADio);
        erica.toProgress(logicaProgramacaoEssencial);
        erica.toProgress(mentoria1);

        System.out.println("----------------- After Erica progress --------------------");
        ShowBootcamp.toPrint(spreadJavaDeveloper);
    }
}

class ShowBootcamp{
    public static void toPrint(Bootcamp bootcamp){
        String mask = "%-10s  %5s  %12s  %12s  %12s\n";
        System.out.println("Bootcamp name: "+bootcamp.getName());
        System.out.println("Content(s)   : "+bootcamp.getContents().size());
        System.out.println("Devs number  : "+bootcamp.getDevs().size());
        System.out.println("Total XP     : "+bootcamp.calculateXP());
        System.out.printf(mask,"Devs names","XP","Certificates","Subscribed","Completed");
        bootcamp.getDevs().forEach(dev-> System.out.printf(mask
                ,dev.getName()
                ,dev.calculateXP()
                ,dev.countCertificates(List.of(bootcamp))
                ,String.valueOf(dev.getSubscribedContents().size())
                ,String.valueOf(dev.getCompletedContents().size())
        ));
        System.out.println("");
    }
}