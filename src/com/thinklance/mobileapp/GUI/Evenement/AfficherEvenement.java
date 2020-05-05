/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.mobileapp.GUI.Evenement;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.messaging.Message;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.thinklance.mobileapp.Entities.CategorieEvenement;
import com.thinklance.mobileapp.Entities.Evenement;
import com.thinklance.mobileapp.Entities.Participer;
import com.thinklance.mobileapp.Services.CategorieService;
import com.thinklance.mobileapp.Services.EvenementService;
import com.thinklance.mobileapp.Services.ParticiperService;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Object;

/**
 *
 * @author Oussema-PC
 */
public class AfficherEvenement {

    Form f;
    ImageViewer iv;
    Image i;
    Boolean test = true;
private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star);
    s.setBgTransparency(0);
}

private Slider createStarRankSlider() {
    Slider starRank = new Slider();
    starRank.setEditable(true);
    starRank.setMinValue(0);
    starRank.setMaxValue(10);
    Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
            derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
    Style s = new Style(0xffff33, 0, fnt, (byte)0);
    Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    s.setOpacity(100);
    s.setFgColor(0);
    Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
    initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
    starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
    return starRank;
}
    public AfficherEvenement() {
        f = new Form("Les événements", new BoxLayout(BoxLayout.Y_AXIS));
        f.getToolbar().addCommandToSideMenu("Les événements à participer", null, e -> {
            AfficherEvenementParticper a = new AfficherEvenementParticper();
            a.getF().show();
            ;
        });
        f.getToolbar().addCommandToSideMenu("Ajouter un événement", null, e -> {
            AjouterEvenement a = new AjouterEvenement();
            a.getA().show();
            ;
        });
        f.getToolbar().addCommandToSideMenu("Voir les catégories", null, e -> {
            AfficherCategorie a = new AfficherCategorie();
            a.getF().show();
            ;
        });

        ArrayList<Evenement> EvenementL = new ArrayList();
        EvenementService cs = new EvenementService();
        EvenementL = cs.getList3();
        for (Evenement e : EvenementL) {
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
                        Image i5 = Image.createImage("/logoevent.png").scaled(25, 25);
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
                    Label prix1 = new Label("Prix : " + e.getPrix() + "DT");
                    Button btn = new Button("Participer");

   
                    ArrayList<Participer> ParticiperL = new ArrayList();
                    ParticiperService ps = new ParticiperService();
                    ParticiperL = ps.getList3();
                    System.out.println(ParticiperL);
                    test = true;
                    for (Participer p : ParticiperL) {
                        if (p.getIdevent() == e.getId() && (p.getIdadmin() == 1)) {
                            test = false;
                        }

                    }
                    hi2.add(sl);
                    hi2.add(co3);
                    hi2.add(co1);
                    hi2.add(co2);
                    hi2.add(prix1);
                    if ((test == true) && (e.getNbr_place() > 0)) {
                        hi2.add(btn);
                    }
                    else
                    {
                           hi2.add(FlowLayout.encloseCenter(createStarRankSlider()));
                    }
                    hi2.getToolbar().addCommandToLeftBar("Retour", null, e -> f.showBack());
                    btn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            System.out.println(e.getId());
                            Participer p = new Participer(0, 1, e.getId());
                            ParticiperService ps = new ParticiperService();
                            ps.Participer(p);
                            EvenementService ES = new EvenementService();
                            ES.updatenbr(e.getId());
                            Dialog.show("Succès", "L'événement aura lieu le " + e.getDatedeb() + " !", "ok", null);
                            AfficherEvenement a = new AfficherEvenement();
                            Message m = new Message( "L'événement **"+e.getNom() +"** aura lieu le " + e.getDatedeb() + " !");
                            String textAttachmentUri = null;
                            m.getAttachments().put(textAttachmentUri , null);
                            String imageAttachmentUri = null;
                            m.getAttachments().put(imageAttachmentUri , null);
                            Display.getInstance().sendMessage(new String[]{"mohamedoussema.feki@esprit.tn"}, "Un événement à participer ", m);
                            a.getF().show();

                        }
                    });
                    hi2.show();
                }
            });
        }

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
