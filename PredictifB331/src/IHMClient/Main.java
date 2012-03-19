/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package IHMClient;

import Service.PrepareBD;
import Service.Service;

/**
 *
 * @author Administrateur
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PrepareBD preparation = new PrepareBD();
        preparation.populate();
         preparation.addClients();
        Service service = new Service();

        if(service.connectEmploye(5, "hashedpasswd"))
        {
            System.out.println("oui");
        }
        //
    }


}
