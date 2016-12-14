package putout.thebest.notifycation;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher).setContentTitle("My Notification").setContentText("this is the content....");

        Intent intent = new Intent(this,SecondClass.class);

        TaskStackBuilder stackbuilder = TaskStackBuilder.create(this);
        stackbuilder.addParentStack(SecondClass.class);
        stackbuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackbuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        NM.notify(0,builder.build());

    }
}
