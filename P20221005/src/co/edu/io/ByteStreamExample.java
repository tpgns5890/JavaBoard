package co.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStreamExample {

	public static void main(String[] args) {
		try {
			fileCopy();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void fileCopy() throws IOException {
		FileInputStream fis = new FileInputStream("C:/temp/origin.jpg");
		FileOutputStream fos = new FileOutputStream("C:/temp/origin.jpg");
		byte[] buf = new byte[100];
		
		
		//시간출력
		long start = System.currentTimeMillis();
		while(true) {
			int bytes = fis.read(buf);// 한 바이트씩 읽기
			
			if(bytes == -1) 
				break;
			fos.write(buf); // 배열의 크기만큼 버퍼에 저장하고 한번에 저장
			
		}
		fos.close();
		fis.close();
		
		long end = System.currentTimeMillis();
		
		System.out.println();
		System.out.println();
	}
	public static void readBuf() throws IOException {
		InputStream is = new FileInputStream("C:/Temp/data2.dat");
		byte[] buf = new byte[2];
		
		while(true) {
			int bytes = is.read(buf); // 배열에 선언된 크기만큼 한번에 읽어들임.
			if(bytes == -1 ) {
				break;
			}
			for (int i=0; i<bytes; i++) {
				System.out.print(buf[i] + " ");
				
			}
			System.out.println();
		}
	}

	public static void writeBuf() throws IOException {
		byte[] arr = new byte[] { 10, 20, 30 };
		OutputStream os = new FileOutputStream("C:/Temp/data1.dat");
		os.write(arr);
		os.close();
	}

	public static void read() {

		try {
			InputStream is = new FileInputStream("C:/Temp/data1.dat");
			while (true) {
				int bytes = is.read();
				if (bytes == -1) {
					break;
				}
				System.out.println(bytes);
			}
			is.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("complete");

	}

	public static void write() {
		// 출력스트림
		try {
			OutputStream os = new FileOutputStream("C:/Temp/data1.dat");

			byte a = 10;
			byte b = 20;

			os.write(a);
			os.write(b);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
