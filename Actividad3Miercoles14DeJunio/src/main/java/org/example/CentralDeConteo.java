package org.example;

import java.util.List;

// sujeto concreto
public class CentralDeConteo extends Subject{

    private Integer votosCandidato1;
    private Integer votosCandidato2;

    private Integer totalCandidato2=0;

    private Integer totalCandidato1=0;
    public void informarMesa(Integer voto1, Integer voto2){

        this.votosCandidato1=voto1;
        this.votosCandidato2=voto2;
        this.totalCandidato1=this.totalCandidato1+voto1;
        this.totalCandidato2=this.totalCandidato2+voto2;
        System.out.println("Se ha realizado un nuevo informe de mesa");
        this.notifiy();
    }
    @Override
    public void notifiy() {
        observers.forEach(observer -> observer.update(crearReporte()));
    }

    public void removeByName(String name){
        this.removeObserver(observers.stream()
                .filter(observer -> observer instanceof  MedioDeComunicacion && ((MedioDeComunicacion) observer)
                        .getName().equals(name))
                .findFirst()
                .get());
    }

    public String crearReporte(){
        return "Último reporte de la mesa\n[" +
                "Voto del candidato 1 en la mesa: " +this.votosCandidato1 +"\n"+
                "Voto del candidato 2 en la mesa: " +this.votosCandidato2 +"\n"+
                "Votos totales al candidato 1: "+this.totalCandidato1+"\n"+
                "Votos totales al candidato 2: "+this.totalCandidato2+ "]";
    }

}
