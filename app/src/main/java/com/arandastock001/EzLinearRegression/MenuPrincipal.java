package com.arandastock001.EzLinearRegression;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.arandastock001.EzLinearRegression.Modelo.ControladorDeColores;

public class MenuPrincipal extends AppCompatActivity {

    private Button btnProcederACamara, btnAcercaDe, btnVerHistorial, btnIngresarNumeros, btnOpciones;
    private ConstraintLayout menuPrincipal;
    private ControladorDeColores controladorDeColores;

    //metodo para verificar que tenga permisos
   // public static boolean hasPermissions(Context context, String... permissions) {
     //   if (context != null && permissions != null) {
       //     for (String permission : permissions) {
         //       if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
           //         return false;
             //   }
           // }
       // }
       // return true;
   // }

    int PERMISSION_ALL = 1;
    String[] PERMISSIONS = {
            //android.Manifest.permission.READ_CONTACTS,
            //android.Manifest.permission.WRITE_CONTACTS,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
           // android.Manifest.permission.READ_SMS,
            //android.Manifest.permission.CAMERA
    };




    //@Override
  //  public void onRequestPermissionsResult(int requestCode, String[] permissions,  int[] grantResults){
//
      //  if (!hasPermissions(this, PERMISSIONS)) {
    //        ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
  //      }
//
//    }




    //Para verificar permiso
    public void checkPermission(String permission, int requestCode)
    {

        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(
                MenuPrincipal.this,
                permission)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat
                    .requestPermissions(
                            MenuPrincipal.this,
                            new String[] { permission },
                            requestCode);
        }
        else {
        // No se dio permiso
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnProcederACamara  = (Button)findViewById(R.id.btnProcederACamara);
        btnAcercaDe = (Button)findViewById(R.id.btnAcercaDe);
        btnVerHistorial = (Button)findViewById(R.id.btnVerHistorial);
        btnIngresarNumeros = (Button)findViewById(R.id.btnIngresarNumeros);
        btnOpciones = (Button)findViewById(R.id.btnOpciones);

        menuPrincipal = (ConstraintLayout)findViewById(R.id.layoutMenuPrincipal);


        controladorDeColores=ControladorDeColores.getInstance();


        if(controladorDeColores.getCodigoColor()!=null){

            controladorDeColores.setObjetoConstraint(menuPrincipal);
            controladorDeColores.cambiarColor();
        }else if(controladorDeColores.getCodigoColor()==null){
            controladorDeColores.setCodigoColor(1);
        }












        checkPermission(  Manifest.permission.WRITE_EXTERNAL_STORAGE,  1);







        btnProcederACamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),CapturaActivity.class);
                startActivity(i);
                finish();

            }
        });

        btnAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(getApplicationContext(),AcercaDe.class);
                startActivity(i);
                finish();

            }
        });



        btnVerHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),VerHistorial.class);
                startActivity(i);
                finish();

            }
        });


        btnIngresarNumeros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),IngresoManual.class);
                startActivity(i);
                finish();
            }
        });



        btnOpciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MenuOpciones.class);
                startActivity(i);
                finish();

            }
        });



        Toast toast = Toast.makeText(getApplicationContext(),
                "Bienvenido a la aplicación",
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);

        toast.show();

    }









}
