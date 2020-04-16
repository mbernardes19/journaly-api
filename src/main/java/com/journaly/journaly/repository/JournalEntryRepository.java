package com.journaly.journaly.repository;

import com.journaly.journaly.model.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {

}
