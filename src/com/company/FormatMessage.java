package com.company;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Di on 14.04.2017.
 */
public class FormatMessage
{


    private static final int CRITICAL_SIZE = 300;

    private static String sFileName;

    private static FileWriter fw;

    public static void format(Object object, String fileName)
    {
        UserObject userObject = (UserObject) object;

        sFileName =fileName;

        String text = "name = " + userObject.getName() + "\n comment  = " + userObject.getComment();

        try {

            fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.println(text);
            out.println("11111111");

            out.println("csdcs");

            out.close();

            checkSize();



        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }


    private static void checkSize()
    {
        File file = new File(sFileName);
        if (file.length() > CRITICAL_SIZE)
        {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(sFileName));

                String tempStr = "";

                Stream<String> lines = bufferedReader.lines();
                List<String> linesList = lines.map(s -> tempStr + s).collect(Collectors.toList());

                String totalLine = "";
                for (String line : linesList
                        ) {
                    totalLine += " " + line;
                }

                byte[] bytes = totalLine.getBytes("UTF-8");
                String text = new String(bytes, "UTF-8");

                SendMailClass.sendMailTLL(text);

                bufferedReader.close();
                clearFile();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }

        }
    }



    public static void clearFile()
    {
        File file = new File(sFileName);
        file.deleteOnExit();

    }



}
