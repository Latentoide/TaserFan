package com.example.taserfan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.taserfan.API.API;
import com.example.taserfan.API.Connector;
import com.example.taserfan.API.Result;
import com.example.taserfan.base.BaseActivity;
import com.example.taserfan.base.CallInterface;

public class LoginActivity extends BaseActivity implements CallInterface {

    Empleado e;
    Result<Empleado> res;
    EditText usuario, password;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.username);
        password = findViewById(R.id.password);

        b = findViewById(R.id.login);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executeCall(LoginActivity.this);
            }
        });
    }

    @Override
    public void doInBackground() {
        Authentification authentication = new Authentification(usuario.getText().toString(), password.getText().toString());
        res = Connector.getConector().post(Empleado.class, authentication, API.Routes.AUTHENTICATE);
    }

    @Override
    public void doInUI() {
        if(res instanceof Result.Success){
            LoggedInUserRepository.getInstance().login(((Result.Success<Empleado>) res).getData());
            Intent intent = new Intent(this, AcitivityOfVehicles.class);
            startActivity(intent);
        }else{
            Result.Error resultado = (Result.Error) res;
            Toast.makeText(this, resultado.getError(), Toast.LENGTH_SHORT).show();
        }
    }
}