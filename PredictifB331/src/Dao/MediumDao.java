/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;
import javax.persistence.Query;
import Modele.Client;
import Modele.Medium;
import Util.JpaUtil;

/**
 *
 * @author Administrateur
 */
public class MediumDao
{

    static private MediumDao instance = null;

    public static MediumDao getInstance()
    {
        if (instance == null)
        {
            instance = new MediumDao();
        }

        return instance;
    }

    public void create(Medium medium)
    {
        JpaUtil.getEntityManager().persist(medium);
    }

    public void create(List<Medium> mediums)
    {
        for (Medium medium : mediums)
        {
            create(medium);
        }
    }

    public List<Medium> findAll()
    {
        Query q = JpaUtil.getEntityManager().createQuery("SELECT m FROM Medium m");
        return q.getResultList();
    }

    public void update(Medium medium)
    {
        JpaUtil.getEntityManager().merge(medium);
    }

    private MediumDao()
    {
    }

}
