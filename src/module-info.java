module Agenda {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires ListaContatos;

    opens frisney.com.github.agenda to javafx.graphics, javafx.fxml;
    opens frisney.com.github.agenda.gui.controllers to javafx.graphics, javafx.fxml;

    exports frisney.com.github.agenda.gui.controllers;
}
