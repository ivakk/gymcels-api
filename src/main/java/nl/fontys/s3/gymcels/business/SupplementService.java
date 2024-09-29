package nl.fontys.s3.gymcels.business;

import nl.fontys.s3.gymcels.domain.OrderItem;
import nl.fontys.s3.gymcels.domain.Supplement;
import nl.fontys.s3.gymcels.dto.OrderItemDTO;
import nl.fontys.s3.gymcels.dto.SupplementDTO;

import java.util.ArrayList;

public interface SupplementService {
    boolean createSupplement(SupplementDTO supplement);
    boolean deleteSupplement(int supplementId);
    boolean updateSupplement(SupplementDTO supplement);
    Supplement getSupplementByID(int supplementId);
    ArrayList<SupplementDTO> getAllSupplements();
    SupplementDTO convertSupplementToDTO(Supplement supplement);
    Supplement convertDTOToSupplement(SupplementDTO supplementDTO);

}
