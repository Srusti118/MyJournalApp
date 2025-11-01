package net.engineeringdigest.journalApp.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")

public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;



    @GetMapping
    public ResponseEntity<?> getAll() {
        List<JournalEntry>  all = journalEntryService.getAll();
        if(all != null && !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry) {
        try{
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return new ResponseEntity<>(myEntry, HttpStatus.CREATED);}
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId) {
      Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);
      if(journalEntry.isPresent()){
          return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId) {
        journalEntryService.deleteById(myId);
        return new ResponseEntity<JournalEntry>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{myId}")
    public ResponseEntity<?> updateJournalEntryById(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntry) {
        JournalEntry old = journalEntryService.findById(myId).orElse(null);

        if(old!=null){
            old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("")?newEntry.getContent(): old.getContent());
            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")?newEntry.getTitle(): old.getTitle());
            return new ResponseEntity<>(old,HttpStatus.OK);
        }

        journalEntryService.saveEntry(old);
        return new ResponseEntity<>(old,HttpStatus.NOT_FOUND);
    }

}




//method inside controller should be public so that it can be accessed by external HTTP

//Delete ----> this could have also been done by GetMapping but then the naming that we write
//to access this in url /journal/id/2 will be same so we have changes that here

//@RequestMapping("/journal")--->class par mapping add karse , localhost:8080/journal then agad join karse je method ma hase e

// @Autowired ---> as aaiya autowired therefore journalentryservice should be a component
//    private JournalEntryService journalEntryService;

//as findById returns optional ---> orElse (null) will make sure something gets return

//ResponseEntity<?>() ----> can return object of anything baki ? no j object return
//return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);

//check id chhe k nai alsoo