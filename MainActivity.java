package com.example.panos.wizardtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NAME1="com.example.panos.wizardtracker.EXTRA_NAME1";
    public static final String EXTRA_NAME2="com.example.panos.wizardtracker.EXTRA_NAME2";
    public static final String EXTRA_NAME3="com.example.panos.wizardtracker.EXTRA_NAME3";
    public static final String EXTRA_NAME4="com.example.panos.wizardtracker.EXTRA_NAME4";
    public static final String EXTRA_NAME5="com.example.panos.wizardtracker.EXTRA_NAME5";
    public static final String EXTRA_NAME6="com.example.panos.wizardtracker.EXTRA_NAME6";
    public static final String EXTRA_NUMBEROFPLAYERS="com.example.panos.wizardtracker.EXTRA_NUMBEROFPLAYERS";


    EditText numberInput;
    EditText firstNameInput;
    EditText secondNameInput;
    EditText thirdNameInput;
    EditText forthNameInput;
    EditText fifthNameInput;
    EditText sixthNameInput;
    Button completeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberInput=findViewById(R.id.numberInput);
        firstNameInput=findViewById(R.id.firstNameInput);
        secondNameInput=findViewById(R.id.secondNameInput);
        thirdNameInput=findViewById(R.id.thirdNameInput);
        forthNameInput=findViewById(R.id.forthNameInput);
        fifthNameInput=findViewById(R.id.fifthNameInput);
        sixthNameInput=findViewById(R.id.sixthNameInput);
        completeButton=findViewById(R.id.completeButton);


        numberInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                boolean handled=false;
                String np= numberInput.getText().toString();
                int numberOfPlayers=Integer.parseInt(np);

                if(i==EditorInfo.IME_ACTION_DONE){
                    completeButton.setEnabled(true);
                    if(numberOfPlayers==3){
                        firstNameInput.setVisibility(View.VISIBLE);
                        secondNameInput.setVisibility(View.VISIBLE);
                        thirdNameInput.setVisibility(View.VISIBLE);
                        forthNameInput.setVisibility(View.INVISIBLE);
                        fifthNameInput.setVisibility(View.INVISIBLE);
                        sixthNameInput.setVisibility(View.INVISIBLE);
                    }
                    else if(numberOfPlayers==4){
                        firstNameInput.setVisibility(View.VISIBLE);
                        secondNameInput.setVisibility(View.VISIBLE);
                        thirdNameInput.setVisibility(View.VISIBLE);
                        forthNameInput.setVisibility(View.VISIBLE);
                        fifthNameInput.setVisibility(View.INVISIBLE);
                        sixthNameInput.setVisibility(View.INVISIBLE);
                    }
                    else if(numberOfPlayers==5){
                        firstNameInput.setVisibility(View.VISIBLE);
                        secondNameInput.setVisibility(View.VISIBLE);
                        thirdNameInput.setVisibility(View.VISIBLE);
                        forthNameInput.setVisibility(View.VISIBLE);
                        fifthNameInput.setVisibility(View.VISIBLE);
                        sixthNameInput.setVisibility(View.INVISIBLE);
                    }
                    else if(numberOfPlayers==6){
                        firstNameInput.setVisibility(View.VISIBLE);
                        secondNameInput.setVisibility(View.VISIBLE);
                        thirdNameInput.setVisibility(View.VISIBLE);
                        forthNameInput.setVisibility(View.VISIBLE);
                        fifthNameInput.setVisibility(View.VISIBLE);
                        sixthNameInput.setVisibility(View.VISIBLE);
                    }
                    else{
                        firstNameInput.setVisibility(View.INVISIBLE);
                        secondNameInput.setVisibility(View.INVISIBLE);
                        thirdNameInput.setVisibility(View.INVISIBLE);
                        forthNameInput.setVisibility(View.INVISIBLE);
                        fifthNameInput.setVisibility(View.INVISIBLE);
                        sixthNameInput.setVisibility(View.INVISIBLE);
                    }
                    handled=true;
                }
                return false;
            }
        });

        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openScoreActivity();
            }
        });


    }
    public void openScoreActivity(){

        int numberOfPlayers=Integer.parseInt(numberInput.getText().toString());
        String name1=firstNameInput.getText().toString();
        String name2=secondNameInput.getText().toString();
        String name3=thirdNameInput.getText().toString();
        String name4=forthNameInput.getText().toString();
        String name5=fifthNameInput.getText().toString();
        String name6=sixthNameInput.getText().toString();


        Intent intent= new Intent(this,score.class);
        intent.putExtra(EXTRA_NAME1,name1);
        intent.putExtra(EXTRA_NAME2,name2);
        intent.putExtra(EXTRA_NAME3,name3);
        intent.putExtra(EXTRA_NAME4,name4);
        intent.putExtra(EXTRA_NAME5,name5);
        intent.putExtra(EXTRA_NAME6,name6);
        intent.putExtra(EXTRA_NUMBEROFPLAYERS,numberOfPlayers);
        startActivity(intent);


    }
}
