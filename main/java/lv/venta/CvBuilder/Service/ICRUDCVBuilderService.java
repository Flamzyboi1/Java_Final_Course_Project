package lv.venta.CvBuilder.Service;

import lv.venta.CvBuilder.Model.CVProfile;
import java.util.ArrayList;

public interface ICRUDCVBuilderService {
    
    ArrayList<CVProfile> selectAllCVProfiles();
    
    CVProfile selectCVProfileById(int id) throws Exception;
    
    void deleteCVProfileById(int id) throws Exception;
    
    void insertCVProfile(CVProfile cvProfile);
    
    void updateCVProfileById(int id, CVProfile cvProfile) throws Exception;
}