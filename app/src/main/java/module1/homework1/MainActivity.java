package module1.homework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private int incrementVar = 0;
    private TextView incrementedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initIncrementFields();
        initFibonacheFields();
    }

    private void initIncrementFields() {
        incrementedValue = (TextView) findViewById(R.id.someId);
        incrementedValue.setText(String.valueOf(incrementVar));

        EditText editText = (EditText) findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length()> incrementVar) {
                    incrementVar = editable.length();
                    incrementedValue.setText(String.valueOf(incrementVar));
                }
            }
        });
    }

    private void initFibonacheFields() {
        EditText editText = (EditText) findViewById(R.id.fibonacheEditText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length()> 0) {
                    Integer  val=  Integer.valueOf(editable.toString());
                    TextView fTextVal  = (TextView) findViewById(R.id.fibonacheTextView);

                    fTextVal.setText(String.valueOf(calculateFebonacheIndexVal(val)));
                 }
            }
        });

    }

    private int calculateFebonacheIndexVal(Integer val) {
        int prevFebonacheVal = 0;
        System.out.println(prevFebonacheVal);
        int febonacheVal= 1;
        System.out.println(febonacheVal);

        for (int i = 0; i < val; i++) {
            System.out.println(febonacheVal);
            prevFebonacheVal = febonacheVal - prevFebonacheVal;
            febonacheVal += prevFebonacheVal;
        }
        System.out.println(febonacheVal);
        return febonacheVal;
    }

    public void clickButton(View view) {
        incrementedValue.setText(String.valueOf(++incrementVar));
    }
}
