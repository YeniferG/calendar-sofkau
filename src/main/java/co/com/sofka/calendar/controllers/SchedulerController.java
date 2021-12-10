package co.com.sofka.calendar.controllers;

import co.com.sofka.calendar.model.ProgramDate;
import co.com.sofka.calendar.services.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class SchedulerController {

    @Autowired
    SchedulerService sheSchedulerService;

    @GetMapping("/generate/{date}/{id}")
    public Flux<ProgramDate> generateCalendar(@PathVariable("date") String date, @PathVariable("id") String id){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate localDate = LocalDate.parse(date, formatter);

        return sheSchedulerService.generateCalendar(id, localDate);
    }

}
