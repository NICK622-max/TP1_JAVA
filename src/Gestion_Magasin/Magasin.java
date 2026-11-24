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

public class Magasin {

    private List<Produit> produits;

    public Magasin() {
        this.produits = new ArrayList<>();
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    public void afficherProduitsDisponibles() {
        System.out.println("Produits disponibles");
        boolean auMoinsUn = false;
        for (Produit p : produits) {
            if (p.getQuantite() > 0) {
                p.afficherDetails();
                auMoinsUn = true;
            }
        }
        if (!auMoinsUn) {
            System.out.println("Aucun produit en stock.");
        }
    }

    // Recherche insensible à la casse. Retourne null si rien trouvé.
    public Produit trouverProduitParNom(String nom) {
        for (Produit p : produits) {
            if (p.getNom().equalsIgnoreCase(nom.trim())) {
                return p;
            }
        }
        return null;
    }
}