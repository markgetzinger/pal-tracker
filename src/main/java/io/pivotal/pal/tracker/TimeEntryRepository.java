package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface TimeEntryRepository {
    public TimeEntry find(long id);
    public TimeEntry create(TimeEntry timeEnt);
    public List<TimeEntry> list();
    public TimeEntry update(long timeEntryId, TimeEntry timeEntry);
    public void delete(long timeEntryId);
}
