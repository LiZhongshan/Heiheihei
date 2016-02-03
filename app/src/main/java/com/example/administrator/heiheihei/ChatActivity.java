package com.example.administrator.heiheihei;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2016/1/26.
 */
public class ChatActivity extends AppCompatActivity implements View.OnClickListener {
    /** Called when the activity is first created. */

    private Button mBtnSend;
    private Button mBtnBack;
    private EditText mEditTextContent;
    private ListView mListView;
    private ChatMsgViewAdapter mAdapter;
    private List<ChatMsgEntity> mDataArrays = new ArrayList<ChatMsgEntity>();
    public static final String COPY_IMAGE = "EASEMOBIMG";
    public static final int REQUEST_CODE_COPY_AND_PASTE = 11;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_xiaoling);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        initView();

        initData();
    }


    public void initView()
    {
        mListView = (ListView) findViewById(R.id.listview);
        mBtnSend = (Button) findViewById(R.id.btn_send);
        mBtnSend.setOnClickListener(this);
        /*mBtnBack = (Button) findViewById(R.id.btn_back);
        mBtnBack.setOnClickListener(this);*/

        mEditTextContent = (EditText) findViewById(R.id.et_sendmessage);
    }

    private String[]msgArray = new String[]{"  你好  ", "  还阔以  ", "  什么叫还阔以  ", "  还阔以就是还阔以  ",
            "  为什么还阔以就是还阔以呢  ", "  还阔以就是你问我问什么还阔以  ",
            "  晕~~  ", "  哦了 ",};

    private String[]dataArray = new String[]{"2016-02-02 18:00", "2016-02-02 18:10",
            "2016-02-02 18:11", "2016-02-02 18:20",
            "", "2016-02-02 18:35",
            "2016-02-02 18:40", "2016-02-02 18:50"};
    private final static int COUNT = 8;
    public void initData()
    {
        for(int i = 0; i < COUNT; i++)
        {
            ChatMsgEntity entity = new ChatMsgEntity();
            //entity.setDate(dataArray[i]);
            if (i % 2 == 0)
            {
                //entity.setName("小玲");
                entity.setMsgType(true);
            }else{
                //entity.setName("me");
                entity.setMsgType(false);
            }

            entity.setText(msgArray[i]);
            mDataArrays.add(entity);
        }

        mAdapter = new ChatMsgViewAdapter(this, mDataArrays);
        mListView.setAdapter(mAdapter);

    }


    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch(v.getId())
        {
            case R.id.btn_send:
                send();
                break;
            case R.id.btn_back:
                finish();
                break;
        }
    }

    private void send()
    {
        String contString = mEditTextContent.getText().toString();
        if (contString.length() > 0)
        {
            ChatMsgEntity entity = new ChatMsgEntity();
            entity.setDate(getDate());
            entity.setName("小玲");
            entity.setMsgType(false);
            entity.setText(contString);

            mDataArrays.add(entity);
            mAdapter.notifyDataSetChanged();

            mEditTextContent.setText("");

            mListView.setSelection(mListView.getCount() - 1);
        }
    }

    private String getDate() {
        Calendar c = Calendar.getInstance();

        String year = String.valueOf(c.get(Calendar.YEAR));
        String month = String.valueOf(c.get(Calendar.MONTH));
        String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH) + 1);
        String hour = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
        String mins = String.valueOf(c.get(Calendar.MINUTE));


        StringBuffer sbBuffer = new StringBuffer();
        sbBuffer.append(year + "-" + month + "-" + day + " " + hour + ":" + mins);


        return sbBuffer.toString();
    }


    /*public void head_xiaohei(View v) {
        Intent intent = new Intent (ChatActivity.this,InfoXiaohei.class);
        startActivity(intent);
    }*/
}