import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.view.View.OnKeyListener;

import com.example.apollo.soundcrawler.R;

public class AndroidEnterKeyActivity extends Activity implements OnKeyListener {
    @Override
    public boolean onKey(View view, int keyCode, KeyEvent event) {

        EditText searchField = (EditText)findViewById(R.id.search);
        Log.v("searchField", searchField.getText().toString());
        if(event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            Log.v("searchField", searchField.getText().toString());
            return true;
        }
        return false; // pass on to other listeners.
    }
}
