package br.com.alura.screenmatch.testes;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DatasEHoras {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate aniversarioLouise = LocalDate.of(1992, Month.DECEMBER, 10);
        System.out.println(aniversarioLouise);

        int idade = hoje.getYear() - aniversarioLouise.getYear();
        System.out.println(idade + " anos");

        Period periodo = Period.between(hoje, aniversarioLouise);
        System.out.println(periodo);

        LocalTime agora = LocalTime.now();
        System.out.println(agora);

        LocalDateTime hojeAgora = LocalDateTime.now();
        System.out.println(hojeAgora);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm:ss");
        System.out.println(hojeAgora.format(formatador));
    }
}
