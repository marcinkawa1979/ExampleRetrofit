package com.android.example.exampleretrofit;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.example.exampleretrofit.POJO.Data;
import com.android.example.exampleretrofit.POJO.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

   @BindView(R.id.username)
    EditText name;
   @BindView(R.id.email)
    EditText emailId;
   @BindView(R.id.password)
    EditText password;
   @BindView(R.id.signUp)
    Button sinUp;

   User user;
   Data recivedData;
   String recivedToken;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        sinUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validate the fields and call sign method to implement the api
                if (validate(name) && validateEmail() && validate(password)) {
                    signUp();
                }
            }
        });
    }

    private boolean validateEmail() {
        String email = emailId.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            emailId.setError("Email is not valid.");
            emailId.requestFocus();
            return false;
        }
        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean validate(EditText editText) {
        // check the lenght of the enter data in EditText and give error if its empty
        if (editText.getText().toString().trim().length() > 0) {
            return true; // returns true if field is not empty
        }
        editText.setError("Please Fill This");
        editText.requestFocus();
        return false;
    }

    private void signUp(){
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show(); // show progress dialog

        // Api is a class in which we define a method getClient() that returns the API Interface class object
        // registration is a POST request type method in which we are sending our field's data
        // enqueue is used for callback response and error

        //Api get client jest obiektem ApiInterface
        // registration to funkcja z interfacu
        // i dalej są żądane pola wpisane z konsoli
        (Api.getClient().logIn(emailId.getText().toString().trim(),
                password.getText().toString().trim())).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                recivedToken = response.body().getData().getApiToken();
                Toast.makeText(getApplicationContext(), recivedToken, Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                //TODO odpowiedz daje pusty obiekt więc problem jest z adresem Url bądz z zapytaniem z interfacu

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("response", t.getStackTrace().toString());
                progressDialog.dismiss();
            }
        });

    }
}
