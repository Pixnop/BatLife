package leon.fievet.batlife.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Batterie implements Serializable {
    private String marque;
    private String modele;
    private String type;
    private String connectique;
    private int capacite;
    private int puissance;
    private int autonomie;
    private int prix;
    private int poids;
    private int taille;
    private int nbCellules;

    private String Id;

    private String QrCode;

    public Batterie(String marque, String modele, String type, String connectique, int capacite,
                    int puissance, int autonomie, int prix, int poids, int taille,
                    int nbCellules, String id) {
        this.marque = marque;
        this.modele = modele;
        this.type = type;
        this.connectique = connectique;
        this.capacite = capacite;
        this.puissance = puissance;
        this.autonomie = autonomie;
        this.prix = prix;
        this.poids = poids;
        this.taille = taille;
        this.nbCellules = nbCellules;
        this.Id = id;
    }

    @NonNull
    @Override
    public String toString() {
        return marque + "_" +
                modele + "_" +
                type + "_" +
                connectique + "_" +
                capacite + "_" +
                puissance + "_" +
                autonomie + "_" +
                prix + "_" +
                poids + "_" +
                taille + "_" +
                nbCellules + "_";
    }
    public void setQr(String qr) {
        this.QrCode = qr;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public String getType() {
        return type;
    }

    public String getConnectique() {
        return connectique;
    }

    public int getCapacite() {
        return capacite;
    }

    public int getPuissance() {
        return puissance;
    }

    public int getAutonomie() {
        return autonomie;
    }

    public int getPrix() {
        return prix;
    }

    public int getPoids() {
        return poids;
    }

    public int getTaille() {
        return taille;
    }

    public int getNbCellules() {
        return nbCellules;
    }

    public String getQrCode() {
        return QrCode;
    }

    public String getId() {
        return Id;
    }
}
