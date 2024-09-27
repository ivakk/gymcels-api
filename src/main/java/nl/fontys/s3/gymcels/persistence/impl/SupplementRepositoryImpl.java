package nl.fontys.s3.gymcels.persistence.impl;

import nl.fontys.s3.gymcels.domain.Supplement;
import nl.fontys.s3.gymcels.persistence.SupplementRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class SupplementRepositoryImpl implements SupplementRepository {
    @Override
    public boolean createSupplementRepo(Supplement supplement) {
        return false;
    }

    @Override
    public boolean deleteSupplementRepo(int supplementId) {
        return false;
    }

    @Override
    public boolean updateSupplementRepo(Supplement supplement) {
        return false;
    }

    @Override
    public Supplement getSupplementByIDRepo(int supplementId) {
        return null;
    }

    @Override
    public ArrayList<Supplement> getAllSupplementsRepo() {
        return null;
    }
}
