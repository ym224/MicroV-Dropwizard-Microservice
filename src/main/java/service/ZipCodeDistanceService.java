package service;

import model.Dto.ZipCodeDistance;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

public class ZipCodeDistanceService {

    private String url;
    private String apiKey;
    private Client client;

    /*api key: vZ0j8hPvgczDCqDrjva98IrpUt8oKUfOuDQtzHMb9fNrIE2Q2V9nVjAoFYKw5kaJ
    Example request:
    https://www.zipcodeapi.com/rest/apikey/distance.json/10044/10028/mile

    {
        "distance": 1.021
    }*/

    public ZipCodeDistanceService(String url, String apiKey, Client client) {
        this.url = url;
        this.apiKey = apiKey;
        this.client = client;
    }


    protected ZipCodeDistance callZipCodeAPI(String zipCode1, String zipCode2){
        String request_url = url + apiKey + "/distance.json/" + zipCode1 + "/" + zipCode2 + "/mile";

        ZipCodeDistance zipCodeDistance = new ZipCodeDistance(0);
        try {
            zipCodeDistance = client.target(request_url).request().get(ZipCodeDistance.class);
        }
        catch (WebApplicationException ex) {
            ex.printStackTrace();
        }
        return zipCodeDistance;
    }

}
