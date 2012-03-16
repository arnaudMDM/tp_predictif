/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JFramePrincipal.java
 *
 * Created on 28 févr. 2012, 16:56:12
 */

package predictifIHM;

import Modele.Client;
import Modele.Medium;
import Service.Service;
import java.awt.Component;
import java.awt.Dialog;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrateur
 */
public class JFramePrincipal extends javax.swing.JFrame {
private Service service;
private List<Client> listeClients;
    private List<Medium> listeAutresMediums;
    private List<Medium> listeFavorisMediums;
    /** Creates new form JFramePrincipal */
    public JFramePrincipal(Service service) {
       this.service = service;
       initComponents();
       jButton1.setVisible(false);
       jButton2.setVisible(false);
       jButtonValier.setVisible(false);
       jButtonAnnuler.setVisible(false);


       listeClients = service.getAllClients();
       initialiserChamps();
       //jTableClient.enableInputMethods(false);
       //jTableClient.setCellSelectionEnabled(false);
       initialisationGrille();
       jTableClient.setRowSelectionInterval(0, 0);
    }

    private void ModeAffichage() {
        jComboBoxReference.setEnabled(false);
        jTextAreaAutres.setVisible(false);
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        jTextAreaAdresse.setEditable(false);
        jTextFieldDateNaissance.setEditable(false);
        jTextFieldEmail.setEditable(false);
        jTextFieldNom.setEditable(false);
        jTextFieldPrenom.setEditable(false);
        jTextFieldTelephone.setEditable(false);
        jButtonAnnuler.setVisible(false);
        jButtonValier.setVisible(false);
        jButtonModifier.setVisible(true);
        jButtonSupprimer.setVisible(true);
        jButtonAjouterClient.setEnabled(true);
        jButtonrRechercher.setEnabled(true);
        jTextFieldRecherche.setEnabled(true);
    }

    private void initialisationGrille() {
        jTableClient.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

            public void valueChanged(ListSelectionEvent e) {
                int n = jTableClient.getSelectedRow();
                if (n!= -1) {
                    Client client = listeClients.get(n);
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                     Date date =client.getDateNaissance().getTime();

                    jLabelRepNumero.setText(String.valueOf(client.getNumClient()));
                    jTextFieldDateNaissance.setText(dateFormat.format(date));
                    jTextFieldEmail.setText(client.getEmail());
                    jTextFieldNom.setText(client.getNom());
                    jTextFieldPrenom.setText(client.getPrenom());
                    jTextFieldTelephone.setText(client.getTel());
                    jTextAreaAdresse.setText(client.getAdressePostale());

                    jTextAreaFavoris.removeAll();
                    listeFavorisMediums = client.getMediumsFavoris();
                    for (Medium m : listeFavorisMediums) {
                       jTextAreaFavoris.add(m.getNom());
                    }
                    jTextAreaAutres.removeAll();
                    listeAutresMediums = service.getAllMediums();
                    boolean valide;
                    List<Medium> temp = new ArrayList<Medium>();
                    for (Medium m : listeAutresMediums) {
                        valide = true;
                        for (int i = 0; i < listeFavorisMediums.size(); ++i)
                        {
                            if(listeFavorisMediums.get(i).getNom().equals(m.getNom()))
                            {
                                temp.add(m);
                                valide = false;
                            }
                        }
                        if(valide)
                        {
                            jTextAreaAutres.add(m.getNom());
                        }
                    }
                    listeAutresMediums.removeAll(temp);

                    jLabelRepAstro.setText(client.getSigneAstrologique().getNom());
                    Object[] objets = new Object[1];
                    objets[0] = client.getReferent().getNom();
                    jComboBoxReference.setModel(new DefaultComboBoxModel(objets));

                }

                //throw new UnsupportedOperationException("Not supported yet.");
            }

        });
    }

    public void initialiserChamps() {
        //int n = jTableClient.getSelectedRow();
       // Client unClient = listeClients.get(n
        Object [] names={"Numero","Nom","Prenom","Date de naissance"};
        Object [][] donnees = new Object[listeClients.size()][names.length];
        int cpt =0;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        for(Client c : listeClients)
        {
            date = c.getDateNaissance().getTime();
            donnees[cpt] [0] = c.getNumClient();
            donnees[cpt] [1] = c.getNom();
            donnees[cpt] [2] = c.getPrenom();
            donnees[cpt++] [3] = dateFormat.format(date);

        }
        DefaultTableModel modele= new DefaultTableModel(donnees,names);
        jTableClient.setModel(modele);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAjouterClient = new javax.swing.JButton();
        jTextFieldRecherche = new javax.swing.JTextField();
        jButtonrRechercher = new javax.swing.JButton();
        jButtonModifier = new javax.swing.JButton();
        jButtonSupprimer = new javax.swing.JButton();
        jPanelInfoClient = new javax.swing.JPanel();
        jLabelTitreDétails = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jLabelReferent = new javax.swing.JLabel();
        jLabelNom = new javax.swing.JLabel();
        jLabelPrenom = new javax.swing.JLabel();
        jLabelDateNaissance = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelTel = new javax.swing.JLabel();
        jLabelAdresse = new javax.swing.JLabel();
        jLabelAstro = new javax.swing.JLabel();
        jLabelMedium = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelRepNumero = new javax.swing.JLabel();
        jComboBoxReference = new javax.swing.JComboBox();
        jTextFieldNom = new javax.swing.JTextField();
        jTextFieldPrenom = new javax.swing.JTextField();
        jTextFieldDateNaissance = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldTelephone = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaAdresse = new javax.swing.JTextArea();
        jLabelRepAstro = new javax.swing.JLabel();
        jTextAreaAutres = new java.awt.List();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextAreaFavoris = new java.awt.List();
        jLabelErreur = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClient = new javax.swing.JTable();
        jButtonValier = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonAjouterClient.setText("Ajouter un client");
        jButtonAjouterClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAjouterClientMouseClicked(evt);
            }
        });

        jButtonrRechercher.setText("Rechercher");
        jButtonrRechercher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonrRechercherMouseClicked(evt);
            }
        });

        jButtonModifier.setText("Modifier");
        jButtonModifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonModifierMouseClicked(evt);
            }
        });

        jButtonSupprimer.setText("Supprimer");
        jButtonSupprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSupprimerMouseClicked(evt);
            }
        });

        jPanelInfoClient.setBackground(new java.awt.Color(255, 255, 255));

        jLabelTitreDétails.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTitreDétails.setText("Détails du client sélectionné");

        jLabelNumero.setText("Numéro:");

        jLabelReferent.setText("Référent:");

        jLabelNom.setText("Nom:");

        jLabelPrenom.setText("Prénom:");

        jLabelDateNaissance.setText("Date de naissance:");

        jLabelEmail.setText("Adresse Email:");

        jLabelTel.setText("Téléphone:");

        jLabelAdresse.setText("Adresse postale:");

        jLabelAstro.setText("Signe Astrologique:");

        jLabelMedium.setText("Médiums favoris:");

        jLabelRepNumero.setText("0");

        jComboBoxReference.setEnabled(false);
        jComboBoxReference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxReferenceActionPerformed(evt);
            }
        });

        jTextFieldNom.setEditable(false);

        jTextFieldPrenom.setEditable(false);
        jTextFieldPrenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrenomActionPerformed(evt);
            }
        });

        jTextFieldDateNaissance.setEditable(false);
        jTextFieldDateNaissance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDateNaissanceActionPerformed(evt);
            }
        });

        jTextFieldEmail.setEditable(false);
        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });

        jTextFieldTelephone.setEditable(false);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextAreaAdresse.setColumns(20);
        jTextAreaAdresse.setEditable(false);
        jTextAreaAdresse.setRows(5);
        jScrollPane2.setViewportView(jTextAreaAdresse);

        jLabelRepAstro.setText("Aucun");

        jTextAreaAutres.setVisible(false);

        jButton1.setText(">>");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("<<");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelInfoClientLayout = new javax.swing.GroupLayout(jPanelInfoClient);
        jPanelInfoClient.setLayout(jPanelInfoClientLayout);
        jPanelInfoClientLayout.setHorizontalGroup(
            jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoClientLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInfoClientLayout.createSequentialGroup()
                        .addComponent(jLabelMedium)
                        .addContainerGap())
                    .addGroup(jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelInfoClientLayout.createSequentialGroup()
                            .addComponent(jLabelEmail)
                            .addContainerGap())
                        .addGroup(jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelInfoClientLayout.createSequentialGroup()
                                    .addComponent(jLabelNumero)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 354, Short.MAX_VALUE)
                                    .addGroup(jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabelRepNumero))
                                    .addGap(47, 47, 47))
                                .addComponent(jLabelReferent)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfoClientLayout.createSequentialGroup()
                                    .addGroup(jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelTitreDétails, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelInfoClientLayout.createSequentialGroup()
                                            .addComponent(jLabelAstro)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
                                            .addComponent(jLabelRepAstro))
                                        .addGroup(jPanelInfoClientLayout.createSequentialGroup()
                                            .addGroup(jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfoClientLayout.createSequentialGroup()
                                                    .addComponent(jLabelPrenom)
                                                    .addGap(260, 260, 260))
                                                .addGroup(jPanelInfoClientLayout.createSequentialGroup()
                                                    .addComponent(jLabelNom)
                                                    .addGap(275, 275, 275)))
                                            .addGroup(jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextFieldNom)
                                                .addComponent(jTextFieldPrenom)
                                                .addComponent(jTextFieldDateNaissance, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                                .addComponent(jComboBoxReference, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldTelephone, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                                        .addGroup(jPanelInfoClientLayout.createSequentialGroup()
                                            .addComponent(jLabelAdresse)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelInfoClientLayout.createSequentialGroup()
                                            .addComponent(jTextAreaAutres, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(87, 87, 87)
                                            .addGroup(jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jButton1)
                                                .addComponent(jButton2))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                                            .addComponent(jTextAreaFavoris, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(49, 49, 49)))
                            .addGroup(jPanelInfoClientLayout.createSequentialGroup()
                                .addGroup(jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelTel)
                                    .addComponent(jLabelDateNaissance))
                                .addContainerGap())))))
            .addGroup(jPanelInfoClientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelErreur)
                .addContainerGap(467, Short.MAX_VALUE))
        );
        jPanelInfoClientLayout.setVerticalGroup(
            jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoClientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitreDétails, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumero)
                    .addComponent(jLabel1)
                    .addComponent(jLabelRepNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelReferent)
                    .addComponent(jComboBoxReference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInfoClientLayout.createSequentialGroup()
                        .addComponent(jLabelNom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelPrenom)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDateNaissance)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelEmail))
                    .addGroup(jPanelInfoClientLayout.createSequentialGroup()
                        .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDateNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTel)
                    .addComponent(jTextFieldTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInfoClientLayout.createSequentialGroup()
                        .addComponent(jLabelAdresse)
                        .addGap(53, 53, 53)
                        .addGroup(jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAstro)
                            .addComponent(jLabelRepAstro)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelMedium)
                .addGap(25, 25, 25)
                .addGroup(jPanelInfoClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextAreaAutres, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTextAreaFavoris, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfoClientLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addGap(30, 30, 30)
                .addComponent(jLabelErreur)
                .addContainerGap())
        );

        jTableClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Numéro", "Nom", "Prénom", "Date de naissance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableClient.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableClient);
        jTableClient.getColumnModel().getColumn(0).setResizable(false);
        jTableClient.getColumnModel().getColumn(1).setResizable(false);
        jTableClient.getColumnModel().getColumn(3).setResizable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jButtonValier.setText("Valider");
        jButtonValier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonValierMouseClicked(evt);
            }
        });

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAnnulerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAjouterClient)
                        .addGap(65, 65, 65)
                        .addComponent(jTextFieldRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonrRechercher))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButtonModifier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonValier)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSupprimer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAnnuler))
                    .addComponent(jPanelInfoClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAjouterClient)
                    .addComponent(jTextFieldRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonrRechercher)
                    .addComponent(jButtonModifier)
                    .addComponent(jButtonSupprimer)
                    .addComponent(jButtonValier)
                    .addComponent(jButtonAnnuler))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelInfoClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrenomActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextFieldPrenomActionPerformed

    private void jTextFieldDateNaissanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDateNaissanceActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextFieldDateNaissanceActionPerformed

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextFieldEmailActionPerformed

    private void jComboBoxReferenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxReferenceActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jComboBoxReferenceActionPerformed

    private void jButtonSupprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSupprimerMouseClicked
        // TODO add your handling code here:
        JDialog jDialogSuppression = new JDialogSuppression(this,true,service,listeClients.get(jTableClient.getSelectedRow()));
        jDialogSuppression.setVisible(true);
        //A MODIFIER SI ON A LE TEMPS
        
        listeClients = service.getAllClients();
        initialiserChamps();
        jTableClient.setRowSelectionInterval(0, 0);
    }//GEN-LAST:event_jButtonSupprimerMouseClicked

    private void jButtonAjouterClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAjouterClientMouseClicked
        // TODO add your handling code here:
        JFrameAjouterClient jFrameAjouterClient = new JFrameAjouterClient(service);
        jFrameAjouterClient.setVisible(true);
        listeClients = service.getAllClients();
        initialiserChamps();
        jTableClient.setRowSelectionInterval(0, 0);
    }//GEN-LAST:event_jButtonAjouterClientMouseClicked

    private void jButtonModifierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonModifierMouseClicked
        // TODO add your handling code here:
        jComboBoxReference.setEnabled(true);
        jTextAreaAutres.setVisible(true);
        jButton1.setVisible(true);
        jButton2.setVisible(true);
        jTextAreaAdresse.setEditable(true);
        jTextFieldDateNaissance.setEditable(true);
        jTextFieldEmail.setEditable(true);
        jTextFieldNom.setEditable(true);
        jTextFieldPrenom.setEditable(true);
        jTextFieldTelephone.setEditable(true);
        jButtonAnnuler.setVisible(true);
        jButtonValier.setVisible(true);
        jButtonModifier.setVisible(false);
        jButtonSupprimer.setVisible(false);
        jButtonAjouterClient.setEnabled(false);
        jButtonrRechercher.setEnabled(false);
        jTextFieldRecherche.setEnabled(false);
    }//GEN-LAST:event_jButtonModifierMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        if(jTextAreaAutres.getSelectedIndex() != -1) {
            listeFavorisMediums.add(listeAutresMediums.get(jTextAreaAutres.getSelectedIndex()));
            listeAutresMediums.remove(jTextAreaAutres.getSelectedIndex());
            jTextAreaFavoris.add(jTextAreaAutres.getSelectedItem());
            jTextAreaAutres.remove(jTextAreaAutres.getSelectedIndex());
        }
}//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        if(jTextAreaFavoris.getSelectedIndex() != -1) {
            listeAutresMediums.add(listeFavorisMediums.get(jTextAreaFavoris.getSelectedIndex()));
            listeFavorisMediums.remove(jTextAreaFavoris.getSelectedIndex());
            jTextAreaAutres.add(jTextAreaFavoris.getSelectedItem());
            jTextAreaFavoris.remove(jTextAreaFavoris.getSelectedIndex());
        }
}//GEN-LAST:event_jButton2MouseClicked

    private void jButtonAnnulerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAnnulerMouseClicked
        // TODO add your handling code here:
        ModeAffichage();
        listeClients = service.getAllClients();
        initialisationGrille();
        int temp = jTableClient.getSelectedRow();
        jTableClient.setRowSelectionInterval(0, 0);
        jTableClient.setRowSelectionInterval(temp,temp);
    }//GEN-LAST:event_jButtonAnnulerMouseClicked

    private void jButtonValierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonValierMouseClicked
        // TODO add your handling code here:
//        Client client = new Client (jTextFieldNom.getText(),jTextFieldPrenom.getText(),jTextAreaAdresse.getText(),
//                jTextFieldEmail.getText(),jTextFieldTelephone.getText(), NewGregorianCalendar(jTextFieldDateNaissance.getText())
//                ,));
        try {
            int n = jTableClient.getSelectedRow();
            Client client ;
            if (n!= -1) {
                client = listeClients.get(n);
                client.setNom(jTextFieldNom.getText());
                client.setPrenom(jTextFieldPrenom.getText());
                client.setAdressePostale(jTextAreaAdresse.getText());
                client.setDateNaissance(NewGregorianCalendar(jTextFieldDateNaissance.getText()));
                client.setEmail(jTextFieldEmail.getText());
                client.setTel(jTextFieldTelephone.getText());

                service.updateClient(client);
            }

            //service.updateClient(listeClients.get(jTableClient.getSelectedRow()));
            ModeAffichage();
        }
        catch(Exception e) {
            jLabelErreur.setText(e.getMessage());
        }


    }//GEN-LAST:event_jButtonValierMouseClicked

    private void jButtonrRechercherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonrRechercherMouseClicked
        // TODO add your handling code here:
        List<Client> temp = service.getAllClients();
        listeClients.clear();
        for(Client c : temp)
        {
            if(c.getNom().equalsIgnoreCase(jTextFieldRecherche.getText())
                    || c.getPrenom().equalsIgnoreCase(jTextFieldRecherche.getText())
                    || String.valueOf(c.getNumClient()).equalsIgnoreCase(jTextFieldRecherche.getText())
                    || jTextFieldRecherche.getText().equals(""))
            {
                listeClients.add(c);
            }
        }
        initialiserChamps();
        jTableClient.setRowSelectionInterval(0, 0);
    }//GEN-LAST:event_jButtonrRechercherMouseClicked

    private GregorianCalendar NewGregorianCalendar(String date) throws Exception
    {
        String[] listeStrings = date.split("/");

        if(listeStrings.length != 3)
        {
            throw new Exception("date invalide");
        }
        //VERIFIER DATE
        int jour = Integer.parseInt(listeStrings[0]);
        int mois = Integer.parseInt(listeStrings[1])-1;
        int annee = Integer.parseInt(listeStrings[2]);

        return new GregorianCalendar(annee,mois,jour);
    }

    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//
//                new JFramePrincipal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAjouterClient;
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JButton jButtonValier;
    private javax.swing.JButton jButtonrRechercher;
    private javax.swing.JComboBox jComboBoxReference;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAdresse;
    private javax.swing.JLabel jLabelAstro;
    private javax.swing.JLabel jLabelDateNaissance;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelErreur;
    private javax.swing.JLabel jLabelMedium;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelPrenom;
    private javax.swing.JLabel jLabelReferent;
    private javax.swing.JLabel jLabelRepAstro;
    private javax.swing.JLabel jLabelRepNumero;
    private javax.swing.JLabel jLabelTel;
    private javax.swing.JLabel jLabelTitreDétails;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelInfoClient;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableClient;
    private javax.swing.JTextArea jTextAreaAdresse;
    private java.awt.List jTextAreaAutres;
    private java.awt.List jTextAreaFavoris;
    private javax.swing.JTextField jTextFieldDateNaissance;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldPrenom;
    private javax.swing.JTextField jTextFieldRecherche;
    private javax.swing.JTextField jTextFieldTelephone;
    // End of variables declaration//GEN-END:variables

}
