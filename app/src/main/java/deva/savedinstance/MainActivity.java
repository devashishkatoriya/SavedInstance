package deva.savedinstance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView i_value;
    private EditText editText;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("debug","At onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        i_value = (TextView) findViewById(R.id.textView2);
        editText = (EditText) findViewById(R.id.editText);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("debug","At onClickListener()");
                i = Integer.parseInt(editText.getText().toString());
                i_value.setText(i);
            }
        });
        Log.d("debug","onCreate() Completed");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d("debug","At onRestoreInstanceState()");
        super.onRestoreInstanceState(savedInstanceState);
        i=savedInstanceState.getInt("value_of_i");
        i_value.setText(i);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        Log.d("debug","At onSaveInstanceState()");
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("value_of_i",Integer.parseInt(editText.getText().toString()));
    }
}
