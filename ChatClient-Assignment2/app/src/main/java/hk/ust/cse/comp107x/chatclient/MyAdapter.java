package hk.ust.cse.comp107x.chatclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by muppala on 8/6/16.
 */
public class MyAdapter extends ArrayAdapter<Message> {
    private final Context context;
    private final ArrayList<Message> messages;

    public MyAdapter(Context context, ArrayList<Message> messages) {
        super(context, R.layout.message, messages);
        this.context = context;
        this.messages = messages;
    }

    // This method constructs the ListItem's view from the data obtained
    // from the Message object. This will be called by ListView while it
    // is being drawn.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // TODO
        View messageView = null;

        // Get a reference to the LayoutInflater. This helps construct the
        // view from the layout file
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Change the layout based on who the message is from
        if (messages.get(position).fromMe()) {
            messageView = inflater.inflate(R.layout.mymessage,parent,false);
            TextView textView = (TextView)(messageView.findViewById(R.id.mymessageTextView));
            textView.setText(messages.get(position).getMessage());
            TextView textView1 = (TextView)(messageView.findViewById(R.id.mytimeTextView));
            textView1.setText(messages.get(position).getTime());
            //TODO

        } else {
            messageView = inflater.inflate(R.layout.message,parent,false);
            TextView textView = (TextView)(messageView.findViewById(R.id.messageTextView));
            textView.setText(messages.get(position).getMessage());
            TextView textView1 = (TextView)(messageView.findViewById(R.id.timeTextView));
            textView1.setText(messages.get(position).getTime());
            //TODO

        }

        return messageView;
    }
}