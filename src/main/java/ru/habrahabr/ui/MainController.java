package ru.habrahabr.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.habrahabr.Comp;

import javax.annotation.PostConstruct;

/**
 * Date: 27.08.15
 * Time: 11:10
 *
 * @author Ruslan Molchanov (ruslanys@gmail.com)
 * @author http://mruslan.com
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private Comp comp;

    // FXML fields
    @FXML private Button btnTest;

    @FXML
    public void fxmlInit() {
        // Имейте ввиду, что такие методы инициализации UI от JavaFX не пройдут.
        // Инициализация UI, в данном случае, происходит в методе init() (@PostConstruct);

        // Хотя поведение элементов, такое как setOnAction, лучше описывать в FXML файле.
        // Например: onAction="#onButtonPress"
    }

    @PostConstruct
    public void init() {
//        btnTest.setOnAction(event -> comp.test());
    }

    @FXML
    public void onButtonPress() {
        comp.test();
    }
}
