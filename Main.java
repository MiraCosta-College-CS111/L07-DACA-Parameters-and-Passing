// YOUR NAME: Catherine Walker
// COLLABORATORS: CS111 Students
// DATE: 3/8/2021

public class Main
{
  // CONSTANTS
  //ascii art credit: http://www.oocities.org/spunk1111/bodypart.htm
	public static final String ASCII_ART_0 ="    .----.    .----.  ",
					ASCII_ART_1 = "   (  --  \\  /  --  )",
					ASCII_ART_2 = "          |  |        ",
					ASCII_ART_3 = "         _/  \\_      ",
					ASCII_ART_4 = "        (_    _)      ",
					ASCII_ART_5 = "     ,    `--`    ,   ",
					ASCII_ART_6 = "     \\'-.______.-'/  ",
					ASCII_ART_7 = "      \\          /   ",
					ASCII_ART_8 = "       '.--..--.'     ",
					ASCII_ART_9 = "         `\"\"\"\"\"` ",
					ASCII_CREDIT ="   ascii art by: jgs    ";

	public static final String TITLE_USA = "UNITED STATES OF AMERICA",
				TITLE_EAC = "EMPLOYMENT AUTHORIZATION CARD";
	public static final String LABEL_SURNAME = "Surname", LABEL_GIVEN_NAME = "Given Name", LABEL_USCIS_NUM = "USCIS#",
				LABEL_CATEGORY = "Category", LABEL_CARD_NUM = "Card#", LABEL_BIRTH_COUNTRY = "Country of Birth",
				LABEL_TERMS_CONDITIONS = "Terms and Conditions", LABEL_BIRTH_DATE = "Date of Birth",
				LABEL_SEX = "Sex", LABEL_VALID_DATE = "Valid From:", LABEL_EXPIRE_DATE = "Card Expires:",
				LABEL_REENTRY_DISCLAIMER = "NOT VALID FOR REENTRY TO U.S.";

	public static void main(String[] args)
	{
		//DECLARATION SECTION
		//complete fields
		String surname, givenName, category, cardNum, birthCountry, termsAndConditions;
		char sex;
		
		//parts of fields
		String birthMonth;
		int uscisNum1, uscisNum2, uscisNum3, birthDay, birthYear,
			validDay, validMonth, validYear, expireMonth, expireDay, expireYear;
			
		//extra vars to help with formatting of Strings (not raw data like above vars)
		String uscisNum, dateOfBirth, validDate, expireDate;
	
		//INITIALIZATION SECTION
		surname = UtilityBelt.readString("Surname: ", 1, 45);
		givenName = UtilityBelt.readString("Given name: ",1,45);
		category = UtilityBelt.readString("Category: ",1,15);
		cardNum = UtilityBelt.readString("Card Number: ",1,15);
		birthCountry = UtilityBelt.readString("Country of Birth: ", 1, 45);
		termsAndConditions = UtilityBelt.readString("Terms and Conditions: ", 1, 45);
		sex = UtilityBelt.readChar("Sex: ","MFNX");
		
		uscisNum1 = UtilityBelt.readInt("uscicNum1: ",0,999);
		uscisNum2 = UtilityBelt.readInt("uscicNum2: ",0,999);
		uscisNum3 = UtilityBelt.readInt("uscicNum3: ",0,999);

		birthMonth = UtilityBelt.readString("Month of Birth (abbr.): ",3,3);
		birthDay = UtilityBelt.readInt("Day of birth: ",1,31);
		birthYear = UtilityBelt.readInt("Year of birth: ",1000,9999);

		validDay = UtilityBelt.readInt("Day of valid date: ",1,31);
		validMonth = UtilityBelt.readInt("Month of valid date: ",1,12);
		validYear = UtilityBelt.readInt("Year of valid date: ",1000,9999);

		expireMonth = UtilityBelt.readInt("Month of expire date: ",1,12);
		expireDay = UtilityBelt.readInt("Day of expire date: ",1,31);
		expireYear = UtilityBelt.readInt("Year of expire date: ",1000,9999);
		
		//Strings to help clean up long printf's below
		uscisNum = String.format("%03d-%03d-%03d", uscisNum1, uscisNum2, uscisNum3);
		dateOfBirth = String.format("%02d %s %d", birthDay, birthMonth, birthYear);
		validDate = Main.formatDate(validMonth, validDay, validYear);
		expireDate = Main.formatDate(expireMonth, expireDay, expireYear);

		
		//INPUT + CALCULATION SECTION
		//N/A
		
		//OUTPUT SECTION
		System.out.println(Main.formatCard(surname, givenName, category, cardNum, birthCountry, termsAndConditions, sex, uscisNum, dateOfBirth, validDate, expireDate));
   // Main.formatCard("Walker", "Catherine", "D10", "ABC2459826", "Scotland", "None", 'F', "001-123-555", "13 SEP 1984", "01/01/2005", "12/31/2011");
	}

  // STATIC METHODS
  /** DESCRIPTION: Prints to the console the Employment Authorization Card using given parameters.*/
  public static String formatCard(String surname, String givenName, String category, String cardNum, String birthCountry, String termsAndConditions, char sex, String uscisNum, String dateOfBirth, String validDate, String expireDate)
  {
    String card;

    card = "╔══════════════════════════════════════════════════════════════════════╗\n";
		card += String.format("║%35s%35s║%n", TITLE_USA, "");
		card += String.format("║%60s%10s║%n", TITLE_EAC, "");
		card += String.format("║%-25s%-45s║%n", "", LABEL_SURNAME);
		card += String.format("║%-25s%-45s║%n", "", surname);
		card += String.format("║%-25s%-45s║%n", ASCII_ART_0, LABEL_GIVEN_NAME);
		card += String.format("║%-25s%-45s║%n", ASCII_ART_1, givenName);

		card += String.format("║%-25s%-15s%-15s%-15s║%n", ASCII_ART_2, LABEL_USCIS_NUM, LABEL_CATEGORY, LABEL_CARD_NUM);
		card += String.format("║%-25s%-15s%-15s%-15s║%n", ASCII_ART_3, uscisNum, category, cardNum);

		card += String.format("║%-25s%-45s║%n", ASCII_ART_4, LABEL_BIRTH_COUNTRY);
		card += String.format("║%-25s%-45s║%n", ASCII_ART_5, birthCountry);
		card += String.format("║%-25s%-45s║%n", ASCII_ART_6, LABEL_TERMS_CONDITIONS);
		card += String.format("║%-25s%-45s║%n", ASCII_ART_7, termsAndConditions);

		card += String.format("║%-25s%-15s%-30s║%n", ASCII_ART_8, LABEL_BIRTH_DATE, LABEL_SEX);
		card += String.format("║%-25s%-15s%-30s║%n", ASCII_ART_9, dateOfBirth, sex);

		card += String.format("║%-25s%-15s%-30s║%n", "", LABEL_VALID_DATE, validDate);
		card += String.format("║%-25s%-15s%-30s║%n", "", LABEL_EXPIRE_DATE, expireDate);

		card += String.format("║%-25s%-45s║%n", ASCII_CREDIT, LABEL_REENTRY_DISCLAIMER);
		card += "╚══════════════════════════════════════════════════════════════════════╝";

    return card;
  }

  /** DESCRIPTION: Returns a string of date formatted as mm/dd/yyyy */
  public static String formatDate(int month, int day, int year)
  {
    return String.format("%02d/%02d/%4d", month, day, year);
  }

}