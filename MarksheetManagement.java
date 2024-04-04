c
import java.io.*;

public class MarksheetManagement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String temp, rollno, name, fname, mname, sch, dob, class1, yn;
        String[] subjcode = {"EN-102", "CH-104", "CS-111", "MA-107", "PH-101"};
        String[] subjects = {"ENGLISH", "CHEMISTRY", "COMPUTER SCIENCE", "MATHEMATICS", "PHYSICS"};
        int[] num = new int[5];
        int total = 0, result = 0;
        float per;

        System.out.print("If you want to record data the type Y otherwise type N : ");
        yn = reader.readLine();

        FileWriter ptr = new FileWriter("record.txt", true);
        FileWriter fptr = new FileWriter("recordm.txt", true);

        if (yn.equalsIgnoreCase("Y")) {
            System.out.println("\n\n\t\tMarksheet management of school\n\n");
            System.out.print("Enter roll No.: ");
            rollno = reader.readLine();
            ptr.write(rollno);
            fptr.write(rollno);

            System.out.print("Enter your name: ");
            name = reader.readLine();
            ptr.write(name);

            System.out.print("Enter father name: ");
            fname = reader.readLine();
            ptr.write(fname);

            System.out.print("Enter mother name: ");
            mname = reader.readLine();
            ptr.write(mname);

            System.out.print("Enter school name: ");
            sch = reader.readLine();
            ptr.write(sch);

            System.out.print("Enter date of birth in dd-mm-yyyy format: ");
            dob = reader.readLine();
            ptr.write(dob);

            System.out.print("Enter class: ");
            class1 = reader.readLine();
            ptr.write(class1);

            System.out.println("Enter subject marks");
            for (int i = 0; i < 5; i++) {
                System.out.print(subjects[i] + ": ");
                num[i] = Integer.parseInt(reader.readLine());
                if (num[i] > 100 || num[i] < 1) {
                    System.out.println("invalid marks enter valid marks");
                    i--;
                }
            }

            for (int i = 0; i < 5; i++) {
                fptr.write((char) num[i]);
            }

            ptr.close();
            fptr.close();
        } else {
            System.out.println("\n\n\t\tMarksheet management of school\n\n");
            System.out.print("Enter roll No.: ");
            rollno = reader.readLine();

            BufferedReader ptrReader = new BufferedReader(new FileReader("record.txt"));
            for (int i = 0; i < 100; i++) {
                temp = ptrReader.readLine();
                name = ptrReader.readLine();
                fname = ptrReader.readLine();
                mname = ptrReader.readLine();
                sch = ptrReader.readLine();
                dob = ptrReader.readLine();
                class1 = ptrReader.readLine();
                result = temp.compareTo(rollno);
                if (result == 0)
                    break;
            }
            ptrReader.close();

            BufferedReader fptrReader = new BufferedReader(new FileReader("recordm.txt"));
            for (int i = 0; i < 100; i++) {
                temp = fptrReader.readLine();
                for (int j = 0; j < 5; j++) {
                    num[j] = fptrReader.read();
                }
                result = temp.compareTo(rollno);
                if (result == 0)
                    break;
            }
            fptrReader.close();

            if (result == 0) {
                for (int i = 0; i < 5; i++) {
                    total += num[i];
                }
                per = total / 5.0f;
                System.out.println("");

                for (int i = 0; i < 5; i++) {
                    System.out.printf("|\t%s \t\t 100 \t 33 \t %d\n", subjcode[i], num[i]);
                }

                System.out.println("|-----------------------------------------------------------------------------------\n" +
                        "|\t \t 500 | TOTAL MARKS OBTAINED\t " + total + "\n" +
                        "|-----------------------------------------------------------------------------------\n");

                if (per >= 80 && per <= 100) {
                    System.out.println("|RESULT : PASS IN FIRST DIVISION\n" +
                            "|GRADE : A\n" +
                            "|PERCENTAGE OBTAINED : " + String.format("%.2f", per));
                } else if (per >= 60 && per <= 79) {
                    System.out.println("|RESULT : PASS IN FIRST DIVISION\n" +
                            "|GRADE : B\n" +
                            "|PERCENTAGE OBTAINED : " + String.format("%.2f", per));
                } else if (per >= 41 && per <= 59) {
                    System.out.println("|RESULT : PASS IN SECOND DIVISION\n" +
                            "|GRADE : C\n" +
                            "|PERCENTAGE OBTAINED : " + String.format("%.2f", per));
                } else if (per >= 33 && per <= 40) {
                    System.out.println("|RESULT : PASS IN THIRD DIVISION\n" +
                            "|GRADE : D\n" +
                            "|PERCENTAGE OBTAINED : " + String.format("%.2f", per));
                }
            }
        }
    }
}


