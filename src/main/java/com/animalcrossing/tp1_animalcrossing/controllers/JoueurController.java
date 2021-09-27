package com.animalcrossing.tp1_animalcrossing.controllers;

import com.animalcrossing.tp1_animalcrossing.dao.JoueurDao;
import com.animalcrossing.tp1_animalcrossing.modele.Archipel;
import com.animalcrossing.tp1_animalcrossing.modele.Joueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/*@RequestMapping("/players") // pour postman
@RestController*/

@Controller
public class JoueurController {

    @Autowired
    private JoueurDao joueurDao;

    public JoueurController(JoueurDao joueurDao) {
        this.joueurDao = joueurDao;
    }

    /*@GetMapping
    public List<Joueur> getListeJoueurs() {  // pour Postman
        return joueurDao.getPlayersList();
    }*/

    /*@GetMapping("/players")
    public List<Joueur> getPlayersList(*//*ModelAndView modelAndView*//*) {
        List<Joueur> joueurs = joueurDao.getPlayersList();
        *//*modelAndView = new ModelAndView("joueurs");
        modelAndView.addObject("listeJoueurs", joueurs);*//*
        return joueurs;
    }*/

    /*@PostMapping
    public Joueur addPlayer(@RequestBody Joueur joueur) { // pour Postman
        return joueurDao.createPlayer(joueur);
    }*/

    @GetMapping("/inscription")
    public ModelAndView inscriptionPage() {
        ModelAndView model = new ModelAndView("inscription");
        return model;
    }

    @GetMapping("/connectionPlayer")
    public ModelAndView connectionPage() {
        ModelAndView model = new ModelAndView("connection");
        return model;
    }

    @PostMapping("connection")
    public ModelAndView connectPlayer(@RequestParam("mailJoueurEnvoye") String mailJoueur,
                                    HttpServletRequest req,
                                    ModelAndView modelAndView) {

        Joueur joueur = joueurDao.findPlayerByMail(mailJoueur);

        boolean isExistMail = joueurDao.isExistMail(mailJoueur);
        String messageErreur = "Ce compte n'existe pas";


        if(isExistMail) {
            req.getSession().setAttribute("connectedPlayer", joueur);
            /* playerDashboard()*/
            modelAndView = new ModelAndView("isOkConnection"); //view vers laquelle user sera renvoyé

        } else {
            modelAndView = new ModelAndView("connection");
            modelAndView.addObject("messageErreur", messageErreur) ;
        }
        return modelAndView;
    }

    @GetMapping("/dashboard")
    public ModelAndView displayDashboard(@RequestParam("playerId") int playerId, ModelAndView modelAndView) {
        /*Joueur joueur = joueurDao.findPlayerById(playerId);
        System.out.println(joueur.getNom());*/                              //pour retrouver le joueur à partir de l'id de l'url
        /*modelAndView.addObject("playerFirstName", joueur.getNom());
        modelAndView.addObject("playerLastName", joueur.getPrenom());*/
        Archipel archipel = joueurDao.findArchipelByPlayer(playerId);

        modelAndView = new ModelAndView("dashboard");
        if (archipel == null) {
            String messageNoArchipel = "Vous n'avez pas d'archipel";
            modelAndView.addObject("messageNoArchipel", messageNoArchipel);

        }


        return modelAndView;
    }


    /*@GetMapping("/dashboard")
    public ModelAndView playerDashboard(int playerId, ModelAndView modelAndView) {

    }*/



    @PostMapping("createPlayer") //parenthèses: fait référence au POST dans le front
    public ModelAndView playerInscription(@RequestParam("nomJoueurEnvoye") String nomJoueur,
                                          @RequestParam("prenomJoueurEnvoye") String prenomJoueur,
                                          @RequestParam("mailJoueurEnvoye") String mailJoueur,
                                          ModelAndView modelAndView) {

        modelAndView = new ModelAndView("inscription");

        Joueur joueur = new Joueur(nomJoueur, prenomJoueur, mailJoueur);

        boolean isExistMail = joueurDao.isExistMail(mailJoueur);
        String messageErreur = "Ce compte existe déjà";


        if(!isExistMail) {
            Joueur joueurToInsert = joueurDao.createPlayer(joueur);
        } else {
            modelAndView.addObject("messageErreur", messageErreur) ;
            modelAndView.addObject("nomJoueurAffiche", nomJoueur);
            modelAndView.addObject("prenomJoueurAffiche", prenomJoueur);
        }

        return modelAndView;
    }

    }


