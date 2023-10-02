/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import dao.ObjetBdd;
import annot.PrimaryKeyAnnotation;

/**
 *
 * @author P14A-10-Cedric
 */
public class Postulant extends ObjetBdd<Postulant> {
    @PrimaryKeyAnnotation
    private int id;
    private String nom;
    private String prenom;
    private Date date_naissance;
    private int sexe;
    private String mail;
    private String mdp;

    public Postulant(String nom, String prenom, String date_naissance, String sexe, String mail, String mdp) throws Exception {
        this.setNom(nom);
        this.setPrenom(prenom);
        String dateString = date_naissance; // Replace with your input date string
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // Step 1: Parse the String date into a java.util.Date
            
            this.setDate_naissance(dateFormat.parse(date_naissance));

            System.out.println("Input String Date: " + dateString);
            System.out.println("java.util.Date: " + dateFormat.parse(date_naissance));
        } catch (ParseException e) {
            e.printStackTrace();
            throw e;
        }
        this.sexe = Integer.parseInt(sexe);
        this.mail = mail;
        this.mdp = mdp;
    }

    public Postulant(int id) {
        this.setId(id);
    }

    public Postulant(int id, String nom, String prenom, Date date, int sexe, String mail, String mdp) {
        this.setId(id);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDate_naissance(date);
        this.setSexe(sexe);
        this.setMail(mail);
        this.setMdp(mdp);
    }

    public Postulant(String nom, String prenom, Date date, int sexe, String mail, String mdp) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDate_naissance(date);
        this.setSexe(sexe);
        this.setMail(mail);
        this.setMdp(mdp);
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date) {
        this.date_naissance = date;
    }

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    
}
