package randomStuff;

public class functions {
		public static double stringToDouble(String stringx){
			boolean decimalReached=false, negative=false;
			String convertedString="";
			double returnDouble=0, preDecimal=1, pastDecimal=1;
			int roundPastDecimal=1;//(aka also decimal count past decimal point);
		//this function converts a string literal to a double value; 
		//any characters that are not decimals and numbers 1-9 are ignored including zero's in some cases. 
		//any zero before the first non-zero number 1-9 is ignored unless that zero is directly to the left of the decimal point. 
		//if the first decimal has been found, any decimal after that will be ignored. from thereon, any number 0-9 will be accounted for. 
		//Special Case: if the length of 'convertedString' is zero and a '-' precedes it, or a '-' is just before a decimal and no valid number has been reached, then this value will be negative. 
		for(int n=0;n<stringx.length();n++){//convert string to be ready to be converted to double form: 
			if(negative==false&&convertedString.length()==0&&stringx.charAt(n)==(int)45)negative=true;
			if(decimalReached==false){
				if(convertedString.length()==0&&stringx.charAt(n)==(int)48||stringx.charAt(n)<(int)48&&stringx.charAt(n)!=(int)46||stringx.charAt(n)>(int)57&&stringx.charAt(n)!=(int)46)continue;	
				else if(stringx.charAt(n)!=(int)46){
					preDecimal*=10;
					convertedString+=stringx.charAt(n);
					continue;
				}
				else if(stringx.charAt(n)==(int)46){
					if(convertedString.length()==0)convertedString+='0';
					convertedString+='.';
					decimalReached=true;
					continue;
				}
			}
			else{
				if(stringx.charAt(n)<(int)48||stringx.charAt(n)>(int)57)continue;
				else{
					roundPastDecimal*=10;
					convertedString+=stringx.charAt(n);
					continue;
				}
			}
		}decimalReached=false;
		for(int n=0;n<convertedString.length();n++){//convert string to double:
			if(convertedString.charAt(n)=='.'){decimalReached=true;continue;}
			if(decimalReached==false){
				preDecimal/=10;
				returnDouble+=(((int)convertedString.charAt(n))-48)*preDecimal;
			}
			else{
				pastDecimal/=10;
				returnDouble+=(((int)convertedString.charAt(n))-48)*pastDecimal;
			}
		}
		if(roundPastDecimal>1000000000)roundPastDecimal=1000000000;//System.out.println(roundPastDecimal);
		returnDouble=(double)Math.round(returnDouble * roundPastDecimal)/roundPastDecimal;//System.out.println((double)Math.round(returnDouble * roundPastDecimal)/roundPastDecimal);
		if(negative==true)returnDouble*=-1;//System.out.println("negative? "+negative+" | Converted string: "+convertedString+" | return value: "+returnDouble);
		return returnDouble;
	}
}