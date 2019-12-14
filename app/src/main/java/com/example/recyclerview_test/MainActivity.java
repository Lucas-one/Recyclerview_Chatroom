package com.example.recyclerview_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DataItem> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initializeData();
        final RecyclerView recyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager manager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(manager); // LayoutManager 등록
        final ChatMessageAdapter chatAppMsgAdapter = new ChatMessageAdapter(dataList);
        recyclerView.setAdapter(chatAppMsgAdapter);  // Adapter 등록


        ///////////////////실시간 채팅 넣기

        final EditText msgInputText = (EditText)findViewById(R.id.chat_input_msg);
        //edittext에서 입력 받은것을 msgInputText에 담는다.
        Button msgSendButton = (Button)findViewById(R.id.chat_send_msg);

        msgSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msgContent = msgInputText.getText().toString();//그걸 string으로 msgContent에 넣는다.
                if(!TextUtils.isEmpty(msgContent))//입력을 받았다면
                {
                    // Add a new sent message to the list.
                    //내가보낸거랑, 상대가 보낸거랑 어떻게 구분하지..?
                    //받은거랑 보낸 메시지에 어떻게 viewtype을 부여할 수 있을까...? => 해결
                    //받은메세지는 어떻게 구분?
                    DataItem msgDto = new DataItem(msgContent,null,Code.ViewType.RIGHT_CONTENT);
                    dataList.add(msgDto);

                    int newMsgPosition = dataList.size() - 1;

                    // Notify recycler view insert one new data.
                    chatAppMsgAdapter.notifyItemInserted(newMsgPosition);

                    // Scroll RecyclerView to the last message.
                    recyclerView.scrollToPosition(newMsgPosition);

                    // Empty the input edit text box.
                    msgInputText.setText("");
                }
            }
        });

        ////////////////////실시간 채팅 넣기 끝
    }

    public void initializeData()
    {
        dataList = new ArrayList<>();

        dataList.add(new DataItem("사용자1님이 입장하셨습니다.", null,  Code.ViewType.CENTER_CONTENT));
        dataList.add(new DataItem("사용자2님이 입장하셨습니다.", null,  Code.ViewType.CENTER_CONTENT));
        dataList.add(new DataItem("안녕하세요", "사용자1",  Code.ViewType.LEFT_CONTENT));
        dataList.add(new DataItem("안녕하세요", "사용자2",  Code.ViewType.RIGHT_CONTENT));

    }

}
