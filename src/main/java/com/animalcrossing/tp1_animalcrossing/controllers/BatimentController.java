package com.animalcrossing.tp1_animalcrossing.controllers;

import com.animalcrossing.tp1_animalcrossing.dao.BatimentDao;
import com.animalcrossing.tp1_animalcrossing.dao.CinemaDao;
import com.animalcrossing.tp1_animalcrossing.dao.IleDao;
import com.animalcrossing.tp1_animalcrossing.modele.Archipel;
import com.animalcrossing.tp1_animalcrossing.modele.Batiment;
import com.animalcrossing.tp1_animalcrossing.modele.Cinema;
import com.animalcrossing.tp1_animalcrossing.modele.Ile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BatimentController {
    private final BatimentDao batimentDao;
    private final IleDao ileDao;
    private final CinemaDao cinemaDao;

    @Autowired
    public BatimentController(BatimentDao batimentDao, IleDao ileDao, CinemaDao cinemaDao) {
        this.batimentDao = batimentDao;
        this.ileDao = ileDao;
        this.cinemaDao = cinemaDao;
    }

    @GetMapping("/batiments{idIle}")
    public ModelAndView getBatimentsList(@RequestParam("idIle") String idIle, ModelAndView modelAndView) {

        int idIleToInt = Integer.parseInt(idIle);

        List<Batiment> batimentsList = batimentDao.getBatimentList(idIleToInt);
        modelAndView = new ModelAndView("batiments");
        modelAndView.addObject("listeBatiments", batimentsList);

//on liste les cinémas
        List<Cinema> cinemasList = cinemaDao.getCinemaList(idIleToInt);
        modelAndView.addObject("listeCinemas", cinemasList);


        return modelAndView;
    }

    @PostMapping("createBatiment")
    public ModelAndView createBatiment(@RequestParam("nomBatimentEnvoye") String nomBatiment,
                                       @RequestParam("idTypeBatimentEnvoye") int idTypeBatiment,
                                       @RequestParam("idIle") int idIle,
                                       ModelAndView modelAndView) {



        Batiment batiment = new Batiment(nomBatiment, idTypeBatiment, idIle);

        Batiment batimentToInsert = batimentDao.createBatiment(batiment);

        List<Batiment> batiments = batimentDao.getBatimentList(idIle);
        List<Ile> ile = ileDao.getIleById(idIle);
        List<Cinema> cinemasList = cinemaDao.getCinemaList(idIle);


        modelAndView = new ModelAndView("batiments");
        modelAndView.addObject("listeBatiments", batiments);
        modelAndView.addObject("idIle", idIle);
        modelAndView.addObject("nomIleAfterCreation", ile.get(0).getNom());
        modelAndView.addObject("listeCinemas", cinemasList);
        System.out.println(ile.get(0).getNom());

        return modelAndView;
    }

    @PostMapping("displayUpdateBatiment")
    public ModelAndView displayUpdateBatiment(@RequestParam("idBatiment") int idBatimentToUpdate,
                                  @RequestParam("idIle") int idIle,
                                  ModelAndView modelAndView) {

        List<Batiment> batiments = batimentDao.getBatimentList(idIle);
        List<Cinema> cinemas = cinemaDao.getCinemaList(idIle);
        List<Ile> ile = ileDao.getIleById(idIle);


        modelAndView = new ModelAndView("batimentsWithBatimentsToUpdate");
        modelAndView.addObject("listeBatiments", batiments);
        modelAndView.addObject("listeCinemas", cinemas);
        modelAndView.addObject("idBatimentToUpdate", idBatimentToUpdate);
        modelAndView.addObject("nomIleAfterCreation", ile.get(0).getNom());
        return modelAndView;
    }

    @PostMapping("updateBatiment")
    public ModelAndView updateBatiment(@RequestParam("idBatimentToUpdate") int idBatiment,
                                  @RequestParam("nomBatimentToUpdate") String nomBatiment,
                                  @RequestParam("idTypeBatimentToUpdate") int idTypeBatiment,
                                  @RequestParam("idIle") int idIle,
                                  ModelAndView modelAndView) {


        Batiment batiment = new Batiment(idBatiment, nomBatiment, idIle, idTypeBatiment);

        Batiment batimentToUpdate = batimentDao.updateBatiment(batiment);

        List<Ile> ile = ileDao.getIleById(idIle);
        List<Batiment> batiments = batimentDao.getBatimentList(idIle);
        List<Cinema> cinemas = cinemaDao.getCinemaList(idIle);

        modelAndView = new ModelAndView("batiments");
        modelAndView.addObject("listeBatiments", batiments);
        modelAndView.addObject("listeCinemas", cinemas);
        modelAndView.addObject("nomIleAfterCreation", ile.get(0).getNom());

        return modelAndView;
    }
}
