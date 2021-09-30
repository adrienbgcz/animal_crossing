package com.animalcrossing.tp1_animalcrossing.controllers;

import com.animalcrossing.tp1_animalcrossing.dao.CinemaDao;
import com.animalcrossing.tp1_animalcrossing.dao.FilmDao;
import com.animalcrossing.tp1_animalcrossing.dao.IleDao;
import com.animalcrossing.tp1_animalcrossing.map.FilmsWithTicketsMapper;
import com.animalcrossing.tp1_animalcrossing.modele.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.dao.EmptyResultDataAccessException;
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


    @PostMapping("getFilmsByCinema")
    public ModelAndView getFilmsByCinema(@RequestParam("idCinema") int idCinema, @RequestParam("nomCinema") String nomCinema, ModelAndView modelAndView) {
        List<Film> allFilms = filmDao.getAllFilms();

        List<FilmsWithTickets> listeFilms = filmDao.getFilmsByCinema(idCinema);
        modelAndView = new ModelAndView("filmsAffiche");
        modelAndView.addObject("listeFilms", listeFilms);
        modelAndView.addObject("nomCinema", nomCinema);
        modelAndView.addObject("allFilms", allFilms);
        modelAndView.addObject("idCinema", idCinema);

        return modelAndView;
    }

    @PostMapping("addFilmToCinema")
    public ModelAndView addFilmToCinema(@RequestParam("idFilmToAdd") int idFilm,
                                        @RequestParam("idCinemaToAdd") int idCinema,
                                        @RequestParam("nomCinema") String nomCinema,
                                        ModelAndView modelAndView) {

        CinemaFilm cinemaFilm = new CinemaFilm(idCinema, idFilm);

        List<CinemaFilm> cinemaFilmToCompare = filmDao.getCinemaFilmList(cinemaFilm);

        if (cinemaFilmToCompare.isEmpty()) {
            CinemaFilm cinemaFilmToAdd = filmDao.addFilm(cinemaFilm);

            List<FilmsWithTickets> films = filmDao.getFilmsByCinema(idCinema);
            List<Film> allFilms = filmDao.getAllFilms();

            modelAndView = new ModelAndView("filmsAffiche");
            modelAndView.addObject("listeFilms", films);
            modelAndView.addObject("nomCinema", nomCinema);
            modelAndView.addObject("allFilms", allFilms);
            modelAndView.addObject("idCinema", idCinema);
            return modelAndView;
        } else {

            List<FilmsWithTickets> films = filmDao.getFilmsByCinema(idCinema);
            List<Film> allFilms = filmDao.getAllFilms();
            String messageErreur = "Ce film est déjà à l'affiche";

            modelAndView = new ModelAndView("filmsAffiche");
            modelAndView.addObject("listeFilms", films);
            modelAndView.addObject("nomCinema", nomCinema);
            modelAndView.addObject("allFilms", allFilms);
            modelAndView.addObject("idCinema", idCinema);
            modelAndView.addObject("messageErreur", messageErreur);

            return modelAndView;
        }
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

