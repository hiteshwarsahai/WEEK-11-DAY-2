+package W11StudyHall1Day2;
+
+import java.io.File;
+import java.io.IOException;
+import java.util.ArrayList;
+import java.util.Iterator;
+
+import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
+import org.apache.poi.ss.usermodel.Cell;
+import org.apache.poi.ss.usermodel.DataFormatter;
+import org.apache.poi.ss.usermodel.Row;
+import org.apache.poi.ss.usermodel.Sheet;
+import org.apache.poi.ss.usermodel.Workbook;
+import org.apache.poi.ss.usermodel.WorkbookFactory;
+
+public class ReadingExcel {
+	public static final String SAMPLE_XLSX_FILE_PATH = "sample-xlsx-file.xlsx";
+
+    public static void main(String[] args) throws IOException, InvalidFormatException {
+
+        // Creating a Workbook from an Excel file (.xls or .xlsx)
+        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
+        
+        File A = new File ("sample-xlsx-file.xlsx");
+        
+        // Retrieving the number of sheets in the Workbook
+        System.out.println("Workbook Name:  " + A.getName());
+        
+        System.out.println("\nWorkbook has " + workbook.getNumberOfSheets() + " Sheets : ");
+        
+        ArrayList<String> sheetNames = new ArrayList<String>();
+        for (int i=0; i<workbook.getNumberOfSheets(); i++) {
+            sheetNames.add( workbook.getSheetName(i) );
+            }
+    System.out.println(sheetNames);
+
+    Sheet sheet = workbook.getSheetAt(0);
+    
+    // Get number of columns in each row 
+    int numberOfColumns = 0;
+    Iterator<Row> rowIterator1 = sheet.rowIterator();
+    if (rowIterator1.hasNext())
+    {
+        Row headerRow = (Row) rowIterator1.next();
+        //get the number of column in the header row
+        numberOfColumns = headerRow.getPhysicalNumberOfCells();
+    }
+    System.out.println("\nNumber of columns in each row: "+numberOfColumns);
+
+    // Create a DataFormatter to format and get each cell's value as String
+   DataFormatter dataFormatter = new DataFormatter();
+       
+  
+    // 1. You can obtain a rowIterator and columnIterator and iterate over them
+    System.out.println("\nIterating over Rows and Columns using Iterator\n");
+    Iterator<Row> rowIterator = sheet.rowIterator();
+    while (rowIterator.hasNext()) {
+        Row row = rowIterator.next();
+
+        // Now let's iterate over the columns of the current row
+        Iterator<Cell> cellIterator = row.cellIterator();
+
+        while (cellIterator.hasNext()) {
+            Cell cell = cellIterator.next();
+            String cellValue = dataFormatter.formatCellValue(cell);
+            System.out.print(cellValue + "\t");
+        }
+        System.out.println();
+    }
+
+    
+    System.out.println("\nSheet 1");
+    int x=sheet.getRow(0).getPhysicalNumberOfCells();
+    String a=Integer.toString(x);
+    
+    System.out.println("Total columns = " + a);
+    
+    int y=sheet.getPhysicalNumberOfRows();
+    String b=Integer.toString(y);
+    
+    System.out.println("Total Rows = " + b);
+    
+    Sheet sheet1 = workbook.getSheetAt(1);
+    
+    System.out.println("\nSheet 2");
+    int z=sheet1.getRow(0).getPhysicalNumberOfCells();
+    String c=Integer.toString(z);
+    
+    System.out.println("Total columns = " + c);
+    
+    int p=sheet1.getPhysicalNumberOfRows();
+    String g=Integer.toString(p);
+    
+    System.out.println("Total Rows = " +g);
+    
+    Sheet sheet2 = workbook.getSheetAt(2);
+    System.out.println("\nSheet 3");
+    int q=sheet2.getRow(4).getPhysicalNumberOfCells();
+    String h=Integer.toString(q);
+    
+    System.out.println("Total columns = " + h);
+    
+    int r=sheet2.getPhysicalNumberOfRows();
+    String i=Integer.toString(r);
+    
+    System.out.println("Total Rows = " + i);
+    // Closing workbook class
+    workbook.close();
+    }
+}