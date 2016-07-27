package edu.hillel.progressbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvProgress;
    private ProgressBar pbProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvProgress = (TextView) findViewById(R.id.tvProgress);
        pbProgress = (ProgressBar) findViewById(R.id.pbProgress);

        Button btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        new MyTask(this).execute(100);
    }

    public void showProgress(int progress) {
        tvProgress.setText(String.valueOf(progress));
        pbProgress.setProgress(progress);
    }
}
