package covid.map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CovidParser {

    public static final String countryUrl =
            "https://raw.githubusercontent.com/ajturner/acetate/master/places/Countries-Europe.csv";
    private RestTemplate restTemplate;
    private UrlWizard urlWizard;

    public CovidParser(UrlWizard urlWizard) {
        this.urlWizard = urlWizard;
        restTemplate = new RestTemplate();
    }

    public List<Point> getCovidData(int month, int day) throws IOException {
        List<Country> countries = new ArrayList<>();
        String countryList = restTemplate.getForObject(countryUrl, String.class);
        countryList=countryList.replace("United_Kingdom", "United Kingdom")
                .replace("Czechia", "Czech Republic");
        List<Point> points = new ArrayList<>();
        String values = restTemplate.getForObject(urlWizard.buildCovidUrl(month,day), String.class);

        StringReader countryReader = new StringReader(countryList);
        CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(countryReader);
        for (CSVRecord country : parser) {
            String name = country.get("name");
            double lat = Double.parseDouble(country.get("latitude"));
            double lon = Double.parseDouble(country.get("longitude"));
            countries.add(new Country(name, lat, lon));
        }

        StringReader stringReader = new StringReader(values);
        parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);

        int ind = -1;

        for (CSVRecord strings : parser) {
            String name = strings.get("EU/EEA and the UK");
            int cases = Integer.parseInt(strings.get("Cases"));
            int deaths = Integer.parseInt(strings.get("Deaths"));
            double lat = -1;
            double lon = -1;

            Optional<Country> res = countries.stream().filter(country -> country.getName().equals(name)).findAny();
            if (res.isPresent()) {
                lat = res.get().getLat();
                lon = res.get().getLon();
            } else continue;

            points.add(new Point(lat, lon, name + "\nCases: " + cases + "\nDeaths: " + deaths));
        }
        return points;
    }
}
