package com.dapo.softair;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dapo.softair.Utilidades.ViewPagerAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class MenuTecActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;

    TabLayout tabLayoutTec;
    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;
    TextView txtMosNomTecn;
    Button btnLogOutTec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tec);

        //txtMosNomTecn = findViewById(R.id.txtMosNomTec);

        //mostrarNomTec();

        tabLayoutTec = findViewById(R.id.tabLayoutTec);
        viewPager2 = findViewById(R.id.viewPagerTec);
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);
        tabLayoutTec.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayoutTec.getTabAt(position).select();

            }
        });

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout =findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle  toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        /*
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Miperfil()).commit();
            navigationView.setCheckedItem(R.id.nav_view);
        }*/

        /*btnLogOutTec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent goTec = new Intent(MenuTecActivity.this, IniSesRegActivity.class);
                startActivity(goTec);
            }
        });*/

    }
    @Override
   public boolean onNavigationItemSelected(@NonNull MenuItem item) {

       switch (item.getItemId()){

           case 0:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Miperfil()).commit();
              break;
       }
      drawerLayout.closeDrawer(GravityCompat.START);
      return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);

        }
        else {
            super.onBackPressed();
        }
    }

    public void mostrarNomTec(){

        // Mostrar el nombre del tecnico en el TextView

        String nombreTecnico = getIntent().getStringExtra("nombre_tecnico");

        if (nombreTecnico != null) {
            txtMosNomTecn.setText("Bienvenido, " + nombreTecnico);
        } else {
            txtMosNomTecn.setText("Error al obtener el nombre del cliente");
        }

    }

}



