package mx.tec.example.android_dialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.TokenWatcher;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        final Toast myToast = new Toast(context);
        myToast.makeText(context, "I am a toast", Toast.LENGTH_SHORT).show();

        AlertDialog.Builder dialogConfig = new   AlertDialog.Builder(context);
        dialogConfig.setTitle("Hi dialog");
        dialogConfig.setMessage("Are you sure?");
        dialogConfig.setNeutralButton("Close, ",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        myToast.makeText(context, "You clicked neutral", Toast.LENGTH_SHORT).show();

                    }
                });
        dialogConfig.setNeutralButton("close, ",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        myToast.makeText(context, "You clicked yes", Toast.LENGTH_SHORT).show();

                    }
                });
        dialogConfig.setNegativeButton("No, ",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        myToast.makeText(context, "You clicked no", Toast.LENGTH_SHORT).show();

                    }
                });
        AlertDialog myDialog = dialogConfig.create();
        myDialog.show();

        int NOTIFY_ID = 1234;
        Notification.Builder notifyBuilder = new Notification.Builder(this);
        notifyBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notifyBuilder.setContentTitle("This is my notification");
        notifyBuilder.setContentText("This is the detail of the notification ");

        Intent notificationIntent = new Intent(this, ChildActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
        notifyBuilder.setContentIntent(contentIntent);
        NotificationManager myNotification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        myNotification.notify(NOTIFY_ID, notifyBuilder.build());
    }
}
