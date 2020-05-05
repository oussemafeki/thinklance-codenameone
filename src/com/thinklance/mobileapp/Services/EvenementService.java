/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinklance.mobileapp.Services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.ui.events.ActionListener;
import com.thinklance.mobileapp.Entities.CategorieEvenement;
import com.thinklance.mobileapp.Entities.Evenement;
import java.io.IOException;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Oussema-PC
 */
public class EvenementService {
    public void ajoutEvenement(Evenement e) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/ThinkLance/web/app_dev.php/create?nom="+e.getNom()+"&description="+ e.getDescription()+"&lieu="+e.getLieu()+"&date="+e.getDatedeb()+"&nbr_place="+e.getNbr_place()+"&prix="+e.getPrix()+"&nom_categorie="+e.getCategorie();// création de l'URL
          //  String Url = "http://41.226.11.252:1130/tasks/?nomevenement=aaaa&lieu= " + ta.getNom() + "/" + ta.getEtat();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((f) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    public void updatenbr(int id) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/ThinkLance/web/app_dev.php/updatenbr/"+id;
          //  String Url = "http://41.226.11.252:1130/tasks/?nomevenement=aaaa&lieu= " + ta.getNom() + "/" + ta.getEtat();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((f) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
     public ArrayList<Evenement> parseListEvenement(String json) {
         
          

        ArrayList<Evenement> listEvenement = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Evenement e = new Evenement();

                float id = Float.parseFloat(obj.get("id").toString());
                float prix = Float.parseFloat(obj.get("prix").toString());
                float nbr_place =Float.parseFloat(obj.get("nbrPlace").toString());
                e.setId((int) id);
                e.setNom(obj.get("nom").toString());
                e.setDescription(obj.get("description").toString());
                e.setLieu(obj.get("lieu").toString());
               e.setDatedeb(obj.get("date").toString());
               e.setCategorie(obj.get("nomcategorie").toString());
              //  e.setDate_fin((Date) obj.get("date_fin")); 
                  e.setNbr_place((int) nbr_place);
                // e.setCategorie(obj.get("nom_categorie").toString());
                  e.setPrix((Float)prix); 
                System.out.println(e);
                
                listEvenement.add(e);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listEvenement);
        return listEvenement;

    }
    ArrayList<Evenement> listevenement = new ArrayList<>();
       public ArrayList<Evenement> getList3(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/ThinkLance/web/app_dev.php/read");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                EvenementService ser = new EvenementService();
                listevenement = ser.parseListEvenement(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listevenement ;
    }
    
}
