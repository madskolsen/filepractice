package com.company;
import java.io.*;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

public class Main {



    static void udskriv(int[]talArray, double talTilSnit){
        System.out.println(Arrays.toString(talArray) + " Sum: " + talTilSnit);
    }
    static void gennemSnit(int[] talArray, int antalTal){
        double sum = 0;
        for (int i = 0; i < talArray.length; i++) {
            sum += talArray[i];
        }
        System.out.println("Gennemsnittet af dit array er: " +sum/talArray.length);
    }
    static void createFile(String filNavn){
        try{
            File minFil = new File(filNavn);
            if (minFil.createNewFile()){
                System.out.println("File created: "+minFil.getName());
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static void writeToFile(int[] talArray, String filNavn){
        try{
            BufferedWriter bufWrite = new BufferedWriter(new FileWriter(filNavn,false));
            for (int i = 0; i < talArray.length; i++) {
                bufWrite.write(talArray[i] + "\n");
            }
            bufWrite.close();
            System.out.println("Succesfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    static void readFromFile(){
        try{
            File minFil = new File("MinFil.txt");
            Scanner myReader = new Scanner(minFil);
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
    static void writeToFileOutputStream(int[] talArray) throws FileNotFoundException {
        File minFil = new File("MinFil3.dat");
        FileOutputStream fos = new FileOutputStream("MinFil3.dat");
        try {
            for (int i = 0; i < talArray.length; i++) {
            fos.write(talArray[i]);
        }
            fos.write(talArray.length);

        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    static void readFromFis() throws IOException {
        try {
            // create a reader
            FileInputStream fis = new FileInputStream(new File("MinFil3.dat"));
            int ch;
            while ((ch = fis.read()) != -1) {
                System.out.println(ch);
            }

            // close the reader
            fis.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    static void addTen(int[] talArray){
        for (int i = 0; i < talArray.length; i++) {
            talArray[i]+=10;
        }
        createFile("MinFil1.txt");
        writeToFile(talArray,"MinFil1.txt");
    }
   /* static void writeToFileText(String filNavn){
        //1 Pernille 12.50 2 Peter 22.75 3 Christian 2 30.10
        String[] personer = {"Pernille", "Peter", "Christian"};
        int[] nr ={1,2,3};
        Float[] floats = new Float[3];
        Formatter format = new Formatter("persondata.txt");
        format.format("%d %s %f",nr,personer,floats);
        try{
            BufferedWriter bufWrite = new BufferedWriter(new FileWriter(filNavn,false));
           // for (int i = 0; i < talArray.length; i++) {
            //    bufWrite.write(talArray[i] + "\n");

            bufWrite.close();
            System.out.println("Succesfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    */
    /*
    static void readFromFileText() throws FileNotFoundException {
        String[] personer = new String[3];
        Float[] floats = new Float[3];
        int[] nr = new int[3];
        int i = 0;
            File minFil = new File("persondata.txt");
            Scanner myReader = new Scanner(minFil);
            while (myReader.hasNext()){
                String data = myReader.nextLine();
                System.out.println(data);

            while (myReader.hasNext()) {
                nr[i] = myReader.nextInt();
                personer[i] = myReader.next();
                floats[i] = myReader.nextFloat();

                i++;
            }
            myReader.close();
            System.out.println("Succesfully wrote to text");
    }
    */



    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int antalTal = 10;
        int[] talArray = new int[antalTal];
        double talTilSnit = 0;

       /* for (int i = 0; i < 10; i++) {
            System.out.println("Indsæt værdi til array plads "+i+": ");
            talArray[i]=scanner.nextInt();
            talTilSnit += talArray[i];
            System.out.println(talTilSnit);
        }
        */
        Person person = new Person();
        Person pernille = new Person(1, "Pernille",12.50F);
        Person peter = new Person(2, "Peter", 22.75F);
        Person christian = new Person(3, "Christian", 30.10F);
        Person[] personer = {pernille,peter,christian};

       /* pernille.udskrivPerson();
        peter.udskrivPerson();
        christian.udskrivPerson();

        */
        person.udskrivArrayPerson(personer,3);
        person.UdskrivTilFil(personer,3);
        person.indFraFil();

    }
}


//("%d %s %f", navn, navn, navn)