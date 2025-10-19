package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface JournalEntryRepository extends MongoRepository <JournalEntry , ObjectId> {
}









//this will run the query from the db
//MongoRepository is interface has got methods for our convience so always extend it
//does all the crude operations

//have to pass (Pogo class jema badhu define chhe,id nu dataType)