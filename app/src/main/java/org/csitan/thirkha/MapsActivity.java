package org.csitan.thirkha;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.media.browse.MediaBrowser;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity
        implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private LatLng latLng;
    private String temp;
    CharSequence [] items = {"TAP", "WELL", "RIVER", "POND", "OTHER"};
    boolean[] itemSelected = new boolean[items.length];

    Databss databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();

        databaseHandler = new Databss(getApplicationContext());


        List<Resource> resources = databaseHandler.getAllResources();
        if(!resources.isEmpty()) {
            for (int i = 0; i < resources.size(); i++) {
                Resource rn =  resources.get(i);
                mMap.addMarker(new MarkerOptions().position(new LatLng(rn.getLat(), rn.getLon())).title(rn.getType()+"Drinkable")
                                               .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
            }
        }
        /*
        Databss  databaseHandler = new Databss(this);
        List<Resource> resources = databaseHandler.getAllResourcesDetail();
resource
        for(Resource rn :resources)
        {



        }

        */
        /*
        Databss2 database2 = new Databss2(this);
        List<ResourceDetail> rsrc =  database2.getAllResourcesDetail();
        for(ResourceDetail rn :rsrc)
        {


         mMap.addMarker(new MarkerOptions().position(new LatLng(rn.getLat(), rn.getLon())).title(rn.getType()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        }
        */


        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();


        mGoogleApiClient.connect();




      mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
          @Override
          public void onMapLongClick(LatLng latLg) {


               showDialog(1);

                latLng = latLg;




          }
      });


       mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
           @Override
           public boolean onMarkerClick(Marker marker) {
             //  Toast.makeText(getBaseContext(), "called description function", Toast.LENGTH_SHORT).show();


               return false;

           }
       });




    }

    public static String KEY_LAT = "lat";
    public static String KEY_LNG = "lng";


    @Override
    protected Dialog onCreateDialog(int id)
    {

        switch (id) {
            case 0:
                return new AlertDialog.Builder(this)
                        .setIcon(R.drawable.abc_btn_rating_star_on_mtrl_alpha)
                        .setTitle("SELECT WATER RESOURCE TYPE:")
                        .setPositiveButton("UPDATE", new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                       // Toast.makeText(getBaseContext(), "clicked", Toast.LENGTH_LONG).show();

                                       mMap.addMarker(new MarkerOptions().position(new LatLng(latLng.latitude, latLng.longitude)).title(temp).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

                                    }
                                })
                        .setNegativeButton("CANCEL", new
                               DialogInterface.OnClickListener() {
                                  @Override
                                  public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(getBaseContext(),"CANCEL",Toast.LENGTH_LONG).show();
                                    }
                                })
                        .setMultiChoiceItems(items, itemSelected, new
                                DialogInterface.OnMultiChoiceClickListener(){
                                    @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked)
                                        {
                                        //Toast.makeText(getBaseContext(),items[which],Toast.LENGTH_SHORT).show();
                                        //send to database

                                            temp = items[which].toString();
                                          //  Toast.makeText(getBaseContext(), temp + latLng, Toast.LENGTH_SHORT).show();


                                        }

                        }     ).create();

            case 1:
                return new AlertDialog.Builder(this)
                        .setTitle("WHO ARE YOU ? ")
                        .setPositiveButton("ORGANIZATION", new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Toast.makeText(getBaseContext(), "clicked", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(getApplicationContext(), LogIn.class);
                                        startActivity(intent);
                                       /*
                                        double lng = mLastLocation.getLongitude();
                                        double lat = mLastLocation.getLatitude();
                                        intent.putExtra(KEY_LAT, lat);
                                        intent.putExtra(KEY_LNG, lng);
                                        startActivity(intent);

                                         */
                                      //  Toast.makeText(getBaseContext(), temp + latLng, Toast.LENGTH_SHORT).show();
                                        mMap.addMarker(new MarkerOptions().position(new LatLng(latLng.latitude, latLng.longitude)).title(temp).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));



                                    }
                                })
                        .setNegativeButton("INDIVIDUAL", new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(getBaseContext(), "CANCEL", Toast.LENGTH_LONG).show();
                                        showDialog(0);
                                       // String l1 = latLng.toString();
                                        double l1 = latLng.latitude;
                                        double l2 = latLng.longitude;
                                        Resource tem = new Resource(temp,l1, l2);

                                        databaseHandler.addContact(tem);
                                      //  Toast.makeText(getBaseContext(), tem.getType() + " "+ tem.getLat()+" "+ tem.getLon()+ " "+ tem.getId()+ " insrt", Toast.LENGTH_LONG).show();





                                        mMap.addMarker(new MarkerOptions().position(new LatLng(latLng.latitude, latLng.longitude)).title(temp).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                                    }
                                })
                        .create();
        }

       return null;
    }




    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {

       // mMap.addMarker(new MarkerOptions().position(new LatLng(27.7000, 85.3333)).title("Marker"));



        // mMap.addMarker(new MarkerOptions().position(new LatLng(0,0)).title("Marker")); //initial marker
    }

    @Override
    public void onConnected(Bundle bundle) {

        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);




            //initial marker
         //   mMap.getMyLocation();


            /////----------------------------------Zooming camera to position user-----------------

          //  LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
          //  Criteria criteria = new Criteria();

          //  Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
            if (mLastLocation != null)
            {
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                        new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()), 13));

                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()))      // Sets the center of the map to location user
                        .zoom(15)                   // Sets the zoom
                        .bearing(0)                // Sets the orientation of the camera to east
                        .tilt(0)                   // Sets the tilt of the camera to 30 degrees
                        .build();                   // Creates a CameraPosition from the builder
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                mMap.addMarker(new MarkerOptions().position(new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude())).title("u r here"));
            }

/////----------------------------------Zooming camera to position user-----------------








    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
