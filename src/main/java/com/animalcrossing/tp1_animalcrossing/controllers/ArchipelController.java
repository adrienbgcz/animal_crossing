package com.animalcrossing.tp1_animalcrossing.controllers;

import com.animalcrossing.tp1_animalcrossing.dao.ArchipelDao;
import com.animalcrossing.tp1_animalcrossing.dao.IleDao;
import com.animalcrossing.tp1_animalcrossing.modele.Archipel;
import com.animalcrossing.tp1_animalcrossing.modele.Ile;
import com.animalcrossing.tp1_animalcrossing.modele.Joueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ArchipelController {

    @Autowired
    private ArchipelDao archipelDao;
    private IleDao ileDao;

    public ArchipelController(ArchipelDao archipelDao, IleDao ileDao) {
        this.archipelDao = archipelDao;
        this.ileDao = ileDao;
    }



    @GetMapping("/archipel")
        public ModelAndView getArchipelList(@RequestParam("playerId") int playerId, ModelAndView modelAndView) {
                List<Archipel> archipels = archipelDao.getArchipelList(playerId);
                List<Ile> iles = ileDao.getIleList(archipels.get(0).getId());
                modelAndView = new ModelAndView("archipel");
                modelAndView.addObject("listeArchipels", archipels);
                modelAndView.addObject("listeIles", iles);

        return modelAndView;
    }

    @GetMapping("/createArchipel")
    public ModelAndView createArchipelPage() {
        ModelAndView model = new ModelAndView("createArchipel");

        return model;
    }

    @PostMapping("createArchipel") //parenthèses: fait référence au POST dans le front
    public ModelAndView createArchipel(@RequestParam("nomArchipelEnvoye") String nomArchipel,
                                      @RequestParam("localisationArchipelEnvoye") String localisationArchipel,
                                      @RequestParam("idJoueurEnvoye") int idJoueur,
                                      ModelAndView modelAndView) {

        modelAndView = new ModelAndView("archipel");

        Archipel archipel = new Archipel(nomArchipel, localisationArchipel, idJoueur);

        Archipel archipelToInsert = archipelDao.createArchipel(archipel);



        /*boolean isExistMail = joueurDao.isExistMail(mailJoueur);
        String messageErreur = "Ce compte existe déjà";


        if(!isExistMail) {
            Joueur joueurToInsert = joueurDao.createPlayer(joueur);
        } else {
            modelAndView.addObject("messageErreur", messageErreur) ;
            modelAndView.addObject("nomJoueurAffiche", nomJoueur);
            modelAndView.addObject("prenomJoueurAffiche", prenomJoueur);
        }*/

        return modelAndView;
    }


}


