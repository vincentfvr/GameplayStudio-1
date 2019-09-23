package com.ocr.vincent;

import java.util.Arrays;
import java.util.Scanner;

public class Modules {
    Scanner sc = new Scanner(System.in);
    int nbMode;
    int devMode = 0;
    int[] theComb = new int[4];
    int[] myComb = new int[4];
    int myValue = 0;
    int counter = 1;
    int nbTry = 1;
    int victory = 0;
    String listResults = "";
    int i;

    /**
     * LANCEMENT DU JEU
     */
    public void runGame() {
        this.displayModesMenu();
            System.out.println("Saisir un chiffre (entre 1 et 9) et validez avec Entrée");
        this.generateComb();
        do {
            counter = 1;
            do {
                this.displayAskComb();
            } while (counter<=4 && (myValue>=1 || myValue<=9));
            listResults="";
            this.displayResult();
            nbTry=nbTry+1;
        } while (victory == 0);
    }

    /**
     * Affichage du choix du mode et control de saisie
     */
    public void displayModesMenu() {
        do {
            System.out.println("CHOISIR UN MODE DE JEU : 1 - challenger, 2 - défenseur, 3 - duel");
            nbMode = sc.nextInt();
            switch (nbMode) {
                case 1:
                    System.out.println("MODE CHALLENGER : Trouvez la combinaison de 4 chiffres : [x] [x] [x] [x]");
                    break;
                case 2:
                    System.out.println("MODE DÉFENSEUR SÉLECTIONNÉ");
                    break;
                case 3:
                    System.out.println("MODE DUEL SÉLECTIONNÉ");
                    break;
                case 1234:
                    System.out.println("MODE DÉVELOPPEUR ACTIF");
                    devMode=1;
                    break;
                default:
                    System.out.println("Taper 1,2 ou 3");
                    break;
            }
        } while (nbMode < 1 || nbMode > 3);
    }

    /**
     *  Création de la combinaison à trouver
     */
    public void generateComb() {
        int nb = 0;
        for ( i = 0 ; i<4; i++) {
            do {
                nb = (int) (Math.random() * 10 );     /** avec 0 < nb < 9 */
                theComb[i] = nb;
            } while (nb==0);
        }
        if (devMode==1) {
            System.out.println("DEV_MODE: "+theComb[0] + theComb[1] + theComb[2] + theComb[3]);
        }

    }

    /**
     * Affiche la demande de proposition (avec numérotation counter/4)
     */
    public void displayAskComb() {
            System.out.println("Essai n°" + nbTry + " - Chiffre " + counter + "/4 ?");
        myValue = sc.nextInt();

        if (myValue<1 || myValue>9) {
            System.out.println("Veuillez saisir une valeur comprise entre 1 et 9");
        } else {
            this.displayMyCombination(counter, myValue);
            counter = counter + 1;
        }
    }

    /**
     * Affiche la proposition faite avec + la numérotation
     */
    public void displayMyCombination(int counter, int myValue) {
        switch (counter) {
            case 1: myComb[0] = myValue;
                break;
            case 2: myComb[1] = myValue;
                break;
            case 3: myComb[2] = myValue;
                break;
            case 4: myComb[3] = myValue;
                break;
        }
        System.out.println("--> Ma combinaison : "  + myComb[0] + myComb[1] + myComb[2] + myComb[3]);
        if (devMode==1) {
            System.out.println("DEV-MODE : "+theComb[0] + theComb[1] + theComb[2] + theComb[3]);
        }
    }

    /**
     * Affiche la réponse en fonction de la proposition
     */
    public void displayResult() {
        for ( i = 0 ; i<4; i++) {
           if (myComb[i]==theComb[i]) {
               listResults = listResults + "=";
           } else if (myComb[i]<theComb[i]) {
               listResults = listResults + "+";
           }else if (myComb[i]>theComb[i]) {
                listResults = listResults + "-";
           }
        }
        System.out.println("-->    Indications : " + listResults);
        if (listResults.contains("====")) {
            victory=1;
            listResults ="";
            System.out.println("******************************************");
            System.out.println("* GAGNÉ! Combinaison trouvée en " + nbTry + " coups. *");
            System.out.println("******************************************");
        }
    }
}