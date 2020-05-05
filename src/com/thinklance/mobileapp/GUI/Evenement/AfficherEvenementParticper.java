/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.mobileapp.GUI.Evenement;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.thinklance.mobileapp.Entities.Evenement;
import com.thinklance.mobileapp.Entities.Participer;
import com.thinklance.mobileapp.Services.EvenementService;
import com.thinklance.mobileapp.Services.ParticiperService;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Oussema-PC
 */
public class AfficherEvenementParticper {
    Form f;
    ImageViewer iv;
    Image i;
Boolean test=true;
    public AfficherEvenementParticper() {
        f = new Form("à participer", new BoxLayout(BoxLayout.Y_AXIS));
        f.getToolbar().addCommandToSideMenu("Les événements à participer", null, e->{
    AfficherEvenementParticper a = new AfficherEvenementParticper();
        a.getF().show()
    ;});
f.getToolbar().addCommandToSideMenu("Ajouter un événement", null, e->{
    AjouterEvenement a = new AjouterEvenement();
        a.getA().show();
    ;});
f.getToolbar().addCommandToSideMenu("Voir les catégories", null, e->{
    AfficherCategorie a = new AfficherCategorie();
        a.getF().show();
    ;});
f.getToolbar().addCommandToSideMenu("Retour", null, e->{
   AfficherEvenement a = new AfficherEvenement();
        a.getF().show();
    ;});
        ArrayList<Evenement> EvenementL = new ArrayList();
        EvenementService cs = new EvenementService();
        EvenementL = cs.getList3();
        if(EvenementL==null)
        {
            SpanLabel message = new SpanLabel("Pas d'événement à participer !");
            f.add(message);
        }
        for (Evenement e : EvenementL) {
               ArrayList<Participer> ParticiperL = new ArrayList();
        ParticiperService ps = new ParticiperService();
        ParticiperL = ps.getList3();
                    System.out.println(ParticiperL);
                    test=true;
        for (Participer p : ParticiperL) {
            if (p.getIdevent()==e.getId()&&(p.getIdadmin()==1))
            {
            
            
            Container co;
            co = new Container(new BoxLayout(BoxLayout.X_AXIS));
            try {
                i = Image.createImage("/logoevent.png").scaled(60, 60);
                iv = new ImageViewer(i);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            SpanLabel lb = new SpanLabel(e.getNom());
            //Label lbd = new Label(e.getDescription());
            //  Label lieu = new Label(e.getLieu());
            // Label date_debut = new Label(e.getDate_debut() + "");
            //  Label date_fin = new Label(e.getDate_fin() + "");
            // Label nbr = new Label(e.getNbr_place() + "Places disponibles");
            Label date = new Label(e.getCategorie());
            // Label categorie= new Label(e.getCategorie());
            // Label vide=new Label ("************");
            co.add(iv);
            Container eve;
            eve = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            eve.add(lb);
            eve.add(date);
            co.add(eve);
            //  co.add(lbd);
            f.add(co);
            iv.addPointerReleasedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Form hi2 = new Form(e.getNom(), BoxLayout.y());
                    SpanLabel categorie = new SpanLabel(e.getCategorie());
                    hi2.add(categorie);
                    
                    SpanLabel sl = new SpanLabel(e.getDescription());
                    Container co1;
                    co1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                    SpanLabel lieu = new SpanLabel(e.getLieu());
                    try {
                        Image i3 = Image.createImage("/lieu.png").scaled(25, 25);
                        ImageViewer iv3 = new ImageViewer(i3);
                        co1.add(iv3);
                        co1.add(lieu);
                    } catch (IOException ex) {
                    }
                    Container co2;
                    co2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                    SpanLabel nbr = new SpanLabel(e.getNbr_place() + "");
                    try {
                        Image i4 = Image.createImage("/nbrplace.jpg").scaled(40, 40);
                        ImageViewer iv4 = new ImageViewer(i4);
                        co2.add(iv4);
                        co2.add(nbr);
                    } catch (IOException ex) {
                    }
                        Container co3;
                    co3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                    SpanLabel date = new SpanLabel(e.getDatedeb());
                    try {
                        Image i5 = Image.createImage("/logoevent.png").scaled(25,25);
                        ImageViewer iv5 = new ImageViewer(i5);
                        co3.add(iv5);
                        co3.add(date);
                    } catch (IOException ex) {
                    }
                    Image i2;
                    try {
                        i2 = Image.createImage("/logoevent.png").scaled(100, 100);
                        ImageViewer iv2 = new ImageViewer(i2);
                        hi2.add(iv2);
                    } catch (IOException ex) {
                    }
                    Label prix1 = new Label("Prix : "+e.getPrix() + "DT");
                      Button btn = new Button("Participer");
                      
                      ArrayList<Participer> ParticiperL = new ArrayList();
        ParticiperService ps = new ParticiperService();
        ParticiperL = ps.getList3();
                    System.out.println(ParticiperL);
                    test=true;
        for (Participer p : ParticiperL) {
            if (p.getIdevent()==e.getId()&&(p.getIdadmin()==1))
            {
                test=false;
            }
                
        }
                    hi2.add(sl);
                    hi2.add(co3);
                    hi2.add(co1);
                    hi2.add(co2);
                    hi2.add(prix1);
                    if (test==true)
                    {
                    hi2.add(btn);
                    }
                    hi2.getToolbar().addCommandToLeftBar("Retour", null, e -> f.showBack());
                    btn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            System.out.println(e.getId());
                            Participer p = new Participer(0,1, e.getId());
                            ParticiperService ps = new ParticiperService();
                            ps.Participer(p);
                            Dialog.show("Succès","L'événement aura lieu le "+e.getDatedeb()+" !","ok", null);
                            AfficherEvenement a = new AfficherEvenement();
        a.getF().show();
                        }
                    });
                    hi2.show();
                }
            });
        }

    }
        }}

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
