package com.example.cedriclingom.blablacampus.routes.utils;

import android.content.Context;
import android.location.Address;
//import com.example.cedriclingom.blablacampus.routes.models.Address;
import android.location.Location;

import com.example.cedriclingom.blablacampus.routes.models.Place;
import com.example.cedriclingom.blablacampus.routes.models.Ride;
import com.example.cedriclingom.blablacampus.routes.models.Route;
import com.example.cedriclingom.blablacampus.routes.service.GeocoderService;
import com.example.cedriclingom.blablacampus.routes.service.GooglePlaceService;
import com.example.cedriclingom.blablacampus.routes.service.RouteService;
import com.example.cedriclingom.blablacampus.security.service.UserService;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cz.msebera.android.httpclient.Header;


public class RideHandler {


    private static List<Address> startingPoint;

    private static List<Address> endPoint;

    private static Location startingPointLocation;

    private static Location endPointLocation;

    private static Route newRoute;

    private static Route modifiedRoute;

    private static Place startingPlace;

    private static Place endPlace;








    public static List<Address> getStartingPoint() {
        return startingPoint;
    }

    public static void setStartingPoint(List<Address> startingPoint) {

        RideHandler.startingPoint = startingPoint;
    }

    public static List<Address> getEndPoint() {
        return endPoint;
    }

    public static void setEndPoint(List<Address> endPoint) {
        RideHandler.endPoint = endPoint;
    }

    public static Location getStartingPointLocation() {
        return startingPointLocation;
    }

    public static void setStartingPointLocation(Location startingPointLocation) {

        RideHandler.startingPointLocation = startingPointLocation;
    }

    public static Location getEndPointLocation() {
        return endPointLocation;
    }

    public static void setEndPointLocation(Location endPointLocation) {

        RideHandler.endPointLocation = endPointLocation;
    }

    public static Route getNewRoute() {
        return newRoute;
    }

    public static void setNewRoute(Route newRoute) {
        RideHandler.newRoute = newRoute;
    }

    public static Route getModifiedRoute() {
        return modifiedRoute;
    }

    public static void setModifiedRoute(Route modifiedRoute) {
        RideHandler.modifiedRoute = modifiedRoute;
    }

    public static void setStartingPlace(Place startingPlace) {
        RideHandler.startingPlace = startingPlace;
    }

    public static Place getEndPlace() {
        return endPlace;
    }

    public static void setEndPlace(Place endPlace) {
        RideHandler.endPlace = endPlace;
    }












    private static List<Address> transformToAddress(String address, Context context){

        List<Address> listOfAddress = null;

        try {

            listOfAddress = GeocoderService.getGeocoder(context).getFromLocationName(address, 5);

        } catch (IOException e) {

            e.printStackTrace();

        }

        return  listOfAddress;
    }




    private static  boolean isDistanceSuitableBtwAdresses(Route route,
                                                  Location startingPointLocation,
                                                  Location endPointLocation,
                                                  Context context){

        boolean response = false;

        Location startPointForRoute = new Location
                (
                        RideHandler.transformToAddress
                                (route.getStartingPoint().getAddress().getAddress(),
                                        context
                                ).get(0).getAddressLine(0)
                );

        Location endPointForRoute = new Location
                (
                        RideHandler.transformToAddress
                                (route.getEndPoint().getAddress().getAddress(),
                                        context
                                ).get(0).getAddressLine(0)
                );

        response =
                (
                        startPointForRoute.distanceTo(startingPointLocation)>=0 &&
                                startPointForRoute.distanceTo(startingPointLocation)<=50
                ) && (
                        endPointForRoute.distanceTo(endPointLocation)>=0 &&
                                endPointForRoute.distanceTo(endPointLocation)<=50
                );

        return response;
    }





    private static Route checkRouteExsitenceInUserRoutes(Context context){

        Route route = null;

        List<Route> userRoutes = RouteService.getUserRoutes();

        if(userRoutes != null)
        {

            Iterator<Route> itRoute = userRoutes.iterator();

            Route tmpRoute = itRoute.next();

            while
            (
                    !isDistanceSuitableBtwAdresses(tmpRoute, startingPointLocation, endPointLocation, context)&&
                            itRoute.hasNext()
            ){

                tmpRoute = itRoute.next();

            }

            if(isDistanceSuitableBtwAdresses(tmpRoute, startingPointLocation, endPointLocation, context)){

                route = tmpRoute;
            }

        }

        return route;
    }




    private static Place getStartingPlace(Ride ride, Context context){

        GooglePlaceService.getGooglePlaceService
                (
                        startingPointLocation.getLatitude(),
                        startingPointLocation.getLongitude(),
                        "point_of_interest",
                        50
                );

        GooglePlaceService.getNearbyPlaces(new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                System.out.println("Succeeded in getting the starting places with statusCode: "+ statusCode);

                JSONObject firstResponse = GooglePlaceService.convertToJson(responseBody);

                GooglePlaceService.setGooglePlaceService(null);

                getEndPlace(firstResponse, ride, context);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                System.out.println("Failed in getting the places!");

            }
        });

        return null;
    }

    private static void saveUserRoute(Route newRoute, Route modifiedRoute, Context context){

        RouteService.doSaveUserRoute(RideHandler.getNewRoute(), RideHandler.getModifiedRoute(), context, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                System.out.println("Success in creating or modifying the route with status code: " + statusCode);

                RideHandler.setNewRoute(null);

                RideHandler.setModifiedRoute(null);



            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                System.out.println("Failed in creating or modifying the route with status code: " + statusCode);

                System.out.println(error.getMessage());

            }
        });


    }




    private static Place getEndPlace(JSONObject firstResponse, Ride ride, Context context){

        GooglePlaceService.getGooglePlaceService
                (
                        endPointLocation.getLatitude(),
                        endPointLocation.getLongitude(),
                        "university",
                        50
                );

        GooglePlaceService.getNearbyPlaces(new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                System.out.println("Succeeded in getting the end places with statusCode: " + statusCode);

                JSONObject secondResponse = GooglePlaceService.convertToJson(responseBody);

                GooglePlaceService.updateRequestedPlacesResult(firstResponse, secondResponse);


                com.example.cedriclingom.blablacampus.routes.models.Address startingAddress
                        = new com.example.cedriclingom.blablacampus.routes.models.Address
                        (
                                startingPointLocation.getLongitude(),
                                startingPointLocation.getLatitude(),
                                startingPoint.get(0).getAddressLine(0)
                        );

                com.example.cedriclingom.blablacampus.routes.models.Address endAddress
                        = new com.example.cedriclingom.blablacampus.routes.models.Address
                        (
                                endPointLocation.getLongitude(),
                                endPointLocation.getLatitude(),
                                endPoint.get(0).getAddressLine(0)
                        );

                startingPlace = new Place
                        (
                                GooglePlaceService.getStartingPlace().getPlaceName(),
                                GooglePlaceService.getStartingPlace().getPlaceDescription(),
                                GooglePlaceService.getStartingPlace().isStudyingPlace(),
                                startingAddress
                        );

                endPlace = new Place
                        (
                                GooglePlaceService.getEndPlace().getPlaceName(),
                                GooglePlaceService.getEndPlace().getPlaceDescription(),
                                GooglePlaceService.getEndPlace().isStudyingPlace(),
                                endAddress
                        );

                newRoute = new Route(startingPlace, endPlace, new ArrayList<Ride>());

                ride.setRoute(null);

                newRoute.getRides().add(ride);

                System.out.println(newRoute.getStartingPoint().getName());
                System.out.println(newRoute.getEndPoint().getName());

                saveUserRoute(RideHandler.getNewRoute(), RideHandler.getModifiedRoute(), context);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                System.out.println("Failed in getting the places!");

            }
        });

        return null;
    }





    public static void constructRoute(Context context, String date, String hour, String minute){

        Route route = checkRouteExsitenceInUserRoutes(context);

        newRoute = null;

        modifiedRoute = null;

        TimeHandler.toDate(date, hour, minute);

        Ride ride = new Ride(TimeHandler.getDate(), true, null, UserService.getUserInfos(), 0);



        if(route == null){

            getStartingPlace(ride, context);

        }else{

            ride.setRoute(null);

            route.getRides().add(ride);

            modifiedRoute = route;

            System.out.println(modifiedRoute.getStartingPoint().getName());
            System.out.println(modifiedRoute.getEndPoint().getName());

        }

    }






    public static void createRide(String startingAddress,
                                  String endAddress,
                                  String startingDate,
                                  String endDate,
                                  String hour,
                                  String minute,
                                  Context context){

        setStartingPoint(transformToAddress(startingAddress, context));

        setEndPoint(transformToAddress(endAddress, context));

        startingPointLocation = new Location(startingPoint.get(0).getAddressLine(0));

        startingPointLocation.setLatitude(startingPoint.get(0).getLatitude());

        startingPointLocation.setLongitude(startingPoint.get(0).getLongitude());

        endPointLocation = new Location(endPoint.get(0).getAddressLine(0));

        endPointLocation.setLatitude(endPoint.get(0).getLatitude());

        endPointLocation.setLongitude(endPoint.get(0).getLongitude());

        constructRoute(context, startingDate, hour, minute);
    }


}
