package cfxApace.soapAPi.Controller;

import org.oorsprong.websamples_countryinfo.CountryInfoService;
import org.oorsprong.websamples_countryinfo.CountryInfoServiceSoapType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CapitalCityController {
    @GetMapping("/capital")
    public String getCapitalCity(@RequestParam(value = "countryCode", defaultValue = "US") String countryCode) {
        try {
            CountryInfoService service = new CountryInfoService();
            CountryInfoServiceSoapType port = service.getCountryInfoServiceSoap();
            String capitalCity = port.capitalCity(countryCode);
            return "The capital city is: " + capitalCity;
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }
}
