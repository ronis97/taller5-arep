package edu.escuelaing.arep;

import java.net.MalformedURLException;

import static spark.Spark.*;

public class SparkWebServer3 {
    public static void main(String... args) throws MalformedURLException {
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure("keystores/ks1.p12",
                "123456", null, null);
        port(5000);

        get("hellolocal", (req,res) -> "Hello local!");
        //get("helloremoto",(req,res) -> SecureURLReader.readURL("https://localhost:5001/hellolocal"));

    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
