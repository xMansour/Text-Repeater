package com.example.mansour.annoythem_textrepeater;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static Boolean setNewLine = false;
    Button mBtnProduce;
    FloatingActionButton mBtnFloatingCopy;
    EditText mTextWordToBeCopied;
    EditText mTextNumberOfIterations;
    EditText mTextOutput;
    CheckBox mCheckBoxNewLine;
    String mRepeatedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnProduce = (Button) findViewById(R.id.btnProduce);
        mTextWordToBeCopied = (EditText) findViewById(R.id.textWordToBeCopied);
        mTextNumberOfIterations = (EditText) findViewById(R.id.textNumberOfIterations);
        mTextOutput = (EditText) findViewById(R.id.textOutput);
        mCheckBoxNewLine = (CheckBox) findViewById(R.id.checkBoxNewLine);
        mBtnFloatingCopy = (FloatingActionButton) findViewById(R.id.btnFloatingCopy);

        mBtnProduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTextWordToBeCopied.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Type something to be copied!", Toast.LENGTH_SHORT).show();
                    mTextWordToBeCopied.setText("TYPE SOMETHING!");
                }else if(mTextNumberOfIterations.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Enter the number of copies", Toast.LENGTH_SHORT).show();
                }
                else {
                    String mText = mTextWordToBeCopied.getText().toString();
                    int mNumberOfIterations = Integer.parseInt(mTextNumberOfIterations.getText().toString());
                    mRepeatedText = StringUtils.repeat(mText, mNumberOfIterations);
                    mTextOutput.setText(mRepeatedText);
                }
            }
        });

        mCheckBoxNewLine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                setNewLine = !setNewLine;
            }
        });

        mBtnFloatingCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Repeated Text", mRepeatedText);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(MainActivity.this, "Text Copied To Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
