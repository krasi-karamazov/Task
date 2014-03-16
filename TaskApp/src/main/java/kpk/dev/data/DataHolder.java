package kpk.dev.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import kpk.dev.models.EmployeeDecorator;
import kpk.dev.models.Manager;
import kpk.dev.models.Worker;
import kpk.dev.utils.Constants;
import kpk.dev.utils.PersonGenerator;

public class DataHolder {

    private static DataHolder sInstance;
    private static Map<Manager, List<EmployeeDecorator>> mStaff;


    private DataHolder() {
        mStaff = new HashMap<Manager, List<EmployeeDecorator>>();
        for(int i = 0; i < Constants.NUM_MANAGERS; i++) {
            Manager manager = new Manager(PersonGenerator.generatePerson());
            int workersForManager = PersonGenerator.generateNumSubordinates();
            manager.setNumberOfSubordinates(workersForManager);
            List<EmployeeDecorator> workers = new ArrayList<EmployeeDecorator>();
            for(int j = 0; j < workersForManager; j++) {
                Worker worker = new Worker(PersonGenerator.generatePerson());
                worker.setPoints(PersonGenerator.generateEmployeeScore());
                workers.add(worker);
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

    public List<EmployeeDecorator> getAllWorkers() {
        final List<EmployeeDecorator> allWorkers = new ArrayList<EmployeeDecorator>();
        final Set<Map.Entry<Manager, List<EmployeeDecorator>>> entries = mStaff.entrySet();
        for(Map.Entry<Manager, List<EmployeeDecorator>> entry : entries){
            List<EmployeeDecorator> workers = entry.getValue();
            if(workers.size() > 0) {
                allWorkers.addAll(workers);
            }
        }
        return allWorkers;
    }

    public List<EmployeeDecorator> getWorkersForManager(Manager manager) {
        return mStaff.get(manager);
    }

    public List<EmployeeDecorator> getManagers() {
        final List<EmployeeDecorator> managers = new ArrayList<EmployeeDecorator>();
        managers.addAll(mStaff.keySet());
        return managers;
    }

    public List<EmployeeDecorator> getAllEmployees() {
        final List<EmployeeDecorator> allEmployes = new ArrayList<EmployeeDecorator>();
        allEmployes.addAll(getManagers());
        allEmployes.addAll(getAllWorkers());
        return allEmployes;
    }
}
