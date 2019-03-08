package com.example.cedriclingom.blablacampus.routes.service;

import android.location.Location;

import com.example.cedriclingom.blablacampus.routes.utils.PlaceRequestResult;
import com.example.cedriclingom.blablacampus.security.models.User;
import com.example.cedriclingom.blablacampus.security.utils.MyHttpClientService;
import com.google.android.libraries.places.api.internal.impl.net.pablo.PlaceResult;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class GooglePlaceService extends MyHttpClientService {

       private static double latitude;
       private static double longitude;
       private static String apikey;
       private static String typeofPlace;
       private static int radius;
       private static List<PlaceResult> listOfPlaceResults;
       private static String nearbySearchUrl;
       private static PlaceRequestResult startingPlace;
       private static PlaceRequestResult endPlace;
       private static GooglePlaceService googlePlaceService;











    private GooglePlaceService(){

        setApikey("AIzaSyB78yuEKK9VTtmTx2WoWcYvT3kBZat2X0A");
        setNearbySearchUrl("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
    }
    private GooglePlaceService(double latitude, double longitude, String typeofPlace, int radius) {

        this();

        setLatitude(latitude);

        setLongitude(longitude);

        setTypeofPlace(typeofPlace);

        setRadius(radius);
    }







    public static double getLatitude() {
        return latitude;
    }

    public static void setLatitude(double latitude) {
        GooglePlaceService.latitude = latitude;
    }

    public static double getLongitude() {
        return longitude;
    }

    public static void setLongitude(double longitude) {
        GooglePlaceService.longitude = longitude;
    }

    public static String getApikey() {
        return apikey;
    }

    public static void setApikey(String apikey) {
        GooglePlaceService.apikey = apikey;
    }

    public static String getTypeofPlace() {
        return typeofPlace;
    }

    public static void setTypeofPlace(String typeofPlace) {
        GooglePlaceService.typeofPlace = typeofPlace;
    }

    public static int getRadius() {
        return radius;
    }

    public static void setRadius(int radius) {
        GooglePlaceService.radius = radius;
    }

    public static List<PlaceResult> getListOfPlaceResults() {
        return listOfPlaceResults;
    }

    public static void setListOfPlaceResults(List<PlaceResult> listOfPlaceResults) {
        GooglePlaceService.listOfPlaceResults = listOfPlaceResults;
    }

    public static String getNearbySearchUrl() {
        return nearbySearchUrl;
    }

    public static void setNearbySearchUrl(String nearbySearchUrl) {
        GooglePlaceService.nearbySearchUrl = nearbySearchUrl;
    }

    public static PlaceRequestResult getStartingPlace() {
        return startingPlace;
    }

    public static void setStartingPlace(PlaceRequestResult startingPlace) {
        GooglePlaceService.startingPlace = startingPlace;
    }

    public static PlaceRequestResult getEndPlace() {
        return endPlace;
    }

    public static void setEndPlace(PlaceRequestResult endPlace) {
        GooglePlaceService.endPlace = endPlace;
    }

    public static GooglePlaceService getGooglePlaceService
            (
                    double latitude,
                    double longitude,
                    String typeofPlace,
                    int radius
            ) {

        if(googlePlaceService == null){

            googlePlaceService = new GooglePlaceService(latitude, longitude, typeofPlace, radius);

        }

        return googlePlaceService;

    }

    public static void setGooglePlaceService(GooglePlaceService googlePlaceService) {
        GooglePlaceService.googlePlaceService = googlePlaceService;
    }










    private static void getPlace(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {

        getClient().get(url, params, responseHandler);

    }

    public static void getNearbyPlaces(AsyncHttpResponseHandler responseHandler) {


        RequestParams params = new RequestParams();

        params.put("location", latitude+","+longitude);

        params.put("radius", radius);

        params.put("type", typeofPlace);

        params.put("key", apikey);

        getPlace(nearbySearchUrl, params, responseHandler);

    }


    public static JSONObject convertToJson(byte[] responseBody){

        JSONObject response = null;

        try {

            if(responseBody != null){

                response = new JSONObject(new String(responseBody));

            }


        } catch (JSONException e) {

            e.printStackTrace();

        }

        return response;

    }


    private static String getChoosenTypeOfPlace(String typeofPlace){

        String chosentype;

        switch (typeofPlace){

            case "university": chosentype = typeofPlace;
            break;

            case "hospital": chosentype = typeofPlace;
            break;

            case "supermaket": chosentype = typeofPlace;
            break;

            case "train_station": chosentype = typeofPlace;
            break;

            case "stadium": chosentype = typeofPlace;
            break;

            case "pharmacy": chosentype = typeofPlace;
            break;

            case "local_government_office": chosentype = typeofPlace;
            break;

            case "meal_delivery": chosentype = typeofPlace;
            break;

            case "meal_takeaway": chosentype = typeofPlace;
            break;

            case "bank": chosentype = typeofPlace;
            break;

            case "library": chosentype = typeofPlace;
            break;

            case "school": chosentype = typeofPlace;
            break;

            case "store": chosentype = typeofPlace;
            break;

            default: chosentype = null;
            break;
        }

        return  chosentype;
    }

    private static PlaceRequestResult filterReponse(JSONObject reponse){

        JSONArray results = null;

        PlaceRequestResult placeRequestResult = null;

        try {

            results = reponse.getJSONArray("results");

            boolean found = false;

            String typeOfplace = null;

            int i = 0;

            while(!found && i < results.length()){

                typeOfplace = getChoosenTypeOfPlace(results.getJSONObject(i).getJSONArray("types").getString(0));

                if(typeOfplace != null) found = true;

                ++i;

            }

            if(found){

                placeRequestResult = new PlaceRequestResult();

                boolean studyingPlace = false;

                if(typeOfplace.equals("university") || typeOfplace.equals("school")) studyingPlace = true;

                placeRequestResult.setPlaceName(results.getJSONObject(i-1).getString("name"));

                placeRequestResult.setPlaceDescription(results.getJSONObject(i-1).getString("place_id"));

                placeRequestResult.setStudyingPlace(studyingPlace);

            }

        } catch (JSONException e) {

            e.printStackTrace();

        }




        return placeRequestResult;
    }

    public static void updateRequestedPlacesResult(JSONObject firstRequestedPlaceResult, JSONObject secondRequestedPlaceResult){

        startingPlace = filterReponse(firstRequestedPlaceResult);

        endPlace = filterReponse(secondRequestedPlaceResult);

    }


}
