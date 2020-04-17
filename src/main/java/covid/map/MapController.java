package covid.map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("covid")
public class MapController {

    private CovidParser covidParser;

    public MapController(CovidParser covidParser) {
        this.covidParser = covidParser;
    }

    @GetMapping("/{month}/{day}")
    public String getMap(@PathVariable int month, @PathVariable int day, Model model) throws IOException {
        model.addAttribute("points", covidParser.getCovidData(month, day));
        return "";
    }
}
