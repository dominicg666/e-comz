package food.restaurant.com.tastyfoods;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBufferResponse;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import food.restaurant.com.tastyfoods.Font.Calligrapher;
import food.restaurant.com.tastyfoods.Utils.InfoWindowCustom;
import food.restaurant.com.tastyfoods.Utils.LocationTrack;
import food.restaurant.com.tastyfoods.Utils.PlaceAutocompleteAdapter;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;



public class AddAddress extends AppCompatActivity implements
        OnMapReadyCallback  {
    private static final String TAG = "";
    private GoogleMap mMap;
    private String mPlaceName;
    private String mAddress;
    Button clearButton;

    protected GeoDataClient mGeoDataClient;
    private PlaceAutocompleteAdapter mAdapter;
    private AutoCompleteTextView mAutocompleteView;
    private EditText mAddressEdit;
    SupportMapFragment mapFragment;

    private static final LatLngBounds BOUNDS_GREATER_SYDNEY = new LatLngBounds(
            new LatLng(-34.041458, 150.790100), new LatLng(-33.682247, 151.383362));
    private LatLng sydney;

    private ArrayList<String> permissionsToRequest;
    private ArrayList<String> permissionsRejected = new ArrayList<>();
    private ArrayList<String> permissions = new ArrayList<>();

    private final static int ALL_PERMISSIONS_RESULT = 101;
    LocationTrack locationTrack;

    private boolean BootLocation=true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.app_bar_header_custom);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.toolbar_back_button);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ActionBar actionBar = getSupportActionBar(); // support.v7
        actionBar.setTitle("Address");
        TextView mytext=(TextView) findViewById(R.id.mytext);
        mytext.setText("Delivery Address");



        mapInit();


        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Lato-Regular.ttf", true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void mapInit(){

        permissions.add(ACCESS_FINE_LOCATION);
        permissions.add(ACCESS_COARSE_LOCATION);

        permissionsToRequest = findUnAskedPermissions(permissions);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {


            if (permissionsToRequest.size() > 0)
                requestPermissions(permissionsToRequest.toArray(new String[permissionsToRequest.size()]), ALL_PERMISSIONS_RESULT);
        }

        //end gps


        mGeoDataClient = Places.getGeoDataClient(this, null);

        mAutocompleteView = (AutoCompleteTextView)
                findViewById(R.id.autocomplete_places);
        mAddressEdit = (EditText) findViewById(R.id.select_address);
        mAutocompleteView.setOnItemClickListener(mAutocompleteClickListener);
        mAdapter = new PlaceAutocompleteAdapter(this, mGeoDataClient, BOUNDS_GREATER_SYDNEY, null);
        mAutocompleteView.setAdapter(mAdapter);

        clearButton = (Button) findViewById(R.id.button_clear);
        clearButton.setVisibility(View.GONE);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAutocompleteView.setText("");
                clearButton.setVisibility(View.GONE);
            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        CardView bottomCard = (CardView) findViewById(R.id.bottomCard);
        bottomCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = mAddressEdit.getText().toString();
                if (isValidRequired(address)) {
                    mAddressEdit.setError("Address required");
                    return;
                }
                String city = mAutocompleteView.getText().toString();
                if (isValidRequired(city)) {
                    mAutocompleteView.setError("City required");
                    return;
                }
                finish();


            }
        });


    }
    private boolean isValidRequired(String pass) {
        //Toast.makeText(getApplicationContext(), pass.trim(), Toast.LENGTH_SHORT).show();
        if (pass.trim().equals("")) {
            return true;
        }

        return false;
    }

    public void getCurrentLocation(){
        locationTrack = new LocationTrack(AddAddress.this);
        if (locationTrack.canGetLocation()) {


            double longitude = locationTrack.getLongitude();
            double latitude = locationTrack.getLatitude();
            sydney = new LatLng(latitude,longitude);
            Geocoder geocoder = new Geocoder(getApplicationContext(),
                    Locale.getDefault());

            try {
                List<Address> listAddresses = geocoder.getFromLocation(latitude,
                        longitude, 1);
                if (null != listAddresses && listAddresses.size() > 0) {
// Here we are finding , whatever we want our marker to show when           clicked
//                    String state = listAddresses.get(0).getAdminArea();
//                    String country = listAddresses.get(0).getCountryName();
//                    String subLocality = listAddresses.get(0).getSubLocality();
//                    markerOptions.title("" + sydney + "," + subLocality + "," + state
//                            + "," + country);
                    mAddress=listAddresses.get(0).getAddressLine(0).toString();
                    mPlaceName=listAddresses.get(0).getSubLocality();
                    //mAutocompleteView.setText(listAddresses.get(0).getAddressLine(0).toString());

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            callbackMap(mMap,sydney);

           // Toast.makeText(getApplicationContext(), "Longitude:" + Double.toString(longitude) + "\nLatitude:" + Double.toString(latitude), Toast.LENGTH_SHORT).show();
        } else {
            sydney = new LatLng(17.4040849,78.4167004);

            locationTrack.showSettingsAlert();
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.getUiSettings().setScrollGesturesEnabled(false);

        if(BootLocation){
            getCurrentLocation();
            BootLocation=false;
        }else{

            callbackMap(mMap,sydney);
        }


    }

    public void callbackMap(GoogleMap googleMap,LatLng sydney){
        Marker marker= mMap.addMarker(new MarkerOptions().position(sydney).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_address)).title(mPlaceName).snippet(mAddress));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(18));
        mMap.setPadding(0,320,0,0);
        mMap.setInfoWindowAdapter(new InfoWindowCustom(this));
        marker.showInfoWindow();
    }

    private AdapterView.OnItemClickListener mAutocompleteClickListener
            = new AdapterView.OnItemClickListener() {
        public static final String TAG ="" ;
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            final AutocompletePrediction item = mAdapter.getItem(position);
            final String placeId = item.getPlaceId();
            final CharSequence primaryText = item.getPrimaryText(null);

            Log.i(TAG, "Autocomplete item selected: " + primaryText);

            Task<PlaceBufferResponse> placeResult = mGeoDataClient.getPlaceById(placeId);
            placeResult.addOnCompleteListener(mUpdatePlaceDetailsCallback);

            Toast.makeText(getApplicationContext(), "Clicked: " + primaryText,
                    Toast.LENGTH_SHORT).show();
            Log.i(TAG, "Called getPlaceById to get Place details for " + placeId);
        }
    };

    /**
     * Callback for results from a Places Geo Data Client query that shows the first place result in
     * the details view on screen.
     */
    private OnCompleteListener<PlaceBufferResponse> mUpdatePlaceDetailsCallback
            = new OnCompleteListener<PlaceBufferResponse>() {
        public static final String TAG = "";

        @Override
        public void onComplete(Task<PlaceBufferResponse> task) {
            try {
                PlaceBufferResponse places = task.getResult();

                // Get the Place object from the buffer.
                final Place place = places.get(0);

                mPlaceName=place.getName().toString();
                mAddress=place.getAddress().toString();
                sydney=place.getLatLng();
                mapFragment.getMapAsync(AddAddress.this);
                clearButton.setVisibility(View.VISIBLE);

//                mPlaceDetailsText.setText(formatPlaceDetails(getResources(), place.getName(),
//                        place.getId(), place.getAddress(), place.getPhoneNumber(),
//                        place.getWebsiteUri()));

                // Display the third party attributions if set.
                final CharSequence thirdPartyAttribution = places.getAttributions();
                if (thirdPartyAttribution == null) {
//                    mPlaceDetailsAttribution.setVisibility(View.GONE);
                   // clearButton.setVisibility(View.GONE);
                } else {
//                    mPlaceDetailsAttribution.setVisibility(View.VISIBLE);
                    //clearButton.setVisibility(View.VISIBLE);

//                    mPlaceDetailsAttribution.setText(
//                            Html.fromHtml(thirdPartyAttribution.toString()));
                }

                Log.i(TAG, "Place details received: " + place.getName());

                places.release();
            } catch (RuntimeRemoteException e) {
                // Request did not complete successfully
                Log.e(TAG, "Place query did not complete.", e);
                return;
            }
        }
    };

    private static Spanned formatPlaceDetails(Resources res, CharSequence name, String id,
                                              CharSequence address, CharSequence phoneNumber, Uri websiteUri) {
        Log.e(TAG, res.getString(R.string.place_details, name, id, address, phoneNumber,
                websiteUri));
        return Html.fromHtml(res.getString(R.string.place_details, name, id, address, phoneNumber,
                websiteUri));

    }

    private ArrayList<String> findUnAskedPermissions(ArrayList<String> wanted) {
        ArrayList<String> result = new ArrayList<String>();

        for (String perm : wanted) {
            if (!hasPermission(perm)) {
                result.add(perm);
            }
        }

        return result;
    }

    private boolean hasPermission(String permission) {
        if (canMakeSmores()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED);
            }
        }
        return true;
    }

    private boolean canMakeSmores() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        switch (requestCode) {

            case ALL_PERMISSIONS_RESULT:
                for (String perms : permissionsToRequest) {
                    if (!hasPermission(perms)) {
                        permissionsRejected.add(perms);
                    }
                }

                if (permissionsRejected.size() > 0) {


                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (shouldShowRequestPermissionRationale(permissionsRejected.get(0))) {
                            showMessageOKCancel("These permissions are mandatory for the application. Please allow access.",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                requestPermissions(permissionsRejected.toArray(new String[permissionsRejected.size()]), ALL_PERMISSIONS_RESULT);
                                            }
                                        }
                                    });
                            return;
                        }
                    }

                }else {
                    getCurrentLocation();
                }

                break;
        }

    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(AddAddress.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationTrack.stopListener();
    }

}
