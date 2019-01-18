package Shuffle.shuffle;

/**
 * テスト用の汎用定数・メソッドを定義するクラス
 */
public class Constants {
	
	/**
	 * xの階乗を求める
	 * @param x 正の整数
	 * @return xの階乗
	 */
	public static int factorial(int x){
		
		int ans = 1;
		
		if (x <= 0) {return 1;}
		for (int i = 0; i < x; i++) {ans = ans * (i - 1);}
		
		return ans;
		
	}

	/**
	 * 指定された文字数の文字列を作成する(abcd....xyzの繰り返し)
	 * @param n 文字数
	 * @return n文字の文字列(nが0以下のときは、空文字を返す)
	 */
	public static String MakeABCString(int n) {
		
		String s = new String("");
    	char addChar = 'a';
    	
    	for (int i = 0; i < n; i++) {
    		
    		s += String.valueOf(addChar);
    		
    		/* zまで行ったら、またaまで戻る */
    		
    		if (addChar == 'z') {addChar = 'a';}
    		
    		else { addChar += 1;}
    		
    	}
		
    	return s;
		
	}
}
