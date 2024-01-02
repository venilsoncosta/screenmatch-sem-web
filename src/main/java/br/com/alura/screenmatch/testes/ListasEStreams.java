package br.com.alura.screenmatch.testes;

import java.util.*;

public class ListasEStreams {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        for(int i = 1; i <= 5; i++){
            System.out.println("Digite o nome " + i);
            nomes.add(entrada.nextLine());
        }

        nomes.stream().sorted().forEach(System.out::println);

        Map<String, Integer> meusNomes = new HashMap<>();
        meusNomes.put("Louise", 45);
        meusNomes.put("Lucas", 495);
        meusNomes.put("Venilson", 7);
        System.out.println(meusNomes);

    }
}
