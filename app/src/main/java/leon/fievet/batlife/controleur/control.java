package leon.fievet.batlife.controleur;

import android.content.Context;

import leon.fievet.batlife.model.Batterie;
import leon.fievet.batlife.outils.Serializer;

public final class control {

    private String files = "batteries";
    private leon.fievet.batlife.model.Batterie Batterie;

    public void creeBatterie(String marque, String modele, String type, String connectique,
                             int capacite, int puissance, int autonomie, int prix, int poids,
                             int taille, int nbCellules, String id, Context contexte) {
        Batterie = new Batterie(marque, modele, type, connectique, capacite, puissance,
                autonomie, prix, poids, taille, nbCellules, id);
        Serializer.serialize(files, Batterie, contexte);

    }
}
