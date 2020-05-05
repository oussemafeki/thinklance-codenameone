/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.mobileapp.Entities;

/**
 *
 * @author Oussema-PC
 */
public class Participer {
    int id ; 
    int idadmin;
    int idevent;

    public Participer(int id, int idadmin, int idevent) {
        this.id = id;
        this.idadmin = idadmin;
        this.idevent = idevent;
    }
    
    public Participer()
    {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    public int getIdevent() {
        return idevent;
    }

    public void setIdevent(int idevent) {
        this.idevent = idevent;
    }

    @Override
    public String toString() {
        return "Participer{" + "id=" + id + ", idadmin=" + idadmin + ", idevent=" + idevent + '}';
    }
    
    
}
