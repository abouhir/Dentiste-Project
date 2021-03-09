package application.controller;

public class Model {
    private String cin;
    private String nom;
    private String prenom;
    private String date;

    public Model(String cin, String nom, String prenom, String date) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
    }



    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
