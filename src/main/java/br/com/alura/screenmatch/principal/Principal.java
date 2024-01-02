package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosEpisodios;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu() {
        String opcao;
        do {
            System.out.println("Digite o nome da série que você quer buscar");
            var nomeSerie = leitura.nextLine();
            var json = consumo.obterDados(ENDERECO +
                    nomeSerie.replace(" ", "+") + API_KEY);
            DadosSerie dados = conversor.obterdados(json, DadosSerie.class);
            System.out.println(dados);

            List<DadosTemporada> temporadas = new ArrayList<>();

            for (int i = 1; i <= dados.totalTemporadas(); i++) {
                json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+")
                        + "&season=" + i + API_KEY);
                DadosTemporada dadosTemporada = conversor.obterdados(json, DadosTemporada.class);
                temporadas.add(dadosTemporada);
            }
            temporadas.forEach(System.out::println);

            for(int i = 0; i < dados.totalTemporadas(); i++){
                List<DadosEpisodios> episodios = temporadas.get(i).episodios();
                for(int j = 0; j < episodios.size(); j++){
                    System.out.println(episodios.get(j).titulo());
                }
            }

            temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

            List<DadosEpisodios> dadosEpisodios = temporadas.stream()
                    .flatMap(t -> t.episodios().stream())
                    .collect(Collectors.toList());

            System.out.println("\nTop 5 episódios");

            dadosEpisodios.stream()
                    .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                    .sorted(Comparator.comparing(DadosEpisodios::avaliacao).reversed())
                    .limit(5)
                    .forEach(System.out::println);

            // Perguntar ao usuário se ele deseja continuar
            System.out.println("Deseja buscar outra série? (s/n)");
            opcao = leitura.nextLine();
        } while ("s".equalsIgnoreCase(opcao));

        System.out.println("Encerrando...");
    }

}
