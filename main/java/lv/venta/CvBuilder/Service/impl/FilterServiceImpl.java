package lv.venta.CvBuilder.Service.impl;

import lv.venta.CvBuilder.Model.CVProfile;
import lv.venta.CvBuilder.Repo.ICVProfile;
import lv.venta.CvBuilder.Service.IFilterCVBuilderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class FilterServiceImpl implements IFilterCVBuilderService {

    @Autowired
    private ICVProfile cvRepo;

    @Override
    public ArrayList<CVProfile> filterProfilesWithAdvancedLanguages() throws Exception {
        ArrayList<CVProfile> result = cvRepo.findProfilesWithCefrLevelAdvanced();
        if (result == null || result.isEmpty()) {
            throw new Exception("There are no CV profiles with advanced language levels");
        }
        return result;
    }

    @Override
    public ArrayList<CVProfile> filterProfilesByWorkplace(String companyName) throws Exception {
        if (companyName == null || companyName.isEmpty()) {
            throw new Exception("Company name input is incorrect!");
        }
        ArrayList<CVProfile> result = cvRepo.findByExperiencesCompanyContainingIgnoreCase(companyName);
        if (result == null || result.isEmpty()) {
            throw new Exception("There are no CV profiles under company: " + companyName);
        }
        return result;
    }
}