package sg.edu.np.edu.mad.madweek2practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] ToastMsg = new String[1];
        User newUser = new User();
        Button FollowButton = findViewById(R.id.fnfbutton);
        FollowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (newUser.followed == true) {
                    FollowButton.setText("unfollow");
                    newUser.followed = false;
                    ToastMsg[0] = "Followed";
                } else if (newUser.followed == false) {
                    FollowButton.setText("follow");
                    newUser.followed = true;
                    ToastMsg[0] = "UnFollowed";
                }
                Toast.makeText(MainActivity.this, ToastMsg[0], Toast.LENGTH_SHORT).show();
            }

        });
        Intent receivingEnd = getIntent();
        Integer message = receivingEnd.getIntExtra("Key",0);
        TextView txt = findViewById(R.id.textView);
        txt.setText("MAD" + message.toString());

        Button MessageButton = findViewById(R.id.MsgButton);
        MessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityName2 = new Intent(MainActivity.this, MessageGroup.class);
                activityName2.putExtra("message", "value");
                startActivity(activityName2);

            }
        });

    }

}