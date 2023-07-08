package com.example.dzidzi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


public class FeedbackFragment extends Fragment {
    Context context;
    Button feedbackBtn;
    TextInputEditText input1;
    TextInputEditText input2;
    RadioGroup radiogroup;

    public FeedbackFragment(Context context) {
        this.context = context;
    }

    TextView feedbackHeader;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feedback, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        feedbackHeader = view.findViewById(R.id.feedbackHeader);
        feedbackBtn = view.findViewById(R.id.feedbackbutton);
        input1 = view.findViewById(R.id.input1);
        input2 = view.findViewById(R.id.input2);
        radiogroup = view.findViewById(R.id.radioGroupId);


        feedbackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input1.getText().equals("") || input2.getText().equals("") || radiogroup.getCheckedRadioButtonId() != -1) {
                    Toast.makeText(context, "Thanks for the feedback", Toast.LENGTH_SHORT).show();
                } else {
                    input1.setText("");
                    input2.setText("");
                    radiogroup.clearCheck();
                    Toast.makeText(context, "Kindly enter data", Toast.LENGTH_SHORT).show();
                }
            }
        });
        feedbackHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, MainActivity.class);
                context.startActivity(i);
            }
        });

    }
}