package com.arandastock001.EzLinearRegression;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.arandastock001.EzLinearRegression.Gdrive.FileUtils;
import com.arandastock001.EzLinearRegression.Gdrive.GoogleDriveServiceHelper;
import com.arandastock001.EzLinearRegression.Modelo.ControladorDeColores;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.Collections;
import java.util.List;


public class MenuPrincipal extends AppCompatActivity {


    private static final String TAG = "MenuPrincipal";


    private static final int REQUEST_CODE_SIGN_IN = 1;
    private static final int PICK_FILE_REQUEST = 100;

    static GoogleDriveServiceHelper mDriveServiceHelper;
    static String folderId="";
    GoogleSignInClient googleSignInClient;

    private Button btnProcederACamara, btnAcercaDe, btnVerHistorial, btnIngresarNumeros, btnOpciones, btnLogIn, btnLogOut, btnCrearCarp;
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

        btnLogIn = (Button)findViewById(R.id.btnLogIn);
        btnLogOut = (Button)findViewById(R.id.btnLogOut);
        btnCrearCarp = (Button)findViewById(R.id.btnCrearCarp);

        menuPrincipal = (ConstraintLayout)findViewById(R.id.layoutMenuPrincipal);


        controladorDeColores = ControladorDeColores.getInstance();



        if(controladorDeColores.getCodigoColor()!=null){

            controladorDeColores.setObjetoConstraint(menuPrincipal);
            controladorDeColores.cambiarColor();
        }else if(controladorDeColores.getCodigoColor()==null){
            controladorDeColores.setCodigoColor(1);
        }


        //No es necesario que lo vea
        btnCrearCarp.setVisibility(View.INVISIBLE);

        //checkPermission(  Manifest.permission.WRITE_EXTERNAL_STORAGE,  1);

        //Solicitar permisos
        requestPermissions();






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


        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLogIn.setEnabled(false);
                btnLogOut.setEnabled(true);
                //ingresar
                requestSignIn();




            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLogIn.setEnabled(true);
                btnLogOut.setEnabled(false);
                //salir





            }
        });


        Toast toast = Toast.makeText(getApplicationContext(),
                "Bienvenido a la aplicación",
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);

        toast.show();

    }






    private void requestSignIn() {
        Log.d(TAG, "Requesting sign-in");

        GoogleSignInOptions signInOptions =
                new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestScopes(new Scope(DriveScopes.DRIVE_FILE))
                        .requestEmail()
                        .build();
        googleSignInClient = GoogleSignIn.getClient(this, signInOptions);

        // The result of the sign-in Intent is handled in onActivityResult.
        startActivityForResult(googleSignInClient.getSignInIntent(), REQUEST_CODE_SIGN_IN);
    }


    // This method will get call when user click on sign-out button
    public void signOut(View view) {
        if (googleSignInClient != null){
            googleSignInClient.signOut()
                    .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            btnLogIn.setEnabled(true);
                            btnLogOut.setEnabled(false);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {


                            Log.e(TAG, "Unable to sign out.", exception);
                        }
                    });
        }




    }


    // This method will get call when user click on upload file button
    public void uploadFile(View view) {

        btnCrearCarp.callOnClick();
        Intent intent;
        if (android.os.Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
            intent = new Intent("com.sec.android.app.myfiles.PICK_DATA");
            //intent = new Intent("com/android/data/com.arandastock001.ezregre/files/");
            intent.putExtra("CONTENT_TYPE", "*/*");
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            Log.e(TAG, "uploadFile: if" );
        } else {

            String[] mimeTypes =
                    {"application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", // .doc & .docx
                            "application/vnd.ms-powerpoint", "application/vnd.openxmlformats-officedocument.presentationml.presentation", // .ppt & .pptx
                            "application/vnd.ms-excel", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", // .xls & .xlsx
                            "text/plain",
                            "application/pdf",
                            "application/zip", "application/vnd.android.package-archive"};

            //    String[] mimeTypes = {
            //          "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
            // };
            intent = new Intent(Intent.ACTION_GET_CONTENT); // or ACTION_OPEN_DOCUMENT
            intent.setType("*/*");
            intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
            Log.e(TAG, "uploadFile: else" );
        }
        startActivityForResult(Intent.createChooser(intent,"Elegir archivo para subir"),PICK_FILE_REQUEST);

    }


    // This method will get call when user click on create folder button
    public void createFolder(View view) {
        if (mDriveServiceHelper != null) {

            // check folder present or not
            mDriveServiceHelper.isFolderPresent()
                    .addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String id) {
                            if (id.isEmpty()){
                                mDriveServiceHelper.createFolder()
                                        .addOnSuccessListener(new OnSuccessListener<String>() {
                                            @Override
                                            public void onSuccess(String fileId) {
                                                Log.e(TAG, "folder id: "+fileId );
                                                folderId=fileId;
                                               // showMessage("Folder Created with id: "+fileId);
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception exception) {
                                              //
                                                Log.e(TAG, "No se pudo crear el archivo.", exception);
                                            }
                                        });
                            }else {
                                folderId=id;
                              //  showMessage("Folder already present");
                            }

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                          //  showMessage("Couldn't create file..");
                            Log.e(TAG, "No se pudo crear el archivo", exception);
                        }
                    });
        }
    }


    /**
     * Handles the {@code result} of a completed sign-in activity initiated from {@link
     * #requestSignIn()}.
     */
    private void handleSignInResult(Intent result) {
        GoogleSignIn.getSignedInAccountFromIntent(result)
                .addOnSuccessListener(googleAccount -> {
                    Log.d(TAG, "Ingreso como " + googleAccount.getEmail());

                    // Use the authenticated account to sign in to the Drive service.
                    GoogleAccountCredential credential =
                            GoogleAccountCredential.usingOAuth2(
                                    this, Collections.singleton(DriveScopes.DRIVE_FILE));
                    credential.setSelectedAccount(googleAccount.getAccount());
                    Drive googleDriveService =
                            new Drive.Builder(
                                    AndroidHttp.newCompatibleTransport(),
                                    new GsonFactory(),
                                    credential)
                                    .setApplicationName("Ez Linear Regression")
                                    .build();

                    // The DriveServiceHelper encapsulates all REST API and SAF functionality.
                    // Its instantiation is required before handling any onClick actions.
                    mDriveServiceHelper = new GoogleDriveServiceHelper(googleDriveService);

                    //enable other button as sign-in complete
                    btnLogIn.setEnabled(false);

                    btnLogOut.setEnabled(true);


                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Log.e(TAG, "No se pudo ingresar.", exception);

                        btnLogIn.setEnabled(true);
                    }
                });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {

        switch (requestCode) {
            case REQUEST_CODE_SIGN_IN:
                if (resultCode == Activity.RESULT_OK && resultData != null) {
                    handleSignInResult(resultData);
                }
                break;

            case PICK_FILE_REQUEST:
                if(resultData == null){
                    //no data present
                    return;
                }

             //   loadToast.setText("Uploading file...");
              //  loadToast.show();

                // Get the Uri of the selected file
                Uri selectedFileUri = resultData.getData();
                Log.e(TAG, "selected File Uri: "+selectedFileUri );
                // Get the path
                String selectedFilePath = FileUtils.getPath(this, selectedFileUri);//FileUtilsNoEraPublico
                Log.e(TAG,"Selected File Path:" + selectedFilePath);


                if(selectedFilePath != null && !selectedFilePath.equals("")){
                    if (mDriveServiceHelper != null) {
                        mDriveServiceHelper.uploadFileToGoogleDrive(selectedFilePath)
                                .addOnSuccessListener(new OnSuccessListener<Boolean>() {
                                    @Override
                                    public void onSuccess(Boolean result) {
                                        Toast.makeText(getApplicationContext(), "Se subió el archivo! ", Toast.LENGTH_SHORT).show();
                                     //   loadToast.success();
                                   //     showMessage("File uploaded ...!!");
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                     //   loadToast.error();
                                   //     showMessage("Couldn't able to upload file, error: "+e);
                                    }
                                });
                    }
                }else{
                    Toast.makeText(this,"No se pudo subir el archivo",Toast.LENGTH_SHORT).show();
                }
                break;
        }

        super.onActivityResult(requestCode, resultCode, resultData);
    }



    private void requestPermissions() {
        Dexter.withContext(this)
                .withPermissions(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA,
                        Manifest.permission.INTERNET)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            Toast.makeText(getApplicationContext(), "Permisos otorgados", Toast.LENGTH_SHORT).show();
                            requestSignIn();

                        }

                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            // show alert dialog navigating to Settings
                            showSettingsDialog();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        Toast.makeText(getApplicationContext(), "Ocurrio un error! ", Toast.LENGTH_SHORT).show();
                    }
                })
                .onSameThread()
                .check();
    }

    // navigating user to app settings
    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }

    /**
     * Showing Alert Dialog with Settings option
     * Navigates user to app settings
     * NOTE: Keep proper title and message depending on your app
     */
    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MenuPrincipal.this);
        builder.setTitle("Permisos requeridos");
        builder.setMessage("Faltan permisos, concedalos en ajustes");
        builder.setPositiveButton("Ir a ajustes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                openSettings();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }


}
