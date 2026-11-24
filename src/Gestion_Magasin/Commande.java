/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion_Magasin;

/**
 *
 * @author emman
 */
import java.util.ArrayList;
import java.util.List;

public class Commande {

    private static int compteur = 0; // pour générer des id uniques

    private int idCommande;
    private Client client;
    private List<Produit> produitsCommandes;
    private double total;

    // Initialise une commande avec un client et les produits du panier
    public Commande(Client client, Panier panier) {
        compteur++;
        this.idCommande = compteur;
        this.client = client;
        // Copie de la liste : si on vide le panier ensuite, la commande garde ses produits
        this.produitsCommandes = new ArrayList<>(panier.getProduits());
        this.total = panier.calculerTotal();
    }

    public int getIdCommande() {
        return idCommande;
    }

    public Client getClient() {
        return client;
    }

    public List<Produit> getProduitsCommandes() {
        return produitsCommandes;
    }

    public double getTotal() {
        return total;
    }

    public void afficherDetailsCommande() {
        System.out.println("===== Commande n°" + idCommande + " =====");
        client.afficherDetails();
        System.out.println("Produits :");
        for (Produit p : produitsCommandes) {
            System.out.printf("  - %-15s %8.2f €%n", p.getNom(), p.getPrix());
        }
        System.out.printf("TOTAL : %.2f €%n", total);
    }
}