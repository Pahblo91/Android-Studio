package com.pablopupo.projeto10;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class ImcActivity extends AppCompatActivity {

    private TextView editPeso, editAltura;
    private Button Calcular, Limpar;
    double imc, peso, altura;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imc);

        editPeso = findViewById(R.id.editTextPeso);
        editAltura = findViewById(R.id.editTextAltura);
        Calcular = findViewById(R.id.buttonCalcular);
        Limpar = findViewById(R.id.buttonLimpar);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Calcular_Imc(View view) {
        peso = (Double.parseDouble(editPeso.getText().toString()));
        altura = (Double.parseDouble(editAltura.getText().toString()));

        altura = altura / 100;
        imc = peso / (altura * altura);

        if (imc < 17) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Calculadora IMC");
            alerta.setMessage("Seu IMC é de " + imc + " e você está muito abaixo do peso.");
            alerta.setNeutralButton("OK", null);

            alerta.create();
            alerta.show();

        } else if (imc >= 17 && imc < 18.5) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Calculadora IMC");
            alerta.setMessage("Seu IMC é de " + imc + " e você está muito abaixo do peso.");
            alerta.setNeutralButton("OK", null);

            alerta.create();
            alerta.show();

        } else if (imc >= 18.5 && imc < 25) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Calculadora IMC");
            alerta.setMessage("Seu IMC é de " + imc + " seu peso está normal.");
            alerta.setNeutralButton("OK", null);

            alerta.create();
            alerta.show();

        } else if (imc >= 25 && imc < 30) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Calculadora IMC");
            alerta.setMessage("Seu IMC é de " + imc + " e você está acima do peso.");
            alerta.setNeutralButton("OK", null);

            alerta.create();
            alerta.show();

        } else if (imc >= 30 && imc < 35){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Calculadora IMC");
            alerta.setMessage("Seu IMC é de " + imc + "e você está com obesidade grau I.");
            alerta.setNeutralButton("OK", null);

            alerta.create();
            alerta.show();

        } else if (imc >= 35 && imc < 40 ){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Calculadora IMC");
            alerta.setMessage("Seu IMC é de " + imc + "e você está com obesidade grau II");
            alerta.setNeutralButton("OK", null);

            alerta.create();
            alerta.show();

        } else {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Calculadora IMC");
            alerta.setMessage("Seu IMC é de " + imc + " e você está com obesidade grau III - Morbida");
            alerta.setNeutralButton("OK", null);

            alerta.create();
            alerta.show();

        }
    }
    public void Calcular_Limpar(View view) {
        editPeso.setText("");
        editAltura.setText("");

        peso = 0;
        altura = 0;
        imc = 0;

    }

}