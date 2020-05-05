/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.mobileapp.GUI.Evenement;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.thinklance.mobileapp.Entities.CategorieEvenement;
import com.thinklance.mobileapp.Services.CategorieService;
import java.util.ArrayList;

/**
 *
 * @author Oussema-PC
 */
public class AfficherCategorie {
    Form f ;
    public AfficherCategorie()
    {
         f= new Form("Les catégories",new BoxLayout(BoxLayout.Y_AXIS));
        

               
          ArrayList <CategorieEvenement> CategorieL = new ArrayList();
          CategorieService cs =new CategorieService();
          CategorieL=cs.getList2();
           for (CategorieEvenement c : CategorieL)
           {
            
             Container co;
             co= new Container(new BoxLayout(BoxLayout.X_AXIS));

              
                SpanLabel lb = new  SpanLabel("*"+c.getNom()+" ("+c.getDescription()+" )");
               // Label lbd=new Label(c.getDescription());
                co.add(lb);          
                //co.add(lbd);

                
                 f.add(co);
            }
           f.getToolbar().addCommandToLeftBar("Retour", null, e -> {
                AfficherEvenement a = new AfficherEvenement();
        a.getF().show();
           });
        // f.show();
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
