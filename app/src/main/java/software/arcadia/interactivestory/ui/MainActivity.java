package software.arcadia.interactivestory.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nameField;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(software.arcadia.interactivestory.R.layout.activity_main);

        nameField = (EditText)findViewById(software.arcadia.interactivestory.R.id.nameEditText);
        startButton = (Button)findViewById(software.arcadia.interactivestory.R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameField.getText().toString();
                startStory(name);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        nameField.setText("");
    }

    private void startStory(String name) {
        Intent intent = new Intent(this, StoryActivity.class);
        Resources resources = getResources();
        String key = resources.getString(software.arcadia.interactivestory.R.string.key_name);
        intent.putExtra(key, name);
        startActivity(intent);
    }
}














