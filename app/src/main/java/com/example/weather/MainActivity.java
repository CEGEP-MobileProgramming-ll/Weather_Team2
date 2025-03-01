package com.example.weather;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public Toolbar toolbar;
    public DrawerLayout drawerLayout;
    public NavController navController;
    public NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupNavigation();
    }


    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }


    public void setupNavigation(){
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigationView);
        navController= Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
        NavigationUI.setupWithNavController(navigationView,navController);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        menuItem.setCheckable(true);
        drawerLayout.closeDrawers();
        int id=menuItem.getItemId();
        Bundle b=new Bundle();
        switch (id){
            case R.id.c_montreal:
                b.putInt("Country",R.id.c_montreal);
                Toast.makeText(this, "Montreal's weather is showing!"+b.getInt("Country"), Toast.LENGTH_SHORT).show();
                navController= Navigation.findNavController(this,R.id.nav_host_fragment);
                Log.d("MainFragment","id="+b);
                navController.navigate(R.id.mainFragment,b);
                break;
            case R.id.c_london:
                Toast.makeText(this,"London's weather is showing!",Toast.LENGTH_SHORT).show();
                b.putInt("Country",R.id.c_london);
                navController= Navigation.findNavController(this,R.id.nav_host_fragment);
                Log.d("MainFragment","id="+b);
                navController.navigate(R.id.mainFragment,b);
                break;
            case R.id.c_abd:
                Toast.makeText(this,"Ahmedabad's weather is showing!",Toast.LENGTH_SHORT).show();
                b.putInt("Country",R.id.c_abd);
                navController= Navigation.findNavController(this,R.id.nav_host_fragment);
                Log.d("MainFragment","id="+b);
                navController.navigate(R.id.mainFragment,b);
                break;
            case R.id.c_ny:
                Toast.makeText(this,"New York's weather is showing!",Toast.LENGTH_SHORT).show();
                b.putInt("Country",R.id.c_ny);
                navController= Navigation.findNavController(this,R.id.nav_host_fragment);
                navController.navigate(R.id.mainFragment,b);
                break;
            case R.id.c_chicago:
                Toast.makeText(this,"Chicago's weather is showing!",Toast.LENGTH_SHORT).show();
                b.putInt("Country",R.id.c_chicago);
                navController= Navigation.findNavController(this,R.id.nav_host_fragment);
                navController.navigate(R.id.mainFragment,b);
                break;
            case R.id.c_mumbai:
                Toast.makeText(this,"Mumbai's weather is showing!",Toast.LENGTH_SHORT).show();
                b.putInt("Country",R.id.c_mumbai);
                navController= Navigation.findNavController(this,R.id.nav_host_fragment);
                navController.navigate(R.id.mainFragment,b);
                break;
            case R.id.c_toronto:
                Toast.makeText(this,"Toronto's weather is showing!",Toast.LENGTH_SHORT).show();
                b.putInt("Country",R.id.c_toronto);
                navController= Navigation.findNavController(this,R.id.nav_host_fragment);
                navController.navigate(R.id.mainFragment,b);
                break;
            case R.id.c_vancouver:
                Toast.makeText(this,"vancouver's weather is showing!",Toast.LENGTH_SHORT).show();
                b.putInt("Country",R.id.c_vancouver);
                navController= Navigation.findNavController(this,R.id.nav_host_fragment);
                navController.navigate(R.id.mainFragment,b);
                break;
            case R.id.c_surat:
                Toast.makeText(this,"Surat's weather is showing!",Toast.LENGTH_SHORT).show();
                b.putInt("Country",R.id.c_surat);
                navController= Navigation.findNavController(this,R.id.nav_host_fragment);
                navController.navigate(R.id.mainFragment,b);
                break;
        }
        return true;
    }



    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this,R.id.nav_host_fragment),drawerLayout);
    }
}