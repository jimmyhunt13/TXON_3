package com.example.taxon_03;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
TextView totalQuestionTextView;
TextView questionTextView;
 Button ansA,ansB,ansC,ansD;
 Button submitBtn;
 int score=0;
 int totalQuestion=QuestionAnswer.question.length;
 int currentQuestionIndex=0;
 String selectedAnswer="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalQuestionTextView=findViewById(R.id.total_que);
        questionTextView=findViewById(R.id.question);
        ansA=findViewById(R.id.ans_A);
        ansB=findViewById(R.id.ans_B);
        ansC=findViewById(R.id.ans_C);
        ansD=findViewById(R.id.ans_D);
        submitBtn=findViewById(R.id.submit_btn);
        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
        totalQuestionTextView.setText("Total question :"+totalQuestion);
        loadNewQuestion();

    }

    @Override
    public void onClick(View view) {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);
       Button clickedButton =(Button) view;
       if(clickedButton.getId()==R.id.submit_btn){
           if(selectedAnswer.equals(QuestionAnswer.correctAnswer[currentQuestionIndex])){
           score++;
       }currentQuestionIndex++;
           loadNewQuestion();
       }
       else{
           selectedAnswer=clickedButton.getText().toString();
           clickedButton.setBackgroundColor(Color.YELLOW);
       }

    }
    void loadNewQuestion(){
        if(currentQuestionIndex==totalQuestion){
            finishQuiz();
            return;
        }
        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
    }
    void finishQuiz(){
    String passStatus="";
    if(score> totalQuestion+0.60){
        passStatus="Passed";
    }
    else{
        passStatus="Passed";
    }
    new AlertDialog.Builder(this)
            .setTitle(passStatus)
            .setMessage("Score is "+score+" out of "+totalQuestion)
            .setPositiveButton("Restart",(dialogInterface,i)->restartQuize())
            .setCancelable(false)
            .show();
    }
void restartQuize(){
        score=0;
        currentQuestionIndex=0;
        loadNewQuestion();
}
}