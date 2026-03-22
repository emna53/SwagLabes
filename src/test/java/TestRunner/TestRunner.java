package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Chemin vers vos fichiers .feature
        features = "src/test/java/Features/Login.feature",
        // Chemin vers vos Step Definitions et Hooks
        glue = "Steps",
        tags = "@regression",

        // Plugins pour la génération des rapports
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html", // Rapport standard
                "json:target/cucumber.json",           // Requis pour les rapports pros
                "junit:target/cucumber.xml"          // Rapport pour Jenkins/CI
        },
        // Pour une console plus lisible
        monochrome = true,
        // Pour vérifier que chaque étape du feature a un code correspondant
        dryRun = false
)
public class TestRunner {

}
