package com.example.taserfan;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.taserfan.API.API;
import com.example.taserfan.API.Connector;
import com.example.taserfan.API.Result;
import com.example.taserfan.Vehiculos.Coche;
import com.example.taserfan.base.BaseActivity;
import com.example.taserfan.base.CallInterface;

import java.sql.Date;

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

        ThemeSetup.applyPreferenceTheme(this);
        API.Routes.changeURL(GestionPreferencias.getInstance().getIP(this), GestionPreferencias.getInstance().getPort(this));
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executeCall(LoginActivity.this);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.configuracion:
                Intent intent = new Intent(this, PreferencesActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
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