package com.example.mapscanactuallygodye;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    public double fullLat = 43.998104;
    public double fullLng = -79.456040;
    public String detect;
    public String animal;
    public String date = "";
    public int toggler = 0;
    public int toggler1 = 0;
    List animalTypes = new ArrayList();
    List latitudes = new ArrayList();
    List longitudes = new ArrayList();
    List dates = new ArrayList();
    public String stringanimals = "";
    public String stringlatitudes = "";
    public String stringlongitudes = "";
    public String stringdates = "";
    public List rawDates = new ArrayList();
    private GoogleMap mMap;
    public boolean identifier;
    HashMap<String, String> markerMap = new HashMap<String, String>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        identifier = true;
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if(identifier = true){
            try{
                FileInputStream fIn = openFileInput("animalTypes");
                int c;
                String temp = "";

                while ((c = fIn.read()) != -1)
                {
                    temp = temp + Character.toString((char) c);
                }
                //Make stuff equal output here
                stringanimals = temp;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            //Updating latitudes
            try{
                FileInputStream fIn = openFileInput("latitudes");
                int c;
                String temp = "";

                while ((c = fIn.read()) != -1)
                {
                    temp = temp + Character.toString((char) c);
                }
                //Make stuff equal output here
                stringlatitudes = temp;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            //Updating longitudes
            try{
                FileInputStream fIn = openFileInput("longitudes");
                int c;
                String temp = "";

                while ((c = fIn.read()) != -1)
                {
                    temp = temp + Character.toString((char) c);
                }
                //Make stuff equal output here
                stringlongitudes = temp;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            //Updating dates
            try{
                FileInputStream fIn = openFileInput("dates");
                int c;
                String temp = "";

                while ((c = fIn.read()) != -1)
                {
                    temp = temp + Character.toString((char) c);
                }
                //Make stuff equal output here
                stringdates = temp;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            System.out.println("ANIMAL TYPES BEFORE CONVERSION: " + stringanimals);

            animalTypes = new ArrayList(Arrays.asList(stringanimals.split(" ")));
            latitudes = new ArrayList(Arrays.asList(stringlatitudes.split(" ")));
            longitudes = new ArrayList(Arrays.asList(stringlongitudes.split(" ")));
            dates = new ArrayList(Arrays.asList(stringdates.split(" ")));

            // KK22
            date = date.replaceAll(" ", "-");
            System.out.println(date);

            animalTypes.add(animal);
            latitudes.add(fullLat);
            longitudes.add(fullLng);
            dates.add(date);

            animalTypes.removeAll(Arrays.asList("", null));
            latitudes.removeAll(Arrays.asList("", null));
            longitudes.removeAll(Arrays.asList("", null));
            dates.removeAll(Arrays.asList("", null));

            System.out.println("ANIMAL TYPES AFTER: " + animalTypes);




                            for (int i = 0; i < animalTypes.size(); i++) {
                                LatLng wildlifeCurrPos = new LatLng(Double.parseDouble((String) latitudes.get(i)), Double.parseDouble((String) longitudes.get(i)));
                                mMap.addMarker(new MarkerOptions().position(wildlifeCurrPos).title((String) animalTypes.get(i)).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).snippet(dates.get(i) + ""));
                                System.out.println("One iteration");

                            }




        }

        System.out.println("ANIMAL TYPES before evevevevevrything: " + animalTypes);



        Intent intent = getIntent();
        detect = intent.getStringExtra("DETECT");
        if(detect != null) {
            if (detect.equals("1")) {
                detect = "0";
                fullLat = Double.parseDouble(intent.getStringExtra("LAT"));
                fullLng = Double.parseDouble(intent.getStringExtra("LNG"));
                animal = intent.getStringExtra("ANIMAL");
                date = intent.getStringExtra("TIME");
                //Write to text files
                System.out.println("ANIMAL TYPES BEFORE EVERYTHING: " + animalTypes);



                //Reading and updating Files
                //Updating animalType
                try{
                    FileInputStream fIn = openFileInput("animalTypes");
                    int c;
                    String temp = "";

                    while ((c = fIn.read()) != -1)
                    {
                        temp = temp + Character.toString((char) c);
                    }
                    //Make stuff equal output here
                    stringanimals = temp;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                //Updating latitudes
                try{
                    FileInputStream fIn = openFileInput("latitudes");
                    int c;
                    String temp = "";

                    while ((c = fIn.read()) != -1)
                    {
                        temp = temp + Character.toString((char) c);
                    }
                    //Make stuff equal output here
                    stringlatitudes = temp;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                //Updating longitudes
                try{
                    FileInputStream fIn = openFileInput("longitudes");
                    int c;
                    String temp = "";

                    while ((c = fIn.read()) != -1)
                    {
                        temp = temp + Character.toString((char) c);
                    }
                    //Make stuff equal output here
                    stringlongitudes = temp;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                //Updating dates
                try{
                    FileInputStream fIn = openFileInput("dates");
                    int c;
                    String temp = "";

                    while ((c = fIn.read()) != -1)
                    {
                        temp = temp + Character.toString((char) c);
                    }
                    //Make stuff equal output here
                    stringdates = temp;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                System.out.println("ANIMAL TYPES BEFORE CONVERSION: " + stringanimals);

                animalTypes = new ArrayList(Arrays.asList(stringanimals.split(" ")));
                latitudes = new ArrayList(Arrays.asList(stringlatitudes.split(" ")));
                longitudes = new ArrayList(Arrays.asList(stringlongitudes.split(" ")));
                dates = new ArrayList(Arrays.asList(stringdates.split(" ")));

                // KK22
                date = date.replaceAll(" ", "-");
                System.out.println(date);

                animalTypes.add(animal);
                latitudes.add(fullLat);
                longitudes.add(fullLng);
                dates.add(date);

                System.out.println("ANIMAL TYPES AFTER: " + animalTypes);

                //Convert animal list to string and write it
                String convstring = "";
                for(int i = 0; i < animalTypes.size(); i++){
                    convstring = convstring + " " + animalTypes.get(i);
                }
                try {
                    System.out.println("CURRENT CONVSTRING: " + convstring);
                    FileOutputStream out = openFileOutput("animalTypes", Context.MODE_PRIVATE);
                    out.write(convstring.getBytes());
                    out.close();
                }
                catch (IOException e) {
                    System.out.println("Exception Occurred" + e);
                }

                stringanimals = convstring;

                //Convert latitude to string and write it
                convstring = "";
                for(int i = 0; i < latitudes.size(); i++){
                    convstring = convstring + " " + latitudes.get(i);
                }
                try {
                    FileOutputStream out = openFileOutput("latitudes", Context.MODE_PRIVATE);
                    out.write(convstring.getBytes());
                    out.close();
                }
                catch (IOException e) {
                    System.out.println("Exception Occurred" + e);
                }

                stringlatitudes = convstring;

                //Convert longitude to string and write it
                convstring = "";
                for(int i = 0; i < longitudes.size(); i++){
                    convstring = convstring + " " + longitudes.get(i);
                }
                try {
                    FileOutputStream out = openFileOutput("longitudes", Context.MODE_PRIVATE);
                    out.write(convstring.getBytes());
                    out.close();
                }
                catch (IOException e) {
                    System.out.println("Exception Occurred" + e);
                }

                stringlongitudes = convstring;

                //Convert date to string and write it
                System.out.println("Date before: " + date);
                System.out.println("Date after: " + date);
                convstring = "";
                for(int i = 0; i < dates.size(); i++){
                    convstring = convstring + " " + dates.get(i);
                }
                try {
                    FileOutputStream out = openFileOutput("dates", Context.MODE_PRIVATE);
                    out.write(convstring.getBytes());
                    out.close();
                }
                catch (IOException e) {
                    System.out.println("Exception Occurred" + e);
                }
                stringdates = convstring;

                System.out.println("String versions: " + stringanimals);
                System.out.println(stringlatitudes);
                System.out.println(stringlongitudes);
                System.out.println(stringdates);



                animalTypes = new ArrayList(Arrays.asList(stringanimals.split(" ")));
                latitudes = new ArrayList(Arrays.asList(stringlatitudes.split(" ")));
                longitudes = new ArrayList(Arrays.asList(stringlongitudes.split(" ")));
                dates = new ArrayList(Arrays.asList(stringdates.split(" ")));

                System.out.println("Array versions: " + animalTypes);
                System.out.println(latitudes);
                System.out.println(longitudes);
                System.out.println(dates);

                animalTypes.removeAll(Arrays.asList("", null));
                latitudes.removeAll(Arrays.asList("", null));
                longitudes.removeAll(Arrays.asList("", null));
                dates.removeAll(Arrays.asList("", null));



                System.out.println("Array versions: " + animalTypes);
                System.out.println(latitudes);
                System.out.println(longitudes);
                System.out.println(dates);
                System.out.println("Array size: " + animalTypes.size());

                for(int i = 0; i < animalTypes.size();i++){
                    LatLng wildlifeCurrPos = new LatLng(Double.parseDouble((String)latitudes.get(i)), Double.parseDouble((String)longitudes.get(i)));
                    mMap.addMarker(new MarkerOptions().position(wildlifeCurrPos).title((String)animalTypes.get(i)).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).snippet(dates.get(i) + ""));
                    System.out.println("One iteration");


                }
            System.out.println("AFTER ENTIRE PROCESS: " + animalTypes);
            }
        }



        Button debugButton = (Button) findViewById(R.id.debugButton);
        debugButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
            FileOutputStream out = openFileOutput("animalTypes", Context.MODE_PRIVATE);
            out.write("".getBytes());
            out.close();
            }
            catch (IOException e) {
                System.out.println("Exception Occurred" + e);
            }

            try {
                FileOutputStream out = openFileOutput("latitudes", Context.MODE_PRIVATE);
                out.write("".getBytes());
                out.close();
            }
            catch (IOException e) {
                System.out.println("Exception Occurred" + e);
            }

            try {
                FileOutputStream out = openFileOutput("longitudes", Context.MODE_PRIVATE);
                out.write("".getBytes());
                out.close();
            }
            catch (IOException e) {
                System.out.println("Exception Occurred" + e);
            }

            try {
                FileOutputStream out = openFileOutput("dates", Context.MODE_PRIVATE);
                out.write("".getBytes());
                out.close();
            }
            catch (IOException e) {
                System.out.println("Exception Occurred" + e);
            }

            }
        });





        // Add markers to the map and do other map setup.
        // Set a listener for info window events.

        LatLng Aurora = new LatLng(44.0065, 79.4504);

        float zoomLevel = 13.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Aurora, zoomLevel));


            //Fleury Park
            LatLng Fleury_Park = new LatLng(44.001293, -79.471154);
            final Marker park1 = mMap.addMarker(new MarkerOptions().position(Fleury_Park).title("Fleury Park").snippet("Click for more info"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Fleury_Park));
            String fleury = park1.getId();
            markerMap.put(fleury, "action_one");

            //Machell Park Playground
            LatLng Machell_Park_Playground = new LatLng(44.005714, -79.470758);
            final Marker park2 = mMap.addMarker(new MarkerOptions().position(Machell_Park_Playground).title("Machell Park Playground").snippet("Click for more info"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Machell_Park_Playground));
            String machell = park2.getId();
            markerMap.put(machell, "action_two");

            //Town Park Aurora
            LatLng Town_Park_Aurora = new LatLng(43.998316, -79.462680);
            final Marker park3 = mMap.addMarker(new MarkerOptions().position(Town_Park_Aurora).title("Town Park Aurora").snippet("Click for more info"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Town_Park_Aurora));
            String townpark = park3.getId();
            markerMap.put(townpark, "action_three");

            //Confederation Park
            LatLng Confederation_Park = new LatLng(43.983341, -79.478111);
            final Marker park4 = mMap.addMarker(new MarkerOptions().position(Confederation_Park).title("Confederation Park").snippet("Click for more info"));
            String confederation = park4.getId();
            markerMap.put(confederation, "action_four");

            //Copland Park
            LatLng Copland_Park = new LatLng(43.998755, -79.488263);
            final Marker park5 = mMap.addMarker(new MarkerOptions().position(Copland_Park).title("Copland Park").snippet("Click for more info"));
            String copland = park5.getId();
            markerMap.put(copland, "action_five");

            //Summit Park
            LatLng Summit_Park = new LatLng(44.003271, -79.490168);
            final Marker park6 = mMap.addMarker(new MarkerOptions().position(Summit_Park).title("Summit Park ").snippet("Click for more info"));
            String summit = park6.getId();
            markerMap.put(summit, "action_six");

            //Harmon Park
            LatLng Harmon_Park = new LatLng(44.001684, -79.483596);
            final Marker park7 = mMap.addMarker(new MarkerOptions().position(Harmon_Park).title("Harmon Park").snippet("Click for more info"));
            String harmon = park7.getId();
            markerMap.put(harmon, "action_seven");

            //Valhalla Park
            LatLng valhallaTrail = new LatLng(44.007134, -79.463863);
            final Marker park8 = mMap.addMarker(new MarkerOptions().position(valhallaTrail).title("Valhalla Park").snippet("Click for more info"));
            String valhalla = park8.getId();
            markerMap.put(valhalla, "action_eight");

            //Parks End
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            //Trails Begin

            //Sheppard's Bush Trail
            LatLng Sheppards_Bush = new LatLng(43.998104, -79.456040);
            final Marker trail1 = mMap.addMarker(new MarkerOptions().position(Sheppards_Bush).title("Sheppards Bush Trail").snippet("Click for more info").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
            String sheppard = trail1.getId();
            markerMap.put(sheppard, "action2_one");






        final LatLng Wildlife = new LatLng(43.999456, -79.463790);
        final Marker currentPos = mMap.addMarker(new MarkerOptions().position(Wildlife).title("Report Wildlife Sighting").draggable(true).snippet("Drag to the location of wildlife sighting").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        String drag = currentPos.getId();
        markerMap.put(drag, "action_a");


        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener(){
            @Override
            public void onInfoWindowClick(Marker marker) {
                String actionId = markerMap.get(marker.getId());
                if (actionId.equals("action_one")){
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Fleury Park");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                    }
                else if (actionId.equals("action_two")){
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Machell Park Playground");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                }
                else if (actionId.equals("action_three")){
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Town Park Aurora");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                }
                else if (actionId.equals("action_four")){
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Confederation Park");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                }
                else if (actionId.equals("action_five")){
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Copland Park");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                }
                else if (actionId.equals("action_six")){
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Summit Park");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                }
                else if (actionId.equals("action_seven")){
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Harmon Park");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                }
                else if (actionId.equals("action_eight")){
                    Intent startIntent = new Intent(getApplicationContext(), InfoScreen.class);
                    startIntent.putExtra("PARK", "Valhalla Park");
                    //show how to pass information to another activity
                    startActivity(startIntent);
                }
                else if(actionId.equals("action_a")){
                    System.out.println("heh");


                }
            }
        });

        Button toggleParks = (Button) findViewById(R.id.toggleParks);
        toggleParks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggler == 0) {
                    park1.setVisible(false);
                    park2.setVisible(false);
                    park3.setVisible(false);
                    park4.setVisible(false);
                    park5.setVisible(false);
                    park6.setVisible(false);
                    park7.setVisible(false);
                    park8.setVisible(false);
                    toggler = toggler + 1;
                }
                else if(toggler == 1) {
                    park1.setVisible(true);
                    park2.setVisible(true);
                    park3.setVisible(true);
                    park4.setVisible(true);
                    park5.setVisible(true);
                    park6.setVisible(true);
                    park7.setVisible(true);
                    park8.setVisible(true);
                    toggler = toggler - 1;
                }
            }
        });
        Button toggleTrails = (Button) findViewById(R.id.toggleTrails);
        toggleTrails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggler1 == 0) {
                    trail1.setVisible(false);

                    toggler1 = toggler1 + 1;
                }
                else if(toggler1 == 1) {
                    trail1.setVisible(true);

                    toggler1 = toggler1 - 1;
                }
            }
        });

        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                Geocoder gc = new Geocoder(MapsActivity.this);
                List<Address> list = null;

                    final LatLng draggablePos = marker.getPosition();
                    fullLat = draggablePos.latitude;
                    fullLng = draggablePos.longitude;

                System.out.println("CURRENT LATITUDE: " + fullLat + "CURRENT LONGITUDE: " + fullLng);
                }
            });



        ImageView hanathansucks = (ImageView)findViewById(R.id.hanathansucks);
        hanathansucks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent startIntent = new Intent(getApplicationContext(), WildLifeSubmissions.class);
                startIntent.putExtra("LAT", Double.toString(fullLat));
                startIntent.putExtra("LNG", Double.toString(fullLng));
                startIntent.putExtra("ANIMALS", (stringanimals));
                startIntent.putExtra("LATITUDES", (stringlatitudes));
                startIntent.putExtra("LONGITUDES", (stringlongitudes));
                startIntent.putExtra("DATES", (stringdates));

                //show how to pass information to another activity
                startActivity(startIntent);



            }

        });

        System.out.println("ANIMAL TYPES after evevevevevrything: " + animalTypes);

    }
}
