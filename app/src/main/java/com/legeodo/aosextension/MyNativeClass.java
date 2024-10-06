package com.legeodo.aosextension;

import com.unity3d.player.UnityPlayer;
import android.content.Context;
import android.widget.Toast;

public class MyNativeClass {
	// 싱글톤 인스턴스
	private static MyNativeClass m_instance;
	private Context context;

	// 싱글톤 인스턴스를 가져오는 메서드
	public static MyNativeClass instance() {
		if (m_instance == null) {
			m_instance = new MyNativeClass();
		}
		return m_instance;
	}

	// Context 설정
	public void setContext(Context context) {
		this.context = context;
	}

	// 토스트 메시지 출력
	public void ShowToast() {
		if (context != null) {
			Toast.makeText(context, "토스트 위젯 출력", Toast.LENGTH_LONG).show();
		} else {
			// Context가 없을 경우 에러 처리
			Toast.makeText(UnityPlayer.currentActivity, "Context가 설정되지 않았습니다!", Toast.LENGTH_LONG).show();
		}
	}

	// 유니티로 메시지 전달
	public void TestLog(String objName, String objMethod) {
		if (context != null) {
			UnityPlayer.UnitySendMessage(objName, objMethod, "테스트 메세지 출력");
		} else {
			UnityPlayer.UnitySendMessage(objName, objMethod, "Context가 설정되지 않았습니다.");
		}
	}
}