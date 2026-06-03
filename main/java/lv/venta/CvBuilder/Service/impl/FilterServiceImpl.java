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
    public ArrayList<CVProfile> filterProfilesWithAdvancedLanguages() {
        return cvRepo.findProfilesWithCefrLevelAdvanced();
    }

    @Override
    public ArrayList<CVProfile> filterProfilesByWorkplace(String companyName) { 
        return cvRepo.findByExperiencesCompanyContainingIgnoreCase(companyName);
    }
}