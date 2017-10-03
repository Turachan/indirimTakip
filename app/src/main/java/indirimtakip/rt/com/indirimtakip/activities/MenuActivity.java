package indirimtakip.rt.com.indirimtakip.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import indirimtakip.rt.com.indirimtakip.R;
import indirimtakip.rt.com.indirimtakip.parser.ParseKadin;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity_menu);

        Button erkekBtn, kadinBtn, cocukBtn, indirimBtn;

        erkekBtn = (Button) findViewById(R.id.erkekBtn);
        kadinBtn = (Button) findViewById(R.id.kadinBtn);
        cocukBtn = (Button) findViewById(R.id.cocukBtn);
        indirimBtn = (Button) findViewById(R.id.indirimBtn);

        erkekBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ErkekActivity.class);
                startActivity(intent);            }
        });

        kadinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), KadinActivity.class);
                ParseKadin parseKadin = new ParseKadin(getResources().getStringArray(R.array.kadinHTML));
                startActivity(intent);
            }
        });

        cocukBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CocukActivity.class);
                startActivity(intent);
            }
        });

        indirimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), IndirimActivity.class);
                startActivity(intent);
            }
        });
    }

}
