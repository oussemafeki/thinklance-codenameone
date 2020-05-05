/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.mobileapp.GUI.Evenement;

import com.codename1.ui.Button;
import com.codename1.ui.Calendar;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.thinklance.mobileapp.Entities.CategorieEvenement;
import com.thinklance.mobileapp.Entities.Evenement;
import com.thinklance.mobileapp.Services.CategorieService;
import com.thinklance.mobileapp.Services.EvenementService;


import java.util.ArrayList;
import java.util.Date;
import javafx.scene.control.DatePicker;

/**
 *
 * @author Oussema-PC
 */
public class AjouterEvenement {
    Form a ;
    public AjouterEvenement(){
        
        a=new Form("Ajouter événement");
       
        a.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        TextField nom=new TextField();
        nom.setHint("Nom");
        TextArea description=new TextField();
        description.setHint("Description");
        TextField lieu=new TextField();
        lieu.setHint("Lieu");
        Picker	db=new	Picker();
        db.setType(Display.PICKER_TYPE_DATE);
      TextField prix=new TextField();
        prix.setHint("Prix");
         TextField nbr=new TextField();
        nbr.setHint("Nombre de place ");
         ComboBox categorie = new ComboBox();
          ArrayList <CategorieEvenement> CategorieL = new ArrayList();
          CategorieService cs1 =new CategorieService();
          CategorieL=cs1.getList2();
           for (CategorieEvenement c : CategorieL)
           {
               categorie.addItem(c);
           }
           
        a.add(nom);
        a.add(description);
        a.add(lieu);
        a.add(db);
        a.add(nbr);
        a.add(prix);
        a.add(categorie);
     
        Button btn = new Button("Ajouter");
        a.add(btn);
        Picker	current=new	Picker();
        current.setType(Display.PICKER_TYPE_DATE);
        btn.addActionListener(e->
        {
            
          
            System.out.println("nom="+nom.getText());
           
            if((nom.getText()=="")||(description.getText()=="")||(lieu.getText()=="")||(nbr.getText()=="")||(prix.getText()==""))
            {
               Dialog.show("Echec","Il faut remplir tout les champs","ok", null);
            }
//            else if (current.getTime()-db.getTime()>0)
//            {
//                Dialog.show("Echec","La date doit être supèrieure à la date actuelle !","ok", null);
//            }
            
            else
            {
                Evenement ev = new Evenement(nom.getText(), lieu.getText(), description.getText(), db.getText(), (int) Float.parseFloat(nbr.getText().toString()) ,(Float) Float.parseFloat(prix.getText().toString()), categorie.getSelectedItem().toString(), 1);
                    EvenementService cs = new EvenementService();
                   cs.ajoutEvenement(ev);
                   Dialog.show("Succès","Evénement ajoutée !","ok", null);
            }
        });
        a.getToolbar().addCommandToLeftBar("Retour", null, e -> {
             AfficherEvenement a = new AfficherEvenement();
        a.getF().show();
        });
    }

    public Form getA() {
        return a;
    }

    public void setA(Form a) {
        this.a = a;
    }
    
}
