package com.test.hafta4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.test.hafta4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        sharedPreferences = this.getSharedPreferences("package com.test.hafta4;", Context.MODE_PRIVATE);

    }

    public void kaydet(View view){

        String userName = binding.nameEdt.getText().toString();
        String lokasyon = binding.konumEdt.getText().toString();

        sharedPreferences.edit().putString("kullanıcı adı", userName).apply();
        sharedPreferences.edit().putString("konum", lokasyon).apply();

        Toast.makeText(getApplicationContext(), "Başarılı...", Toast.LENGTH_LONG).show() ;



    }


    public void goster(View view){

        String userName = sharedPreferences.getString("kullanıcı adı", "kullanıcı adı bulunamadı");
        String lokasyon = sharedPreferences.getString("konum", "lokasyon bulunamadı");

        binding.nametxtview.setText("kullanıcı adı:" + userName);
        binding.konumTxtView.setText("lokasyon:" + lokasyon);


    }

    public void sil(View view){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        binding.nametxtview.setText("");
        binding.konumTxtView.setText("");

        Toast.makeText(getApplicationContext(), "silindi...", Toast.LENGTH_LONG).show() ;

    }






}