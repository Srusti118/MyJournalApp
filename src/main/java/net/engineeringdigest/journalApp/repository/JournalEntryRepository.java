package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository <JournalEntry , String> {
}









//this will run the query from the db
//MongoRepository is interface has got methods for our convience so always extend it
//does all the crude operations
