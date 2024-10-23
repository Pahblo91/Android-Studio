package com.pablopupo.projeto06;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    String[] frases = {

            "A persistência é o caminho do êxito.",
            "O sucesso é a soma de pequenos esforços repetidos dia após dia.",
            "Não importa o tamanho da montanha, ela não pode tapar o sol."

    };
    public void gerarFrase(View view) {
        TextView texto = findViewById(R.id.text_Result);
        int numeroAleatorio = new Random().nextInt(3);

        String frase = frases[numeroAleatorio];

        texto.setText(frase);
    }
    public void exibirTodos(View view) {
        TextView texto = findViewById(R.id.text_Result);
        String textoResultado = "";

        for (String frase : frases) {
            textoResultado = textoResultado + frase + "\n \n";

        }
        texto.setText(textoResultado);

    }
}