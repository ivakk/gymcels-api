package nl.fontys.s3.gymcels.controller;

import jakarta.validation.constraints.NotNull;
import nl.fontys.s3.gymcels.business.SupplementService;
import nl.fontys.s3.gymcels.domain.Supplement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/supplements")
public class SupplementController {
    private final SupplementService supplementService;

    public SupplementController(SupplementService supplementService) {
        this.supplementService = supplementService;
    }

    @GetMapping
    public List<Supplement> getSupplements() {
        return supplementService.getAllSupplements();
    }

    @GetMapping("/{id}")
    public Supplement getSupplement(@PathVariable("id") int id) {
        if (id < 0) {
            throw new IllegalArgumentException("id < 0");
        }
        else{
            return supplementService.getSupplementByID(id);
        }
    }

    @PostMapping
    public ResponseEntity<Supplement> createSupplement(@NotNull @RequestBody Supplement supplement) {
        if (supplementService.createSupplement(supplement)){
            return new ResponseEntity<>(supplement, HttpStatus.CREATED);
        }
        else {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }
}
