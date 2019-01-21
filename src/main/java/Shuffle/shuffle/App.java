package Shuffle.shuffle;

import java.util.Scanner;

/**
 * メインクラス<br>
 * ユーザの入力を受けつけ、文字シャッフルメソッドに渡すためのクラス
 */
public class App {

	/** バリデーション時、何文字までの入力を許可するか */
	private static final int MAX_INPUT_SIZE = 10;
	
	public static void main(String[] args) {
		
		/* ユーザの入力を受け付ける */
		
		System.out.println("シャッフル対象文字列 : ");
		final Scanner scan = new Scanner(System.in);
		final String usrInput = scan.next();
		scan.close();
		
		/* 入力値チェック */
		
		(new Validator(MAX_INPUT_SIZE)).validate(usrInput);
		
		/* 入力された文字列のシャッフルパターンをリストアップ */
		
		ControlString
			.shuffleString(usrInput)
			.stream()
			.forEach(System.out::println);
		
	}
	
}
