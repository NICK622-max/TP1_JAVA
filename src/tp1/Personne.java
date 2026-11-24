/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1;

import java.time.LocalDate;

/**
 *
 * @author emman
 */
import java.time.Year;

/**
 * TP 1 - JAVA (Exercices 1, 2 et 3)
 * Classe Personne : attributs, constructeurs, getters/setters, méthodes utilitaires.
 */
public class Personne {

    // Exercice 1 : attributs
    // private : encapsulation. On n'accède aux attributs que via les getters/setters.
    // (protected servirait seulement si des sous-classes devaient y accéder directement)
    private String nom;
    private String prenom;
    private int anNaissance;

    // Compteur partagé par TOUTES les instances (static) -> question 12
    private static int nbPersonnes = 0;

    //Exercice 1 : constructeurs

    // Constructeur naturel : initialise les 3 attributs avec les paramètres
    public Personne(String nom, String prenom, int anNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.anNaissance = anNaissance;
        nbPersonnes++;
        afficherNbPers();
    }

    // Constructeur : nom = "Inconnu", prénom et année passés en paramètres
    public Personne(String prenom, int anNaissance) {
        this("Inconnu", prenom, anNaissance); // réutilise le constructeur naturel
    }

    // Constructeur par défaut : appelle le premier constructeur
    public Personne() {
        this("Potter", "Harry", 1980);
    }

    //Exercice 1 : getters
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAnNaissance() {
        return anNaissance;
    }

    //  Exercice 1 : setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAnNaissance(int anNaissance) {
        this.anNaissance = anNaissance;
    }

    // Exercice 2

    // 6) Retourne l'âge à partir de l'année en cours
    public int calculerAge() {
        return Year.now().getValue() - anNaissance;
    }

    // 7) Affiche les infos de la personne
    public void afficherInfos() {
        System.out.println("Nom: " + nom);
        System.out.println("Prenom: " + prenom);
        System.out.println("Age: " + calculerAge());
    }

    // 8) Ex : "Dupont Jacques mange un Sandwich"
    public void mange(String aliment) {
        System.out.println(nom + " " + prenom + " mange " + aliment);
    }
    
    //9) Point d'entrée
    public static void main(String[] args) {

        System.out.println("   10) Creation de 3 instances    ");
        Personne personne1 = new Personne("Dupont", "Jean", 2004); // constructeur naturel
        Personne personne2 = new Personne("Anna", 2002); // nom = "Inconnu"
        Personne personne3 = new Personne(); // Harry Potter 1980

        System.out.println("\n    11) Getters   ");
        System.out.println("personne1 : " + personne1.getNom() + " " + personne1.getPrenom()
                + " ne(e) en " + personne1.getAnNaissance());
        System.out.println("personne2 : " + personne2.getNom() + " " + personne2.getPrenom()
                + " ne(e) en " + personne2.getAnNaissance());
        System.out.println("personne3 : " + personne3.getNom() + " " + personne3.getPrenom()
                + " ne(e) en " + personne3.getAnNaissance());

        System.out.println("\n    11) Setters    ");
        personne1.setPrenom("Jacques");
        personne1.setAnNaissance(1990);
        System.out.println("personne1 modifiee : " + personne1.getNom() + " "
                + personne1.getPrenom() + " " + personne1.getAnNaissance());

        System.out.println("\n    11) calculerAge()   ");
        System.out.println(personne1.getPrenom() + " a " + personne1.calculerAge() + " ans");
        System.out.println(personne3.getPrenom() + " a " + personne3.calculerAge() + " ans");

        System.out.println("\n    11) afficherInfos()    ");
        personne1.afficherInfos();
        System.out.println("---");
        personne2.afficherInfos();
        System.out.println("---");
        personne3.afficherInfos();

        System.out.println("\n    11) mange()    ");
        personne1.mange("un Sandwich");
        personne2.mange("une pomme");
        personne3.mange("une Chocogrenouille");

        System.out.println("\n    12) afficherNbPers()    ");
        afficherNbPers();

        System.out.println("\n     13) isBissextile()     ");
        Personne[] personnes = {personne1, personne2, personne3};
        for (Personne p : personnes) {
            System.out.println(p.getAnNaissance() + " bissextile ? " + isBissextile(p.getAnNaissance()));
        }
        // Cas limites pour vérifier la règle
        System.out.println("1900 bissextile ? " + isBissextile(1900) + " (multiple de 100 mais pas de 400)");
        System.out.println("2000 bissextile ? " + isBissextile(2000) + " (multiple de 400)");

        System.out.println("\n     14) Nombres premiers     ");
        afficherPremiers(personne2.getAnNaissance());

        System.out.println("\n     15) isPalindrome()     ");
        for (Personne p : personnes) {
            String annee = String.valueOf(p.getAnNaissance());
            System.out.println(p.getPrenom() + " " + p.getNom() + " :");
            System.out.println("   nom    \"" + p.getNom() + "\" palindrome ? " + isPalindrome(p.getNom()));
            System.out.println("   prenom \"" + p.getPrenom() + "\" palindrome ? " + isPalindrome(p.getPrenom()));
            System.out.println("   annee  \"" + annee + "\" palindrome ? " + isPalindrome(annee));
        }
        System.out.println("\"Esope reste ici et se repose\" palindrome ? "
                + isPalindrome("Esope reste ici et se repose"));
    }

    // 12) Affiche le nombre de personnes créées (appelée à chaque construction)
    public static void afficherNbPers() {
        System.out.println(">> Nombre de personnes creees : " + nbPersonnes);
    }

    //Exercice 3

    // 13) Bissextile : multiple de 4 mais pas de 100, OU multiple de 400
    public static boolean isBissextile(int annee) {
        return (annee % 4 == 0 && annee % 100 != 0) || (annee % 400 == 0);
    }

    // 14) Affiche tous les nombres premiers <= annee
    public static void afficherPremiers(int annee) {
        System.out.println("Nombres premiers <= " + annee + " :");
        int compteur = 0;
        for (int n = 2; n <= annee; n++) {
            if (estPremier(n)) {
                System.out.print(n + " ");
                compteur++;
                if (compteur % 20 == 0) {
                    System.out.println(); // retour à la ligne tous les 20 nombres
                }
            }
        }
        System.out.println();
        System.out.println("(" + compteur + " nombres premiers)");
    }

    // Méthode utilitaire : on teste les diviseurs jusqu'à racine de n
    private static boolean estPremier(int n) {
        if (n < 2) return false;
        for (int d = 2; d * d <= n; d++) {
            if (n % d == 0) return false;
        }
        return true;
    }

    // 15) Palindrome : on ignore la casse, les espaces et la ponctuation
    public static boolean isPalindrome(String texte) {
        String s = texte.toLowerCase().replaceAll("[^a-z0-9]", "");
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    
}