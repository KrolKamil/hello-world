import java.io.*;

public class Main {

    static int MAXN;

    static String fileIn, fileOut;

    static int spf[];

    static int n,m,b;

    static long time;

    static int bNumbers;

    static void sieve()
    {
        spf[1] = 1;
        for (int i=2; i<MAXN; i++)

            spf[i] = i;

        for (int i=4; i<MAXN; i+=2)
            spf[i] = 2;

        for (int i=3; i*i<MAXN; i++)
        {
            if (spf[i] == i)
            {
                for (int j=i*i; j<MAXN; j+=i)

                    if (spf[j]==j)
                        spf[j] = i;
            }
        }
    }

    public static void factorize()
    {
        Boolean isB = true;
        int temporary_number;
        int howMany = 0;

        for(int i=n; i<=n+m; i++)
        {
            temporary_number = i;

            while(temporary_number>1)
            {
                if(spf[temporary_number] > b)
                {
                    isB = false;
                    break;
                }
                temporary_number /= spf[temporary_number];
            }

            if(isB==true)
            {
                howMany++;
            }
            isB=true;
        }

        bNumbers = howMany;
    }

    public static void read()
    {
        String fileName = fileIn;
        String[] nmb;
        String line;

        try {
            FileReader fileReader =
                    new FileReader(fileName);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            line = bufferedReader.readLine();
            nmb = line.split(" ");

            n = Integer.parseInt(nmb[0]);

            m = Integer.parseInt(nmb[1]);

            b = Integer.parseInt(nmb[2]);

            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
    }

    public static void setValues()
    {
        MAXN = (n+m+1);
        spf = new int[MAXN];
    }

    public static void factorizeAndCountTime()
    {
        long start = System.currentTimeMillis();
        factorize();
        long stop = System.currentTimeMillis();

        time = stop - start;
    }

    public static void sendResults()
    {

        String fileName = fileOut;

        try {
            FileWriter fileWriter =
                    new FileWriter(fileName);

            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

            bufferedWriter.write(Integer.toString(bNumbers));
            bufferedWriter.newLine();
            bufferedWriter.write(Long.toString(time));

            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + fileName + "'");
        }




    }

    public static void main(String[] args)
    {
        fileIn = args[0];
        fileOut = args[1];
        read();
        setValues();
        sieve();
        factorizeAndCountTime();
        sendResults();

    }
}
