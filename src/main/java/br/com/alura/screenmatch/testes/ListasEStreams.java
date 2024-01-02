package br.com.alura.screenmatch.testes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListasEStreams {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("Java", "Stream", "Operações", "Intermediárias");

        List<Integer> tamanhos = palavras.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println(tamanhos); // Output: [4, 6, 11, 17]

        List<String> nomes = new ArrayList<>();
        nomes.add("Louise");
        nomes.add("Venilson");
        nomes.add("Luiz");
        nomes.add("Lorena");

        nomes.stream().sorted().limit(2).forEach(System.out::println);

    }
}
