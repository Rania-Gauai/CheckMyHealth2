package com.lordroid.checkmyhealth;

import android.content.Intent;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton radioButtonFemme;
    RadioButton radioButtonHomme;
    EditText editTextPoids, editTextTaille,editTextAge;
    Button buttonCalcul;
    TextView textViewImg;
    ImageView imageViewNormal,imageViewMaigre , imageViewGraisse;
    ImageButton  imageButtonAcc;
   public double imcH , imcF;
   double poids =0 , taille= 0;
    Integer age =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ecoute_btn_calcul();
        ecoute_btn_accueil();
    }
    public void init(){
        imageButtonAcc  =  (ImageButton) findViewById(R.id.image_button_acc);
        imageViewNormal =  (ImageView) findViewById(R.id.iv_normal);
        imageViewMaigre =  (ImageView) findViewById(R.id.iv_maigre);
        imageViewGraisse =  (ImageView) findViewById(R.id.iv_graisse);
        buttonCalcul = (Button) findViewById(R.id.button_calcul);
        editTextAge =(EditText) findViewById(R.id.et_age);
        TextView textViewAge = (TextView) findViewById(R.id.tv_age);
       textViewImg = (TextView) findViewById(R.id.tv_img);
        editTextTaille =(EditText) findViewById(R.id.et_taille);
        TextView textViewTaille = (TextView) findViewById(R.id.tv_taille);
        editTextPoids =(EditText) findViewById(R.id.et_poids);
        TextView textViewPoids = (TextView) findViewById(R.id.tv_poids);
        radioButtonFemme = (RadioButton) findViewById(R.id.rb_femme);
        radioButtonHomme = (RadioButton) findViewById(R.id.rb_homme);

    }

    public void ecoute_btn_calcul(){
        buttonCalcul.setOnClickListener (new Button.OnClickListener() {
            public void onClick (View v){
                poids =Double.parseDouble(editTextPoids.getText().toString());
                age =Integer.parseInt(editTextAge.getText().toString());
                taille =Double.parseDouble(editTextTaille.getText().toString());
                imcH=(1.2* ( poids/(taille *taille)))+(0.23 * age)-16.2;
                imcF= (1.2* ( poids/(taille *taille)))+(0.23 * age)-5.4;
                if(radioButtonFemme.isChecked()){
                    if( (15<imcF) && (imcF <30)){
                        imageViewMaigre.setVisibility(View.GONE);
                        imageViewGraisse.setVisibility(View.GONE);
                        imageViewNormal.setVisibility(View.VISIBLE);
                        textViewImg.setText("IMG= "+imcF + "\n Normal");
                        textViewImg.setTextColor(getResources().getColor(R.color.green));
                    }
                    else if (imcF<15){
                        imageViewNormal.setVisibility(View.GONE);
                        imageViewMaigre.setVisibility(View.VISIBLE);
                        imageViewGraisse.setVisibility(View.GONE);
                        textViewImg.setText("IMG= "+imcF+ "\n maigre");
                        textViewImg.setTextColor(getResources().getColor(R.color.red));
                    }else {
                        imageViewNormal.setVisibility(View.GONE);
                        imageViewGraisse.setVisibility(View.VISIBLE);
                        imageViewMaigre.setVisibility(View.GONE);
                        textViewImg.setText("IMG= "+imcF+ "\n graisse");
                        textViewImg.setTextColor(getResources().getColor(R.color.red));
                    }
                }
                else if(radioButtonHomme.isChecked()) {
                if( (10<imcH) & (imcH <25)){
                    imageViewMaigre.setVisibility(View.GONE);
                    imageViewGraisse.setVisibility(View.GONE);
                    imageViewNormal.setVisibility(View.VISIBLE);
                    textViewImg.setText("IMG= "+imcF + "\n Normal");
                    textViewImg.setTextColor(getResources().getColor(R.color.green));
                }
                else if (imcH<10){
                    imageViewNormal.setVisibility(View.GONE);
                    imageViewMaigre.setVisibility(View.VISIBLE);
                    imageViewGraisse.setVisibility(View.GONE);
                    textViewImg.setText("IMG= "+imcF+ "\n maigre");
                    textViewImg.setTextColor(getResources().getColor(R.color.red));
                }else {
                    imageViewNormal.setVisibility(View.GONE);
                    imageViewGraisse.setVisibility(View.VISIBLE);
                    imageViewMaigre.setVisibility(View.GONE);
                    textViewImg.setText("IMG= "+imcF+ "\n graisse");
                    textViewImg.setTextColor(getResources().getColor(R.color.red));
                }}
                else{
                    Toast toast = Toast.makeText(MainActivity.this, "SELECT SEXE "
                            ,Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
    public  void ecoute_btn_accueil(){
        imageButtonAcc.setOnClickListener (new ImageButton.OnClickListener() {
            public void onClick (View v){
                Intent intent = new Intent (MainActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
