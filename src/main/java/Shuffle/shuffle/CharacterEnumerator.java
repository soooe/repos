package Shuffle.shuffle;

import Shuffle.shuffle.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * 文字列を処理するクラス
 * 指定された文字列をシャッフルしてできる文字列を重複なく全てリストアップすることを目的とする
 * 例 : 入力がbabの場合 → abb, bab, bba をリストアップ
 * 基本的には、並べ替え関数f(s) s:入力文字列　を以下のように再帰的に定義することで実行する
 *
 * f(s) s:入力文字列
 * -sが1文字の場合-
 * 終了
 * -sが2文字以上の場合-
 * 先頭1文字を固定し、残りの文字列を並べ替える
 * 例：s = "abb"の場合
 * a + f("bb")
 * b + f("ab")
 */
public class CharacterEnumerator {

    /**
     * 任意の文字列に対し、その順序を入れ替えることでできる全ての文字列パターンを列挙する
     *
     * 次のいずれかの場合は空リストが返る
     * -入力文字列に半角英数字でない文字が含まれるとき
     * -文字数が規定値を超えるとき
     * -文字数が0のとき
     * -引数がnullのとき
     *
     * @param inputStr 入力文字列
     * @return 全ての文字列リスト
     */
    public static List<String> shuffleString(String inputStr) {
        final List<String> buffer = new ArrayList<>();
        enumerateCombination("", inputStr, buffer);
        return buffer;
    }

    private static void enumerateCombination(final String fixed, final String candidates, final List<String> buffer) {
        if (candidates.isEmpty()) {
            buffer.add(fixed);
        }

        for (int i = 0; i < candidates.length(); i++) {
            enumerateCombination(
                    fixed + candidates.charAt(i),
                    candidates.substring(0, i) + candidates.substring(i+1),
                    buffer);
        }
    }
}

