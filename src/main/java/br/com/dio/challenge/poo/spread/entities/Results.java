package br.com.dio.challenge.poo.spread.entities;

@FunctionalInterface
public interface Results {
    Integer DEFAULT_XP = 10;
    int calculateXP();
}
