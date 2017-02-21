package com.exercise.path;

import android.widget.Button;
import android.widget.EditText;

import com.exercise.path.BuildConfig;
import com.exercise.path.MainActivity;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {
    private MainActivity mainActivity;
    private EditText gridEditText;
    private EditText resultEditText;
    private Button button;

    //I use Roboelectric for TDD so i can test with the android sdk without building the apk.
    @Before
    public void setup() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        gridEditText = (EditText) mainActivity.findViewById(com.exercise.path.R.id.gridEditText);
        resultEditText = (EditText) mainActivity.findViewById(com.exercise.path.R.id.resultEditText);
        button = (Button) mainActivity.findViewById(com.exercise.path.R.id.button);
        gridEditText.setText("1 2 3 4 5");
    }

    @Test
    public void clickResult_shouldChangeResultEditText() {
        button.performClick();
        assertThat(resultEditText.getText().length(), greaterThan(0));
    }
}
