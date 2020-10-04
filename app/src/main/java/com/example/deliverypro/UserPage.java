package com.example.deliverypro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class UserPage extends AppCompatActivity {

    EditText txt_name,txt_email,txt_age,txt_phNo,txt_home,txt_city,txt_pass;
    Button btn_view,btn_update,btn_del;
    DatabaseReference dbRef_user;
    UserDetails user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        txt_name=findViewById(R.id.inputName);
        txt_email=findViewById(R.id.inputEmail);
        txt_age=findViewById(R.id.inputAge);
        txt_phNo=findViewById(R.id.inputPhno);
        txt_home=findViewById(R.id.inputHome);
        txt_city=findViewById(R.id.inputCity);
        txt_pass=findViewById(R.id.inputPass);

        btn_view=findViewById(R.id.viewbtn);
        btn_update=findViewById(R.id.updatebtn);
        btn_del=findViewById(R.id.delbtn);

        user=new UserDetails();

        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef_user= FirebaseDatabase.getInstance().getReference().child("UserDetails/user");
                dbRef_user.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()){
                            txt_name.setText(dataSnapshot.child("inputName").getValue().toString());
                            txt_email.setText(dataSnapshot.child("inputEmail").getValue().toString());
                            txt_age.setText(dataSnapshot.child("inputAge").getValue().toString());
                            txt_phNo.setText(dataSnapshot.child("inputPhno").getValue().toString());
                            txt_home.setText(dataSnapshot.child("inputHome").getValue().toString());
                            txt_city.setText(dataSnapshot.child("inputCity").getValue().toString());
                        }
                        else
                            Toast.makeText(getApplicationContext(),"Cannot find user",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef_user=FirebaseDatabase.getInstance().getReference().child("UserDetails");
                try {
                    if (TextUtils.isEmpty(txt_name.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Username Empty",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txt_email.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Email Empty",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txt_age.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Age is empty",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txt_phNo.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Contact Number is empty",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txt_home.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Home Address is empty",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txt_city.getText().toString()))
                        Toast.makeText(getApplicationContext(),"City is empty",Toast.LENGTH_SHORT).show();
                    else{
                      user.setUserName(txt_name.getText().toString().trim());
                      user.setEmailAdd(txt_email.getText().toString().trim());
                      user.setAge(txt_age.getText().toString().trim());
                      user.setPhNo(txt_phNo.getText().toString().trim());
                      user.setHomeAd(txt_home.getText().toString().trim());
                      user.setCity(txt_city.getText().toString().trim());
                      user.setPass((txt_pass.getText().toString().trim()));
                      dbRef_user.child("user1").setValue(user);
                      Toast.makeText(getApplicationContext(),"Successfully Inserted",Toast.LENGTH_SHORT).show();
                      clearControls();

                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef_user=FirebaseDatabase.getInstance().getReference().child("user").child("user1");
                dbRef_user.removeValue();
                Toast.makeText(getApplicationContext(),"Successfully Deleted",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void clearControls(){
        txt_name.setText("");
        txt_email.setText("");
        txt_age.setText("");
        txt_phNo.setText("");
        txt_home.setText("");
        txt_city.setText("");
        txt_pass.setText("");
    }
}