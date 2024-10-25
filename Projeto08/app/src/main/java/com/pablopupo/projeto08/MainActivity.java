package com.pablopupo.projeto08;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText edit_precoAlcool, edit_precoGasolina;
    private TextView text_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);
        edit_precoAlcool = findViewById(R.id.edit_precoAlcool);
        edit_precoGasolina = findViewById(R.id.edit_precoGasolina);
        text_resultado = findViewById(R.id.textView_Resultado);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcularPreco(View view) {
      String precoAlcool = edit_precoAlcool.getText().toString();
      String precoGasolina = edit_precoGasolina.getText().toString();

      Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

      if(camposValidados){
          Double valorAlcool = Double.parseDouble(precoAlcool);
          Double valorGasolina = Double.parseDouble(precoGasolina);

          Double resultado = valorAlcool / valorGasolina;


          if(resultado >= 0.7){
              text_resultado.setText("Melhor abastecer com gasolina");
          } else {
              text_resultado.setText("Melhor abastecer com álcool");
          }

      } else {
          text_resultado.setText("Preencha os preços primeiro!");
      }

    }

    public Boolean validarCampos(String pAlcool, String pGasolina){
        boolean camposValidados = true; // CAMPO VERDADEIRO

        if(pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        } else if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;

        }
        return camposValidados;
    }



}