import java.io.*;
import java.util.*;

class Unpacker
{
    public FileInputStream instream = null;

    public Unpacker(String PackFileName)
    {
        try
        {
            instream = new FileInputStream(PackFileName);
            UnpackFiles();
        }
        catch(Exception e)
        {
            System.out.println("Error while unpacking: " + e);
        }
    }

    public void UnpackFiles()
    {
        int iRet = 0, FileSize = 0, iCount = 0;
        String SHeader = null;

        try
        {
            byte[] header = new byte[100];

            while((iRet = instream.read(header)) != -1)
            {
                SHeader = new String(header).trim();
                String[] parts = SHeader.split(" ");

                String filename = parts[0];
                FileSize = Integer.parseInt(parts[1]);

                FileOutputStream fout = new FileOutputStream(new File(filename));

                byte[] fileData = new byte[FileSize];
                instream.read(fileData);
                fout.write(fileData);
                fout.close();

                System.out.println("Extracted: " + filename);
                iCount++;
            }

            instream.close();
            System.out.println("Total files extracted: " + iCount);
        }
        catch(Exception e)
        {
            System.out.println("Error in unpacking files: " + e);
        }
    }
}
