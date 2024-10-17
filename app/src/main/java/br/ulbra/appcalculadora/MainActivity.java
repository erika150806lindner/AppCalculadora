package br.ulbra.appcalculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
   EditText edtVei,edtPlaca, edtDistancia, edtConsumo, edtPreco;
   Button btnCalcular, btnLimpar;
   TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtVei = findViewById(R.id.edtVei);
        edtPlaca = findViewById(R.id.edtPlaca);
        edtDistancia = findViewById(R.id.edtDistancia);
        edtConsumo = findViewById(R.id.edtConsumo);
        edtPreco = findViewById(R.id.edtPreco);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        txtResultado =findViewById(R.id.txtResultado);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vei, placa;
                double distancia, consumo, preco, litros, custo;
               DecimalFormat f= new DecimalFormat("0.00");
                vei = edtVei.getText().toString();
                placa = edtPlaca.getText().toString();

                distancia = Double.parseDouble(edtDistancia.getText().toString());
                consumo = Double.parseDouble(edtConsumo.getText().toString());
                preco = Double.parseDouble(edtPreco.getText().toString());

                litros = distancia/consumo;
                custo = litros * preco;
                txtResultado.setText("O seu veiculo:"+vei +"  necessitou de "+litros
                        +" \n litros para percorrer: "+distancia
                +" e você gastou R$"+f.format(custo));

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtVei.setText(null);
                edtPlaca.setText(null);
                edtDistancia.setText(null);
                edtConsumo.setText(null);
                edtPreco.setText(null);

            }
        });




    }
}