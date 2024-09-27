package nl.fontys.s3.gymcels.persistence.impl;

import nl.fontys.s3.gymcels.domain.Supplement;
import nl.fontys.s3.gymcels.persistence.SupplementRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class FakeSupplementRepositoryImpl implements SupplementRepository {
    private ArrayList<Supplement> supplements = new ArrayList<>();
    @Override
    public boolean createSupplementRepo(Supplement supplement) {
        supplements = new ArrayList<>();
        if (supplement == null) {
            return false;
        }
        else {
            supplements.add(supplement);
            return true;
        }
    }

    @Override
    public boolean deleteSupplementRepo(int supplementId) {
        supplements = new ArrayList<>();
        supplements.add(new Supplement(1, "BiotechUSA", "Beef Protein", "Good Protein",
                "very high protein", 10, 100.0));
        Supplement supplement = new Supplement(1, "BiotechUSA", "Beef Protein", "Good Protein",
                "very high protein", 10, 100.0);
        if (supplementId <= 0) {
            return false;
        }
        else {
            supplements.remove(getSupplementByIDRepo(supplementId));
            return true;
        }
    }

    @Override
    public boolean updateSupplementRepo(Supplement supplement) {
        return false;
    }

    @Override
    public Supplement getSupplementByIDRepo(int supplementId) {
        Supplement supplement = new Supplement(1, "BiotechUSA", "Beef Protein", "Good Protein",
                "very high protein", 10, 10.0);
        if (supplementId <= 0) {
            throw new IllegalArgumentException("Invalid supplement ID");
        }
        else {
            return supplement;
        }
    }

    @Override
    public ArrayList<Supplement> getAllSupplementsRepo() {
        supplements = new ArrayList<>();
        supplements.add(new Supplement(1, "BiotechUSA", "Beef Protein", "Good Protein",
                "very high protein", 10, 10.0));
        supplements.add(new Supplement(2, "Optimum Nutrition", "Whey Protein", "Mid Protein",
                "high protein", 10, 9.0));
        supplements.add(new Supplement(3, "MyProtein", "Vegan Protein", "Bad Protein",
                "no protein", 10, 20.0));
        return supplements;
    }
}
