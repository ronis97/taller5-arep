package edu.escuelaing.arep;

import java.net.MalformedURLException;

import static spark.Spark.*;

public class SparkWebServer4 {
    public static void main(String... args) throws MalformedURLException {
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure("keystores/ks2.p12",
                "123456", null, null);
        port(5001);

        get("hellolocal", (req,res) -> "Hello local!");

    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
