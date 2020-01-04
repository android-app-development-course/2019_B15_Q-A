package zhj.viewpagerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class question extends AppCompatActivity {
    TextView name;
    TextView title;
    TextView content;
    TextView caozuo;
    Button answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_question);
        name=(TextView)findViewById(R.id.name);
        title=(TextView)findViewById(R.id.title);
        caozuo=(TextView)findViewById(R.id.caozuo);
        content=(TextView)findViewById(R.id.content);
        answer=(Button)findViewById(R.id.answer);
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(question.this, Main_Msg.class);
                startActivity(intent2);
            }
        });
        Intent intent3 = getIntent();
        name.setText(intent3.getStringExtra("name"));
        title.setText(intent3.getStringExtra("title"));
        content.setText(intent3.getStringExtra("content"));
        caozuo.setText(intent3.getStringExtra("caozuo"));
    }

}
