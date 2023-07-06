package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CentralDeConteo centralDeConteo= new CentralDeConteo();
        executeGame(centralDeConteo);
    }
    private static void executeGame(CentralDeConteo centralDeConteo) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("" +
                "1- suscribir medio de comunicación \n" +
                "2- desuscribir medio de comunicación \n" +
                "3- publicar reporte\n" +
                "8- Salir");
        int menuOption = sc.nextInt();
        switch (menuOption){
            case 1:
                System.out.println("Subscribir medio de comunicación ");
                String nameToBeAdded = sc2.nextLine();
                MedioDeComunicacion medioDeComunicacion = new MedioDeComunicacion(nameToBeAdded);
                centralDeConteo.addObserver(medioDeComunicacion);
                System.out.println("Medio de comunicación suscrito.");
                executeGame(centralDeConteo);
                break;
            case 2:
                centralDeConteo.getObservers().forEach(System.out::println);
                System.out.println("Desuscribir medio de comunicación");
                String nameToBeRemoved = sc2.nextLine();
                centralDeConteo.removeByName(nameToBeRemoved);
                System.out.println("Medio de comunicación desuscrito.");
                executeGame(centralDeConteo);
                break;
            case 3:
                System.out.println("Publicar reporte");
                System.out.print("Votos candidato 1: ");
                Integer votos1 = sc2.nextInt();
                System.out.print("Votos candidato 2: ");
                Integer votos2 = sc2.nextInt();
                centralDeConteo.informarMesa(votos1,votos2);
                executeGame(centralDeConteo);
                break;
            case 8:
                System.out.println("Gracias por utilizar nuestro sistema!");
                break;
            default:
                System.out.println("Opción incorrecta");
        }
        sc.close();
        sc2.close();
    }
}