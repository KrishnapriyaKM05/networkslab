import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s=new Socket("localhost",5000);
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter order of matrix: ");
        int n=sc.nextInt();

        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        out.writeInt(n);

        int[][] mat = new int[n][n];
        System.out.println("Enter matrix: ");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                out.writeInt(mat[i][j]);
       
        String result=in.readUTF();

        System.out.println(result);
        in.close();
        out.close();
        s.close();
        sc.close();
    }
}