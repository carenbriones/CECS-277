import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		//Scans the text file
		File textFile = new File("textFile.txt");
		Scanner textScanner = new Scanner(textFile);
		ArrayList <String> lines = new ArrayList <String>();
		while (textScanner.hasNextLine()){
			lines.add(textScanner.nextLine());
		}

		//Creates a pattern object for each letter in the alphabet
		Pattern a = Pattern.compile("a", Pattern.CASE_INSENSITIVE);
		Pattern b = Pattern.compile("b", Pattern.CASE_INSENSITIVE);
		Pattern c = Pattern.compile("c", Pattern.CASE_INSENSITIVE);
		Pattern d = Pattern.compile("d", Pattern.CASE_INSENSITIVE);
		Pattern e = Pattern.compile("e", Pattern.CASE_INSENSITIVE);
		Pattern f = Pattern.compile("f", Pattern.CASE_INSENSITIVE);
		Pattern g = Pattern.compile("g", Pattern.CASE_INSENSITIVE);
		Pattern h = Pattern.compile("h", Pattern.CASE_INSENSITIVE);
		Pattern i = Pattern.compile("i", Pattern.CASE_INSENSITIVE);
		Pattern j = Pattern.compile("j", Pattern.CASE_INSENSITIVE);
		Pattern k = Pattern.compile("k", Pattern.CASE_INSENSITIVE);
		Pattern l = Pattern.compile("l", Pattern.CASE_INSENSITIVE);
		Pattern m = Pattern.compile("m", Pattern.CASE_INSENSITIVE);
		Pattern n = Pattern.compile("n", Pattern.CASE_INSENSITIVE);
		Pattern o = Pattern.compile("o", Pattern.CASE_INSENSITIVE);
		Pattern p = Pattern.compile("p", Pattern.CASE_INSENSITIVE);
		Pattern q = Pattern.compile("q", Pattern.CASE_INSENSITIVE);
		Pattern r = Pattern.compile("r", Pattern.CASE_INSENSITIVE);
		Pattern s = Pattern.compile("s", Pattern.CASE_INSENSITIVE);
		Pattern t = Pattern.compile("t", Pattern.CASE_INSENSITIVE);
		Pattern u = Pattern.compile("u", Pattern.CASE_INSENSITIVE);
		Pattern v = Pattern.compile("v", Pattern.CASE_INSENSITIVE);
		Pattern w = Pattern.compile("w", Pattern.CASE_INSENSITIVE);
		Pattern x = Pattern.compile("x", Pattern.CASE_INSENSITIVE);
		Pattern y = Pattern.compile("y", Pattern.CASE_INSENSITIVE);
		Pattern z = Pattern.compile("z", Pattern.CASE_INSENSITIVE);

		//Creates a new ArrayList to count character frequencies
		ArrayList <Integer> letterCounter = new ArrayList <Integer> ();
		for (int zeros = 0; zeros < 26; zeros++){
			letterCounter.add(0);
		}

		for (int count = 0; count < lines.size(); count++){
			for (int characters = 0; characters < lines.get(count).length(); characters++){
				Matcher matchA = a.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchB = b.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchC = c.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchD = d.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchE = e.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchF = f.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchG = g.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchH = h.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchI = i.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchJ = j.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchK = k.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchL = l.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchM = m.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchN = n.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchO = o.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchP = p.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchQ = q.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchR = r.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchS = s.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchT = t.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchU = u.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchV = v.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchW = w.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchX = x.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchY = y.matcher(lines.get(count).substring(characters, characters + 1));
				Matcher matchZ = z.matcher(lines.get(count).substring(characters, characters + 1));

				//Checks if the current character matches the letter
				if(matchA.find()){
					letterCounter.set(0, letterCounter.get(0) + 1);
				} else if (matchB.find()){
					letterCounter.set(1, letterCounter.get(1) + 1);
				} else if (matchC.find()){
					letterCounter.set(2, letterCounter.get(2) + 1);
				} else if (matchD.find()){
					letterCounter.set(3, letterCounter.get(3) + 1);
				} else if (matchE.find()){
					letterCounter.set(4, letterCounter.get(4) + 1);
				} else if (matchF.find()){
					letterCounter.set(5, letterCounter.get(5) + 1);
				} else if (matchG.find()){
					letterCounter.set(6, letterCounter.get(6) + 1);
				} else if (matchH.find()){
					letterCounter.set(7, letterCounter.get(7) + 1);
				} else if (matchI.find()){
					letterCounter.set(8, letterCounter.get(8) + 1);
				} else if (matchJ.find()){
					letterCounter.set(9, letterCounter.get(9) + 1);
				} else if (matchK.find()){
					letterCounter.set(10, letterCounter.get(10) + 1);
				} else if (matchL.find()){
					letterCounter.set(11, letterCounter.get(11) + 1);
				} else if (matchM.find()){
					letterCounter.set(12, letterCounter.get(12) + 1);
				} else if (matchN.find()){
					letterCounter.set(13, letterCounter.get(13) + 1);
				} else if (matchO.find()){
					letterCounter.set(14, letterCounter.get(14) + 1);
				} else if (matchP.find()){
					letterCounter.set(15, letterCounter.get(15) + 1);
				} else if (matchQ.find()){
					letterCounter.set(16, letterCounter.get(16) + 1);
				} else if (matchR.find()){
					letterCounter.set(17, letterCounter.get(17) + 1);
				} else if (matchS.find()){
					letterCounter.set(18, letterCounter.get(18) + 1);
				} else if (matchT.find()){
					letterCounter.set(19, letterCounter.get(19) + 1);
				} else if (matchU.find()){
					letterCounter.set(20, letterCounter.get(20) + 1);
				} else if (matchV.find()){
					letterCounter.set(21, letterCounter.get(21) + 1);
				} else if (matchW.find()){
					letterCounter.set(22, letterCounter.get(22) + 1);
				} else if (matchX.find()){
					letterCounter.set(23, letterCounter.get(23) + 1);
				} else if (matchY.find()){
					letterCounter.set(24, letterCounter.get(24) + 1);
				} else if (matchZ.find()){
					letterCounter.set(25, letterCounter.get(25) + 1);
				}
			}
		}
		
		//Checks how many characters there are (doesn't take into account characters
		//that aren't in the alphabet)
		int characterCount = 0;
		for (int add = 0; add < 26; add++){
			characterCount += letterCounter.get(add);
		}
		
		//Calculates the character percentages
		ArrayList <Double> characterPercentages = new ArrayList <Double> ();
		for (int all = 0; all < 26; all++){
			characterPercentages.add(letterCounter.get(all) * 1.0 / characterCount);
		}
		
		//Prints out letter frequencies
		int letterCount = 0;
		for (char ch = 'a'; ch <= 'z'; ch++){
			System.out.printf("\n" + ch + " = %2.2f%%", characterPercentages.get(letterCount) * 100);
			letterCount++;
		}
		
	}

}
