package lv.venta.CvBuilder.Service;

import lv.venta.CvBuilder.Model.CVProfile;
import java.util.ArrayList;

public interface IFilterCVBuilderService {
    ArrayList<CVProfile> filterProfilesWithAdvancedLanguages() throws Exception;
    ArrayList<CVProfile> filterProfilesByWorkplace(String companyName) throws Exception;
}