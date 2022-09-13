package com.Tarea3.Ejercicios1_2_3.entities;

import javax.persistence.*;

@Entity
@Table(name = "laptops")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int ramGB;
    private int storageGB;
    private String cpu;
    private String screen;
    private String systemOperative;

    public Laptop(){}

    public Laptop(Long id ,int ramGB, int storageGB, String cpu, String screen, String systemOperative) {
        this.id = id;
        this.ramGB = ramGB;
        this.storageGB = storageGB;
        this.cpu = cpu;
        this.screen = screen;
        this.systemOperative = systemOperative;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRamGB() {
        return ramGB;
    }

    public void setRamGB(int ramGB) {
        this.ramGB = ramGB;
    }

    public int getStorageGB() {
        return storageGB;
    }

    public void setStorageGB(int storageGB) {
        this.storageGB = storageGB;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getSystemOperative() {
        return systemOperative;
    }

    public void setSystemOperative(String systemOperative) {
        this.systemOperative = systemOperative;
    }
}
