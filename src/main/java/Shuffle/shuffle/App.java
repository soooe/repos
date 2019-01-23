package Shuffle.shuffle;

import java.util.Scanner;

/**
 * メインクラス<br>
 * ユーザの入力を受けつけ、文字列列挙メソッドに渡すためのクラス
 */
public class App {

	/** バリデーション時、何文字までの入力を許可するか */
	private static final int MAX_INPUT_SIZE = 10;
	
	public static void main(String[] args) {
		
		/* ユーザの入力を受け付ける */
		
		String usrInput = "";
		Scanner scan = new Scanner(System.in);
		while (true) {
			
			System.out.println("シャッフル対象文字列 : ");
			scan = new Scanner(System.in);
			usrInput = scan.next();
			
			try {
				(new Validator(MAX_INPUT_SIZE)).validate(usrInput);
				break;
			}
			catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
		scan.close();
		
		/* 入力された文字列のシャッフルパターンをリストアップ */
		
		CharacterEnumerator
			.enumerateCombination(usrInput)
			.stream()
			.forEach(System.out::println);
		
	}
	
}
