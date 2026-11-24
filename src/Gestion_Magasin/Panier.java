package Gestion_Magasin;

import java.util.ArrayList;
import java.util.List;

public class Panier {

    // Chaque ajout = 1 unité. Un produit ajouté 2 fois apparaît 2 fois.
    private List<Produit> produits;

    public Panier() {
        this.produits = new ArrayList<>();
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public boolean estVide() {
        return produits.isEmpty();
    }

    // Ajoute 1 unité au panier si le stock le permet (et décrémente le stock)
    public void ajouterProduit(Produit produit) {
        if (produit.getQuantite() <= 0) {
            System.out.println("Desole, " + produit.getNom() + " est en rupture de stock.");
            return;
        }
        produits.add(produit);
        produit.setQuantite(produit.getQuantite() - 1);
        System.out.println(produit.getNom() + " ajoute au panier.");
    }

    // Retire 1 unité du panier (et la remet en stock)
    public void supprimerProduit(Produit produit) {
        if (produits.remove(produit)) {
            produit.setQuantite(produit.getQuantite() + 1);
            System.out.println(produit.getNom() + " retire du panier.");
        } else {
            System.out.println(produit.getNom() + " n'est pas dans le panier.");
        }
    }

    public void afficherPanier() {
        if (produits.isEmpty()) {
            System.out.println("Le panier est vide.");
            return;
        }
        System.out.println(" Contenu du panier ");
        for (Produit p : produits) {
            System.out.printf("- %-15s %8.2f €%n", p.getNom(), p.getPrix());
        }
        System.out.printf("Total : %.2f €%n", calculerTotal());
    }

    public double calculerTotal() {
        double total = 0;
        for (Produit p : produits) {
            total += p.getPrix();
        }
        return total;
    }

    // Utilisé après la commande
    public void vider() {
        produits.clear();
    }
}
