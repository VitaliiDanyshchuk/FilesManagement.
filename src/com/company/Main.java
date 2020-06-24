	package com.company;
/*
*
* Classame : Main
*
*  20 June 2020
*
* @author: Danyshchuk Vitalii CHNU 543
* @version: 1.1
*
*  Home task. Files management.
1. Parse the file logs.txt (see the attachment).
2. Calculate the total number of logs (lines).
3. Calculate the total  number of  ERROR logs. Use previous skills - String.split
4.  Calculate the total number of ERROR logs. Use Files.lines.
5. Compare two results.
* */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

        public class Main {

            public static void main(String[] args) throws IOException {


                LocalDateTime start = LocalDateTime.now(); // Create a variable for counting time

                String myString = new String(Files.readAllBytes(
                        Paths.get("C:\\Users\\Vitaliy\\Desktop\\logs.txt"))); // get a log.txt into string

                String[] lines = myString.split("\\n");

                // Calculate the total number of logs (lines).

                System.out.println("Count of lines = " + lines.length);

                // Calculate the total  number of  ERROR logs. Use previous skills - String.split
                int errorLinesCount = 0;

                for (int i = 0; i < lines.length ; i++) {

                    if (lines[i].contains("ERROR")){
                        errorLinesCount++;
                    }

                }
                System.out.println("----STRING.SPLIT-----");
                System.out.println("Count of error lines = " + errorLinesCount);
                LocalDateTime finish = LocalDateTime.now(); // Create a variable for counting time

                System.out.println("Error counting time in string split - "
                        + ChronoUnit.MILLIS.between(
                        start, finish) + " ms");

                // Calculate the total number of ERROR logs. Use Files.lines.
                start = LocalDateTime.now();
                final long errors = Files.lines(
                        Paths.get("C:\\Users\\Vitaliy\\Desktop\\logs.txt"))
                        .filter(line -> line.contains("ERROR"))
                        .count();

                System.out.println("----FILES.LINES-----");
                System.out.println("Second count of errors " + errors);
                finish = LocalDateTime.now();

                System.out.println("Error counting time in files lines - "
                        + ChronoUnit.MILLIS.between
                        (start, finish) + " ms");
    }
}
