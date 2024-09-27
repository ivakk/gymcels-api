package nl.fontys.s3.gymcels.business;

import nl.fontys.s3.gymcels.domain.Supplement;

import java.util.ArrayList;

public interface SupplementService {
    boolean createSupplement(Supplement supplement);
    boolean deleteSupplement(int supplementId);
    boolean updateSupplement(Supplement supplement);
    Supplement getSupplementByID(int supplementId);
    ArrayList<Supplement> getAllSupplements();
}
