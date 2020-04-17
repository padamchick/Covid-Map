package covid.map;

import org.springframework.stereotype.Service;

@Service
public class UrlWizard {

    public String buildCovidUrl(int month, int day) {
        String beg = "https://raw.githubusercontent.com/midas-network/COVID-19/master/data/cases/europe/europe_situation_updates/EU_UK_data_download_2020-";
        String end = "_073000_-0400.csv";
        String res = beg + String.format("%02d", month)+"-"+String.format("%02d", day)+end;
        return res;
    }
}
