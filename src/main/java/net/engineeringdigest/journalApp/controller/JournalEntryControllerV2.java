package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal") //class par mapping add karse , localhost:8080/journal then agad join karse je method ma hase e
public class JournalEntryControllerV2 {


    @GetMapping
    public List<JournalEntry> getAll(){
        return null;
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){

        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId) {
        return null;
    }

    //this could have also been done by GetMapping but then the naming that we write
    //to access this in url /journal/id/2 will be same so we have changes that here
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId) {
        return null;
    }

    @PutMapping("id/{id}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long id,@RequestBody JournalEntry myEntry) {
        return null;
    }
}

//method inside controller should be public so that it can be accessed by external HTTP