package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView questionText;
    private RadioGroup answerGroup;
    private Button submitButton;
    private TextView finalScoreText;

    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionText = findViewById(R.id.question_text);
        answerGroup = findViewById(R.id.answer_group);
        submitButton = findViewById(R.id.submit_button);
        finalScoreText = findViewById(R.id.final_score);

        questions = getQuestions();
        showNextQuestion();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            questionText.setText(currentQuestion.getQuestionText());

            answerGroup.clearCheck();
            ((RadioButton) answerGroup.getChildAt(0)).setText(currentQuestion.getAnswers()[0]);
            ((RadioButton) answerGroup.getChildAt(1)).setText(currentQuestion.getAnswers()[1]);
            ((RadioButton) answerGroup.getChildAt(2)).setText(currentQuestion.getAnswers()[2]);
            ((RadioButton) answerGroup.getChildAt(3)).setText(currentQuestion.getAnswers()[3]);
        } else {
            endQuiz();
        }
    }

    private void checkAnswer() {
        int selectedAnswerIndex = answerGroup.indexOfChild(findViewById(answerGroup.getCheckedRadioButtonId()));
        if (selectedAnswerIndex == questions.get(currentQuestionIndex).getCorrectAnswerIndex()) {
            score++;
        }

        currentQuestionIndex++;
        showNextQuestion();
    }

    private void endQuiz() {
        questionText.setVisibility(View.GONE);
        answerGroup.setVisibility(View.GONE);
        submitButton.setVisibility(View.GONE);
        finalScoreText.setVisibility(View.VISIBLE);

        String result = "Twój wynik wynosi: " + score + "/" + questions.size();
        finalScoreText.setText(result);
    }

    private List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Jaka jest przybliżona długość równika?", new String[]{"30000km", "40000km", "45000km", "35000km"}, 1));
        questions.add(new Question("Który kraj jest największy pod względem powierzchni?", new String[]{"Chiny", "Kanada", "Rosja", "USA"}, 2));
        questions.add(new Question("Jakie jest najwyższe zwierzę na świecie?", new String[]{"Słoń", "Żyrafa", "Tygrys", "Lew"}, 1));
        questions.add(new Question("Która rzeka jest najdłuższa na świecie?", new String[]{"Nil", "Amazonka", "Jangcy", "Missisipi"}, 0));
        questions.add(new Question("Kto wynalazł żarówkę?", new String[]{"Nikola Tesla", "Isaac Newton", "Thomas Edison", "Albert Einstein"}, 2));
        questions.add(new Question("Jakie zwierzę jest symbolem Australii?", new String[]{"Koala", "Orzeł", "Kangur", "Struś"}, 2));
        questions.add(new Question("Który pierwiastek ma symbol 'Fe'?", new String[]{"Cynk", "Złoto", "Srebro", "Żelazo"}, 3));
        questions.add(new Question("Jakie jest największe jezioro na świecie?", new String[]{"Michigan", "Wiktorii", "Bajkał", "Morze Kaspijskie"}, 3));
        questions.add(new Question("Ile wynosi liczba pi (π) w przybliżeniu?", new String[]{"3.12", "3.14", "3.16", "3.18"}, 1));
        questions.add(new Question("Jak nazywa się proces przekształcania cieczy w gaz?", new String[]{"Kondensacja", "Parowanie", "Sublimacja", "Krystalizacja"}, 1));
        return questions;
    }
}