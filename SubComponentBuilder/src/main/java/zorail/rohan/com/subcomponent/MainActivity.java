package zorail.rohan.com.subcomponent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import zorail.rohan.com.subcomponent.component.NetComponent;
import zorail.rohan.com.subcomponent.module.NetModule;

public class MainActivity extends AppCompatActivity {

    @Inject
    SharedPreferences.Editor editor;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.editText);
        NetComponent.Builder builder = (NetComponent.Builder)((MyApp)getApplication()).getComponent().subcomponentBuilders().get(NetComponent.Builder.class).get();
        builder.netModule(new NetModule()).build().inject(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("Name",editText.getText().toString());
                editor.commit();
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });
    }
}
