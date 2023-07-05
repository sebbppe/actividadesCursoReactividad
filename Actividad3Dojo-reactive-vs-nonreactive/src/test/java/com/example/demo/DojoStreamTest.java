package com.example.demo;


import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class DojoStreamTest {

    @Test
    void converterData(){
        List<Player> list = CsvUtilFile.getPlayers();
        assert list.size() == 18207;
    }

    @Test
    void jugadoresMayoresA35(){
        List<Player> list = CsvUtilFile.getPlayers();
        list.stream().filter(player -> player.getAge()>35).forEach(System.out::println);
    }

    @Test
    void jugadoresMayoresA35SegunClub(){
        List<Player> list = CsvUtilFile.getPlayers();
        Map<String,List<Player>> resultado=list.stream().filter(player -> player.getAge()>35)
                .collect(Collectors.groupingBy(Player::getClub));
        System.out.println(resultado);
    }

    @Test
    void mejorJugadorConNacionalidadFrancia(){
        List<Player> list = CsvUtilFile.getPlayers();
        list.stream().filter(player -> player.getNational()
                .equals("France")).max(Comparator.comparing(Player::getWinners)).ifPresent(System.out::println);
    }


    @Test
    void clubsAgrupadosPorNacionalidad(){
        List<Player> list = CsvUtilFile.getPlayers();
        list.stream().collect(Collectors.groupingBy(Player::getNational)).forEach((s, players) -> {
            System.out.println("                        Nacionalidad: "+s);
            players.stream().collect(Collectors.groupingBy(Player::getClub)).forEach(((s1, players1) -> System.out.println(s1)));
        });
    }

    @Test
    void clubConElMejorJugador(){
        List<Player> list = CsvUtilFile.getPlayers();
        list.stream().max(Comparator.comparing(player -> player.getWinners()/ player.getGames()))
                .ifPresent(player -> {
                    System.out.println("Club con mejor jugador: "+player.getClub());
                    System.out.println(player);
                });
    }

    @Test
    void ElMejorJugador(){
        List<Player> list = CsvUtilFile.getPlayers();
    }

    @Test
    void mejorJugadorSegunNacionalidad(){
        List<Player> list = CsvUtilFile.getPlayers();
    }


}
