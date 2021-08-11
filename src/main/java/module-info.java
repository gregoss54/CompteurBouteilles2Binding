module fr.romain.compteurbouteilles2binding {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.romain.compteurbouteilles2binding to javafx.fxml;
    exports fr.romain.compteurbouteilles2binding;
}