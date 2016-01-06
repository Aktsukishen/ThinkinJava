package com.chapter18.learning.l_1810_s;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {

	public static void main(String[] args) throws Exception{
		FileOutputStream fos=new FileOutputStream("resource/filelocking.txt");
		FileLock fl=fos.getChannel().tryLock();
		if(fl!=null){
			System.out.println("Locked File");
			TimeUnit.MILLISECONDS.sleep(100);
			fl.release();
			System.out.println("Released Lock");
		}
		fos.close();
	}

}
