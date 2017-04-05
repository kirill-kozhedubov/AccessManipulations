package iq.ven.accessmanipulations.controller;

import iq.ven.accessmanipulations.objects.AccessObject;
import iq.ven.accessmanipulations.service.AccessObjectGenerator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;



/**
 * Created by User on 05.04.2017.
 */
public class ObjectGeneratorController {
    private ListView<AccessObject> objectsListView;
    private TextField accessObjectAmountTextField;
    private Button generateObjectsButton;
    private CheckBox mandateCheckBox;
    private AccessObjectGenerator accessObjectGenerator;

    ObjectGeneratorController(ListView<AccessObject> objectsListView, TextField accessObjectAmountTextField, Button generateObjectsButton, CheckBox mandateCheckBox) {
        this.objectsListView = objectsListView;
        this.accessObjectAmountTextField = accessObjectAmountTextField;
        this.generateObjectsButton = generateObjectsButton;
        this.mandateCheckBox = mandateCheckBox;
        accessObjectGenerator = new AccessObjectGenerator();
        generateButtonSetOnAction();
    }

    private void generateButtonSetOnAction() {
        generateObjectsButton.setOnAction(event -> {
            if (accessObjectAmountTextField.getText().trim() != "") {
                if (!mandateCheckBox.isSelected()) {
                    objectsListView.setItems(generateDiscrete(Integer.parseInt(accessObjectAmountTextField.getText())));
                } else {
                    objectsListView.setItems(generateMandate(Integer.parseInt(accessObjectAmountTextField.getText())));
                }
            }
        });
    }

    private ObservableList<AccessObject> generateDiscrete(int amount) {
        return FXCollections.observableArrayList(accessObjectGenerator.generateDiscreteAccessObjectList(amount));
    }

    private ObservableList<AccessObject> generateMandate(int amount) {
        return FXCollections.observableArrayList(accessObjectGenerator.generateMandateAccessObjectList(amount));
    }


}
