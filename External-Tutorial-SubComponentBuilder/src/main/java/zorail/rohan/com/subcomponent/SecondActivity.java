package zorail.rohan.com.subcomponent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;


import javax.inject.Inject;

import zorail.rohan.com.subcomponent.component.NetComponent;
import zorail.rohan.com.subcomponent.module.NetModule;

public class SecondActivity extends AppCompatActivity {

    @Inject
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NetComponent.Builder builder = (NetComponent.Builder)((MyApp)getApplication()).getComponent().subcomponentBuilders().get(NetComponent.Builder.class).get();
        builder.netModule(new NetModule()).build().inject(this);

        Toast.makeText(this,preferences.getString("Name",""),Toast.LENGTH_LONG).show();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
