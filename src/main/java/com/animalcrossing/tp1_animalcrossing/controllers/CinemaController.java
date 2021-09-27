package com.animalcrossing.tp1_animalcrossing.controllers;

import com.animalcrossing.tp1_animalcrossing.dao.BatimentDao;
import com.animalcrossing.tp1_animalcrossing.dao.CinemaDao;
import com.animalcrossing.tp1_animalcrossing.dao.IleDao;
import com.animalcrossing.tp1_animalcrossing.modele.Batiment;
import com.animalcrossing.tp1_animalcrossing.modele.Cinema;
import com.animalcrossing.tp1_animalcrossing.modele.Ile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CinemaController {
    private final CinemaDao cinemaDao;
    private final IleDao ileDao;
    private final BatimentDao batimentDao;


    @Autowired
    public CinemaController(CinemaDao cinemaDao, IleDao ileDao, BatimentDao batimentDao) {
        this.cinemaDao = cinemaDao;
        this.ileDao = ileDao;
        this.batimentDao = batimentDao;
    }

    /*@GetMapping("/batiments{idIle}")
    public ModelAndView getCinemaList(@RequestParam("idIle") String idIle, ModelAndView modelAndView) {

        int idIleToInt = Integer.parseInt(idIle);

        List<Cinema> cinemasList = cinemaDao.getCinemaList(idIleToInt);
        modelAndView = new ModelAndView("batiments");
        modelAndView.addObject("listeCinemas", cinemasList);

        return modelAndView;
    }*/

    @PostMapping("createCinema")
    public ModelAndView createCinema(@RequestParam("nomCinemaEnvoye") String nomCinema,
                                       @RequestParam("nombrePlacesEnvoye") int nombrePlaces,
                                       @RequestParam("idIle") int idIle,
                                       ModelAndView modelAndView) {


        Cinema cinema = new Cinema(nomCinema, nombrePlaces, idIle);

        Cinema cinemaToInsert = cinemaDao.createCinema(cinema);

        List<Batiment> batiments = batimentDao.getBatimentList(idIle);
        List<Ile> ile = ileDao.getIleById(idIle);
        List<Cinema> cinemasList = cinemaDao.getCinemaList(idIle);


        modelAndView = new ModelAndView("batiments");
        modelAndView.addObject("listeBatiments", batiments);
        modelAndView.addObject("idIle", idIle);
        modelAndView.addObject("nomIleAfterCreation", ile.get(0).getNom());
        modelAndView.addObject("listeCinemas", cinemasList);

        return modelAndView;
    }
}
