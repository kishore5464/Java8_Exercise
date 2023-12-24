package com.kishore.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8_String_Exercise {
    public static void main(String[] args) {
        String name = "Kishore Kumar Arumugam";
        System.out.println("Real String -> " +name);

        String s = "Rotator";
        String s1 = "kishore";
        String s2 = "ishoKre";

        // 1. One Occurrence Characters
        oneOccurrenceDuplicateAndNonDuplicateCharacters(name);

        // 2. Need to print only duplicate once
        duplicateCharactersOnly(name);

        // 3. Sort Characters in Asc and Des Orders
        sortAscAndDesOrderOfCharacters(name);

        // 4. Convert all Characters to UPPERCASE and lowercase
        convertToUpperCaseOfCharacters(name);

        // 5. Increment and Decrement each Character to its Next Character (e.g. If we have 'A' need to increment to 'B')
        incrementAndDecrementEachCharacterToNextChar(name);

        // 6. Anagram Check for the given 2 Strings
        anagramStrings(s1, s2);

        // 7. Palindrome Check fot the given String
        palindromeCheck(s);
    }

    private static void palindromeCheck(String s) {
        String temp = s.chars().mapToObj(c -> (char) c).map(Character::toLowerCase).map(String::valueOf).collect(Collectors.joining("", "", ""));

        if(temp.equals(s.toLowerCase())) {
            System.out.println("The Given String is a Palindrome -> "+temp);
        } else {
            System.out.println("The Given String is Not a Palindrome -> "+temp);
        }
    }

    private static void anagramStrings(String s1, String s2) {
        s1 = s1.chars().mapToObj(c-> (char)c).map(Character::toLowerCase).sorted().map(String::valueOf).collect(Collectors.joining());
        s2 = s2.chars().mapToObj(c-> (char)c).map(Character::toLowerCase).sorted().map(String::valueOf).collect(Collectors.joining());

        if(s1.equals(s2)) {
            System.out.println("The Given String is an Anagram -> "+s1.equals(s2));
        }
        else {
            System.out.println("The Given String is Not an Anagram -> "+s1.equals(s2));
        }
    }

    private static void incrementAndDecrementEachCharacterToNextChar(String name) {
        String incrementCharName = name.chars().mapToObj(c -> (char) (c + 1)).map(String::valueOf).collect(Collectors.joining(","));
        System.out.println("Incremented Chars name -> "+incrementCharName);

        String decrementCharName = name.chars().mapToObj(c -> (char) (c - 1)).map(String::valueOf).collect(Collectors.joining(","));
        System.out.println("Decrement Chars name -> "+decrementCharName);
    }

    private static void convertToUpperCaseOfCharacters(String name) {
       String upperCase = name.chars().mapToObj(c-> (char) c).map(Character::toUpperCase).map(String::valueOf).collect(Collectors.joining(","));
       System.out.println("Convert all Character to UPPER CASE -> "+upperCase);

       String lowerCase = name.chars().mapToObj(c->(char)c).map(Character::toLowerCase).map(String::valueOf).collect(Collectors.joining(","));
       System.out.println("Convert all Character to lower case -> "+lowerCase);
    }

    private static void sortAscAndDesOrderOfCharacters(String name) {
        String ascSortName = name.chars().mapToObj(c -> (char) c).sorted().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println("Ascending Order Sorted Name -> "+ascSortName);

        String desSortName =  name.chars().mapToObj(c->(char)c).sorted(Comparator.reverseOrder()).map(String::valueOf).collect(Collectors.joining(","));
        System.out.println("Descending Order Sorted Name -> "+desSortName);
    }

    private static void duplicateCharactersOnly(String name) {
        String onlyDupName =  name.chars().distinct().filter(c -> name.indexOf(c) != name.lastIndexOf(c)).mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining(","));
        System.out.println("Multiples Occurrence Chars (Need to print only duplicate only once) -> " +onlyDupName);
    }

    private static void oneOccurrenceDuplicateAndNonDuplicateCharacters(String name) {
       String oneOccurrence =  name.chars().distinct().mapToObj(c -> (char) c).map(String::valueOf).collect(Collectors.joining(","));
       System.out.println("1 Occurrence Chars (If duplicate exists also need to print only once) -> " +oneOccurrence);
    }
}

