package com.filipkesteli.ispitandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PARAMETER_NAME = "com.filipkesteli.ispitandroid.NAME";
    public static final String PARAMETER_SURNAME = "com.filipkesteli.ispitandroid.SURNAME";
    public static final String PARAMETER_OIB = "com.filipkesteli.ispitandroid.OIB";
    public static final String PARAMETER_PHONE_NUMBER = "com.filipkesteli.ispitandroid.NUMBER";
    public static final String PARAMETER_GENDER = "com.filipkesteli.ispitandroid.GENDER";
    public static final String PARAMETER_CITIES = "com.filipkesteli.ispitandroid.CITIES";
    public static final String PARAMETER_SECOND = "com.filipkesteli.ispitandroid.SECOND";;
    public static final int REQUEST_CODE = 0;

    private EditText etName;
    private EditText etSurname;
    private EditText etOIB;
    private EditText etPhoneNumber;
    private RadioGroup rgGender;
    private RadioButton rbMale;
    private RadioButton rbFemale;
    private Spinner spCities;
    private Button btnSaveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();
    }

    private void initWidgets() {
        etName = (EditText) findViewById(R.id.etName);
        etSurname = (EditText) findViewById(R.id.etSurname);
        etOIB = (EditText) findViewById(R.id.etOIB);
        etPhoneNumber = (EditText) findViewById(R.id.etPhoneNumber);
        rgGender = (RadioGroup) findViewById(R.id.rgGender);
        rbMale = (RadioButton) findViewById(R.id.rbMale);
        rbFemale = (RadioButton) findViewById(R.id.rbFemale);
        spCities = (Spinner) findViewById(R.id.spCities);
        btnSaveData = (Button) findViewById(R.id.btnSaveData);
    }

    private void setupListeners() {
        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentSaveData();
            }
        });
    }

    private void intentSaveData() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

        intentPutName(intent);
        intentPutSurname(intent);
        intentPutOIB(intent);
        intentPutNumber(intent);
        intentPutGender(intent);
        intentPutCities(intent);
    }

    private void intentPutName(Intent intent) {
        String name = etName.getText().toString();
        intent.putExtra(PARAMETER_NAME, name);
    }

    private void intentPutSurname(Intent intent) {
        String surname = etSurname.getText().toString();
        intent.putExtra(PARAMETER_SURNAME, surname);
    }

    private void intentPutOIB(Intent intent) {
        String oib = etOIB.getText().toString();
        intent.putExtra(PARAMETER_OIB, oib);
    }

    private void intentPutNumber(Intent intent) {
        String phoneNumber = etPhoneNumber.getText().toString();
        intent.putExtra(PARAMETER_PHONE_NUMBER, phoneNumber);
    }

    private void intentPutGender(Intent intent) {
        String gender = null;
        switch (rgGender.getCheckedRadioButtonId()) {
            case R.id.rbMale:
                gender = rbMale.getText().toString();
                break;
            case R.id.rbFemale:
                gender = rbFemale.getText().toString();
                break;
        }
        intent.putExtra(PARAMETER_GENDER, gender);
    }

    private void intentPutCities(Intent intent) {
        String cities = spCities.getSelectedItem().toString();
        intent.putExtra(PARAMETER_CITIES, cities);
    }

    /*****************************************************************************************/

    /*

    private void sendIntentForResult() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();

                if (data != null && data.hasExtra(PARAMETER_NAME)) {
                    String message = data.getStringExtra(PARAMETER_NAME);
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

*/

}
