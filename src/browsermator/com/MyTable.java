/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package browsermator.com;

import com.opencsv.CSVReader;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




/**
 *
 * @author pcalkins
 */
public class MyTable {
   CSVReader CSVFileReader;
   int number_of_columns;
   int number_of_records;
   String DataFile;
   JTable DataTable;
   Object[] columnnames = {""};
   int rowcount;
   List<String[]> myEntries;
   List<String[]> runtimeEntries;
   String[] URLListRunTimeEntries;
 String listname;
 MyTable (String csvFile)
 {
        if ("".equals(csvFile))
        {
            DataFile = "placeholder";
        }
        else
        {
        DataFile = csvFile;
        }
        DataTable = new JTable();
        myEntries = new ArrayList<>();
        runtimeEntries = new ArrayList<>();
        URLListRunTimeEntries = new String[0];

          File filecheck = new File(csvFile);
if (filecheck.isAbsolute()) {
      
   String[] left_right_side_of_dot = csvFile.split("\\.");
   String file_extension = left_right_side_of_dot[left_right_side_of_dot.length-1];
   
           switch (file_extension)
           {
               case "xls":
                   try
                   {
                   FileInputStream file = new FileInputStream(new File(DataFile));
    
    HSSFWorkbook workbook = new HSSFWorkbook(file);
 
    //Get first sheet from the workbook
    HSSFSheet sheet = workbook.getSheetAt(0);
  
    //Iterate through each rows from first sheet
    Iterator<Row> rowIterator = sheet.iterator();
 
    int number_of_cells =0;
    while(rowIterator.hasNext()) {
        Row row = rowIterator.next();
          int number_of_thesecells = row.getPhysicalNumberOfCells();
          if (number_of_thesecells>number_of_cells)
          {
              number_of_cells = number_of_thesecells;
          }
    }
     Iterator<Row> rowIterator2 = sheet.iterator();
       while(rowIterator2.hasNext()) {
        Row row = rowIterator2.next();
         
 
     
    String[] myRow = new String[number_of_cells];
        Iterator<Cell> cellIterator = row.cellIterator();
      
        int cell_index=0;
        while(cellIterator.hasNext()) {
             
            Cell cell = cellIterator.next();
             
            switch(cell.getCellType()) {
                case Cell.CELL_TYPE_BOOLEAN:
                    Boolean boolvalue = cell.getBooleanCellValue();
                   String cellvalue = "false";
                    if (boolvalue)
                    {
                        cellvalue = "true";
                    }
                    else
                        
                    myRow[cell_index]= cellvalue;
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    myRow[cell_index]= Double.toString(cell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    myRow[cell_index]=cell.getRichStringCellValue().getString();
                    break;    
                case Cell.CELL_TYPE_BLANK:
                    myRow[cell_index]="";
                    break;
                case Cell.CELL_TYPE_ERROR:
                    myRow[cell_index]="";
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    myRow[cell_index]=cell.getCellFormula();
                    break;
            }
             cell_index++;    
            }
        if (cell_index!=number_of_cells)
        {
            for (int x = cell_index; x<number_of_cells; x++)
            myRow[cell_index] = "";
        }

     myEntries.add(myRow);
    }
 
      file.close();
                   } 

 
              
    catch (Exception e)
    {
        System.out.println("Error occurred while reading XLS file: " + e.toString());    
            }
                       break;
               case "xlsx":
                 try
                   {
                   FileInputStream file = new FileInputStream(new File(DataFile));
    
  XSSFWorkbook workbook = new XSSFWorkbook (file);
 
//Get first sheet from the workbook
XSSFSheet sheet = workbook.getSheetAt(0);
  
    //Iterate through each rows from first sheet
    Iterator<Row> rowIterator = sheet.iterator();

    int number_of_cells =0;
    while(rowIterator.hasNext()) {
        Row row = rowIterator.next();
          int number_of_thesecells = row.getPhysicalNumberOfCells();
          if (number_of_thesecells>number_of_cells)
          {
              number_of_cells = number_of_thesecells;
          }
    }
     Iterator<Row> rowIterator2 = sheet.iterator();
       while(rowIterator2.hasNext()) {
        Row row = rowIterator2.next();
         
 
     
    String[] myRow = new String[number_of_cells];
        Iterator<Cell> cellIterator = row.cellIterator();
      
        int cell_index=0;
        while(cellIterator.hasNext()) {
             
            Cell cell = cellIterator.next();
             
            switch(cell.getCellType()) {
                case Cell.CELL_TYPE_BOOLEAN:
                    Boolean boolvalue = cell.getBooleanCellValue();
                   String cellvalue = "false";
                    if (boolvalue)
                    {
                        cellvalue = "true";
                    }
                    else
                        
                    myRow[cell_index]= cellvalue;
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    myRow[cell_index]= Double.toString(cell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    myRow[cell_index]=cell.getRichStringCellValue().getString();
                    break;    
                case Cell.CELL_TYPE_BLANK:
                    myRow[cell_index]="";
                    break;
                case Cell.CELL_TYPE_ERROR:
                    myRow[cell_index]="";
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    myRow[cell_index]=cell.getCellFormula();
                    break;
            }
             cell_index++;    
            }
        if (cell_index!=number_of_cells)
        {
            for (int x = cell_index; x<number_of_cells; x++)
            myRow[cell_index] = "";
        }

     myEntries.add(myRow);
    }
 
      file.close();
                   } 

catch (Exception ex)
{
    System.out.print ("Exception during XLSX import: " + ex.toString());
}

                   break;
               case "csv":
                     try {
                 CSVFileReader = new CSVReader(new FileReader(DataFile), ',', '"', '\0');
              myEntries = CSVFileReader.readAll();   
                     }
                     catch(Exception e)
                             {
                                 
                             }
                             
         
           }
                     

          columnnames = (String[]) myEntries.get(0);
          DefaultTableModel tableModel = new DefaultTableModel(columnnames, myEntries.size()-1); 
           rowcount = tableModel.getRowCount();
          this.number_of_records = rowcount;
          for (int x = 0; x<rowcount+1; x++)
           {
             
              int columnnumber = 0;
             if (x>0)
             {
           for (String thiscellvalue : (String[])myEntries.get(x))
           {
               tableModel.setValueAt(thiscellvalue, x-1, columnnumber);
              columnnumber++;
           }
             }
   
          
           }
        
           
           DataTable = new JTable(tableModel);
        
      
        int number_of_rows = DataTable.getRowCount();
        if (number_of_rows < 10)
        {
      DataTable.setPreferredScrollableViewportSize(new Dimension (694, number_of_rows * DataTable.getRowHeight()));
        }
        else
        {
       DataTable.setPreferredScrollableViewportSize(new Dimension (694,400));     
        }
       
 
       
}
 }
MyTable(List<String[]> in_dataset, String csvFileName)
{
        DataFile = csvFileName;
        DataTable = new JTable();
        myEntries = new ArrayList<>();
        runtimeEntries = new ArrayList<>();
        URLListRunTimeEntries = new String[0];
        
    myEntries = in_dataset;
       if (myEntries.size()>0)
       {
        columnnames = (String[]) myEntries.get(0);
          DefaultTableModel tableModel = new DefaultTableModel(columnnames, myEntries.size()-1); 
           rowcount = tableModel.getRowCount();
          this.number_of_records = rowcount;
          for (int x = 0; x<rowcount+1; x++)
           {
             
              int columnnumber = 0;
             if (x>0)
             {
           for (String thiscellvalue : (String[])myEntries.get(x))
           {
               tableModel.setValueAt(thiscellvalue, x-1, columnnumber);
              columnnumber++;
           }
             }
   
          
           }
        
           
           DataTable = new JTable(tableModel);
        
      
        int number_of_rows = DataTable.getRowCount();
        if (number_of_rows < 10)
        {
      DataTable.setPreferredScrollableViewportSize(new Dimension (694, number_of_rows * DataTable.getRowHeight()));
        }
        else
        {
       DataTable.setPreferredScrollableViewportSize(new Dimension (694,400));     
        }
       }  
}

 MyTable(String[] in_entries, String list_name)

{
     DataFile = "";
        DataTable = new JTable();
        myEntries = new ArrayList<>();
        runtimeEntries = new ArrayList<>();
        URLListRunTimeEntries = new String[0];
        
    listname = list_name;
         if ("".equals(list_name) || "Select a stored URL List".equals(list_name))
         {
      columnnames[0] = "No data file or URL list set."; 
         }
         else
         {
          columnnames[0] = "Stored URL List:" + list_name;
         }
           DefaultTableModel tableModel = new DefaultTableModel(columnnames, 0); 
        


        DataTable = new JTable(tableModel);

  DataTable.getColumnModel().getColumn(0).setPreferredWidth(946);
   DataTable.setPreferredScrollableViewportSize(new Dimension (950, 200));
 //   DataTable.setPreferredSize(new Dimension (694,510));
this.URLListRunTimeEntries = in_entries;

}
 public void populateTableWithURLListRunTimeEntries()
 {
     columnnames[0] = "Stored URL List:" + listname;

  
          DefaultTableModel tableModel = new DefaultTableModel(columnnames, URLListRunTimeEntries.length); 
         
           rowcount = tableModel.getRowCount();
          this.number_of_records = rowcount;
             int columnnumber = 0;
          for (int x = 0; x<rowcount; x++)
           {
             
               
               tableModel.setValueAt(URLListRunTimeEntries[x], x, columnnumber);

 }
                DataTable = new JTable(tableModel);
        
   
        int number_of_rows = DataTable.getRowCount();
    //     DataTable.getColumnModel().getColumn(0).setPreferredWidth(950);
        if (number_of_rows < 10)
        {
      DataTable.setPreferredScrollableViewportSize(new Dimension (950, number_of_rows * DataTable.getRowHeight()));
        }
        else
        {
       DataTable.setPreferredScrollableViewportSize(new Dimension (950,400));     
        }
 }
 public void setColumnWidth(int in_width)
 {
     DataTable.getColumnModel().getColumn(0).setPreferredWidth(in_width);
     
 }

 public void refreshURLListRunTimeEntries()
 {
     URLListRunTimeEntries = new String[0];
 }
 public void setRunTimeFileSet(List<String[]> runtime_entries)
 {
  //   this.runtimeEntries = new ArrayList<>(runtime_entries.size());
     
     this.runtimeEntries = runtime_entries;
 }
 

}
