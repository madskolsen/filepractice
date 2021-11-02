package com.company;

import java.io.*;
import java.util.Scanner;

public class Person implements java.io.Serializable{
private int nr;
private String navn;
private float tal;

    public void UdskrivTilFil(Person[] personer, int antal){
        try {
            File minSerFil = new File("personer.ser");
            FileOutputStream fos = new FileOutputStream(minSerFil);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (int i = 0; i < antal; i++) {
                oos.writeObject(personer[i]);
            }
            System.out.println("Object created and file closed.");
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void indFraFil (){
        try{
            int i = 0;
            Person[] personTabel = new Person[3];
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("personer.ser"));
            for (int j = 0; j < 3; j++) {
                personTabel[i]=(Person) ois.readObject();
                i++;
            }
            udskrivArrayPerson(personTabel, 3);
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }





    public void udskrivArrayPerson(Person[] personer, int antal){
        for (int i = 0; i < antal; i++) {
            System.out.println(personer[i].getNr() + " " + personer[i].getNavn() + " " + personer[i].getTal());
        }

    }

    public void udskrivPerson(){
        System.out.println(this.nr + " " + this.navn + " " + this.tal);
    }
    public Person(){}
    public Person(int nr, String navn, float tal) {
        this.nr = nr;
        this.navn = navn;
        this.tal = tal;
    }

    public int getNr() {
        return nr;
    }

    public void setNr() {
        this.nr = nr;
    }

    public String getNavn() {
        return this.navn;
    }

    public void setNavn() {
        this.navn = navn;
    }

    public float getTal() {
        return tal;
    }

    public void setTal() {
        this.tal = tal;
    }
}
