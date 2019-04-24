package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository){
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry timeEntry =  timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.CREATED);
    }
    @GetMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
        TimeEntry timeEntry =  timeEntryRepository.find(timeEntryId);
        if (timeEntry!=null){
            return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.OK);
        }
        return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> timeEntry =  timeEntryRepository.list();
        return new ResponseEntity<List<TimeEntry>>(timeEntry,HttpStatus.OK);

    }
    @PutMapping("/time-entries/{timeEntryId}")
    public ResponseEntity update(@PathVariable long timeEntryId, @RequestBody TimeEntry expected) {
        TimeEntry timeEntry =  timeEntryRepository.update(timeEntryId,expected);
        if(timeEntry!=null){
            return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.OK);
        }
            return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long timeEntryId) {
        TimeEntry timeEntry = timeEntryRepository.find(timeEntryId);
        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.NO_CONTENT);

    }
}
