/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele.Predictions;

import javax.persistence.Entity;

/**
 *
 * @author Administrateur
 */
@Entity
public class SantePrediction extends Prediction {

    public SantePrediction() {
    }

    public SantePrediction(int niveau, String contenu) {
        this.niveau = niveau;
        this.contenu = contenu;
    }
    
    static public void setSigle()
    {
        sigle = '#';
    }

}
