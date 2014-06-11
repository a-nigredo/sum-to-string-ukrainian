package dev.nigredo;

import java.math.BigDecimal;

/**
 * Original version: <a
 * href="http://www.sql.ru/forum/actualthread.aspx?tid=649518"&gt; сумма
 * прописью </a> <br/>
 * I have made only small improvements - BigDecimal support and value range
 * extension.
 * 
 * @author Łukasz Lech
 */
public class NumberToUkrainianWords {

	public final static int DG_POWER = 100;

	private final static String[][] a_power = new String[][] {
			{ "0", "", "", "" }, // 1
			{ "1", "тисяча ", "тисячи ", "тисяч " }, // 2
			{ "0", "мільйон ", "мільйона ", "мільйонів " }, // 3
			{ "0", "мільярд ", "мільярда ", "мільярдів " }, // 4
			{ "0", "триллион ", "триллиона ", "триллионов " }, // 5
			{ "0", "квадриллион ", "квадриллиона ", "квадриллионов " }, // 6
			{ "0", "квинтиллион ", "квинтиллиона ", "квинтиллионов " }, // 7
			{ "0", "секстиллион ", "секстиллиона ", "секстиллионов " }, // 8
			{ "0", "септиллион ", "септиллиона ", "септиллионов " }, // 9
			{ "0", "октиллион ", "октиллиона ", "октиллионов " }, // 10
	};

	private final static String[][] digit = new String[][] {
			{ "", "", "десять ", "", "" },
			{ "один ", "одна ", "одинадцять ", "десять ", "сто " },
			{ "два ", "дві ", "дванадцять ", "двадцять ", "двісті " },
			{ "три ", "три ", "тринадцять ", "тридцять ", "триста " },
			{ "чотири ", "чотири ", "чотирнадцять ", "сорок ", "чотириста " },
			{ "п'ять ", "п'ять ", "п'ятнадцять ", "п'ятьдесят ", "п'ятсот " },
			{ "шість ", "шість ", "шістнадцать ", "шістдесят ", "шістсот " },
			{ "сім ", "сім ", "сімнадцать ", "сімдесят ", "сімсот " },
			{ "вісім ", "вісім ", "вісімнадцать ", "вісімдесят ", "вісімсот " },
			{ "дев'ять ", "дев'ять ", "дев'ятнадцять ", "дев'яносто ",
					"дев'ятсот " } };

	public static String toWords(BigDecimal sum) {

		int i, mny;
		BigDecimal TAUSEND = new BigDecimal(1000);
		StringBuffer result = new StringBuffer("");
		BigDecimal divisor; // делитель
		BigDecimal psum = sum;

		int one = 1;
		int four = 2;
		int many = 3;

		int hun = 4;
		int dec = 3;
		int dec2 = 2;

		if (sum.equals(BigDecimal.ZERO))
			return "ноль ";

		if (sum.compareTo(BigDecimal.ZERO) < 0) {
			result.append("мінус ");
			psum = psum.negate();
		}

		for (i = 0, divisor = BigDecimal.ONE; i < DG_POWER - 1; i++) {
			divisor = divisor.multiply(TAUSEND);
			if (sum.compareTo(divisor) < 0) {
				i++;
				break; // no need to go further
			}
		}

		// start from previous value
		for (; i >= 0; i--) {

			mny = psum.divide(divisor).intValue();
			psum = psum.remainder(divisor);

			if (mny == 0) {
				if (i == 0) {
					result.append(a_power[i][one]);
				}
			} else {

				if (mny >= 100) {
					result.append(digit[mny / 100][hun]);
					mny %= 100;
				}

				if (mny >= 20) {
					result.append(digit[mny / 10][dec]);
					mny %= 10;
				}

				if (mny >= 10) {
					result.append(digit[mny - 10][dec2]);
				} else if (mny >= 1) {
					result.append(digit[mny]["0".equals(a_power[i][0]) ? 0 : 1]);
				}

				switch (mny){
				case 1:
					result.append(a_power[i][one]);
					break;
				case 2:
				case 3:
				case 4:
					result.append(a_power[i][four]);
					break;
				default:
					result.append(a_power[i][many]);
					break;
				}

			}

			divisor = divisor.divide(TAUSEND);
		}

		return result.toString();
	}
}
