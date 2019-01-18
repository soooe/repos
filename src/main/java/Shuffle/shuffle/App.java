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
        final Scanner scanner = new Scanner(System.in);
        final String userInput = scanner.next();
        scanner.close();

        /* 入力された文字列のシャッフルパターンをリストアップ */
        CharacterEnumerator cs = new CharacterEnumerator();
        List<String> retList = cs.shuffleString(userInput);

        /* シャッフルパターンリストの表示 */
        retList.stream().forEach(System.out::println);
    }

}
