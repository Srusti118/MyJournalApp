package net.engineeringdigest.journalApp.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")

public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;



    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId) {
       return journalEntryService.findById(myId).orElse(null);
    }


    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId myId) {
        journalEntryService.deleteById(myId);
        return true;
    }

    @PutMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntry) {
        JournalEntry old = journalEntryService.findById(myId).orElse(null);

        if(old!=null){
            old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("")?newEntry.getContent(): old.getContent());
            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")?newEntry.getTitle(): old.getTitle());
        }

        journalEntryService.saveEntry(old);
        return old;
    }

}




//method inside controller should be public so that it can be accessed by external HTTP

//Delete ----> this could have also been done by GetMapping but then the naming that we write
//to access this in url /journal/id/2 will be same so we have changes that here

//@RequestMapping("/journal")--->class par mapping add karse , localhost:8080/journal then agad join karse je method ma hase e

// @Autowired ---> as aaiya autowired therefore journalentryservice should be a component
//    private JournalEntryService journalEntryService;

//as findById returns optional ---> orElse (null) will make sure something gets return