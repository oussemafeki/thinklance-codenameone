/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.mobileapp.GUI.Evenement;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.thinklance.mobileapp.Entities.CategorieEvenement;
import com.thinklance.mobileapp.Services.CategorieService;

/**
 *
 * @author Oussema-PC
 */
public class AjouterCategorie {
    Form a ;
    public AjouterCategorie()
    {
      a=new Form("Ajouter catégorie");
       
        a.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        TextField nom=new TextField();
        nom.setHint("Nom");
        TextArea description=new TextField();
        description.setHint("Description");
        a.add(nom);
        a.add(description);
        Button btn = new Button("Ajouter");
        a.add(btn);
        btn.addActionListener(e->
        {
                   CategorieEvenement ce = new CategorieEvenement(0, nom.getText(), description.getText());
                    CategorieService cs = new CategorieService();
                    cs.ajoutCategorie(ce);
        });
        
        
    }

    public Form getA() {
        return a;
    }

    public void setA(Form a) {
        this.a = a;
    }
    
    
}
