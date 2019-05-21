package be.ucll.umami.model;

import be.ucll.umami.repository.DayMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@Service("DayMenuService")
public class DayMenuService {

    @Autowired
    DayMenuRepository dayMenuRepository; // dependency injection of the repository

    public DayMenuService() {
    }

    public List<DayMenu> getAllDayMenus(){
        return dayMenuRepository.findAll();
    }

    public List<DayMenu> getWeekMenu() {
        List<DayMenu> dayMenus = dayMenuRepository.findAll();
        LocalDate today = LocalDate.now();
        LocalDate monday = today.with(DayOfWeek.MONDAY);
        LocalDate sunday = today.with(DayOfWeek.SUNDAY);
        List<DayMenu> weekMenu = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (DayMenu dM: dayMenus) {
            LocalDate date = LocalDate.parse(dM.getDatum(), formatter);
            if(date.equals(monday) || date.equals(sunday) || date.isAfter(monday) && date.isBefore(sunday)){
                weekMenu.add(dM);
            }
        }

        return weekMenu;
    }

    public DayMenu findDayMenuById(String date){
        DayMenu temp = null;
        try {
            temp = dayMenuRepository.findById(date).orElseThrow(IllegalArgumentException::new);
        }catch (IllegalArgumentException e){
            //nothing happens
        }
        return temp;
    }

    public boolean dayMenuIsInRepo(DayMenu daymenu){
        if(findDayMenuById(daymenu.getDatum()) == null){
            return false;
        }
        else{
            return true;
        }
    }

    public void addDayMenu(DayMenu daymenu) {
        if (dayMenuIsInRepo(daymenu)){
            //do nothing
        }
        else{
            dayMenuRepository.save(daymenu);
        }
    }

    public DayMenu changeDayMenu(String date, DayMenu dM){
        return dayMenuRepository.save(dM);

    }

    public void deleteDayMenu(DayMenu dM){

        dayMenuRepository.delete(dM);
    }
}
