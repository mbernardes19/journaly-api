package com.journaly.journaly.controller;

import com.journaly.journaly.model.JournalEntry;
import com.journaly.journaly.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class JournalController {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public JournalEntry saveJournalEntry(@Valid @RequestBody JournalEntry journalEntry) {
        return journalEntryRepository.save(journalEntry);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/entries")
    @ResponseStatus(HttpStatus.OK)
    public List<JournalEntry> getJournalEntries() {
        Comparator<JournalEntry> byDescendingDate = Collections.reverseOrder(Comparator.comparing(JournalEntry::getDate));
        List<JournalEntry> journalEntryList = journalEntryRepository.findAll();
        journalEntryList.sort(byDescendingDate);
        return journalEntryList;
    }



}
