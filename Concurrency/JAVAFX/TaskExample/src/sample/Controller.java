package sample;

import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;


/* there are lots of import statements in java ( pre made - built in classes
                       so make sure you import
                       import javafx.scene.control.ListView;

                       updating listview using platform.runLater method. using runnable.
                       so we update listview when task completes.

                       instead of using platform.runLater
                       we can use Data Binding.*/
public class Controller {
    //private Task<ObservableList<String>> task;

    @FXML
    private ListView listView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label progressLabel;

    @FXML
    private Service<ObservableList<String>> service;


    /*
    update list view using platform.run
    this method accepts runnable and runs it on a ui thread.

    our task is not runnable
    we want to update list view when task completes.
    and call run later when task is complete.


     */



    /**************** INITIALIZE METHOD - WHEN USING PLATFORM.RUNLATER
    public void initialize() {

        task = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                //sleep
                Thread.sleep(1000);
                ObservableList<String> employees = FXCollections.observableArrayList(
                        "Muhammad Umar Tariq",
                        "Tom Cat",
                        "Bugs Bunny",
                        "Daffy Duck",
                        "Lola Bunny",
                        "Tina Russo"
                );
                //return employees; //when using data binding, return employees here.


                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {




                        listView.setItems(employees);


                    }
                });
                return employees;
            }
        };

    }
     **************** INITIALIZE METHOD - WHEN USING PLATFORM.RUNLATER*/


/**************** INITIALIZE METHOD - WHEN USING DATA BINDING ***********/

  //  public void initialize() {

        //run a long running task on the background thread
        //and update it using the UI thread.
        /*
        if it takes long time to fetch records from a database
        background thread is being used
        ui thread remains responsive to the user
        and user thinks that the app is working.

        we can update progress

        by default its indeterminate.

         */
  /*      task = new Task<ObservableList<String>>() {
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
        };

        progressBar.progressProperty().bind(task.progressProperty());
        progressLabel.textProperty().bind(task.messageProperty());
        listView.itemsProperty().bind(task.valueProperty());

    }
     }
    */
            /**************** INITIALIZE METHOD - WHEN USING DATA BINDING ***********/


        /**************** INITIALIZE METHOD - WHEN USING SERVICE ***********/
        public void initialize() {

            //run a long running task on the background thread
            //and update it using the UI thread.
        /*
        if it takes long time to fetch records from a database
        background thread is being used
        ui thread remains responsive to the user
        and user thinks that the app is working.

        we can update progress

        by default its indeterminate.

         */
//       task = new Task<ObservableList<String>>() {
//            @Override
//            protected ObservableList<String> call() throws Exception {
//
//                String[] names = {"Muhammad Umar Tariq",
//                        "Tom Cat",
//                        "Bugs Bunny",
//                        "Daffy Duck",
//                        "Lola Bunny",
//                        "Tina Russo"};
//
//                ObservableList<String> employees = FXCollections.observableArrayList();
//                for(int i=0;i<6;i++){
//                    employees.add(names[i]);
//                    updateMessage("Added : "+ names[i]+" to the List");
//                    //updateProgress takes 2 parameters, current progress , and maximum progress.
//                    updateProgress(i+1,6);
//                    Thread.sleep(200);
//                }
//                //use data binding to link progress property to tasks progress property.
//
//                return employees;
//            }
//        };

//progressBar.progressProperty().bind(task.progressProperty());
            //progressLabel.textProperty().bind(task.messageProperty());
            //listView.itemsProperty().bind(task.valueProperty());


            //create service here
            service = new EmployeeService();
            progressBar.progressProperty().bind(service.progressProperty());
            progressLabel.textProperty().bind(service.messageProperty());
            listView.itemsProperty().bind(service.valueProperty());

//            service.setOnRunning(new EventHandler<WorkerStateEvent>() {
//                @Override
//                public void handle(WorkerStateEvent event) {
//                    //when the service is running
//                    //hide the progressbar
//                    progressBar.setVisible(true);
//                    progressLabel.setVisible(true);
//                }
//            });
//
//            service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//                @Override
//                public void handle(WorkerStateEvent event) {
//                    progressBar.setVisible(false);
//                    progressLabel.setVisible(false);
//
//                }
//            });

     //       progressBar.setVisible(false);
      //      progressLabel.setVisible(false);

            progressBar.visibleProperty().bind(service.runningProperty());
            progressLabel.visibleProperty().bind(service.runningProperty());




    }



/**************** INITIALIZE METHOD - WHEN USING SERVICE ***********/








    @FXML
    public void buttonPressed() {

        //instead of thread.. start a service
        //recommended way to working with tasks / threads.

        //will work only once on button click
        //invocationtargetexception
        //can only start service in ready state, was in state succeeded.
        //restart service , multiple times
        //when service ends, reset to ready state.
        //this can be checked in button click handler code.

        if(service.getState()== Service.State.SUCCEEDED) {
            service.reset();
            service.start();
        } else if(service.getState()== Service.State.READY){
            service.start();
        }

        /*
        everytime state of service changes
        we can call some methods

         */




        //new Thread(task).start();



        //we can only access the ui elements on the Main JAVA FX application Thread
        //because controls are not thread safe
        //all code that touches the user interface must run on java fx application thread.
        //that way , threads cant interfere with each other.

        //but how can we run them using background thread ?

    }
}
