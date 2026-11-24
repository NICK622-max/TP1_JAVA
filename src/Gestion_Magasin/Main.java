/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion_Magasin;

/**
 *
 * @author emman
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Création du magasin et des produits
        Magasin magasin = new Magasin();
        magasin.ajouterProduit(new Produit(1, "Clavier", 49.99, 10));
        magasin.ajouterProduit(new Produit(2, "Souris", 19.90, 15));
        magasin.ajouterProduit(new Produit(3, "Ecran", 189.00, 5));
        magasin.ajouterProduit(new Produit(4, "Casque", 79.50, 2));
        magasin.ajouterProduit(new Produit(5, "Webcam", 39.99, 0)); // rupture de stock

        //Création des clients
        Client[] clients = {
                new Client(1, "Dupont", "jean.dupont@mail.com"),
                new Client(2, "Martin", "lea.martin@mail.com")
        };

        Scanner sc = new Scanner(System.in);

        // Choix du client
        System.out.println("Qui etes-vous ?");
        for (int i = 0; i < clients.length; i++) {
            System.out.print((i + 1) + ". ");
            clients[i].afficherDetails();
        }
        int numClient = lireEntier(sc, "Votre choix : ");
        while (numClient < 1 || numClient > clients.length) {
            numClient = lireEntier(sc, "Choix invalide. Votre choix : ");
        }
        Client client = clients[numClient - 1];
        System.out.println("Bienvenue " + client.getNom() + " !");

        Panier panier = new Panier();
        boolean continuer = true;

        //Menu
        while (continuer) {
            System.out.println();
            System.out.println(" Menu Magasin ");
            System.out.println("1. Afficher les produits disponibles");
            System.out.println("2. Ajouter un produit au panier");
            System.out.println("3. Afficher le panier");
            System.out.println("4. Passer la commande");
            System.out.println("5. Quitter");
            System.out.println("6. Retirer un produit du panier");

            int choix = lireEntier(sc, "Votre choix : ");

            switch (choix) {
                case 1:
                    magasin.afficherProduitsDisponibles();
                    break;

                case 2: {
                    System.out.print("Nom du produit : ");
                    String nom = sc.nextLine();
                    Produit p = magasin.trouverProduitParNom(nom);
                    if (p == null) {
                        System.out.println("Produit introuvable.");
                    } else {
                        panier.ajouterProduit(p);
                    }
                    break;
                }

                case 3:
                    panier.afficherPanier();
                    break;

                case 4:
                    if (panier.estVide()) {
                        System.out.println("Panier vide, impossible de commander.");
                    } else {
                        Commande commande = new Commande(client, panier);
                        commande.afficherDetailsCommande();
                        panier.vider();
                        System.out.println("Merci pour votre commande !");
                    }
                    break;

                case 5:
                    continuer = false;
                    System.out.println("Au revoir !");
                    break;

                case 6: {
                    System.out.print("Nom du produit à retirer : ");
                    String nom = sc.nextLine();
                    Produit p = magasin.trouverProduitParNom(nom);
                    if (p == null) {
                        System.out.println("Produit introuvable.");
                    } else {
                        panier.supprimerProduit(p);
                    }
                    break;
                }

                default:
                    System.out.println("Choix invalide.");
            }
        }
        sc.close();
    }

    // Lit un entier proprement (pas de crash si l'utilisateur tape "abc")
    private static int lireEntier(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String ligne = sc.nextLine().trim();
            try {
                return Integer.parseInt(ligne);
            } catch (NumberFormatException e) {
                System.out.println("Entrez un nombre.");
            }
        }
    }
}
