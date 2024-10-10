package com.example.encuesta.controller;

import com.example.encuesta.entity.Encuesta;
import com.example.encuesta.repository.EncuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
public class EncuestaController {

    @Autowired
    private EncuestaRepository encuestaRepository;

    @GetMapping("/encuesta")
    public String newEncuesta(Model model) {
        model.addAttribute("encuesta", new Encuesta());
        return "encuesta";
    }

    @PostMapping("/api/encuestas")
    public String enviarEncuesta(@ModelAttribute Encuesta encuesta, BindingResult result) {
        if (result.hasErrors()) {
            return "encuesta";
        }

        // Guardar la encuesta en la base de datos
        encuestaRepository.save(encuesta);
        // Devolver a la pagina de agradecimiento
        return "gracias";
    }

    // Listado de encuestas
    @GetMapping("/encuestas")
    public String listarEncuestas(@RequestParam(value = "filtroNivel", required = false) String filtroNivel, Model model) {
        List<Encuesta> encuestas;

        if (filtroNivel != null && !filtroNivel.isEmpty()) {
            encuestas = encuestaRepository.findByNivelSatisfaccion(filtroNivel);
        } else {
            encuestas = encuestaRepository.findAll();
        }

        model.addAttribute("encuestas", encuestas);
        model.addAttribute("filtroNivel", filtroNivel);
        model.addAttribute("totalEncuestas", encuestaRepository.count());
        model.addAttribute("promedioEdad", encuestaRepository.promedioEdad());
        model.addAttribute("distribucionSatisfaccion", encuestaRepository.distribucionSatisfaccion());

        return "listado_encuestas";
    }

    // Borrar encuesta
    @PostMapping("/encuestas/borrar/{id}")
    public String borrarEncuesta(@PathVariable Long id) {
        encuestaRepository.deleteById(id);
        return "redirect:/encuestas";
    }

}
