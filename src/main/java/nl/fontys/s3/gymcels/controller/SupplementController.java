package nl.fontys.s3.gymcels.controller;

import jakarta.validation.constraints.NotNull;
import nl.fontys.s3.gymcels.business.ShoppingCartService;
import nl.fontys.s3.gymcels.business.SupplementService;
import nl.fontys.s3.gymcels.domain.Supplement;
import nl.fontys.s3.gymcels.dto.OrderItemDTO;
import nl.fontys.s3.gymcels.dto.SupplementDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/supplements")
public class SupplementController {
    private final SupplementService supplementService;
    private final ShoppingCartService shoppingCartService;

    public SupplementController(SupplementService supplementService, ShoppingCartService shoppingCartService) {
        this.supplementService = supplementService;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/all")
    public List<SupplementDTO> getSupplements() {
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

    @PostMapping("/create")
    public ResponseEntity<SupplementDTO> createSupplement(@NotNull @RequestBody SupplementDTO supplement) {
        if (supplementService.createSupplement(supplement)){
            return new ResponseEntity<>(supplement, HttpStatus.CREATED);
        }
        else {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/{id}/add")
    public ResponseEntity<OrderItemDTO> addOrderItem(@NotNull @RequestBody OrderItemDTO orderItem) {
        if (shoppingCartService.addItem(orderItem)){
            return new ResponseEntity<>(orderItem, HttpStatus.CREATED);
        }
        else{
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }
}
