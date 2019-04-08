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
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import org.pursuit.billandtedsexcellentapp.R;

import java.util.Arrays;
import java.util.Collections;

import pl.droidsonroids.gif.GifImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment implements QuestionFragmentInterface{

    private QuestionFragmentInterface questionFragmentInterface;
    private View answerLayout;
    private TextView answerTextView;
    private GifImageView answerImageView;
    private Button questionButton;
    private RadioButton question1answer1, question1answer2, question1answer3, question1answer4,
            question2answer1, question2answer2, question2answer3, question2answer4,
            question3answer1, question3answer2, question3answer3, question3answer4,
            question4answer1, question4answer2, question4answer3, question4answer4,
            question5answer1, question5answer2, question5answer3, question5answer4;

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
        answerImageView = view.findViewById(R.id.answer_layout_image);
        question1answer1 = view.findViewById(R.id.question1_answer1);
        question1answer2 = view.findViewById(R.id.question1_answer2);
        question1answer3 = view.findViewById(R.id.question1_answer3);
        question1answer4 = view.findViewById(R.id.question1_answer4);
        question2answer1 =  view.findViewById(R.id.question2_answer1);
        question2answer2 = view.findViewById(R.id.question2_answer2);
        question2answer3 = view.findViewById(R.id.question2_answer3);
        question2answer4 = view.findViewById(R.id.question2_answer4);
        question3answer1 = view.findViewById(R.id.question3_answer1);
        question3answer2 = view.findViewById(R.id.question3_answer2);
        question3answer3 = view.findViewById(R.id.question3_answer3);
        question3answer4 = view.findViewById(R.id.question3_answer4);
        question4answer1 = view.findViewById(R.id.question4_answer1);
        question4answer2 = view.findViewById(R.id.question4_answer2);
        question4answer3 = view.findViewById(R.id.question4_answer3);
        question4answer4 = view.findViewById(R.id.question4_answer4);
        question5answer1 = view.findViewById(R.id.question5_answer1);
        question5answer2 = view.findViewById(R.id.question5_answer2);
        question5answer3 = view.findViewById(R.id.question5_answer3);
        question5answer4 = view.findViewById(R.id.question5_answer4);

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
        int maxCount;
        if (question1answer1.isChecked()) {
            tedCounter++;
        } else if (question1answer2.isChecked()) {
            napoleonCounter++;
        } else if (question1answer3.isChecked()) {
            deathCounter++;
        } else if (question1answer4.isChecked()) {
            stationCounter++;
        }

        if (question2answer1.isChecked()) {
            tedCounter++;
        } else if (question2answer2.isChecked()) {
            napoleonCounter++;
        } else if (question2answer3.isChecked()) {
            deathCounter++;
        } else if (question2answer4.isChecked()) {
            stationCounter++;
        }

        if (question3answer1.isChecked()) {
            tedCounter++;
        } else if (question3answer2.isChecked()) {
            napoleonCounter++;
        } else if (question3answer3.isChecked()) {
            deathCounter++;
        } else if (question3answer4.isChecked()) {
            stationCounter++;
        }

        if (question4answer1.isChecked()) {
            tedCounter++;
        } else if (question4answer2.isChecked()) {
            napoleonCounter++;
        } else if (question4answer3.isChecked()) {
            deathCounter++;
        } else if (question4answer4.isChecked()) {
            stationCounter++;
        }

        if (question5answer1.isChecked()) {
            tedCounter++;
        } else if (question5answer2.isChecked()) {
            napoleonCounter++;
        } else if (question5answer3.isChecked()) {
            deathCounter++;
        } else if (question5answer4.isChecked()) {
            stationCounter++;
        }

        maxCount = Collections.max(Arrays.asList(tedCounter,napoleonCounter,deathCounter,stationCounter));

        if (maxCount == tedCounter) {
            answerTextView.setText("Whoa, you are Ted, dude!");
            answerImageView.setImageResource(R.drawable.keanuwhoa);
        } else if (maxCount == napoleonCounter) {
            answerTextView.setText("Sacre bleu! Vous etes Napoleon!");
            answerImageView.setImageResource(R.drawable.triumphnapoleon);
        } else if (maxCount == deathCounter) {
            answerTextView.setText("Get down with your bad self, Death!");
            answerImageView.setImageResource(R.drawable.deathonstage);
        } else if (maxCount == stationCounter) {
            answerTextView.setText("STATION!!!");
            answerImageView.setImageResource(R.drawable.station);
        }

    }
}
