import java.io.*;
import java.util.*;

class Packer
{
    public FileOutputStream outstream = null;

    public Packer(String FolderName, String PackFileName)
    {
        try
        {
            File f = new File(FolderName);

            File[] fileList = f.listFiles();

            outstream = new FileOutputStream(PackFileName);

            for(File file : fileList)
            {
                if(file.isFile())
                {
                    PackFile(file.getAbsolutePath());
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error occurred while packing: " + e);
        }
    }

    public void PackFile(String filePath)
    {
        byte[] buffer = new byte[1024];
        int bytesRead = 0;

        try
        {
            File f = new File(filePath);
            FileInputStream instream = new FileInputStream(f);

            String header = filePath + " " + f.length();  // "filename size"
            for(int i = header.length(); i < 100; i++)  // Fixed header size
            {
                header += " ";
            }

            byte[] headerBytes = header.getBytes();
            outstream.write(headerBytes);

            while((bytesRead = instream.read(buffer)) != -1)
            {
                outstream.write(buffer, 0, bytesRead);
            }

            instream.close();
        }
        catch(Exception e)
        {
            System.out.println("Error packing file: " + filePath);
        }
    }
}
