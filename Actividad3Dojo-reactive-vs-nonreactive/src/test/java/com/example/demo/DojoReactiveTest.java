package com.example.demo;


import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

public class DojoReactiveTest {

    @Test
    void converterData(){
        List<Player> list = CsvUtilFile.getPlayers();
        assert list.size() == 18207;
    }

    @Test
    void jugadoresMayoresA35() {
        List<Player> list = CsvUtilFile.getPlayers();
        Flux<Player> observable = Flux.fromIterable(list);
        observable.filter(player -> player.getAge()>35)
                .subscribe(System.out::println);
    }


    @Test
    void jugadoresMayoresA35SegunClub(){
        List<Player> readCsv = CsvUtilFile.getPlayers();
        Flux<Player> observable = Flux.fromIterable(readCsv);
        observable.filter(player -> player.getAge()>35)
                .collect(Collectors.groupingBy(Player::getClub)).subscribe(stringListMap -> {
                    stringListMap.forEach(((s, players) -> {
                        System.out.println("                      Club: "+s);
                        players.stream().forEach(System.out::println);
                    }));
                });
    }


    @Test
    void mejorJugadorConNacionalidadFrancia(){
        List<Player> readCsv = CsvUtilFile.getPlayers();
        Flux<Player> observable = Flux.fromIterable(readCsv);
        observable.filter(player -> player.getNational().equals("France"))
                .collect(Collectors.maxBy(Comparator.comparing(player -> player.getWinners()/player.getGames())))
                .map(Optional::get).subscribe(System.out::println);
    }

    @Test
    void clubsAgrupadosPorNacionalidad(){
        List<Player> readCsv = CsvUtilFile.getPlayers();
        Flux<Player> observable = Flux.fromIterable(readCsv);
        observable.groupBy(Player::getNational)
                .flatMap(groupedFlux -> groupedFlux.collectList()
                            .map(list->{
                                Map<String,Set<String>> clubsByNac=new HashMap<>();
                                clubsByNac.put(groupedFlux.key(),list.stream().map(Player::getClub).collect(Collectors.toSet()));
                                return clubsByNac;
                            })
                ).subscribe(stringSetMap -> stringSetMap.forEach((nacionalidad, clubs) -> {
                    System.out.println("              Nacionalidad: "+nacionalidad);
                    clubs.forEach(System.out::println);
                }));

    }

    @Test
    void clubConElMejorJugador(){
        List<Player> readCsv = CsvUtilFile.getPlayers();
        Flux<Player> observable = Flux.fromIterable(readCsv);
        observable.collect(Collectors.maxBy(Comparator.comparing(player -> player.getWinners()/player.getGames()))).map(player -> {
            return player.map(value -> "Club con mejor jugador: " + value.getClub()+", jugador: "+value.getName()).orElse("No se encontró");
        }).subscribe(System.out::println);

    }

    @Test
    void ElMejorJugador() {
        List<Player> readCsv = CsvUtilFile.getPlayers();
        Flux<Player> observable = Flux.fromIterable(readCsv);
        observable
                .collect(Collectors.maxBy(Comparator.comparing(player -> player.getWinners()/player.getGames())))
                .map(Optional::get).subscribe(System.out::println);
    }


    @Test
    void mejorJugadorSegunNacionalidad(){
        List<Player> readCsv = CsvUtilFile.getPlayers();
        Flux<Player> observable = Flux.fromIterable(readCsv);
        observable.groupBy(Player::getNational).flatMap(stringPlayerGroupedFlux ->
            stringPlayerGroupedFlux
                    .collectList()
                    .map(players -> {
                        Map<String, Player> bestPlayers = new HashMap<>();
                        bestPlayers.put(stringPlayerGroupedFlux.key()
                                , players.stream()
                                        .max(Comparator.comparing(player -> player.getWinners() / player.getGames())).get());
                        return bestPlayers;
                    })
            ).subscribe(stringPlayerMap ->
            stringPlayerMap.forEach((nacionalidad, player) -> System.out.println("Mejor jugador de " + nacionalidad + ": " + player))
        );
    }



}
