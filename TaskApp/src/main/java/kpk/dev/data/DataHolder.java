package kpk.dev.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import kpk.dev.models.Manager;
import kpk.dev.models.Worker;
import kpk.dev.utils.Constants;
import kpk.dev.utils.PersonGenerator;

/**
 * Created by krasimirkaramazov on 3/16/14.
 */
public class DataHolder {

    private static DataHolder sInstance;
    private Map<Manager, List<Worker>> mStaff;


    private DataHolder() {
        mStaff = new HashMap<Manager, List<Worker>>();
        for(int i = 0; i < Constants.NUM_MANAGERS; i++) {
            Manager manager = new Manager(PersonGenerator.generatePerson());
            int workersForManager = PersonGenerator.generateNumSubordinates();
            List<Worker> workers = new ArrayList<Worker>();
            for(int j = 0; j < workersForManager; j++) {
                Worker worker = new Worker(PersonGenerator.generatePerson());
                worker.setPoints(PersonGenerator.generateEmployeeScore());
                manager.addSubordinate(worker);
            }
            mStaff.put(manager, workers);
        }
    }

    public static DataHolder getInstance() {
        if(sInstance == null) {
            sInstance = new DataHolder();
        }
        return sInstance;
    }

    public List<Worker> getAllWorkers() {
        final List<Worker> allWorkers = new ArrayList<Worker>();
        final Set<Map.Entry<Manager, List<Worker>>> entries = mStaff.entrySet();
        for(Map.Entry<Manager, List<Worker>> entry : entries){
            List<Worker> workers = entry.getValue();
            if(workers.size() > 0) {
                allWorkers.addAll(workers);
            }
        }
        return allWorkers;
    }

    public List<Worker> getWorkersForManager(Manager manager) {
        return mStaff.get(manager);
    }

    public List<Manager> getManagers() {
        final List<Manager> managers = new ArrayList<Manager>();
        managers.addAll(mStaff.keySet());
        return managers;
    }
}
