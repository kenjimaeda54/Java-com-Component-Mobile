package com.e.componentesbasico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
     private  EditText nome;
     private  TextInputEditText email;
     private  TextView resultado;
     private  CheckBox checkazul;
     private  CheckBox checkvermelho;
     private  CheckBox checkbranco;
     private  CheckBox checkpreto;
     private  TextView cor;
     private  RadioGroup opcaoSexo;
     private  TextView  sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome          = findViewById(R.id.editNome);
        email         = findViewById(R.id.editEmail);
        resultado     = findViewById(R.id.textResultado);
        cor           = findViewById(R.id.textcor);
        checkazul     = findViewById(R.id.checkAzul);
        checkvermelho = findViewById(R.id.checkVermelho);
        checkbranco   = findViewById(R.id.checkBranco);
        checkpreto    = findViewById(R.id.checkPreto);
        opcaoSexo     = findViewById(R.id.opcaoSexo);
        sexo          = findViewById(R.id.textSexo);
        ouvinte();

    }
      public void  enviar(View view){
        String campoNome = nome.getText().toString();
        String campoEmail= email.getText().toString();
        resultado.setText("Nome: "+campoNome+ "\nEmail: "+campoEmail);
        String texto = "Cores selecionado(s):";
        if(checkazul.isChecked()){
           texto +=  "\n azul";

        }
        if(checkvermelho.isChecked()){   //cuidado com os if se tu usar if else,sera uma cadeia dai a variavel texto vai perder valor,com apenas if soma.
          texto +=  "\n vermelho";
        }
        if(checkbranco.isChecked()){
          texto +=  "\n branco";
        }
        if(checkpreto.isChecked()){
          texto += "\n preto";
        }
        cor.setText(texto);//atenção cor.setText precisa estar apos os escopos de decisão para funcionar se estiver antes copilador não entende o que você deseja setar
        limpar();
        }
        public  void ouvinte(){
             opcaoSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                 @Override
                 public void onCheckedChanged(RadioGroup group, int checkedId) {
                     if (checkedId == R.id.radioButtonMasculino) {
                          sexo.setText("Masculino");
                     }else{
                         sexo.setText("Feminino");
                     }
                 }
             });
      }
      public void limpar(){
         nome.setText("");
         email.setText("");
    }

}
