package nl.fontys.s3.gymcels.business.impl;

import nl.fontys.s3.gymcels.business.SupplementService;
import nl.fontys.s3.gymcels.domain.Supplement;
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
    public boolean createSupplement(Supplement supplement) {
        if (supplement == null){
            return false;
        }
        else{
            return supplementRepository.createSupplementRepo(supplement);
        }
    }

    @Override
    public boolean deleteSupplement(int supplementId) {
        if (supplementId <= 0){
            return false;
        }
        else{
            return supplementRepository.deleteSupplementRepo(supplementId);
        }
    }

    @Override
    public boolean updateSupplement(Supplement supplement) {
        if (supplement == null){
            return false;
        }
        else {
            return supplementRepository.updateSupplementRepo(supplement);
        }
    }

    @Override
    public Supplement getSupplementByID(int supplementId) {
        if (supplementId <= 0){
            return null;
        }
        else {
            return supplementRepository.getSupplementByIDRepo(supplementId);
        }
    }

    @Override
    public ArrayList<Supplement> getAllSupplements() {
        return supplementRepository.getAllSupplementsRepo();
    }
}
