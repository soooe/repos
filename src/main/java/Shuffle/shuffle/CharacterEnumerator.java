package Shuffle.shuffle;

import java.util.ArrayList;
import java.util.List;

/**
 * 文字列のパターンを求める機能を提供するクラス
 */
public class CharacterEnumerator {

    /**
     * 与えられた文字列の順序を入れ替えることでできる全ての文字列のパターンを列挙する
     *
     * @param inputStr 入力文字列
     * @return 全ての文字列リスト
     */
    public static List<String> enumerateCombination(String inputStr) {
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

