package com.animalcrossing.tp1_animalcrossing.controllers;

import com.animalcrossing.tp1_animalcrossing.dao.ArchipelDao;
import com.animalcrossing.tp1_animalcrossing.dao.IleDao;
import com.animalcrossing.tp1_animalcrossing.modele.Archipel;
import com.animalcrossing.tp1_animalcrossing.modele.Ile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IleController {

    private final IleDao ileDao;
    private final ArchipelDao archipelDao;

    @Autowired
    public IleController (IleDao ileDao, ArchipelDao archipelDao) {
        this.ileDao = ileDao;
        this.archipelDao = archipelDao;
    }



    /*@GetMapping("displayIles")
    public ModelAndView getIleList(@RequestParam("idArchipel") int idArchipel, ModelAndView modelAndView) {
        List<Ile> iles = ileDao.getIleList(idArchipel);
        modelAndView = new ModelAndView("archipel");
        modelAndView.addObject("listeIles", iles);
        return modelAndView;
    }*/

    /*@PostMapping("createIle")
    public ModelAndView createIlePage() {
        ModelAndView model = new ModelAndView("archipel");
        return model;
    }*/


    @PostMapping("createIle") //parenthèses: fait référence au POST dans le front
    public ModelAndView createIle(@RequestParam("nomIleEnvoye") String nomIle,
                                  @RequestParam("localisationIleEnvoye") String localisationIle,
                                  @RequestParam("idArchipelEnvoye") int idArchipel,
                                  @RequestParam("idPlayer") int idPlayer,
                                  ModelAndView modelAndView) {

        Ile ile = new Ile(nomIle, localisationIle, idArchipel);

        Ile ileToInsert = ileDao.createIle(ile);

        List<Archipel> archipels = archipelDao.getArchipelList(idPlayer);
        List<Ile> iles = ileDao.getIleList(archipels.get(0).getId());
        modelAndView = new ModelAndView("archipel");
        modelAndView.addObject("listeArchipels", archipels);
        modelAndView.addObject("listeIles", iles);

        return modelAndView;
    }

    @PostMapping("displayUpdateIle")
    public ModelAndView updateIle(@RequestParam("idIle") int idIleToUpdate,
                                  @RequestParam("idPlayer") int idPlayer,
                                  ModelAndView modelAndView) {


        List<Archipel> archipels = archipelDao.getArchipelList(idPlayer);
        List<Ile> iles = ileDao.getIleList(archipels.get(0).getId());
        modelAndView = new ModelAndView("archipelWithIleUpdate");
        modelAndView.addObject("listeArchipels", archipels);
        modelAndView.addObject("listeIles", iles);
        modelAndView.addObject("idIleToUpdate", idIleToUpdate);

        return modelAndView;
    }


    @PostMapping("updateIle")
    public ModelAndView updateIle(@RequestParam("nomToUpdateEnvoye") String nomIle,
                                  @RequestParam("localisationToUpdateEnvoye") String localisationIle,
                                  @RequestParam("idArchipelEnvoye") int idArchipel,
                                  @RequestParam("idPlayer") int idPlayer,
                                  @RequestParam("idIleToUpdate") int idIle,
                                  ModelAndView modelAndView) {

        Ile ile = new Ile(idIle, nomIle, localisationIle, idArchipel);

        Ile ileToUpdate = ileDao.updateIle(ile);

        List<Archipel> archipels = archipelDao.getArchipelList(idPlayer);
        List<Ile> iles = ileDao.getIleList(archipels.get(0).getId());
        modelAndView = new ModelAndView("archipel");
        modelAndView.addObject("listeArchipels", archipels);
        modelAndView.addObject("listeIles", iles);

        return modelAndView;
    }

    @PostMapping("deleteIle")
    public ModelAndView deleteIle(@RequestParam("idPlayer") int idPlayer,
                                  @RequestParam("idIle") int idIle,
                                  ModelAndView modelAndView) {


        Ile ile = new Ile(idIle);



        int ileToDelete = ileDao.deleteIle(ile);

        List<Archipel> archipels = archipelDao.getArchipelList(idPlayer);
        List<Ile> iles = ileDao.getIleList(archipels.get(0).getId());
        modelAndView = new ModelAndView("archipel");
        modelAndView.addObject("listeArchipels", archipels);
        modelAndView.addObject("listeIles", iles);

        return modelAndView;
    }

    @GetMapping("/ile")
    public ModelAndView displayIle(ModelAndView modelAndView) {
        modelAndView = new ModelAndView("ile");
        return modelAndView;
    }



}
