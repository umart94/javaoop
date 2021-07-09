package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * EmployeeService.java created by umartariq on 23/09/2020
 * 9:08 PM inside the package - sample
 * in the java project TaskExample using IDE IntelliJ IDEA
 */
public class EmployeeService extends Service<ObservableList<String>> {
    //return employee names.
    //jvm calls create task call method to return the names
    //we have to declare service variable now
    @Override
    protected Task<ObservableList<String>> createTask() {
        return new Task<ObservableList<String>>(){
            @Override
            protected ObservableList<String> call() throws Exception {
                String[] names = {"Muhammad Umar Tariq",
                        "Tom Cat",
                        "Bugs Bunny",
                        "Daffy Duck",
                        "Lola Bunny",
                        "Tina Russo"};

                ObservableList<String> employees = FXCollections.observableArrayList();
                for(int i=0;i<6;i++){
                    employees.add(names[i]);
                    updateMessage("Added : "+ names[i]+" to the List");
                    //updateProgress takes 2 parameters, current progress , and maximum progress.
                    updateProgress(i+1,6);
                    Thread.sleep(200);
                }
                //use data binding to link progress property to tasks progress property.

                return employees;
            }
        };//close create task method.
    }
}
