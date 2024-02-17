package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static char lexemeToChar(String str) {

		// character
		if (str.length() == 3) {
			return str.charAt(1);
		}

		// special character
		if (str.length() == 4 && str.charAt(1)=='\\') {

			return switch(str){
				case "'\\n'" -> '\n';
				case "'\\t'" -> '\t';
                default -> '\0';
            };

		}

		if (str.length() >= 2 && str.charAt(0) == '\'' && str.charAt(1)=='\\') {
			// \X -> ascii code
			try{
				int code = Integer.parseInt(str.substring(2, str.length()-1));
				return (char) code;

			} catch(NumberFormatException e){
				System.out.println(e);
			}
		}

		System.out.println("String " + str + " cannot be converted into character");
		return '\0';
	}

	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}
	
}
