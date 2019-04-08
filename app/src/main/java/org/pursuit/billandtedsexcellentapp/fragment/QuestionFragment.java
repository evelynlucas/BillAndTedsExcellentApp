package org.pursuit.billandtedsexcellentapp.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import org.pursuit.billandtedsexcellentapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment implements QuestionFragmentInterface{

    private QuestionFragmentInterface questionFragmentInterface;
    private View answerLayout;
    private TextView answerTextView;
    private Button questionButton;
    private RadioButton question1answer1, question1answer2, question1answer3, question1answer4;


    public QuestionFragment() {
        // Required empty public constructor
    }

    public static QuestionFragment newInstance() {

        Bundle args = new Bundle();

        QuestionFragment fragment = new QuestionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof QuestionFragmentInterface) {
            questionFragmentInterface = (QuestionFragmentInterface) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        questionFragmentInterface = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        answerLayout = view.findViewById(R.id.answer_replacement_layout);
        answerTextView = view.findViewById(R.id.answer_layout_text);
        question1answer1 = view.findViewById(R.id.question1_answer1);
        question1answer2 = view.findViewById(R.id.question1_answer2);
        question1answer3 = view.findViewById(R.id.question1_answer3);
        question1answer4 = view.findViewById(R.id.question1_answer4);
        questionButton = view.findViewById(R.id.question_button);
        questionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCharacter();
                //
                changeVisibility();
            }
        });

        // LOGIC TO TAKE ANSWERS FROM RADIO BUTTON QUESTIONS
    }

    @Override
    public void changeVisibility() {
        Button returnToQuestionsButton = answerLayout.findViewById(R.id.answer_layout_go_back_button);
        returnToQuestionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerLayout.setVisibility(View.INVISIBLE);
            }
        });

        answerLayout.setVisibility(View.VISIBLE);
    }

    public void calculateCharacter() {
        int tedCounter = 0;
        int napoleonCounter = 0;
        int deathCounter = 0;
        int stationCounter = 0;
        if (question1answer1.isChecked()) {
            tedCounter++;
        } else if (question1answer2.isChecked()) {
            napoleonCounter++;
        } else if (question1answer3.isChecked()) {
            deathCounter++;
        } else if (question1answer4.isChecked()) {
            stationCounter++;
        }

        if (tedCounter > 0) {
            answerTextView.setText("Whoa, you are Ted, dude!");
        }
        if (napoleonCounter > 0) {
            answerTextView.setText("Sacre bleu! Vous etes Napoleon!");
        }

    }
}
