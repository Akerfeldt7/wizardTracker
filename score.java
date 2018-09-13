package com.example.panos.wizardtracker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;

public class score extends AppCompatActivity {
    int roundNumber,firstScore,secondScore,thirdScore,forthScore,fifthScore,sixthScore;
    int dealer;
    boolean editButtonClosed;
    boolean okButtonClosed1;
    boolean okButtonClosed2;
    boolean okButtonClosed3;
    boolean okButtonClosed4;
    boolean okButtonClosed5;
    boolean okButtonClosed6;
    boolean lastRound;

    public static final String STATE_FIRST_SCORE="com.example.panos.wizardtracker.FIRST_SCORE";
    public static final String STATE_SECOND_SCORE="com.example.panos.wizardtracker.SECOND_SCORE";
    public static final String STATE_THIRD_SCORE="com.example.panos.wizardtracker.THIRD_SCORE";
    public static final String STATE_FORTH_SCORE="com.example.panos.wizardtracker.FORTH_SCORE";
    public static final String STATE_FIFTH_SCORE="com.example.panos.wizardtracker.FIFTH_SCORE";
    public static final String STATE_SIXTH_SCORE="com.example.panos.wizardtracker.SIXTH_SCORE";
    public static final String STATE_ROUND_NUMBER="com.example.panos.wizardtracker.ROUND_NUMBER";
    public static final String STATE_ROUND_OKBUTTONCLOSED1="com.example.panos.wizardtracker.OKBUTTONCLOSED1";
    public static final String STATE_ROUND_OKBUTTONCLOSED2="com.example.panos.wizardtracker.OKBUTTONCLOSED2";
    public static final String STATE_ROUND_OKBUTTONCLOSED3="com.example.panos.wizardtracker.OKBUTTONCLOSED3";
    public static final String STATE_ROUND_OKBUTTONCLOSED4="com.example.panos.wizardtracker.OKBUTTONCLOSED4";
    public static final String STATE_ROUND_OKBUTTONCLOSED5="com.example.panos.wizardtracker.OKBUTTONCLOSED5";
    public static final String STATE_ROUND_OKBUTTONCLOSED6="com.example.panos.wizardtracker.OKBUTTONCLOSED6";
    public static final String STATE_ROUND_DEALER="com.example.panos.wizardtracker.DEALER";
    public static final String STATE_LAST_ROUND="com.example.panos.wizardtracker.LASTROUND";

    public score() {
        sixthScore=0;
        fifthScore=0;
        forthScore=0;
        thirdScore=0;
        secondScore=0;
        roundNumber=1;
        firstScore=0;
        dealer=1;
        editButtonClosed=true;
        okButtonClosed1=false; okButtonClosed2=false; okButtonClosed3=false; okButtonClosed4=false;
        okButtonClosed5=false; okButtonClosed6=false;
        lastRound=false;


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        if(savedInstanceState!=null){
            firstScore=savedInstanceState.getInt(STATE_FIRST_SCORE,0);
            secondScore=savedInstanceState.getInt(STATE_SECOND_SCORE,0);
            thirdScore=savedInstanceState.getInt(STATE_THIRD_SCORE,0);
            forthScore=savedInstanceState.getInt(STATE_FORTH_SCORE,0);
            fifthScore=savedInstanceState.getInt(STATE_FIFTH_SCORE,0);
            sixthScore=savedInstanceState.getInt(STATE_SIXTH_SCORE,0);
            roundNumber=savedInstanceState.getInt(STATE_ROUND_NUMBER,1);
            okButtonClosed1=savedInstanceState.getBoolean(STATE_ROUND_OKBUTTONCLOSED1);
            okButtonClosed2=savedInstanceState.getBoolean(STATE_ROUND_OKBUTTONCLOSED2);
            okButtonClosed3=savedInstanceState.getBoolean(STATE_ROUND_OKBUTTONCLOSED3);
            okButtonClosed4=savedInstanceState.getBoolean(STATE_ROUND_OKBUTTONCLOSED4);
            okButtonClosed5=savedInstanceState.getBoolean(STATE_ROUND_OKBUTTONCLOSED5);
            okButtonClosed6=savedInstanceState.getBoolean(STATE_ROUND_OKBUTTONCLOSED6);
            dealer=savedInstanceState.getInt(STATE_ROUND_DEALER);
            lastRound=savedInstanceState.getBoolean(STATE_LAST_ROUND);
        }

        Intent intent=getIntent();
        final String name1=intent.getStringExtra(MainActivity.EXTRA_NAME1);
        final String name2=intent.getStringExtra(MainActivity.EXTRA_NAME2);
        final String name3=intent.getStringExtra(MainActivity.EXTRA_NAME3);
        final String name4=intent.getStringExtra(MainActivity.EXTRA_NAME4);
        final String name5=intent.getStringExtra(MainActivity.EXTRA_NAME5);
        final String name6=intent.getStringExtra(MainActivity.EXTRA_NAME6);
        final int numberOfPlayers=intent.getIntExtra(MainActivity.EXTRA_NUMBEROFPLAYERS,0);

        TableRow firstTableRow=(TableRow)findViewById(R.id.firstTableRow);
        TableRow secondTableRow=(TableRow)findViewById(R.id.secondTableRow);
        TableRow thirdTableRow=(TableRow)findViewById(R.id.thirdTableRow);
        TableRow forthTableRow=(TableRow)findViewById(R.id.forthTableRow);
        TableRow fifthTableRow=(TableRow)findViewById(R.id.fifthTableRow);
        TableRow sixthTableRow=(TableRow)findViewById(R.id.sixthTableRow);

        final TextView firstName=(TextView)findViewById(R.id.firstName);
        final TextView secondName=(TextView) findViewById(R.id.secondName);
        final TextView thirdName=(TextView) findViewById(R.id.thirdName);
        final TextView forthName=(TextView) findViewById(R.id.forthName);
        final TextView fifthName=(TextView) findViewById(R.id.fifthName);
        final TextView sixthName=(TextView) findViewById(R.id.sixthName);

        if (numberOfPlayers==3){
            firstTableRow.setVisibility(View.VISIBLE);
            firstName.setText(name1);
            secondTableRow.setVisibility(View.VISIBLE);
            secondName.setText(name2);
            thirdTableRow.setVisibility(View.VISIBLE);
            thirdName.setText(name3);
            forthTableRow.setVisibility(View.INVISIBLE);
            fifthTableRow.setVisibility(View.INVISIBLE);
            sixthTableRow.setVisibility(View.INVISIBLE);
            okButtonClosed4=true;
            okButtonClosed5=true;
            okButtonClosed6=true;
        }
        else if(numberOfPlayers==4){
            firstTableRow.setVisibility(View.VISIBLE);
            firstName.setText(name1);
            secondTableRow.setVisibility(View.VISIBLE);
            secondName.setText(name2);
            thirdTableRow.setVisibility(View.VISIBLE);
            thirdName.setText(name3);
            forthTableRow.setVisibility(View.VISIBLE);
            forthName.setText(name4);
            fifthTableRow.setVisibility(View.INVISIBLE);
            sixthTableRow.setVisibility(View.INVISIBLE);
            okButtonClosed5=true;
            okButtonClosed6=true;
        }
        else if(numberOfPlayers==5){
            firstTableRow.setVisibility(View.VISIBLE);
            firstName.setText(name1);
            secondTableRow.setVisibility(View.VISIBLE);
            secondName.setText(name2);
            thirdTableRow.setVisibility(View.VISIBLE);
            thirdName.setText(name3);
            forthTableRow.setVisibility(View.VISIBLE);
            forthName.setText(name4);
            fifthTableRow.setVisibility(View.VISIBLE);
            fifthName.setText(name5);
            sixthTableRow.setVisibility(View.INVISIBLE);
            okButtonClosed6=true;
        }
        else if(numberOfPlayers==6){
            firstTableRow.setVisibility(View.VISIBLE);
            firstName.setText(name1);
            secondTableRow.setVisibility(View.VISIBLE);
            secondName.setText(name2);
            thirdTableRow.setVisibility(View.VISIBLE);
            thirdName.setText(name3);
            forthTableRow.setVisibility(View.VISIBLE);
            forthName.setText(name4);
            fifthTableRow.setVisibility(View.VISIBLE);
            fifthName.setText(name5);
            sixthTableRow.setVisibility(View.VISIBLE);
            sixthName.setText(name6);
        }

        set_dealer(firstName,secondName,thirdName,forthName,fifthName,sixthName);







        final EditText firstSaid=(EditText)findViewById(R.id.firstSaid);
        final EditText firstDone=(EditText)findViewById(R.id.firstDone);
        final EditText secondSaid=(EditText)findViewById(R.id.secondSaid);
        final EditText secondDone=(EditText)findViewById(R.id.secondDone);
        final EditText thirdSaid=(EditText)findViewById(R.id.thirdSaid);
        final EditText thirdDone=(EditText)findViewById(R.id.thirdDone);
        final EditText forthSaid=(EditText)findViewById(R.id.forthSaid);
        final EditText forthDone=(EditText)findViewById(R.id.forthDone);
        final EditText fifthSaid=(EditText)findViewById(R.id.fifthSaid);
        final EditText fifthDone=(EditText)findViewById(R.id.fifthDone);
        final EditText sixthSaid=(EditText)findViewById(R.id.sixthSaid);
        final EditText sixthDone=(EditText)findViewById(R.id.sixthDone);

        final TextView firstSum=(TextView)findViewById(R.id.firstSum);
        final TextView secondSum=(TextView)findViewById(R.id.secondSum);
        final TextView thirdSum=(TextView)findViewById(R.id.thirdSum);
        final TextView forthSum=(TextView)findViewById(R.id.forthSum);
        final TextView fifthSum=(TextView)findViewById(R.id.fifthSum);
        final TextView sixthSum=(TextView)findViewById(R.id.sixthSum);

        firstSum.setText(String.valueOf(firstScore));
        secondSum.setText(String.valueOf(secondScore));
        thirdSum.setText(String.valueOf(thirdScore));
        forthSum.setText(String.valueOf(forthScore));
        fifthSum.setText(String.valueOf(fifthScore));
        sixthSum.setText(String.valueOf(sixthScore));


        final Button firstOk=(Button)findViewById(R.id.firstOk);
        final Button secondOk=(Button)findViewById(R.id.secondOk);
        final Button thirdOk=(Button)findViewById(R.id.thirdOk);
        final Button forthOk=(Button)findViewById(R.id.forthOk);
        final Button fifthOk=(Button)findViewById(R.id.fifthOk);
        final Button sixthOk=(Button)findViewById(R.id.sixthOk);
        final Button nextRoundButton=(Button)findViewById(R.id.nextRoundButton);

        if(okButtonClosed1==true){
            firstOk.setEnabled(false);
        }
        if(okButtonClosed2==true){
            secondOk.setEnabled(false);
        }
        if(okButtonClosed3==true){
            thirdOk.setEnabled(false);
        }
        if(okButtonClosed4==true){
            forthOk.setEnabled(false);
        }
        if(okButtonClosed5==true){
            fifthOk.setEnabled(false);
        }
        if(okButtonClosed6==true){
            sixthOk.setEnabled(false);
        }

        nextRoundButton.setEnabled(false);
        if(numberOfPlayers==3 && okButtonClosed1 && okButtonClosed2 && okButtonClosed3){
            nextRoundButton.setEnabled(true);
        }
        else if(numberOfPlayers==4 && okButtonClosed1 && okButtonClosed2 && okButtonClosed3 && okButtonClosed4){
            nextRoundButton.setEnabled(true);
        }
        else if(numberOfPlayers==5 && okButtonClosed1 && okButtonClosed2 && okButtonClosed3 && okButtonClosed4
                && okButtonClosed5){
            nextRoundButton.setEnabled(true);
        }
        else if(numberOfPlayers==6 && okButtonClosed1 && okButtonClosed2 && okButtonClosed3 && okButtonClosed4
                && okButtonClosed5 && okButtonClosed6){
            nextRoundButton.setEnabled(true);
        }


        firstOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int said=0,done=0,sum=0;
                if(!firstSaid.getText().toString().matches("") && !firstDone.getText().toString().matches("")) {
                 said = Integer.parseInt(firstSaid.getText().toString());
                 done = Integer.parseInt(firstDone.getText().toString());
                 sum = Integer.parseInt(firstSum.getText().toString());

                 firstScore=calculate(said,done,sum);
                 firstSum.setText(String.valueOf(firstScore));
                 firstOk.setEnabled(false);
                 okButtonClosed1=true;
                 if(okButtonClosed1 && okButtonClosed2 &&okButtonClosed3 &&okButtonClosed4 && okButtonClosed5 &&okButtonClosed6){
                    nextRoundButton.setEnabled(true);
                 }
                 firstSaid.setText(null);
                 firstDone.setText(null);
                }


            }
        });

        secondOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int said=0,done=0,sum=0;
                if(!secondSaid.getText().toString().matches("") && !secondDone.getText().toString().matches("")) {
                    said = Integer.parseInt(secondSaid.getText().toString());
                    done = Integer.parseInt(secondDone.getText().toString());
                    sum = Integer.parseInt(secondSum.getText().toString());

                    secondScore = calculate(said, done, sum);
                    secondSum.setText(String.valueOf(secondScore));
                    secondOk.setEnabled(false);
                    okButtonClosed2=true;
                    if(okButtonClosed1 && okButtonClosed2 &&okButtonClosed3 &&okButtonClosed4 && okButtonClosed5 &&okButtonClosed6) {
                        nextRoundButton.setEnabled(true);
                    }
                    secondSaid.setText(null);
                    secondDone.setText(null);
                }

            }
        });

        thirdOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int said=0,done=0,sum=0;
                if(!thirdSaid.getText().toString().matches("") && !thirdDone.getText().toString().matches("")) {
                    said = Integer.parseInt(thirdSaid.getText().toString());
                    done = Integer.parseInt(thirdDone.getText().toString());
                    sum = Integer.parseInt(thirdSum.getText().toString());

                    thirdScore = calculate(said, done, sum);
                    thirdSum.setText(String.valueOf(thirdScore));
                    thirdOk.setEnabled(false);
                    okButtonClosed3=true;
                    if(okButtonClosed1 && okButtonClosed2 &&okButtonClosed3 &&okButtonClosed4 && okButtonClosed5 &&okButtonClosed6) {
                        nextRoundButton.setEnabled(true);
                    }

                    thirdSaid.setText(null);
                    thirdDone.setText(null);
                }

            }
        });

        forthOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int said=0,done=0,sum=0;
                if(!forthSaid.getText().toString().matches("") && !forthDone.getText().toString().matches("")) {
                    said = Integer.parseInt(forthSaid.getText().toString());
                    done = Integer.parseInt(forthDone.getText().toString());
                    sum = Integer.parseInt(forthSum.getText().toString());

                    forthScore = calculate(said, done, sum);
                    forthSum.setText(String.valueOf(forthScore));
                    forthOk.setEnabled(false);
                    okButtonClosed4=true;
                    if(okButtonClosed1 && okButtonClosed2 &&okButtonClosed3 &&okButtonClosed4 && okButtonClosed5 &&okButtonClosed6) {
                        nextRoundButton.setEnabled(true);
                    }

                    forthSaid.setText(null);
                    forthDone.setText(null);
                }

            }
        });

        fifthOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int said=0,done=0,sum=0;
                if(!fifthSaid.getText().toString().matches("") && !fifthDone.getText().toString().matches("")) {
                    said = Integer.parseInt(fifthSaid.getText().toString());
                    done = Integer.parseInt(fifthDone.getText().toString());
                    sum = Integer.parseInt(fifthSum.getText().toString());

                    fifthScore = calculate(said, done, sum);
                    fifthSum.setText(String.valueOf(fifthScore));
                    fifthOk.setEnabled(false);
                    okButtonClosed5=true;
                    if(okButtonClosed1 && okButtonClosed2 &&okButtonClosed3 &&okButtonClosed4 && okButtonClosed5 &&okButtonClosed6) {
                        nextRoundButton.setEnabled(true);
                    }
                    fifthSaid.setText(null);
                    fifthDone.setText(null);
                }

            }
        });

        sixthOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int said=0,done=0,sum=0;
                if(!sixthSaid.getText().toString().matches("") && !sixthDone.getText().toString().matches("")) {
                    said = Integer.parseInt(sixthSaid.getText().toString());
                    done = Integer.parseInt(sixthDone.getText().toString());
                    sum = Integer.parseInt(sixthSum.getText().toString());

                    sixthScore = calculate(said, done, sum);
                    sixthSum.setText(String.valueOf(sixthScore));
                    sixthOk.setEnabled(false);
                    okButtonClosed6=true;
                    if(okButtonClosed1 && okButtonClosed2 &&okButtonClosed3 &&okButtonClosed4 && okButtonClosed5 &&okButtonClosed6) {
                        nextRoundButton.setEnabled(true);
                    }
                    sixthSaid.setText(null);
                    sixthDone.setText(null);
                }

            }
        });

        final TextView roundNumberTextview=(TextView)findViewById(R.id.roundNumber);
        roundNumberTextview.setText(String.valueOf(roundNumber));


        nextRoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lastRound){
                    who_is_the_best(numberOfPlayers,name1,name2,name3,name4,name5,name6);
                    //TODO AN MPEI EDO META APO AUTO PREPEI NA KLEISEI I EFARMOGI
                }

                roundNumber++;
                roundNumberTextview.setText(String.valueOf(roundNumber));
                firstOk.setEnabled(true);
                secondOk.setEnabled(true);
                thirdOk.setEnabled(true);
                forthOk.setEnabled(true);
                fifthOk.setEnabled(true);
                sixthOk.setEnabled(true);
                if(numberOfPlayers==3){
                    okButtonClosed1=false;
                    okButtonClosed2=false;
                    okButtonClosed3=false;
                    if(dealer==3){
                        dealer=1;
                    }
                    else{
                        dealer++;
                    }
                    set_dealer(firstName,secondName,thirdName,forthName,fifthName,sixthName);

                }
                else if(numberOfPlayers==4){
                    okButtonClosed1=false;
                    okButtonClosed2=false;
                    okButtonClosed3=false;
                    okButtonClosed4=false;
                    if(dealer==4){
                        dealer=1;
                    }
                    else{
                        dealer++;
                    }
                    set_dealer(firstName,secondName,thirdName,forthName,fifthName,sixthName);
                }
                else if(numberOfPlayers==5){
                    okButtonClosed1=false;
                    okButtonClosed2=false;
                    okButtonClosed3=false;
                    okButtonClosed4=false;
                    okButtonClosed5=false;
                    if(dealer==5){
                        dealer=1;
                    }
                    else{
                        dealer++;
                    }
                    set_dealer(firstName,secondName,thirdName,forthName,fifthName,sixthName);
                }
                else if(numberOfPlayers==6){
                    okButtonClosed1=false;
                    okButtonClosed2=false;
                    okButtonClosed3=false;
                    okButtonClosed4=false;
                    okButtonClosed5=false;
                    okButtonClosed6=false;
                    if(dealer==6){
                        dealer=1;
                    }
                    else{
                        dealer++;
                    }
                    set_dealer(firstName,secondName,thirdName,forthName,fifthName,sixthName);
                }


                nextRoundButton.setEnabled(false);



                if(60/numberOfPlayers==roundNumber){
                    nextRoundButton.setText("FINISH");
                    lastRound=true;
                }


            }
        });

        final EditText choiceNumber=(EditText)findViewById(R.id.choiceNumber);
        final EditText newSumNumber=(EditText)findViewById(R.id.newSumNumber);

        final Button editScore=(Button)findViewById(R.id.editScore);



        editScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editButtonClosed){
                    editScore.setText("Close Edit");
                    choiceNumber.setVisibility(View.VISIBLE);
                    newSumNumber.setVisibility(View.VISIBLE);
                    editButtonClosed=false;

                    newSumNumber.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                        @Override
                        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                            boolean handled=false;


                            if(i== EditorInfo.IME_ACTION_DONE){
                                int newSum=Integer.parseInt(newSumNumber.getText().toString());

                                if( Integer.parseInt(choiceNumber.getText().toString())==1 ){
                                   firstSum.setText(String.valueOf(newSum));
                                   firstScore=newSum;
                                }
                                else if(Integer.parseInt(choiceNumber.getText().toString())==2){
                                    secondSum.setText(String.valueOf(newSum));
                                    secondScore=newSum;
                                }
                                else if(Integer.parseInt(choiceNumber.getText().toString())==3){
                                    thirdSum.setText(String.valueOf(newSum));
                                    thirdScore=newSum;
                                }
                                else if(Integer.parseInt(choiceNumber.getText().toString())==4){
                                    forthSum.setText(String.valueOf(newSum));
                                    forthScore=newSum;
                                }
                                else if(Integer.parseInt(choiceNumber.getText().toString())==5){
                                    fifthSum.setText(String.valueOf(newSum));
                                    fifthScore=newSum;
                                }
                                else if(Integer.parseInt(choiceNumber.getText().toString())==6){
                                    sixthSum.setText(String.valueOf(newSum));
                                    sixthScore=newSum;
                                }
                            }
                            handled=true;


                            return false;
                        }
                    });



                }
                else{
                    editScore.setText("EDIT");
                    choiceNumber.setVisibility(View.INVISIBLE);
                    newSumNumber.setVisibility(View.INVISIBLE);
                    editButtonClosed=true;
                    choiceNumber.setText(null);
                    newSumNumber.setText(null);
                }

            }
        });






    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_ROUND_NUMBER,roundNumber);
        outState.putInt(STATE_FIRST_SCORE,firstScore);
        outState.putInt(STATE_SECOND_SCORE,secondScore);
        outState.putInt(STATE_THIRD_SCORE,thirdScore);
        outState.putInt(STATE_FORTH_SCORE,forthScore);
        outState.putInt(STATE_FIFTH_SCORE,fifthScore);
        outState.putInt(STATE_SIXTH_SCORE,sixthScore);
        outState.putBoolean(STATE_ROUND_OKBUTTONCLOSED1,okButtonClosed1);
        outState.putBoolean(STATE_ROUND_OKBUTTONCLOSED2,okButtonClosed2);
        outState.putBoolean(STATE_ROUND_OKBUTTONCLOSED3,okButtonClosed3);
        outState.putBoolean(STATE_ROUND_OKBUTTONCLOSED4,okButtonClosed4);
        outState.putBoolean(STATE_ROUND_OKBUTTONCLOSED5,okButtonClosed5);
        outState.putBoolean(STATE_ROUND_OKBUTTONCLOSED6,okButtonClosed6);
        outState.putInt(STATE_ROUND_DEALER,dealer);
        outState.putBoolean(STATE_LAST_ROUND,lastRound);
    }

    @Override
    public void onBackPressed(){
        new AlertDialog.Builder(this).setTitle("Really EXIT?").setMessage("Are you sure you want to exit?").setNegativeButton(android.R.string.no,null).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                score.super.onBackPressed();
            }
        }).create().show();
    }

    private int calculate(int said, int done, int sum){
        int score;
        if(said==done){
            score=20+said*10;
        }
        else{
            score=Math.abs(said-done)*(-10);
        }
        score=sum+score;
        return score;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private int you_cant_say(EditText fs,EditText ss, EditText ts, EditText fos, EditText fis, EditText sis){ //DEN XRISIMOPOIEITAI KAPOU
        if(!fs.getText().toString().matches("") && !ss.getText().toString().matches("") &&
                !ts.getText().toString().matches("") && !fos.getText().toString().matches("") &&
                !fis.getText().toString().matches("") && !sis.getText().toString().matches("")){
            int sum,ycs;
            sum=Integer.parseInt(fs.getText().toString())+Integer.parseInt(ss.getText().toString())
            +Integer.parseInt(ts.getText().toString())+Integer.parseInt(fos.getText().toString())
            +Integer.parseInt(fis.getText().toString())+Integer.parseInt(sis.getText().toString());

            ycs=Math.abs(sum-roundNumber);
            return ycs;

        }

        return -1;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void set_dealer(TextView t1,TextView t2, TextView t3,TextView t4,TextView t5, TextView t6){

        if(dealer==1){
            t1.setTextColor(getResources().getColor(R.color.red_Text));

            t2.setTextColor(getResources().getColor(R.color.black));

            t3.setTextColor(getResources().getColor(R.color.black));

            t4.setTextColor(getResources().getColor(R.color.black));

            t5.setTextColor(getResources().getColor(R.color.black));

            t6.setTextColor(getResources().getColor(R.color.black));

        }
        else if(dealer==2){
            t2.setTextColor(getResources().getColor(R.color.red_Text));

            t1.setTextColor(getResources().getColor(R.color.black));

            t3.setTextColor(getResources().getColor(R.color.black));

            t4.setTextColor(getResources().getColor(R.color.black));

            t5.setTextColor(getResources().getColor(R.color.black));

            t6.setTextColor(getResources().getColor(R.color.black));


        }
        else if(dealer==3){
            t3.setTextColor(getResources().getColor(R.color.red_Text));

            t2.setTextColor(getResources().getColor(R.color.black));

            t1.setTextColor(getResources().getColor(R.color.black));

            t4.setTextColor(getResources().getColor(R.color.black));

            t5.setTextColor(getResources().getColor(R.color.black));

            t6.setTextColor(getResources().getColor(R.color.black));


        }
        else if(dealer==4){
            t4.setTextColor(getResources().getColor(R.color.red_Text));

            t2.setTextColor(getResources().getColor(R.color.black));

            t3.setTextColor(getResources().getColor(R.color.black));

            t1.setTextColor(getResources().getColor(R.color.black));

            t5.setTextColor(getResources().getColor(R.color.black));

            t6.setTextColor(getResources().getColor(R.color.black));


        }
        else if(dealer==5){
            t5.setTextColor(getResources().getColor(R.color.red_Text));

            t2.setTextColor(getResources().getColor(R.color.black));

            t3.setTextColor(getResources().getColor(R.color.black));

            t4.setTextColor(getResources().getColor(R.color.black));

            t1.setTextColor(getResources().getColor(R.color.black));

            t6.setTextColor(getResources().getColor(R.color.black));


        }
        else if(dealer==6){
            t6.setTextColor(getResources().getColor(R.color.red_Text));

            t2.setTextColor(getResources().getColor(R.color.black));

            t3.setTextColor(getResources().getColor(R.color.black));

            t4.setTextColor(getResources().getColor(R.color.black));

            t5.setTextColor(getResources().getColor(R.color.black));

            t1.setTextColor(getResources().getColor(R.color.black));


        }
    }

    protected void who_is_the_best(int number_of_players,String n1,String n2,String n3,String n4,String n5,String n6){

        int i,key,j;
        String key_name;
        int[] arr;
        String[] name;
        boolean draw=false;


        arr=new int[number_of_players];
        name=new String[number_of_players];

        if(number_of_players==3){
            arr[0]=firstScore;
            name[0]=n1;
            arr[1]=secondScore;
            name[1]=n2;
            arr[2]=thirdScore;
            name[2]=n3;
        }
        else if(number_of_players==4){
            arr[0]=firstScore;
            name[0]=n1;
            arr[1]=secondScore;
            name[1]=n2;
            arr[2]=thirdScore;
            name[2]=n3;
            arr[3]=forthScore;
            name[3]=n4;
        }
        else if(number_of_players==5){
            arr[0]=firstScore;
            name[0]=n1;
            arr[1]=secondScore;
            name[1]=n2;
            arr[2]=thirdScore;
            name[2]=n3;
            arr[3]=forthScore;
            name[3]=n4;
            arr[4]=fifthScore;
            name[4]=n5;
        }
        else if(number_of_players==6){
            arr[0]=firstScore;
            name[0]=n1;
            arr[1]=secondScore;
            name[1]=n2;
            arr[2]=thirdScore;
            name[2]=n3;
            arr[3]=forthScore;
            name[3]=n4;
            arr[4]=fifthScore;
            name[4]=n5;
            arr[5]=sixthScore;
            name[5]=n6;
        }



        //TODO AN UPARKSEI ISOPALIA





        if(!draw){
            //insertion sort
            for(i=1;i<number_of_players;i++){
                key=arr[i];
                key_name=name[i];
                j=i-1;
                while(j>=0 &&arr[j]>key){
                    arr[j+1]=arr[j];
                    name[j+1]=name[j];
                    j=j-1;
                }
                arr[j+1]=key;
                name[j+1]=key_name;
            }
            ///////////////////////////////////////////////
            String max_score;
            max_score="you did it "+name[number_of_players-1]+" with score "+arr[number_of_players-1];
            new AlertDialog.Builder(this).setTitle("WINNER").setMessage(max_score).setNegativeButton(android.R.string.no,null).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                   //TODO kanonika prepei na kleinei tin efarmogi
                }
            }).create().show();
        }
        else{
            new AlertDialog.Builder(this).setTitle("DRAW").setMessage("DRAW").setNegativeButton(android.R.string.no,null).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //TODO kanonika prepei na kleinei tin efarmogi
                }
            }).create().show();
        }


    }
}
