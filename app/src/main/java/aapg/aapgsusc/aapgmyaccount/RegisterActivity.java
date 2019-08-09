package aapg.aapgsusc.aapgmyaccount;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private EditText Name, Email, Password, Username, Confirm;
    private Button btn_regist;
    String name, email, username, password, configPassword;
    private FirebaseAuth mAuth;
    AlertDialog.Builder builder;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();


        Name = (EditText) findViewById(R.id.register_name);
        Password = (EditText) findViewById(R.id.register_password);
        Confirm = (EditText) findViewById(R.id.register_confirm_password);
        Email = (EditText) findViewById(R.id.register_email);
        Username = (EditText) findViewById(R.id.register_username);
        btn_regist = (Button) findViewById(R.id.register_create_account);
        builder = new AlertDialog.Builder(RegisterActivity.this);
        loadingBar = new ProgressDialog(this);





        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = Name.getText().toString().trim();
                email = Email.getText().toString().trim();
                username = Username.getText().toString().trim();
                password = Password.getText().toString().trim();
                configPassword = Confirm.getText().toString().trim();

                if (name.equals("") || email.equals("") || password.equals("") || username.equals("") || configPassword.equals("")) {

                    btn_regist.setVisibility(View.VISIBLE);
                    builder.setTitle("Something Went Wrong....");
                    builder.setMessage("Please fill all Info......");
                    displayBuilder("input error");
                } else {

                    if (!password.equals(configPassword)) {
                        btn_regist.setVisibility(View.VISIBLE);
                        builder.setTitle("Something Went Wrong....");
                        builder.setMessage("Password are not matching......");
                        displayBuilder("input error");
                    }
                    else {

                        loadingBar.setTitle("Creating New Account");
                        loadingBar.setMessage("Please wait, while we are creating your new Account...");
                        loadingBar.show();
                        loadingBar.setCanceledOnTouchOutside(true);
                        mAuth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task)
                                    {
                                        if(task.isSuccessful())
                                        {
                                            SendUserToSetupActivity();

                                            Toast.makeText(RegisterActivity.this, "you are authenticated successfully...", Toast.LENGTH_SHORT).show();
                                            loadingBar.dismiss();
                                        }
                                        else
                                        {
                                            String message = task.getException().getMessage();
                                            builder.setTitle("Something Went Wrong....");
                                            builder.setMessage(message);
                                            displayBuilder("input error");
                                            loadingBar.dismiss();
                                        }
                                    }
                                });
                    }
                }

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            SendUserToMainActivity();
        }

    }

    private void SendUserToMainActivity() {
        Intent mainIntent = new Intent(RegisterActivity.this, MainActivity.class);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainIntent);
        finish();
    }


    private void SendUserToSetupActivity() {

        Intent setupIntent = new Intent(RegisterActivity.this, SetupActivity.class);
        setupIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(setupIntent);
        finish();
    }



    public void displayBuilder(final String code) {
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (code.equals("input error")) {
                    Password.setText("");
                    Confirm.setText("");

                } else if (code.equals("reg_success")) {
                    finish();
                } else if (code.equals("reg_failed")) {
                    Password.setText("");
                    Confirm.setText("");
                    Name.setText("");
                    Email.setText("");
                    Username.setText("");
                }

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        alertDialog.getButton(alertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
    }
}
