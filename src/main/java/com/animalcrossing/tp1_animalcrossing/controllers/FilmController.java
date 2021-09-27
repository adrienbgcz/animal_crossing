package com.animalcrossing.tp1_animalcrossing.controllers;

import com.animalcrossing.tp1_animalcrossing.dao.CinemaDao;
import com.animalcrossing.tp1_animalcrossing.dao.FilmDao;
import com.animalcrossing.tp1_animalcrossing.dao.IleDao;
import com.animalcrossing.tp1_animalcrossing.modele.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FilmController {
    private final FilmDao filmDao;


    @Autowired
    public FilmController(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    @GetMapping("getFilmsByCinema")
    public ModelAndView getFilmsByCinema(@RequestParam("idIle") int idIle, @RequestParam("nomCinema") String nomCinema, ModelAndView modelAndView) {
        List<Film> listeFilms = filmDao.getFilmsByCinema(idIle);
        modelAndView = new ModelAndView("filmsAffiche");
        modelAndView.addObject("listeFilms", listeFilms);
        modelAndView.addObject("nomCinema", nomCinema);

        return modelAndView;
    }


    /*@GetMapping("/batiments{idIle}")
    public ModelAndView getCinemaList(@RequestParam("idIle") String idIle, ModelAndView modelAndView) {

        int idIleToInt = Integer.parseInt(idIle);

        List<Cinema> cinemasList = cinemaDao.getCinemaList(idIleToInt);
        modelAndView = new ModelAndView("batiments");
        modelAndView.addObject("listeCinemas", cinemasList);

        return modelAndView;
    }*/

    /*@PostMapping("createBatiment")
    public ModelAndView createBatiment(@RequestParam("nomBatimentEnvoye") String nomBatiment,
                                       @RequestParam("idTypeBatimentEnvoye") int idTypeBatiment,
                                       @RequestParam("idIle") int idIle,
                                       ModelAndView modelAndView) {


        Batiment batiment = new Batiment(nomBatiment, idTypeBatiment, idIle);

        Batiment batimentToInsert = batimentDao.createBatiment(batiment);

        List<Batiment> batiments = batimentDao.getBatimentList(idIle);
        List<Ile> ile = ileDao.getIleById(idIle);

        modelAndView = new ModelAndView("batiments");
        modelAndView.addObject("listeBatiments", batiments);
        modelAndView.addObject("idIle", idIle);
        modelAndView.addObject("nomIleAfterCreation", ile.get(0).getNom());
        System.out.println(ile.get(0).getNom());

        return modelAndView;
    }*/
}

