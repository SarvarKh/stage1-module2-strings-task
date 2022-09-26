package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public static void main(String args[]) {
        String source = "qw3e1rt4yu2i3opa1sd1fg2hj4kl";
        List<String> delimiters = List.of("1", "2", "3");
        StringSplitter stringSplitter = new StringSplitter();
        stringSplitter.splitByDelimiters(source, delimiters);
//        ===>
//          List.of("qw", "e", "rt4yu", "i", "opa", "sd", "fg", "hj4kl")
    }
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        try {
            StringBuilder all = new StringBuilder();
            for (String d : delimiters){
                all.append(d);
            }

            List<String> splitStringArr = new ArrayList<>();

            StringTokenizer tokenizer = new StringTokenizer(source, all.toString());
            while (tokenizer.hasMoreTokens()){
                splitStringArr.add(tokenizer.nextToken());
            }

            return splitStringArr;
        } catch (UnsupportedOperationException ex) {
            throw new UnsupportedOperationException("You should implement this method." + ex.toString());
        }
    }
}
