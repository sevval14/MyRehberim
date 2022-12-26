package com.example.loginscreen;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginscreen.databinding.ActivityMainBinding;
import com.example.loginscreen.databinding.FragmentLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class loginFragment extends Fragment  {

    private String txtEmail,txtPassword;
    Button login;
    EditText editEmail,editPassword;
    private FirebaseAuth mAuth;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_login, container, false);
        login = (Button) view.findViewById(R.id.login);
        editEmail = (EditText) view.findViewById(R.id.mail);
        editPassword = (EditText) view.findViewById(R.id.password);

        mAuth =FirebaseAuth.getInstance();




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtEmail =editEmail.getText().toString();
                txtPassword =editPassword.getText().toString();

                if(!TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtPassword) ){
                    mAuth.createUserWithEmailAndPassword(txtEmail,txtPassword).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent intent = new Intent(loginFragment.this.getActivity(),MainPage.class);
                                startActivity(intent);
                                Toast.makeText(loginFragment.this.getActivity(), "Kayıt işlemi başarılı", Toast.LENGTH_SHORT).show();

                            }else{
                                Toast.makeText(loginFragment.this.getActivity(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                }else{
                    Toast.makeText(getActivity(), "Email ve şifre boş olamaz", Toast.LENGTH_SHORT).show();
                }

            }


        });


        return view;
    }





}