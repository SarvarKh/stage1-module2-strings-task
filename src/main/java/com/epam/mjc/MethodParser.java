package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        try {
            int openingParenthesis = signatureString.indexOf(40);
            int closingParenthesis = signatureString.indexOf(41) + 1;

            String methodDeclaration = signatureString.substring(0, openingParenthesis);
            String methodArguments;
            methodArguments = openingParenthesis + 1 == closingParenthesis - 1 ?
                    ", " :
                    signatureString.substring(openingParenthesis + 1, closingParenthesis - 1);

            String[] methodDeclarationArr = methodDeclaration.split(" ", 0);
            String[] methodArgumentsArr = methodArguments.split(", ", 0);

            List<MethodSignature.Argument> arguments = new ArrayList<>();
            if (methodArgumentsArr.length > 0) {
                int count = 0;
                while (count < methodArgumentsArr.length) {
                    String[] singleArgArr = methodArgumentsArr[count].split(" ");
                    arguments.add(new MethodSignature.Argument(singleArgArr[0], singleArgArr[1]));
                    count++;
                }
            }

            MethodSignature methodSignature = new MethodSignature(
                    methodDeclarationArr[methodDeclarationArr.length - 1],
                    arguments);
            if (methodDeclarationArr.length == 3) {
                methodSignature.setAccessModifier(methodDeclarationArr[0]);
                methodSignature.setReturnType(methodDeclarationArr[1]);
            } else {
                methodSignature.setReturnType(methodDeclarationArr[0]);
            }


            System.out.println(methodSignature.toString());
            return methodSignature;
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException("You should implement this method.");
        }

    }
}
