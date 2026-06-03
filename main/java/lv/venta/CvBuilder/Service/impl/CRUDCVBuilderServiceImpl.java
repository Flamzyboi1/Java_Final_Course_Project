package lv.venta.CvBuilder.Service.impl;

import lv.venta.CvBuilder.Model.CVProfile;
import lv.venta.CvBuilder.Repo.ICVProfile;
import lv.venta.CvBuilder.Service.ICRUDCVBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class CRUDCVBuilderServiceImpl implements ICRUDCVBuilderService {

    @Autowired
    private ICVProfile cvRepo;

    @Override
    public ArrayList<CVProfile> selectAllCVProfiles() {
        return (ArrayList<CVProfile>) cvRepo.findAll();
    }

    @Override
    public CVProfile selectCVProfileById(int id) throws Exception {
        return cvRepo.findById(id)
                .orElseThrow(() -> new Exception("Europass CV Profile entry not found"));
    }

    @Override
    public void deleteCVProfileById(int id) throws Exception {
        if (cvRepo.existsById(id)) {
            cvRepo.deleteById(id);
        } else {
            throw new Exception("CV profile entry cannot be deleted - target record not found");
        }
    }

    @Override
    public void insertCVProfile(CVProfile cvProfile) {
        cvRepo.save(cvProfile);
    }

    @Override
    public void updateCVProfileById(int id, CVProfile cvProfile) throws Exception {
        CVProfile existingProfile = cvRepo.findById(id)
                .orElseThrow(() -> new Exception("CV record update targets an invalid reference ID"));
        
       
        existingProfile.setFirstName(cvProfile.getFirstName());
        existingProfile.setLastName(cvProfile.getLastName());
        existingProfile.setEmail(cvProfile.getEmail());
        
        cvRepo.save(existingProfile);
    }

	
}