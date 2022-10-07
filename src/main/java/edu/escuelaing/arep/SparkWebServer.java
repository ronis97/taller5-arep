package edu.escuelaing.arep;

import spark.Request;
import spark.Response;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import static spark.Spark.*;
public class SparkWebServer
{
    public static void main(String... args) throws IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure("keystores/ecikeystore.p12",
                "123456", null, null);
        port(5000);
        SecureURLReader.loadTrustStore("keystores/ecikeystore.p12");
        String reta = SecureURLReader.readURL("https://localhost:5001/tarky");
        System.out.println(reta);
        get("hello", (req,res) -> "Hello World!");
        get ("tarky", (req,res) -> reta);
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }



}
