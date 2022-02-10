package com.danny.ahocado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText ingresarpalabra;
    TextView txtp1,txtp2,txtp3,txtp4,txtahorcado,txtgp;
    Button btnlimpiar,btnverificar;

    String palabra="ETPS";
    int intentos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ingresarpalabra = findViewById(R.id.txtIngresarPalabra);
        btnlimpiar = findViewById(R.id.btnLimpiar);
        btnverificar = findViewById(R.id.btnVerificar);
        txtp1 = findViewById(R.id.lblletra1);
        txtp2 = findViewById(R.id.lblletra2);
        txtp3 = findViewById(R.id.lblletra3);
        txtp4 =  findViewById(R.id.lblletra4);
        txtgp = findViewById(R.id.lblgp);
        txtahorcado = findViewById(R.id.lblahorcado);

        btnlimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentos=0;
                ingresarpalabra.setText("");
                txtp1.setText("_________");
                txtp2.setText("_________");
                txtp3.setText("_________");
                txtp4.setText("_________");
                txtahorcado.setText("");
                txtgp.setText("");
                Toast.makeText(MainActivity.this, "Nuevo Juego", Toast.LENGTH_SHORT).show();
            }
        });

        btnverificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Toast.makeText(MainActivity.this, ingresarpalabra.getText(), Toast.LENGTH_SHORT).show();
                if (palabra.indexOf(String.valueOf(ingresarpalabra.getText()).toUpperCase(Locale.ROOT))>0){
                    Toast.makeText(MainActivity.this, ingresarpalabra.getText(), Toast.LENGTH_SHORT).show();
                    switch(ingresarpalabra.getText().toString().toUpperCase(Locale.ROOT)){
                        case "E":
                            txtp1.setText("E");
                            break;
                        case "T":
                            txtp2.setText("T");
                            break;
                        case "P":
                            txtp3.setText("P");
                            break;
                        case "S":
                            txtp4.setText("S");
                            break;
                    }
                }else{
                    intentos=intentos+1;
                    switch (intentos){
                        case 1:
                            txtahorcado.setText("A");
                            break;
                        case 2:
                            txtahorcado.setText("AH");
                            break;
                        case 3:
                            txtahorcado.setText("AHO");
                            break;
                        case 4:
                            txtahorcado.setText("AHOR");
                            break;
                        case 5:
                            txtahorcado.setText("AHORC");
                            break;
                        case 6:
                            txtahorcado.setText("AHORCA");
                            break;
                        case 7:
                            txtahorcado.setText("AHORCAD");
                            break;
                        case 8:
                            txtahorcado.setText("AHORCADO");
                            txtgp.setText("Perdiste, no seas imbecil");
                            break;

                    }
                    //Toast.makeText(MainActivity.this, String.valueOf(txtahorcado), Toast.LENGTH_SHORT).show();
                }
                if(txtp1.equals("E")&&txtp2.equals("T")&&txtp3.equals("P")&&txtp4.equals("S")){
                    txtgp.equals("Has ganado. Marabilloso.");
                }
                ingresarpalabra.setText("");
            }
        });

    }
}