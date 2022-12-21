package com.emelyantsev303;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

// Емельянцев Никита, 303 группа

public class MainActivity extends AppCompatActivity {

    Spinner spFrom;
    Spinner spTo;
    EditText etFrom;
    TextView tvTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spFrom = findViewById(R.id.spinner_from);
        spTo = findViewById(R.id.spinner_to);
        etFrom = findViewById(R.id.editText_from);
        tvTo = findViewById(R.id.textView_to);

        ArrayAdapter<String> adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);

        adp.add("mm");
        adp.add("cm");
        adp.add("m");
        adp.add("km");

        spFrom.setAdapter(adp);
        spTo.setAdapter(adp);
    }

    public void convert(View v) {
        try
        {
            double from = Double.parseDouble(etFrom.getText().toString());

            String sFrom = (String) spFrom.getSelectedItem();

            String sto = (String) spTo.getSelectedItem();

            double to = 0.0f;
            double m = 0.0f;

            if (sFrom.equals("mm")) m = from / 1000.0f;
            if (sFrom.equals("cm")) m = from / 100.0f;
            if (sFrom.equals("m")) m = from / 1.0f;
            if (sFrom.equals("km")) m = from * 1000.0f;

            if (sto.equals("mm")) to = m * 1000.0f;
            if (sto.equals("cm")) to = m * 100.0f;
            if (sto.equals("m")) to = m * 1.0f;
            if (sto.equals("km")) to = m / 1000.0f;

            tvTo.setText(String.valueOf(to));
        } catch (Exception ex) {
            Toast.makeText(this, "Пустое значение поля!", Toast.LENGTH_SHORT).show();
        }
    }
}