package nl.fontys.s3.gymcels.business.impl;

import nl.fontys.s3.gymcels.business.SupplementService;
import nl.fontys.s3.gymcels.domain.OrderItem;
import nl.fontys.s3.gymcels.domain.Supplement;
import nl.fontys.s3.gymcels.dto.OrderItemDTO;
import nl.fontys.s3.gymcels.dto.SupplementDTO;
import nl.fontys.s3.gymcels.persistence.SupplementRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SupplementServiceImpl implements SupplementService {
    private final SupplementRepository supplementRepository;


    public SupplementServiceImpl(SupplementRepository supplementRepository) {
        this.supplementRepository = supplementRepository;
    }

    @Override
    public boolean createSupplement(SupplementDTO supplement) {
        if (supplement == null){
            throw new IllegalArgumentException("supplement is null");
        }
        else{
            return supplementRepository.createSupplementRepo(convertDTOToSupplement(supplement));
        }
    }

    @Override
    public boolean deleteSupplement(int supplementId) {
        if (supplementId <= 0){
            throw new IllegalArgumentException("supplementId must be a positive integer");
        }
        else{
            return supplementRepository.deleteSupplementRepo(supplementId);
        }
    }

    @Override
    public boolean updateSupplement(SupplementDTO supplement) {
        if (supplement == null){
            return false;
        }
        else {
            return supplementRepository.updateSupplementRepo(convertDTOToSupplement(supplement));
        }
    }

    @Override
    public Supplement getSupplementByID(int supplementId) {
        if (supplementId <= 0){
            throw new IllegalArgumentException("supplementId must be a positive integer");
        }
        else {
            return supplementRepository.getSupplementByIDRepo(supplementId);
        }
    }

    @Override
    public ArrayList<SupplementDTO> getAllSupplements() {
        ArrayList<SupplementDTO> supplements = new ArrayList<>();

        // Fetch all supplements from the repository
        ArrayList<Supplement> allSupplements = supplementRepository.getAllSupplementsRepo();

        // Loop through all the supplements directly
        for (Supplement supplement : allSupplements) {
            supplements.add(convertSupplementToDTO(supplement));
        }

        return supplements;
    }

    @Override
    public SupplementDTO convertSupplementToDTO(Supplement supplement) {
        return new SupplementDTO(
                supplement.getId(),
                supplement.getBrand(),
                supplement.getName(),
                supplement.getDescription(),
                supplement.getSupplementFacts(),
                supplement.getQuantity(),
                supplement.getPrice(),
                null
        );
    }

    @Override
    public Supplement convertDTOToSupplement(SupplementDTO supplement) {
        return new Supplement(
                supplement.getId(),
                supplement.getBrand(),
                supplement.getName(),
                supplement.getDescription(),
                supplement.getSupplementFacts(),
                supplement.getQuantity(),
                supplement.getPrice(),
                null
        );
    }


}
