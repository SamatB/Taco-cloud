package ru.beganov.tacos.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.beganov.tacos.db.TacoRepository;
import ru.beganov.tacos.entity.Taco;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/tacos",
        produces = {"application/json", "text/xml"}) //Обрабатывает запросыс путем /api/tacos
@CrossOrigin(origins = "http://tacocloud:8080") //Разрешает обработку межсайтовых запросов
public class TacoController {

    private final TacoRepository tacoRepository;

    public TacoController(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @GetMapping(params = "recent")
    public Iterable<Taco> recentTacos() {
        PageRequest pageRequest = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        return tacoRepository.findAll(pageRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
        Optional<Taco> tacoOptional = tacoRepository.findById(id);
        if (tacoOptional.isPresent()) {
            return new ResponseEntity<>(tacoOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
