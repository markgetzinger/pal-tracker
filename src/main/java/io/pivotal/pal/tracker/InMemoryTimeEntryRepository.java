package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    HashMap<Long,TimeEntry> repoList = new HashMap<>();
    long repoCount = 1;

    public InMemoryTimeEntryRepository() {


    }
    public TimeEntry create(TimeEntry timeEnt) {
        timeEnt.setId(repoCount);
        repoList.put(repoCount,timeEnt);
        repoCount++;
        return timeEnt;
    }

    public TimeEntry find(long id) {
        TimeEntry timeEnt;
        if(repoList.containsKey(id)){
            timeEnt = repoList.get(id);
            return timeEnt;
        }


        return null;
    }

    public List<TimeEntry> list(){
        List<TimeEntry> returnList = new ArrayList<TimeEntry>();
        repoList.forEach((key,value)-> returnList.add(value));
        return returnList;
    }


    public TimeEntry update(long timeEntryId, TimeEntry timeEntry) {
        if (find(timeEntryId)!=null){
            timeEntry.setId(timeEntryId);
            repoList.replace(timeEntryId,timeEntry);
            return find(timeEntryId);
        }
        return null;
    }

    public void delete(long timeEntryId) {
        if (find(timeEntryId)!=null){
            repoList.remove(timeEntryId);
        }
    }

}
