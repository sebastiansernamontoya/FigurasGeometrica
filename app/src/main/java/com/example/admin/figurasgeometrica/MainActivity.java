package com.example.admin.figurasgeometrica;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import  java.math.*;

public class MainActivity extends AppCompatActivity {

    private TextView tCampo1, tCampo2, tCampo3,tCampo4,resultado;
    private EditText Campo1, Campo2, Campo3,Campo4;
    private RadioButton cuadro, circulo, triangulo, cubo;
    private CheckBox perimetro,area, volumen;
    private int fig=1;
    private  int cont=0, cont2=0;
    private float op1=0, op2=0, op3=0, op4, result=0;
    private String sresultado=" ";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fig=1;
        tCampo1 = (TextView)findViewById(R.id.eCampo1);
        tCampo2 = (TextView)findViewById(R.id.eCampo2);
        tCampo3 = (TextView)findViewById(R.id.eCampo3);
        tCampo4 = (TextView)findViewById(R.id.eCampo4);
        resultado=(TextView)findViewById(R.id.resultados);
        Campo1= (EditText)findViewById(R.id.Campo1);
        Campo2= (EditText)findViewById(R.id.Campo2);
        Campo3= (EditText)findViewById(R.id.Campo3);
        Campo4= (EditText)findViewById(R.id.Campo4);
        perimetro= (CheckBox) findViewById(R.id.cperimetro);
        area= (CheckBox) findViewById(R.id.carea);
        volumen=(CheckBox) findViewById(R.id.cvolumen);


    }


    protected void mostrar2(View view) {

        if(cont==0){
            cont=1;
        }
        else{
            cont=0;
        }

        toggle();
    }

    protected void mostrar1(View view) {

        if(cont2==0){
            cont2=1;
        }
        else{
            cont2=0;
        }
        toggle();
    }


    protected void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.cuadro:
                if (checked) {
                    Campo1.setVisibility(View.VISIBLE);
                    Campo2.setVisibility(View.VISIBLE);
                    Campo3.setVisibility(View.INVISIBLE);
                    Campo4.setVisibility(View.INVISIBLE);
                    tCampo1.setVisibility(View.VISIBLE);
                    tCampo2.setVisibility(View.VISIBLE);
                    tCampo3.setVisibility(View.INVISIBLE);
                    tCampo4.setVisibility(View.INVISIBLE);
                    tCampo1.setText("Ancho");
                    tCampo2.setText("Largo");
                    fig = 1;

                    break;
                }
            case R.id.circulo:
                if (checked) {
                    Campo1.setVisibility(View.VISIBLE);
                    Campo2.setVisibility(View.INVISIBLE);
                    Campo3.setVisibility(View.INVISIBLE);
                    Campo4.setVisibility(View.INVISIBLE);
                    tCampo1.setVisibility(View.VISIBLE);
                    tCampo2.setVisibility(View.INVISIBLE);
                    tCampo3.setVisibility(View.INVISIBLE);
                    tCampo4.setVisibility(View.INVISIBLE);
                    tCampo1.setText("Radio");
                    fig = 2;
                    break;
                }
            case R.id.triangulo:
                if (checked) {
                    Campo1.setVisibility(View.INVISIBLE);
                    Campo2.setVisibility(View.INVISIBLE);
                    Campo3.setVisibility(View.INVISIBLE);
                    Campo4.setVisibility(View.INVISIBLE);
                    tCampo1.setVisibility(View.INVISIBLE);
                    tCampo2.setVisibility(View.INVISIBLE);
                    tCampo3.setVisibility(View.INVISIBLE);
                    tCampo4.setVisibility(View.INVISIBLE);
                    fig = 3;
                    toggle();
                    break;
                }
            case R.id.cubo:
                if (checked) {
                    Campo1.setVisibility(View.VISIBLE);
                    Campo2.setVisibility(View.VISIBLE);
                    Campo3.setVisibility(View.VISIBLE);
                    Campo4.setVisibility(View.INVISIBLE);
                    tCampo1.setVisibility(View.VISIBLE);
                    tCampo2.setVisibility(View.VISIBLE);
                    tCampo3.setVisibility(View.VISIBLE);
                    tCampo4.setVisibility(View.INVISIBLE);
                    tCampo1.setText("Ancho");
                    tCampo2.setText("Largo");
                    tCampo3.setText("Profundidad");
                    fig = 4;

                    break;
                }

        }
    }
    public void calcular(View view) {
        sresultado= "";
        resultado.setText(sresultado);
        if (perimetro.isChecked()) {
            calcularperimetro();

        }
        if (area.isChecked()) {
            calculararea();
        }
        if (volumen.isChecked()) {
            calcularvolumen();
        }
        resultado.setText(sresultado);
        cont=0;
    }



    protected void calcularperimetro(){

        String valor1="",valor2="",valor3="", valor4="";
        if(fig==1 && !Campo1.getText().toString().isEmpty() && !Campo2.getText().toString().isEmpty() ){

            valor1=Campo1.getText().toString();
            valor2=Campo2.getText().toString();
            op1=Float.parseFloat(valor1);
            op2=Float.parseFloat(valor2);
            result=(2*op1)+(2*op2);
            sresultado+= ("Perimetro: "+ (String.valueOf(result))+"\n");
        }

        if(fig==2 && !Campo1.getText().toString().isEmpty()){
            valor1=Campo1.getText().toString();
            op1=Float.parseFloat(valor1);
            result=(2*op1)*((float) Math.PI);
            sresultado+= ("Perimetro: "+ (String.valueOf(result))+"\n");       }
        if(fig==3 && !Campo1.getText().toString().isEmpty() && !Campo2.getText().toString().isEmpty() && !Campo3.getText().toString().isEmpty()){
            valor2=Campo1.getText().toString();
            valor3=Campo2.getText().toString();
            valor4=Campo3.getText().toString();
            op2=Float.parseFloat(valor2);
            op3=Float.parseFloat(valor3);
            op4=Float.parseFloat(valor4);
            result=op2+op3+op4;
            sresultado+= ("Perímetro: "+ (String.valueOf(result))+"\n");
        } if(fig==4 && !Campo1.getText().toString().isEmpty() && Campo2.getText().toString().isEmpty() && !Campo3.getText().toString().isEmpty()){
            valor1=Campo1.getText().toString();
            valor2=Campo2.getText().toString();
            valor3=Campo3.getText().toString();
            op1=Float.parseFloat(valor1);
            op2=Float.parseFloat(valor2);
            op3=Float.parseFloat(valor3);
            result=(4*op1)+(4*op2)+(4*op3);
            sresultado+= ("Perímetro: "+ (String.valueOf(result))+"\n");
        }

    }

    protected void calculararea(){

        String valor1="",valor2="",valor3="", valor4="";
        if(fig==1 && !Campo1.getText().toString().isEmpty() && !Campo2.getText().toString().isEmpty()){
            valor1=Campo1.getText().toString();
            valor2=Campo2.getText().toString();
            op1=Float.parseFloat(valor1);
            op2=Float.parseFloat(valor2);
            result=(op1)*(op2);
            sresultado+= ("Área: "+ (String.valueOf(result))+"\n");
        }

        if(fig==2 && !Campo1.getText().toString().isEmpty()){
            valor1=Campo1.getText().toString();
            op1=Float.parseFloat(valor1);
            result=(op1)*(op1)*((float) Math.PI);
            sresultado+= ("Área: "+ (String.valueOf(result))+"\n");       }
        if(fig==3 && !Campo1.getText().toString().isEmpty() && !Campo4.getText().toString().isEmpty()){
            valor1=Campo1.getText().toString();
            valor2=Campo4.getText().toString();
            op1=Float.parseFloat(valor1);
            op2=Float.parseFloat(valor2);
            result=(op1*op2)/(2);
            sresultado+= ("Área: "+ (String.valueOf(result))+"\n");
        } if(fig==4 && !Campo1.getText().toString().isEmpty() && !Campo2.getText().toString().isEmpty() && !Campo3.getText().toString().isEmpty()){
            valor1=Campo1.getText().toString();
            valor2=Campo2.getText().toString();
            valor3=Campo3.getText().toString();
            op1=Float.parseFloat(valor1);
            op2=Float.parseFloat(valor2);
            op3=Float.parseFloat(valor3);
            result=(2*op1*op1)+(2*op2*op2)+(2*op3*op3);
            sresultado+= ("Área: "+ (String.valueOf(result))+"\n");
        }

    }


    protected void calcularvolumen(){

        String valor1="",valor2="",valor3="", valor4="";
        if(fig==1){
            sresultado+= ("Volumen: Esta figura no posee.\n");
        }

        if(fig==2){
            sresultado+= ("Volumen: Esta figura no posee.\n");
        }
        if(fig==3){
            sresultado+= ("Volumen: Esta figura no posee.\n");

        } if(fig==4 && !Campo1.getText().toString().isEmpty() && !Campo2.getText().toString().isEmpty() && !Campo3.getText().toString().isEmpty()){
            valor1=Campo1.getText().toString();
            valor2=Campo2.getText().toString();
            valor3=Campo3.getText().toString();
            op1=Float.parseFloat(valor1);
            op2=Float.parseFloat(valor2);
            op3=Float.parseFloat(valor3);
            result=(op1)*(op2)*(op3);
            sresultado+= ("Volumen: "+ (String.valueOf(result))+"\n");
        }

    }

    public  void toggle(){

        if(fig==3 && cont==0 && cont2==1){
            Campo1.setVisibility(View.VISIBLE);
            Campo2.setVisibility(View.VISIBLE);
            Campo3.setVisibility(View.VISIBLE);
            Campo4.setVisibility(View.INVISIBLE);
            tCampo1.setVisibility(View.VISIBLE);
            tCampo2.setVisibility(View.VISIBLE);
            tCampo3.setVisibility(View.VISIBLE);
            tCampo4.setVisibility(View.INVISIBLE);
            tCampo1.setText("Lado 1");
            tCampo2.setText("Lado 2");
            tCampo3.setText("Lado 3");
        }

        if(fig==3 && cont==1 && cont2==1){

            Campo1.setVisibility(View.VISIBLE);
            Campo2.setVisibility(View.VISIBLE);
            Campo3.setVisibility(View.VISIBLE);
            Campo4.setVisibility(View.VISIBLE);
            tCampo1.setVisibility(View.VISIBLE);
            tCampo2.setVisibility(View.VISIBLE);
            tCampo3.setVisibility(View.VISIBLE);
            tCampo4.setVisibility(View.VISIBLE);
            tCampo1.setText("Base");
            tCampo2.setText("Lado 2");
            tCampo3.setText("Lado 3");
            tCampo4.setText("Altura");
        }

        if(fig==3 && cont2==0 && cont==1){
            Campo1.setVisibility(View.VISIBLE);
            Campo2.setVisibility(View.INVISIBLE);
            Campo3.setVisibility(View.INVISIBLE);
            Campo4.setVisibility(View.VISIBLE);
            tCampo1.setVisibility(View.VISIBLE);
            tCampo2.setVisibility(View.INVISIBLE);
            tCampo3.setVisibility(View.INVISIBLE);
            tCampo4.setVisibility(View.VISIBLE);
            tCampo1.setText("Base");
            tCampo4.setText("Altura");
        }




    }
}
