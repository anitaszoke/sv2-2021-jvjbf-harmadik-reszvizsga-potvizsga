package examinformation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ExamService {

    private Map<String, List<ExamResult>> results = new TreeMap<>();
    private int theoryMax;
    private int practiceMax;

    public Map<String, List<ExamResult>> getResults() {
        return results;
    }

    public int getTheoryMax() {
        return theoryMax;
    }

    public int getPracticeMax() {
        return practiceMax;
    }

    public void readFromFIle(Path path) {
        String line;

        try {
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                while ((line = reader.readLine()) != null) {
                    if (!line.contains(";")) {
                        setMaxPoints(line);
                    } else {
                        addResults(line);
                    }
                }
            }
        } catch (IOException iae) {
            throw new IllegalArgumentException("Cannot read file: src\\main\\java\\data.txt", iae);
        }
    }


    private void setMaxPoints(String line) {
        String[] fullLine = line.split(" ");
        theoryMax = Integer.parseInt(fullLine[0]);
        practiceMax = Integer.parseInt(fullLine[1]);
    }

    private void addResults(String line) {
        String name = parseLineName(line);
        int theory = parseLineTheory(line);
        int practice = parseLinePractice(line);

        results.putIfAbsent(name, new ArrayList<>());
        List<ExamResult> movies = results.get(name);
        movies.add(new ExamResult(practice, theory));
    }

    private String parseLineName(String line) {
        String[] fullLine = line.split(";");
        return fullLine[0];
    }

    private int parseLineTheory(String line) {
        String[] fullLine = line.split(";");
        String[] nameAndPoints = fullLine[1].split(" ");

        return Integer.parseInt(nameAndPoints[0]);
    }

    private int parseLinePractice(String line) {
        String[] fullLine = line.split(";");
        String[] nameAndPoints = fullLine[1].split(" ");

        return Integer.parseInt(nameAndPoints[1]);
    }

    public List<String> findPeopleFailed() {
        List<String> name = new ArrayList<>();
        for (Map.Entry<String, List<ExamResult>> entry : results.entrySet()) {
            for (ExamResult e : entry.getValue()) {
                if (e.getTheory() < theoryMax / 2 || e.getPractice() < practiceMax / 2) {
                    name.add(entry.getKey());
                }
            }
        }
        return name;
    }


    public String findBestPerson() {
        List<String> name = new ArrayList<>();
        int thisAll = 0;
        for (Map.Entry<String, List<ExamResult>> entry : results.entrySet()) {
            for (ExamResult e : entry.getValue()) {
                if (e.getTheory() + e.getPractice() > thisAll) {
                    thisAll = e.getTheory()+e.getPractice();
                }
            }
        }
        return name.toString();
    }

    }

