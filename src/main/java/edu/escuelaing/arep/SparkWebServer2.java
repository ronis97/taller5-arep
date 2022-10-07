package edu.escuelaing.arep;

import static spark.Spark.*;

public class SparkWebServer2 {
    public static void main(String... args){
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure("keystores/ecikeystore1.p12",
                "123456", null, null);
        port(5001);
        get("tarky", (req,res) -> "Hello tarky!");
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
