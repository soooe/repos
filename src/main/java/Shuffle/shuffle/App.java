package Shuffle.shuffle;

import java.util.List;
import java.util.Scanner;

/**
 * ユーザー入力の文字列から全ての文字の組み合わせを列挙するプログラムのメインクラス。
 * 以下の処理を行う。
 *
 * <pre>
 * 1. ユーザーの入力を標準入力から受け付ける
 * 2. 入力値のバリデーションが通らなければIllegalArgumentExceptionを投げてプログラム終了
 * 3. 標準出力に組み合わせ結果を出力
 * </pre>
 */
public class App {

    /** バリデーション時何文字までの入力を許可するか */
    private static final long MAX_INPUT_SIZE = 100;

    /** エントリーポイント */
    public static void main(String[] args) {

        /* ユーザの入力を受け付ける */
        System.out.println("シャッフル対象文字列: ");
        final Scanner scanner = new Scanner(System.in);
        final String userInput = scanner.next();
        scanner.close();

        /* 入力値チェック */
        (new Validator(MAX_INPUT_SIZE)).validate(userInput);

        /* 入力された文字列のシャッフルパターンをリストアップ */
        CharacterEnumerator
                .shuffleString(userInput)
                .stream()
                .forEach(System.out::println);
    }

}
