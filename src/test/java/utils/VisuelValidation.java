package utils;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import nu.pattern.OpenCV;

public class VisuelValidation {

    static {
        // Charge les bibliothèques natives d'OpenCV
        OpenCV.loadShared();
    }

    /**
     * Compare une zone de l'écran avec une image de référence.
     * @param screenshotPath Chemin de la capture d'écran prise par Selenium
     * @param templatePath Chemin de l'image de référence (l'icône parfaite)
     * @param threshold Seuil de ressemblance (ex: 0.9 pour 90%)
     * @return true si l'élément est trouvé avec une confiance suffisante
     */
    public static boolean isElementPresent(String screenshotPath, String templatePath, double threshold) {
        Mat source = Imgcodecs.imread(screenshotPath);
        Mat template = Imgcodecs.imread(templatePath);

        if (source.empty() || template.empty()) {
            System.err.println("Erreur : Impossible de charger les images.");
            return false;
        }

        Mat result = new Mat();
        // Algorithme de correspondance de motifs
        Imgproc.matchTemplate(source, template, result, Imgproc.TM_CCOEFF_NORMED);

        // Localisation du meilleur score
        Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
        double maxVal = mmr.maxVal;

        System.out.println("Score de similarité détecté : " + maxVal);

        return maxVal >= threshold;
    }
}