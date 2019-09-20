package com.ocr.vincent;

import java.util.Arrays;
import java.util.Scanner;

public class Modules {
    Scanner sc = new Scanner(System.in);
    int[] theComb = new int[4];
    int[] myComb = new int[4];

    int i;
    /**
     * LANCEMENT DU JEU
     */
    public void runGame() {
        /** LANCEMENT DU JEU*/
        int myValue = 0;
        int counter = 1;
        System.out.println("---[ESCAPE GAME]---");
        System.out.println("Trouvez la combinaison suivante : [x] [x] [x] [x]");

        /** Création de la combinaison*/
        this.generateComb();
        System.out.println("combinaison à trouver : "+theComb[0] + theComb[1] + theComb[2] + theComb[3]);
        do {
            this.displayAskComb(counter);
            myValue = sc.nextInt();
            if (myValue<1 || myValue>9) {
                System.out.println("Veuillez saisir une valeur comprise entre 1 et 9");
            } else {
                this.displayMyCombination(counter, myValue);
                counter = counter + 1;
            }
        } while (counter<=4 && (myValue>=1 || myValue<=9));
        this.displayResult();
    }

    /**
     *  Création de la combinaison à trouver
     */
    public void generateComb() {
        for ( i = 0 ; i<4; i++) {
            int nb = 0;
            nb = (int) (Math.random() * 10 );     /** avec 0 < nb < 9 */
            theComb[i] = nb;
        }
    }

    /**
     * Affiche la poposition avec numérotation
     * @param counter nombre de propositions faites sur les 4 possibles
     */
    public void displayAskComb(int counter) {
            System.out.println("Saisir un chiffre compris entre 1 et 9 et validez avec Entrée (Chiffre " + counter + "/4)");
    }

    /**
     * Affiche la poposition faite avec en plus la numérotation
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
        System.out.println("combinaison choisie : "+myComb[0] + myComb[1] + myComb[2] + myComb[3]);
    }

    /**
     * Affiche la réponse en fonction de la proposition
     */
    public void displayResult() {
        System.out.println("combinaison à trouver : "+theComb[0] + theComb[1] + theComb[2] + theComb[3]);
        String listResults = "";
        for ( i = 0 ; i<4; i++) {
           if (myComb[i]==theComb[i]) {
               listResults = listResults + "=";
           } else if (myComb[i]<theComb[i]) {
               listResults = listResults + "+";
           }else if (myComb[i]>theComb[i]) {
                listResults = listResults + "-";
           }
        }
        System.out.println(listResults);
    }
}
