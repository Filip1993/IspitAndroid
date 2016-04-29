package com.filipkesteli.ispitandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private EditText etNameSecond;
    private EditText etSurnameSecond;
    private EditText etOIBSecond;
    private EditText etPhoneNumberSecond;
    private EditText etGenderSecond;
    private EditText etCitiesSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initWidgets();
        handleIntents();
    }

    private void initWidgets() {
        etNameSecond = (EditText) findViewById(R.id.etNameSecond);
        etSurnameSecond = (EditText) findViewById(R.id.etSurnameSecond);
        etOIBSecond = (EditText) findViewById(R.id.etOIBSecond);
        etPhoneNumberSecond = (EditText) findViewById(R.id.etPhoneNumberSecond);
        etGenderSecond = (EditText) findViewById(R.id.etGenderSecond);
        etCitiesSecond = (EditText) findViewById(R.id.etCitiesSecond);
    }

    private void handleIntents() {
        Intent intent = getIntent();

        intentGetName(intent);
        intentGetSurname(intent);
        intentGetOIB(intent);
        intentGetPhoneNumber(intent);
        intentGetGender(intent);
        intentGetCities(intent);
    }

    private void intentGetName(Intent intent) {
        if (intent.hasExtra(MainActivity.PARAMETER_NAME)) {
            String nameSecond = intent.getStringExtra(MainActivity.PARAMETER_NAME);
            etNameSecond.setText(nameSecond+"");
        }
    }

    private void intentGetSurname(Intent intent) {
        if (intent.hasExtra(MainActivity.PARAMETER_SURNAME)) {
            String surnameSecond = intent.getStringExtra(MainActivity.PARAMETER_SURNAME);
            etSurnameSecond.setText(surnameSecond + "");
        }
    }

    private void intentGetOIB(Intent intent) {
        if (intent.hasExtra(MainActivity.PARAMETER_OIB)) {
            String oibSecond = intent.getStringExtra(MainActivity.PARAMETER_OIB);
            etOIBSecond.setText(oibSecond + "");
        }
    }

    private void intentGetPhoneNumber(Intent intent) {
        if (intent.hasExtra(MainActivity.PARAMETER_PHONE_NUMBER)) {
            String phoneNumberSecond = intent.getStringExtra(MainActivity.PARAMETER_PHONE_NUMBER);
            etOIBSecond.setText(phoneNumberSecond);
        }
    }

    private void intentGetGender(Intent intent) {
        if (intent.hasExtra(MainActivity.PARAMETER_OIB)) {
            String genderSecond = intent.getStringExtra(MainActivity.PARAMETER_OIB);
            etGenderSecond.setText(genderSecond + "");
        }
    }

    private void intentGetCities(Intent intent) {
        if (intent.hasExtra(MainActivity.PARAMETER_CITIES)) {
            String citiesSecond = intent.getStringExtra(MainActivity.PARAMETER_CITIES);
            etCitiesSecond.setText(citiesSecond + "");
        }
    }

    @Override
    public void finish() {
        super.finish();
        //setResult(RESULT_OK);
        //zna kamo ide! Ne treba imati cilj kamo ide. To je paket koji zna kamo ide po REQUEST_CODE-u!
        Intent data = new Intent(); //kao implicitan intent -> zna kamo se vraca
        data.putExtra(MainActivity.PARAMETER_SECOND, "USPJESNO OBAVLJENO");
        setResult(RESULT_OK, data);
        super.finish();
    }
}
