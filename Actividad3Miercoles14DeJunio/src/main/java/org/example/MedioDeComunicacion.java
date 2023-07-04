package org.example;

public class MedioDeComunicacion implements Observer{
    private String name;


    public MedioDeComunicacion(String name) {
        this.name = name;
    }

    @Override
    public void update(String param) {
        System.out.println(name + ": Nuevo informe : " + param);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MedioDeComunicación{" +
                "name='" + name + '\'' +
                '}';
    }
}
