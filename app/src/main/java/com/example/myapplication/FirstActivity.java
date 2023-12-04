package com.example.myapplication;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    private EditText inputMB;
    private Button convertButtonMB;
    private TextView resultTextMB;
    private Spinner conversionTypeSpinnerMB;

    private EditText inputDec;
    private Spinner SelectorDec;
    private Button convertButtonDec;
    private TextView resultTextDec;


    private EditText editTextInput;
    private RadioButton radioButtonFahrenheit, radioButtonKelvin;
    private Button buttonConvert;
    private TextView textViewResult;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        // MB dönüşümü için gerekli bileşenleri bağlama
        inputMB = findViewById(R.id.inputMB);
        convertButtonMB = findViewById(R.id.convertButtonMB);
        resultTextMB = findViewById(R.id.resultTextMB);
        conversionTypeSpinnerMB = findViewById(R.id.conversionTypeSpinnerMB);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.conversion_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        conversionTypeSpinnerMB.setAdapter(adapter);

        convertButtonMB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputMB.getText().toString().trim();
                if (input.isEmpty()) {
                    resultTextMB.setText("Lütfen bir değer girin.");
                    return;
                }

                double megabyte = Double.parseDouble(input);
                String selectedConversion = conversionTypeSpinnerMB.getSelectedItem().toString();
                double result = 0;

                switch (selectedConversion) {
                    case "Kilobyte":
                        result = megabyte * 1000;
                        break;
                    case "Byte":
                        result = megabyte * 1000000;
                        break;
                    case "Kibibyte":
                        result = megabyte * 976.56;
                        break;
                    case "Bit":
                        result = megabyte *  8000000;
                        break;
                }

                resultTextMB.setText(input + " MB = " + result + " " + selectedConversion);
            }
        });

        // Onluk sistem dönüşümü için gerekli bileşenleri bağlama
        inputDec = findViewById(R.id.inputDec);
        SelectorDec = findViewById(R.id.SelectorDec);
        convertButtonDec = findViewById(R.id.convertButtonDec);
        resultTextDec = findViewById(R.id.resultTextDec);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.base_options, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SelectorDec.setAdapter(adapter2);

        convertButtonDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertNumber();
            }
        });
    }

    private void convertNumber() {
        String input = inputDec.getText().toString().trim();
        if (input.isEmpty()) {
            resultTextDec.setText("Lütfen bir sayı giriniz.");
            return;
        }

        int number = Integer.parseInt(input);

        String selectedBase = SelectorDec.getSelectedItem().toString();
        String result = "";

        switch (selectedBase) {
            case "İkilik":
                result = Integer.toBinaryString(number);
                break;
            case "Sekizlik":
                result = Integer.toOctalString(number);
                break;
            case "Onaltılık":
                result = Integer.toHexString(number);
                break;
        }

        resultTextDec.setText(selectedBase + " tabanındaki değer: " + result.toUpperCase());
        editTextInput = findViewById(R.id.editTextInput);
        radioButtonFahrenheit = findViewById(R.id.radioButtonFahrenheit);
        radioButtonKelvin = findViewById(R.id.radioButtonKelvin);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        if (editTextInput.getText().toString().isEmpty()) {
            textViewResult.setText("Enter a valid Celsius value");
            return;
        }

        double celsius = Double.parseDouble(editTextInput.getText().toString());
        double result;

        if (radioButtonFahrenheit.isChecked()) {
            result = celsius * 9 / 5 + 32;
            textViewResult.setText(String.format("%.2f Celsius = %.2f Fahrenheit", celsius, result));
        } else if (radioButtonKelvin.isChecked()) {
            result = celsius + 273.15;
            textViewResult.setText(String.format("%.2f Celsius = %.2f Kelvin", celsius, result));
        } else {
            textViewResult.setText("Select a conversion unit");
        }
    }

}







