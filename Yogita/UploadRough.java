import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.SQLException;
import java.text.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class UploadRough {

	public static void main(String[] args) {
		
	 Scanner scan=new Scanner(System.in);
 long SEM_ID=6;
String  DOMAIN_NAME="CT2";
System.out.println("enter sub_code");
 String SUB_CODE=scan.nextLine();
 System.out.println("enter the subject");
 String SUBJECT=scan.nextLine();
 System.out.println("enter  year");
 String YEAR1=scan.nextLine();
 System.out.println("file name");
 String filename=scan.nextLine();
 //JFileChooser chooser = new	JFileChooser();
	//String UploadDir="C:\\Users\\pc\\Desktop\\yogita_upadhyay\\SixthSem\\paper";
	JFileChooser chooser = new	JFileChooser();
	int returnCode = chooser.showOpenDialog(null);
	if(returnCode!=JFileChooser.APPROVE_OPTION) {
		System.out.println("file Not Selected...");
		return ;
	}
	File file  = chooser.getSelectedFile();
	/*System.out.println(studentId);
	System.out.println(file);
	File file  = new File(UploadDir+filename);*/
	
		 FileInputStream fis  = null;
		 Connection con = null;
		 PreparedStatement  pstmt  = null;
		 try {
			 	fis = new FileInputStream(file);
			 	 Class.forName("oracle.jdbc.driver.OracleDriver");
		 String url="jdbc:oracle:thin:@localhost:1521:XE";
		 con=DriverManager.getConnection(url,"System","Ig32mind$");
	String sql="insert into quetionpaper values(qp.nextval,?,?,?,?,to_date('"+YEAR1+"','YYYY'),?,?)";
				pstmt = con.prepareStatement(sql);
				//set date
				
				pstmt.setLong(1,SEM_ID );
				pstmt.setString(2, DOMAIN_NAME);
				pstmt.setString(3,SUB_CODE);
				pstmt.setString(4,SUBJECT);
				
				
				pstmt.setString(5,file.getName());
				pstmt.setBinaryStream(6,fis,(int)file.length());
				////setBinaryStream(int pos, java.io.InputStream is, int length)
				
				int r =pstmt.executeUpdate();
				System.out.println(r==1?"uploaded":" not uploaded");
			}catch(SQLException e){
				System.out.println("db Error : " + e.getMessage());
				e.printStackTrace();
			}catch(Exception e){
				System.out.println("Error : " + e.getMessage());
				e.printStackTrace();
			}finally{
				if(con!=null){
					try{
						con.close();
						System.out.println("db  closed");
					}catch(SQLException e){
						System.out.println("db close error " + e.getMessage());
						e.printStackTrace();
					}
				}//if not null
				
				if(fis!=null){
					try{
						fis.close();
					}catch(IOException e){
						System.out.println("file close error " + e.getMessage());
						e.printStackTrace();
					}
				}//if not null
			}//finally
			

	}

}
