import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Match extends Student {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] studentsArray = new Student[100];
		int countingStudents = 0;
		try {
			System.out.println("Please enter the file name");
			Scanner input = new Scanner(System.in);
			String fileName = input.next();
			File readingStudents = new File(fileName);
			Scanner rS = new Scanner(readingStudents);

			while(rS.hasNextLine()) { // This line practically delimited "\n" for me
				Scanner rL = new Scanner(rS.nextLine());
				rL.useDelimiter("\t");

				//name
				String name = rL.next();
				//gender
				String gettingGender = rL.next();
				char gender = gettingGender.charAt(0);
				//date
				Scanner rD = new Scanner(rL.next());
				rD.useDelimiter("-");
				int month = rD.nextInt();
				int day = rD.nextInt();
				int year = rD.nextInt();

				Date birthDate = new Date(year, month, day);
				//preference
				Preference studentsPreference = new Preference(rL.nextInt(), rL.nextInt(), rL.nextInt(), rL.nextInt());
				if (countingStudents+ 1 != 100) {
					studentsArray[countingStudents++] = new Student(name, gender, birthDate, studentsPreference, false);

				}}



			for (int i = 0; i <= countingStudents; i++) {
				int best_score_for_student_i = 0;
				int[] MatchedatIndex = new int[100];

				for(int j = i+1; j < countingStudents; j++) {
					//System.out.println("HI" + studentsArray[0].compare(studentsArray[2]));
					//System.out.println(studentsArray[i].getMatched());
					//System.out.println(studentsArray[j].getMatched());

					if (studentsArray[i].getMatched() == false && studentsArray[j].getMatched() == false) {
						int compared = studentsArray[i].compare(studentsArray[j]);
						//System.out.println(compared);
						if(compared > best_score_for_student_i) {
							String matchedWith = studentsArray[i].didMatch(studentsArray[j]);
							best_score_for_student_i = compared;
							if(i != countingStudents) {
								System.out.println(studentsArray[i].getName() + " matches with " + matchedWith + " with the score " + best_score_for_student_i);}

						}

					}





					//studentsArray[i].didMatch(studentsArray[MatchedatIndex[i]]);
				}}for(int lastCheck = 0; lastCheck < countingStudents; lastCheck++) {
					if (studentsArray[lastCheck].getMatched() == false) {
						System.out.println("Did not find match for " + studentsArray[lastCheck].getName());
					}


				}


		}catch(FileNotFoundException e){
			System.out.println(e);
			
		}

	}

}

//		/Users/yogeshkirpal/Downloads/Students.txt















