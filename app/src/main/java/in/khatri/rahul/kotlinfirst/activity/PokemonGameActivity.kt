package `in`.khatri.rahul.kotlinfirst.activity

import `in`.khatri.rahul.kotlinfirst.MainActivity
import `in`.khatri.rahul.kotlinfirst.R
import `in`.khatri.rahul.kotlinfirst.model.Pockemon
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class PokemonGameActivity : FragmentActivity(), OnMapReadyCallback  {
    private var map: GoogleMap?= null

   /* override fun onMapReady(p0: GoogleMap?) {

    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_game)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        checkPermmison()
        LoadPockemon()
    }
    var ACCESSLOCATION= 123
    fun checkPermmison(){
        if (Build.VERSION.SDK_INT >= 23){
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), ACCESSLOCATION)
                return
            }
        }
        GetUserLocation()
    }

     @SuppressLint("MissingPermission")
     fun GetUserLocation() {
       // var  myLocation= MyLocationListener()
         var myLocation= MylocationListener()

         var locationManager= getSystemService(Context.LOCATION_SERVICE) as LocationManager

         locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3, 3f, myLocation)

         var mythread= myThread()
         mythread.start()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            ACCESSLOCATION -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    GetUserLocation()
                } else{
                    Toast.makeText(this, "Can't Access Location, need Permission", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
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

    override fun onMapReady(googleMap: GoogleMap){
        map= googleMap
    }
    var location:Location?= null

    // Getting user location
    inner class MylocationListener: LocationListener {
        constructor(){
            location= Location("Start")
            location!!.longitude= 0.0
            location!!.longitude= 0.0
        }

        override fun onLocationChanged(p0: Location?) {
            location= p0
        }

        override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {

        }

        override fun onProviderEnabled(p0: String?) {

        }

        override fun onProviderDisabled(provider: String?) {

        }
         }
    var oldLoction:Location?= null
    inner class myThread:Thread{
        constructor():super(){
            oldLoction= Location("Start")
            oldLoction!!.longitude= 0.0
            oldLoction!!.longitude= 0.0
        }

        override fun run() {
            while (true){
                try {
                    if (oldLoction!!.distanceTo(location)==0f){
                        continue
                    }
                    oldLoction= location
                     runOnUiThread(){
                         map!!.clear()
                         // show location

                         val myCurrentLocation= LatLng(location!!.latitude, location!!.longitude)
                         map!!.addMarker(MarkerOptions().position(myCurrentLocation).title("Me").snippet(" here is my location").icon(BitmapDescriptorFactory.fromResource(R.drawable.mario)))

                         map!!.moveCamera(CameraUpdateFactory.newLatLngZoom(myCurrentLocation, 14f))
                         // show pockemons

                         for (i in 0..listPockemons.size-1){
                             var newPockemon= listPockemons[i]

                             if (newPockemon.IsCatch == false){
                                 val pockemonLoc= LatLng(newPockemon.location!!.latitude, newPockemon.location!!.longitude)
                                 map!!.addMarker(MarkerOptions().position(pockemonLoc).title(newPockemon.name!!).snippet(newPockemon.des!!+", power:"+newPockemon!!.power).icon(BitmapDescriptorFactory.fromResource(newPockemon.image!!)))

                                 if (location!!.distanceTo(newPockemon.location)<2){
                                     newPockemon.IsCatch= true

                                     listPockemons[i]= newPockemon
                                     playerPower+= newPockemon.power!!

                                     Toast.makeText(applicationContext, "You catch new pockemon your new power is "+playerPower, Toast.LENGTH_LONG).show()

                                 }
                             }
                         }
                     }
                    Thread.sleep(1000)
                } catch (ex: Exception){ }
            }
          //  super.run()
        }
    }
    var playerPower= 0.0
    var listPockemons= ArrayList<Pockemon>()

    fun LoadPockemon(){
        listPockemons.add(Pockemon(R.drawable.charmander, "Charmander", "Charmander living in Thadi market", 55.0, 26.848350, 75.768950))

        listPockemons.add(Pockemon(R.drawable.bulbasaur, "Bulbasur", "Bulbasaur living in Jain Temple", 90.5, 26.818850, 75.783150))

        listPockemons.add(Pockemon(R.drawable.squirtle, "Squirtle", "Squirtle living in Nahargarh Fort", 33.5, 26.942060, 75.838720))
    }
}
