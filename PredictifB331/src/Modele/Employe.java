/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Administrateur
 */
@Entity
public class Employe
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codeEmploye;
    private String nom;
    private String prenom;
    @OneToMany(mappedBy = "referent")
    private List<Client> clients;
    private byte[] password;

    public List<Client> getClients()
    {
        return clients;
    }

    public void setClients(List<Client> clients)
    {
        this.clients = clients;
    }

    public int getCodeEmploye()
    {
        return codeEmploye;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

    public void addClient(Client leClient)
    {
        clients.add(leClient);
    }

    public byte[] getPassword()
    {
        return password;
    }

    public Employe(String nom, String prenom, byte[] password)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.clients = new ArrayList<Client>();
    }

    public Employe()
    {
        clients = new ArrayList<Client>();
    }

}
