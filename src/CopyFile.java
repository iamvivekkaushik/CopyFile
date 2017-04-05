import java.io.*;

class CopyFile{
	public static void main(String[] args) throws IOException{
		int i;
		FileInputStream fin = null;
		FileOutputStream fout = null;
		String helpFile = "help.txt";
		FileInputStream help = new FileInputStream(helpFile);
		try{
		if(args[0].equals("--help")){
			
			do{
				i=help.read();
			if(i != -1) System.out.print((char) i);
			try{
			Thread.sleep(20);
			}catch(InterruptedException e){
				System.out.println("Error: Thread Interrupted: "+e);
			}
			}while(i != -1);
			
			return;
		}
		}catch(ArrayIndexOutOfBoundsException d){
			System.out.println("Invalid arguments.\nTry \"java CopyFile --help\" to find out how to use the program.");
		}
		if(args.length != 3){
			System.out.println("For help: java CopyFile --help");
			return;
		}
		
		try{
			
			for(int s = 1; s <= Integer.parseInt(args[0]);s++){
			fin = new FileInputStream(args[1]);
			fout = new FileOutputStream(args[2]+"/"+s+".txt");
			do{
				i = fin.read();
				if(i != -1) fout.write(i);	
			}while(i != -1);
			}
		}catch (IOException e){
			System.out.println("IO Error: "+ e);
		}
		finally{
			try{
				if(fin != null) fin.close();
			}catch(IOException e1){
				System.out.println("Error closing file");
			}
			
			try{
				if(fout != null) fout.close();
			}catch (IOException e2){
				System.out.println("Error closing file");
			}
		}
	}
}