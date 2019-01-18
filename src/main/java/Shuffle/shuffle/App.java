package Shuffle.shuffle;

import java.util.List;
import java.util.Scanner;

/**
 * メインクラス<br>
 * ユーザの入力を受けつけ、文字シャッフルメソッドに渡すためのクラス
 */
public class App {

	public static void main(String[] args) {
		
		/* ユーザの入力を受け付ける */
		
		System.out.println(Message.REQUEST_INPUT);
		Scanner scan = new Scanner(System.in);
		String usrInput = scan.next();
		scan.close();
		
		/* 入力された文字列のシャッフルパターンをリストアップ */
		
		ControlString cs = new ControlString();
		List<String> retList = cs.shuffleString(usrInput);
		
		/* シャッフルパターンリストの表示 */
		
		if (!cs.showList(retList)) {return;}
		retList.clear();
		
		return;
		
	}
	
}
