package nl.fontys.s3.gymcels.persistence;

import nl.fontys.s3.gymcels.domain.OrderItem;
import nl.fontys.s3.gymcels.domain.Supplement;

import java.util.ArrayList;

public interface SupplementRepository {
    boolean createSupplementRepo(Supplement supplement);
    boolean deleteSupplementRepo(int supplementId);
    boolean updateSupplementRepo(Supplement supplement);
    Supplement getSupplementByIDRepo(int supplementId);
    ArrayList<Supplement> getAllSupplementsRepo();
    boolean orderSupplementRepo(OrderItem orderItem);
    boolean cancelOrderSupplementRepo(int orderId);
}
