//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import nl.saxion.app.CsvReader;
import nl.saxion.app.SaxionApp;

public class Application implements Runnable {
    private ArrayList<Infravraag> infravragen;
    private ArrayList<BusinessVragen> BusinessVragenLijst;
    private ArrayList<SoftwareVragen> SoftwareVragenLijst;



    public Application() {
        infravragen = new ArrayList<Infravraag>();
        BusinessVragenLijst = new ArrayList<BusinessVragen>();
        SoftwareVragenLijst = new ArrayList<SoftwareVragen>();

    }

    public static void main(String[] args) {
        SaxionApp.start(new Application(), 2000, 1000);
    }

    public void run() {

        this.readFileInfra();
        this.readFileSoftware();
        this.readFileBusiness();


        while (true) {
            SaxionApp.clear();

            int keuze = printMenu();

            if (keuze == 3) {

                if (this.infravragen.size() > 0) {
                    krijgInfravraag();
                } else {
                    readFileInfra();
                }
            }
            else if (keuze == 1) {
                    if (this.BusinessVragenLijst.size() > 0) {
                        krijgBusinessvraag();
                    } else {
                        readFileBusiness();
                    }
                }
            else if (keuze == 2){

                if (this.SoftwareVragenLijst.size() > 0) {
                    krijgSoftwarevraag();
                } else {
                    readFileSoftware();
                }
            }
            else if (keuze == 0){
                break;
            }
        }
    }

    public void krijgBusinessvraag() {
        Random r = new Random();
        int randomVraag = r.nextInt(this.BusinessVragenLijst.size());

        BusinessVragen teStellenVraag = this.BusinessVragenLijst.get(randomVraag);

        if (Objects.equals(teStellenVraag.typevraag, "Open")) {
            SaxionApp.printLine("Dit is een open vraag:");
            SaxionApp.printLine(teStellenVraag.vraag);
            SaxionApp.printLine("Druk op een knop om het antwoord te tonen");
            SaxionApp.pause();
            SaxionApp.printLine(teStellenVraag.antwoord);
        } else if (Objects.equals(teStellenVraag.typevraag, "Gesloten")) {
            SaxionApp.printLine("Dit is een gesloten vraag:");
            SaxionApp.printLine(teStellenVraag.vraag);
            SaxionApp.print("Typ hier uw antwood: ");
            String antwoordGebruiker = SaxionApp.readString().toLowerCase();
            if (Objects.equals(antwoordGebruiker, teStellenVraag.antwoord.toLowerCase())) {
                SaxionApp.printLine("Het antwoord is correct!");
            } else {
                SaxionApp.printLine("Het antwoord is niet correct :(");
            }
        } else if (Objects.equals(teStellenVraag.typevraag, "TrueOrFalse")) {
            SaxionApp.printLine("Dit is een true or false vraag:");
            SaxionApp.printLine(teStellenVraag.vraag);
            SaxionApp.print("Typ hier uw antwood: ");
            String antwoordGebruiker = SaxionApp.readString().toLowerCase();
            if (Objects.equals(antwoordGebruiker, teStellenVraag.antwoord.toLowerCase())) {
                SaxionApp.printLine("Het antwoord is correct!");
            } else {
                SaxionApp.printLine("Het antwoord is niet correct :(");
            }
        } else if (Objects.equals(teStellenVraag.typevraag, "Meerkeuze")) {
            SaxionApp.printLine("Dit is een meerkeuze vraag:");
            SaxionApp.printLine(teStellenVraag.vraag);
            SaxionApp.printLine(teStellenVraag.optie1);
            SaxionApp.printLine(teStellenVraag.optie2);
            SaxionApp.printLine(teStellenVraag.optie3);
            SaxionApp.printLine(teStellenVraag.optie4);
            SaxionApp.print("Typ hier uw antwood: ");
            String antwoordGebruiker = SaxionApp.readString().toUpperCase();
            if (Objects.equals(antwoordGebruiker, teStellenVraag.antwoord)) {
                SaxionApp.printLine("Het antwoord is correct!");
            } else {
                SaxionApp.printLine("Het antwoord is niet correct :(");
            }
        }
        this.SoftwareVragenLijst.remove(randomVraag);
        SaxionApp.pause();
    }
    public void krijgSoftwarevraag() {
        Random r = new Random();
        int randomVraag = r.nextInt(this.SoftwareVragenLijst.size());

        SoftwareVragen teStellenVraag = this.SoftwareVragenLijst.get(randomVraag);

        if (Objects.equals(teStellenVraag.typevraag, "Open")) {
            SaxionApp.printLine("Dit is een open vraag:");
            SaxionApp.printLine(teStellenVraag.vraag);
            SaxionApp.printLine("Druk op een knop om het antwoord te tonen");
            SaxionApp.pause();
            SaxionApp.printLine(teStellenVraag.antwoord);
        } else if (Objects.equals(teStellenVraag.typevraag, "Gesloten")) {
            SaxionApp.printLine("Dit is een gesloten vraag:");
            SaxionApp.printLine(teStellenVraag.vraag);
            SaxionApp.print("Typ hier uw antwood: ");
            String antwoordGebruiker = SaxionApp.readString().toLowerCase();
            if (Objects.equals(antwoordGebruiker, teStellenVraag.antwoord.toLowerCase())) {
                SaxionApp.printLine("Het antwoord is correct!");
            } else {
                SaxionApp.printLine("Het antwoord is niet correct :(");
            }
        } else if (Objects.equals(teStellenVraag.typevraag, "TrueOrFalse")) {
            SaxionApp.printLine("Dit is een true or false vraag:");
            SaxionApp.printLine(teStellenVraag.vraag);
            SaxionApp.print("Typ hier uw antwood: ");
            String antwoordGebruiker = SaxionApp.readString().toLowerCase();
            if (Objects.equals(antwoordGebruiker, teStellenVraag.antwoord.toLowerCase())) {
                SaxionApp.printLine("Het antwoord is correct!");
            } else {
                SaxionApp.printLine("Het antwoord is niet correct :(");
            }
        } else if (Objects.equals(teStellenVraag.typevraag, "Meerkeuze")) {
            SaxionApp.printLine("Dit is een meerkeuze vraag:");
            SaxionApp.printLine(teStellenVraag.vraag);
            SaxionApp.printLine(teStellenVraag.optie1);
            SaxionApp.printLine(teStellenVraag.optie2);
            SaxionApp.printLine(teStellenVraag.optie3);
            SaxionApp.printLine(teStellenVraag.optie4);
            SaxionApp.print("Typ hier uw antwood: ");
            String antwoordGebruiker = SaxionApp.readString().toUpperCase();
            if (Objects.equals(antwoordGebruiker, teStellenVraag.antwoord)) {
                SaxionApp.printLine("Het antwoord is correct!");
            } else {
                SaxionApp.printLine("Het antwoord is niet correct :(");
            }
        }
        this.SoftwareVragenLijst.remove(randomVraag);
        SaxionApp.pause();
    }

    public void krijgInfravraag() {
        Random r = new Random();
        int randomVraag = r.nextInt(this.infravragen.size());

        Infravraag teStellenVraag = this.infravragen.get(randomVraag);

        if (Objects.equals(teStellenVraag.typevraag, "Open")) {
            SaxionApp.printLine("Dit is een open vraag:");
            SaxionApp.printLine(teStellenVraag.vraag);
            SaxionApp.printLine("Druk op een knop om het antwoord te tonen");
            SaxionApp.pause();
            SaxionApp.printLine(teStellenVraag.antwoord);
        } else if (Objects.equals(teStellenVraag.typevraag, "Gesloten")) {
            SaxionApp.printLine("Dit is een gesloten vraag:");
            SaxionApp.printLine(teStellenVraag.vraag);
            SaxionApp.print("Typ hier uw antwood: ");
            String antwoordGebruiker = SaxionApp.readString().toLowerCase();
            if (Objects.equals(antwoordGebruiker, teStellenVraag.antwoord.toLowerCase())) {
                SaxionApp.printLine("Het antwoord is correct!");
            } else {
                SaxionApp.printLine("Het antwoord is niet correct :(");
            }
        } else if (Objects.equals(teStellenVraag.typevraag, "TrueOrFalse")) {
            SaxionApp.printLine("Dit is een true or false vraag:");
            SaxionApp.printLine(teStellenVraag.vraag);
            SaxionApp.print("Typ hier uw antwood: ");
            String antwoordGebruiker = SaxionApp.readString().toLowerCase();
            if (Objects.equals(antwoordGebruiker, teStellenVraag.antwoord.toLowerCase())) {
                SaxionApp.printLine("Het antwoord is correct!");
            } else {
                SaxionApp.printLine("Het antwoord is niet correct :(");
            }
        } else if (Objects.equals(teStellenVraag.typevraag, "Meerkeuze")) {
            SaxionApp.printLine("Dit is een meerkeuze vraag:");
            SaxionApp.printLine(teStellenVraag.vraag);
            SaxionApp.printLine(teStellenVraag.optie1);
            SaxionApp.printLine(teStellenVraag.optie2);
            SaxionApp.printLine(teStellenVraag.optie3);
            SaxionApp.printLine(teStellenVraag.optie4);
            SaxionApp.print("Typ hier uw antwood: ");
            String antwoordGebruiker = SaxionApp.readString().toUpperCase();
            if (Objects.equals(antwoordGebruiker, teStellenVraag.antwoord)) {
                SaxionApp.printLine("Het antwoord is correct!");
            } else {
                SaxionApp.printLine("Het antwoord is niet correct :(");
            }
        }
        this.infravragen.remove(randomVraag);
        SaxionApp.pause();
    }

    public void readFileBusiness () {
        CsvReader reader = new CsvReader("C:\\Users\\nienk\\Downloads\\ProblemSolving1 (1)\\ProblemSolving(1)\\ProblemSolving\\Exercise1\\Vragen Business");
        reader.skipRow();
        reader.setSeparator(',');

        while (reader.loadRow()) {
            BusinessVragen bv = new BusinessVragen();

            bv.vraag = reader.getString(0);
            bv.antwoord = reader.getString(1);
            bv.typevraag = reader.getString(2);
            bv.optie1 = reader.getString(3);
            bv.optie2 = reader.getString(4);
            bv.optie3 = reader.getString(5);
            bv.optie4 = reader.getString(6);

            BusinessVragenLijst.add(bv);

        }
    }

    public void readFileSoftware () {
         SoftwareVragenLijst.clear();

         CsvReader reader = new CsvReader("C:\\Users\\nienk\\Downloads\\ProblemSolving1 (1)\\ProblemSolving(1)\\ProblemSolving\\Exercise1\\Vragen Software");
         reader.skipRow();
         reader.setSeparator(',');

         while (reader.loadRow()) {

             SoftwareVragen sv = new SoftwareVragen();

             sv.vraag = reader.getString(0);
             sv.antwoord = reader.getString(1);
             sv.typevraag = reader.getString(2);
             sv.typevraag = reader.getString(2);
             sv.optie1 = reader.getString(3);
             sv.optie2 = reader.getString(4);
             sv.optie3 = reader.getString(5);
             sv.optie4 = reader.getString(6);

             SoftwareVragenLijst.add(sv);
         }
    }

        public void readFileInfra () {

            infravragen.clear();

            CsvReader reader = new CsvReader("C:\\Users\\nienk\\Downloads\\ProblemSolving1 (1)\\ProblemSolving(1)\\ProblemSolving\\Exercise1\\Vragen Infrastructuur");
            reader.skipRow();
            reader.setSeparator(',');

            while (reader.loadRow()) {
                Infravraag iv = new Infravraag();
                iv.vraag = reader.getString(0);
                iv.antwoord = reader.getString(1);
                iv.typevraag = reader.getString(2);
                iv.optie1 = reader.getString(3);
                iv.optie2 = reader.getString(4);
                iv.optie3 = reader.getString(5);
                iv.optie4 = reader.getString(6);
                infravragen.add(iv);
            }
        }

        public int printMenu () {
            SaxionApp.printLine("1. Business ", Color.red);
            SaxionApp.printLine();
            SaxionApp.printLine("2. Software ", Color.blue);
            SaxionApp.printLine();
            SaxionApp.printLine("3. Infrastructuur", Color.yellow);
            SaxionApp.printLine();

            SaxionApp.print("Maak uw keuze: ");

            int keuze = SaxionApp.readInt();

            return keuze;
        }
    }

