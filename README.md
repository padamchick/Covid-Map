# COVID-19 Map for Europe
> This application presents all occurrences of the Covid-19 virus for European countries, including the total number of infections and deaths

## Setup
To start the application:
- download the repository
- have [Maven](https://maven.apache.org/download.cgi) and Java 8 (min) installed
- compile the program with `mvn clean install` command
- go to the created target directory and use the command `java -jar name-of-created-jar-file.jar` to run the application in the browser
- application available at http://localhost:8080/covid/month/day

## Sources
- https://github.com/midas-network/COVID-19/blob/master/data/cases/europe/europe_situation_updates/EU_UK_data_download_2020-04-13_073000_-0400.csv
- https://github.com/midas-network/COVID-19/tree/master/data/cases/europe/europe_situation_updates

## Example
![Covid Map](https://i.imgur.com/SBBgovu.jpg)

## Technologies
* Java
* Spring Boot
* Thymeleaf
* OpenStreetMap
* Leaflet

## Contact
Created by [padamchick](https://github.com/padamchick) - feel free to contact me!
