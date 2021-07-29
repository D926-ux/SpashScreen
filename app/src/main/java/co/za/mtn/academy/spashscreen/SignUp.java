package co.za.mtn.academy.spashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    //variable

    TextInputLayout regName, regUsername, regEmail, regPhoneNo, regPassword;
    Button regBtn, regLoginBtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //This line hides the status bar from the screen
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);


        regName = findViewById(R.id.name);
        regUsername = findViewById(R.id.username);
        regEmail = findViewById(R.id.email);
        regPhoneNo = findViewById(R.id.phoneNo);
        regPassword = findViewById(R.id.password);
        regBtn = findViewById(R.id.reg_button);
        regLoginBtn = findViewById(R.id.login_butoon);


        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //  Intent intent = new Intent(SignUp.this, SignUp.class);
                // startActivity(intent);

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");


                //Get all the values

                String name = regName.getEditText().toString();
                String username = regUsername.getEditText().toString();
                String email = regEmail.getEditText().toString();
                String phoneNo = regPhoneNo.getEditText().toString();
                String password = regPassword.getEditText().toString();


                UserHelperClass helperClass = new UserHelperClass();

                reference.setValue(helperClass);

            }


        });


    }

}









